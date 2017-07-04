package com.yayiabc.http.mvc.controller.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.jpa.Cart;
import com.yayiabc.http.mvc.pojo.jpa.OrderItem;
import com.yayiabc.http.mvc.pojo.jpa.Ordera;
import com.yayiabc.http.mvc.pojo.jpa.Receiver;
import com.yayiabc.http.mvc.service.PlaceOrderService;


//下订单
@Controller
@RequestMapping("api/po")
public class PlaceOrderController {
	@Autowired
	private PlaceOrderService placeOrderService;
	//购物车点击立即购买时:
	@RequestMapping("buyNows")
	@ResponseBody
	public 	DataWrapper<HashMap<String, Object>> buyNows(
			@RequestParam(value="token") String token,
			@RequestParam(value="receiverId") Integer receiverId
			/*@RequestParam(value="itemId") String itemId,
			@RequestParam(value="userId") String userId,
			@RequestParam(value="receiverId") String receiver_id,
			@RequestParam(value="itemPropertyNamea") String itemPropertyNamea,
			@RequestParam(value="itemPropertyNameb") String itemPropertyNameb,
			@RequestParam(value="itemPropertyNamec") String itemPropertyNamec,
			@RequestParam(value="num") String num*/
			){
		return placeOrderService.buyNows(token,receiverId);
	}
	//  使用钱币抵扣时  onChange
	@RequestMapping("Ded")
	@ResponseBody
	public DataWrapper<Void> Ded(
			@RequestParam(value="token") String token,
			@RequestParam(value="qbnum") Integer num
			){
		return placeOrderService.ded(token,num);
	}
	//选择地址
	@RequestMapping("upateAddress")
	@ResponseBody
	public DataWrapper<Receiver> upateAddress(
			@RequestParam(value="receiverId") Integer receiverId
			){
		return placeOrderService.upateAddress(receiverId);
	}

	
	//提交订单//将信息保存到订单表里
	@RequestMapping("saveMessage")
	@ResponseBody
	public DataWrapper<Void>  saveMessage(
			/*	@RequestParam(value="orderId")String orderId,
			@RequestParam(value="inHead",required=false)String inHead,
			@RequestParam(value="registerNum",required=false)String registerNum,
			@RequestParam(value="orderMessage",required=false)String orderMessage,
			@RequestParam(value="phone",required=false)String phone,
			@RequestParam(value="actualPay",required=false)String actualPay,
			@RequestParam(value="actualPay",required=false)String actualPay*/
			@ModelAttribute Ordera order,
			@RequestParam(value="token",required=true)String token
			){
		//将信息保存到订单表里

		return placeOrderService.saveMessage(order,token);
	}

	//当用户点击商品图片购买时:
	@RequestMapping("buyNow")
	@ResponseBody
	public 	DataWrapper<HashMap<String, Object>> buyNow(
			@ModelAttribute OrderItem orderItem,
			@RequestParam(value="token",required=true) String token,
			@RequestParam(value="receiverId",required=true) String receiverIds
			){
		
		Integer receiverId= Integer.parseInt(receiverIds);
		return placeOrderService.buyNow(orderItem,token,receiverId);
	}
	//伪清空 购物车
	@ResponseBody
	@RequestMapping("emptyCart")
	public DataWrapper<Void> emptyCart(@RequestParam(value="token")String token){
		return placeOrderService.emptyCart(token);
	}
}