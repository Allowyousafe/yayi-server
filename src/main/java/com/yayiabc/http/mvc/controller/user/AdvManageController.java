package com.yayiabc.http.mvc.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayiabc.common.sdk.LogisticsMain;
import com.yayiabc.common.utils.BeanUtil;
import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.common.utils.PayAfterOrderUtil;
import com.yayiabc.http.mvc.pojo.jpa.AdvChart;
import com.yayiabc.http.mvc.service.AdvManageService;

@Controller
@RequestMapping("api/adv")
public class AdvManageController {
    @Autowired
    private AdvManageService advManageService;
    //show
    @RequestMapping("showAdv")
    @ResponseBody
    public DataWrapper<List<AdvChart>> showAdv(){
    	return advManageService.showAdv();
    }
    
  //update
    @RequestMapping("updateAdv")
    @ResponseBody
    public DataWrapper<Void> updateAdv(
    		@ModelAttribute AdvChart advChart,
    		@RequestParam(value="advId",required=true) Integer advId
    		){
    	advChart.setAdvId(advId);
    	return advManageService.updateAdv(advChart);
    }
    
    //insert
    @RequestMapping("insertAdv")
    @ResponseBody
    public DataWrapper<Void> insertAdv(
    		@ModelAttribute AdvChart advChart
    		){
    	return advManageService.insertAdv(advChart);
    }
  //delete
    /**
     *  "SF",
        "LogisticCode": "118650888018"
     * @param advId
     * @return
     */
    @RequestMapping("deleteAdv")
    @ResponseBody
    public DataWrapper<Void> deleteAdv(
    		@RequestParam(value="advId") Integer advId
    		){
    	return advManageService.deleteAdv(advId);
    }
    @RequestMapping("testLogMain")
    @ResponseBody
    public String testLogMain(
    		@RequestParam(value="ShipperCode") String  ShipperCode,
    		@RequestParam(value="LogisticCode") String  LogisticCode
    		){
    	try {
    		String s=new LogisticsMain().getOrderTracesByJson(ShipperCode, LogisticCode);
    				System.out.println(s);
			return s;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LogisticCode;
    }
    @RequestMapping("test")
    @ResponseBody
    public void da(
    		String orderId
    		){
    	PayAfterOrderUtil payAfterOrderUtil= BeanUtil.getBean("payAfterOrderUtil");
 	   payAfterOrderUtil.universal(orderId);
    }
}
