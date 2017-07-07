package com.yayiabc.http.mvc.controller.saleManage;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayiabc.common.sessionManager.VerifyCodeManager;
import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.jpa.With;
import com.yayiabc.http.mvc.service.MyWalletService;
import com.yayiabc.http.mvc.service.WitManageService;

@Controller
@RequestMapping("api/myWallet")
public class MyWalletController {
	@Autowired
	private MyWalletService myWalletService;
	@Autowired

	private WitManageService witManageService;
	//钱包明细
	@RequestMapping(value="detail")
	@ResponseBody
	public DataWrapper<TreeMap<String, Object>> detail(
			@RequestParam(value="token",required=true)String token,
			@RequestParam(value="date",required=true)int date,
			@RequestParam(value="state",required=true)int state
			){
		return myWalletService.myWalletDetails(token,date,state);
	}
	//提现入口
	@RequestMapping("showWit")
	@ResponseBody
	public  DataWrapper<With> showWit(
			@RequestParam(value="token") String token
			){
		return witManageService.showWit(token);
	}
	//提交提现申请
	@RequestMapping("submitWit")
	@ResponseBody//real_name,type,anumber,cashMoney,phone
	public  DataWrapper<Void> submitWit(
			@RequestParam(value="token") String token,
			@RequestParam(value="vCode") String vCode,
			/* @RequestParam(value="phone") String phone,
   		 @RequestParam(value="moneyNnm") String moneyNnm,*/
			/*real_name  type   anumber
   		 @RequestParam(value="phone") String phone,
   		 @RequestParam(value="vCode") String vCode,
   		 @RequestParam(value="type") String type*/
			@ModelAttribute With with
			){

		if(vCode.equals(VerifyCodeManager.getPhoneCode(with.getPhone()))){
			return witManageService.submitWit(with);
		}
		DataWrapper<Void> dataWrapper= new DataWrapper<Void>();
		dataWrapper.setMsg("验证验证码失败");
		return dataWrapper;
	}
	//查看操作 的订单详情
		 void queryOrder(
				 @RequestParam(value="orderId") String orderId,
				 @RequestParam(value="token") String token
				 ){
			 myWalletService.queryOrder(orderId,token);
		  }
}
