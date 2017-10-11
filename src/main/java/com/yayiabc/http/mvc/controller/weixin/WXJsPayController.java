package com.yayiabc.http.mvc.controller.weixin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yayiabc.common.enums.ErrorCodeEnum;
import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.common.utils.HttpUtil;
import com.yayiabc.common.utils.QbExchangeUtil;
import com.yayiabc.common.weixin.*;
import com.yayiabc.http.mvc.dao.UtilsDao;
import com.yayiabc.http.mvc.dao.WXPayDao;
import com.yayiabc.http.mvc.pojo.jpa.Charge;
import com.yayiabc.http.mvc.pojo.jpa.WXAppEntry;
import com.yayiabc.http.mvc.service.AliPayService;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by 小月亮 on 2017/9/28.
 */
@Controller
@RequestMapping("api/wxRoom")
public class WXJsPayController {

    @Autowired
    private AliPayService aliPayService;

    @Autowired
    private WXPayDao wXPayDao;

    @Autowired
    private UtilsDao utilsDao;

    @RequestMapping("unifiedOrderReturnUrl")
    @ResponseBody
    public DataWrapper<WXAppEntry> unifiedOrderReturnUrl(
            @RequestParam("code")String code,
            @RequestParam("orderId") String orderId, HttpServletResponse response, HttpServletRequest request){
        DataWrapper<WXAppEntry> dataWrapper =new DataWrapper<WXAppEntry>();
        System.out.println("开始处理回调");
        HashMap<String, String> hashMap=aliPayService.queryY(orderId);
        String total_fee=hashMap.get("WIDtotal_fee");//0.01
        Double total=Double.parseDouble(total_fee);
        System.out.println(total_fee);
        Integer totalFee=(int)(total*100);
        String body=hashMap.get("WIDsubject");
        try {
            WXPay wxPay = new WXPay(WXPayConfigImpl.getInstance(), "http://47.93.48.111:8080/api/weixin/getReturnUrl",false,true);
            Map<String,String> reqData =new HashMap<String,String>();
            if(body!=null&&!"".equals(body)){
                reqData.put("body",body);//必传
            }else{
                reqData.put("body", "商品名称");
            }
            wXPayDao.deleteOrderRecord(orderId);
            String outTradeNo= UUID.randomUUID().toString();
            String[] str=outTradeNo.split("-");
            outTradeNo="";
            for (String string : str) {
                outTradeNo+=string;
            }
            wXPayDao.addOrderRecord(orderId,outTradeNo);
            reqData.put("out_trade_no",outTradeNo);
            reqData.put("fee_type", "CNY");
            reqData.put("openid",accessToken(code));
            System.out.println(reqData.get("openid"));
            if(totalFee!=null&&!"".equals(totalFee)){
                reqData.put("total_fee",totalFee+"");//必传,总金额,接口中单位为分,对账单中的单位为元,必须为整数,可以通过参数传进来
            }else {
                reqData.put("total_fee","1");
            }
            reqData.put("spbill_create_ip",request.getRemoteAddr());//终端ip,必传,APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
            reqData.put("trade_type","JSAPI");//必传,现场扫码付
            reqData.put("product_id",System.currentTimeMillis()+"");//扫码支付时此参数必传,可以通过参数传进来,trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
            System.out.println(reqData);
            Map<String,String> respMap=wxPay.unifiedOrder(reqData);
            System.out.println(respMap);
            SortedMap<String, String> parameterMap = new TreeMap<String, String>();
            String packages = "prepay_id="+respMap.get("prepay_id");
            parameterMap.put("appid", WXPayConfigImpl.getInstance().getAppID());
            parameterMap.put("package", packages);
            parameterMap.put("nonceStr", WXPayUtil.generateNonceStr());
            parameterMap.put("timeStamp",String.valueOf(System.currentTimeMillis()/1000));
            String sign=WXPayUtil.generateSignature(parameterMap,"90d4bae1c1843cec9aff6b4533f05881", WXPayConstants.SignType.MD5);
            System.out.println(sign);
            WXAppEntry wxAppEntry =new WXAppEntry(parameterMap.get("appid"),Long.parseLong(parameterMap.get("timeStamp")),parameterMap.get("partnerid"),respMap.get("prepay_id"),parameterMap.get("nonceStr"),sign);
            dataWrapper.setData(wxAppEntry);
        } catch (Exception e) {
            String msg="服务器错误";
            e.printStackTrace();
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }



    @RequestMapping("unifiedOrderCharge")
    @ResponseBody
    public DataWrapper<WXAppEntry> unifiedOrderCharge(
            @RequestParam("code")String code,
            @RequestParam(value="money",required=true) Integer money,
                                   @RequestParam("qbType")String qbType,
                                   @RequestHeader(value="token",required=true) String token,
                                   HttpServletRequest request,
                                   HttpServletResponse response){
        DataWrapper<WXAppEntry> dataWrapper =new DataWrapper<WXAppEntry>();
        String chargeId=UUID.randomUUID().toString();
        String[] str=chargeId.split("-");
        chargeId="";
        for (String string : str) {
            chargeId+=string;
        }
        double totalMoney= QbExchangeUtil.getQbByMoney(money,qbType);
        Charge charge=new Charge();
        charge.setChargeId(chargeId);
        charge.setQbNum(money);
        String totalFee=(int)(totalMoney*100)+"";
        charge.setMoney(totalFee);
        charge.setState(1);
        charge.setToken(utilsDao.getUserID(token));
        charge.setQbType(qbType);
        wXPayDao.deleteChargeByToken(utilsDao.getUserID(token));
        wXPayDao.addCharge(charge);
        try {
            WXPay wxPay = new WXPay(WXPayConfigImpl.getInstance(), "http://47.93.48.111:8080/api/weixin/getChargeReturnUrl",false,true);
            Map<String,String> reqData =new HashMap<String,String>();
            reqData.put("body","qb");//必传
            reqData.put("out_trade_no",chargeId);
            reqData.put("fee_type", "CNY");
            System.out.println(totalFee+"总价");
            reqData.put("total_fee",totalFee);//必传,总金额,接口中单位为分,对账单中的单位为元,必须为整数,可以通过参数传进来
            reqData.put("spbill_create_ip",request.getRemoteAddr());//终端ip,必传,APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
            reqData.put("trade_type","JSAPI");//必传,现场扫码付
            reqData.put("product_id",System.currentTimeMillis()+"");//扫码支付时此参数必传,可以通过参数传进来,trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
            reqData.put("openid",accessToken(code));
            Map<String,String> respMap=wxPay.unifiedOrder(reqData);
            System.out.println(respMap);
            SortedMap<String, String> parameterMap = new TreeMap<String, String>();
            String packages = "prepay_id="+respMap.get("prepay_id");
            parameterMap.put("appId", WXPayConfigImpl.getInstance().getAppID());
            parameterMap.put("mch_id", "1377180402");
            parameterMap.put("nonceStr", WXPayUtil.generateNonceStr());
            parameterMap.put("signType", WXPayConstants.MD5);
            parameterMap.put("package", packages);
          
            parameterMap.put("timeStamp",String.valueOf(System.currentTimeMillis()/1000));//原先的  90d4bae1c1843cec9aff6b4533f05881
            parameterMap.put("sign", WXPayUtil.generateSignature(parameterMap, "xiaojiangxiaojiangxiaojiangjiang",WXPayConstants.SignType.MD5));
            parameterMap.put("paySign",parameterMap.get("sign") );
           
            WXAppEntry wxAppEntry =new WXAppEntry(parameterMap.get("appId"),Long.parseLong(parameterMap.get("timeStamp")),respMap.get("partnerid"),respMap.get("prepay_id"),parameterMap.get("nonceStr"),parameterMap.get("paySign"));
            System.out.println("...................."+wxAppEntry);
          
            dataWrapper.setData(wxAppEntry);
        } catch (Exception e) {
            String msg="服务器错误";
            e.printStackTrace();
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    public String accessToken(String code) throws IOException {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + "wx4b1a6fde77626a32" + "&secret=" + "90d4bae1c1843cec9aff6b4533f05881"+ "&code=" + code + "&grant_type=authorization_code";
        Map<String,Object> map= HttpUtil.sendGet(url);
        System.out.println(map);
        return (String)map.get("openid");
    }

    /**
     * 通过微信用户的code换取网页授权access_token
     * @return
     * @throws IOException
     * @throws
     */
    public List<Object> accessToken1(String code)throws IOException {
		List<Object> list = new ArrayList<Object>();
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+  "wx4b1a6fde77626a32" + "&secret=" +  "90d4bae1c1843cec9aff6b4533f05881"+ "&code=" + code + "&grant_type=authorization_code";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse res = client.execute(post);
		if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = res.getEntity();
			String str = EntityUtils.toString(entity, "utf-8");
			ObjectMapper mapper=new ObjectMapper();
			Map<String,Object> jsonOb=mapper.readValue(str, Map.class);
			list.add(jsonOb.get("access_token"));
			list.add(jsonOb.get("openid"));
		}
		return list;
	}   
}