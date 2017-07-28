package com.yayiabc.http.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yayiabc.http.mvc.pojo.jpa.OrderItem;
import com.yayiabc.http.mvc.pojo.jpa.Ordera;
import com.yayiabc.http.mvc.pojo.model.OrderManagement;

public interface OrderManagementDao {
   List<OrderManagement> showOrder(HashMap<String, Object> hMap);

    int  closeTrading(@Param("orderId")String orderId,@Param("flagBit") Integer flagBit);
   
    //显示退款处理
   Ordera refundProcessing(@Param("orderId")String orderId);
    
    //操作退款数据
    int makeRefundData(Map<String, String> map);
    
    //显示订单详情
    Ordera queryOrderDetails(String orderId);
    
    //查询下单商品数  SELECT num FROM order_item WHERE item_id=3 AND order_id=2
    int queryMaxNum(@Param("orderId")String orderId,@Param("itemId")String itemId);
    
    
    //模拟失去焦点
    List<OrderItem> showFund(@Param("orderId")String orderId,@Param("itemId")String itemId);
    //根据订单查询  用户
	String queryUser(String orederId);
    
	//
	Integer userBalance(String userId); //
	
    //仓库发货
	int warehouseDelivery(@Param("orderId")String orderId,
			@Param("logisticsName")String logisticsName,
			@Param("logisticsCode")String  logisticsCode);
    //根据//通过orderId查找到userId
	String queryUserId(@Param("orderId")String orderId);

	int queryCount(HashMap<String, Object> hMap);

	List<OrderItem> queryOrderItemList(@Param("orderId")String orderId);
	//查看当前订单的赠送铅笔数   实际付款
	Ordera queryOrder(@Param("orderId")String orderId);
	  //扣除该用户钱币
		int dedQbNum(@Param("dedQbNum")double dedQbNum,@Param("userId")String userId);
     ///数据插入退款表
	int  saveRefundMessage(@Param("userId")String userId,
			@Param("haoCaiRefundSumMoney")Double haoCaiRefundSumMoney, 
			@Param("toolRefundSumMoney")Double toolRefundSumMoney, 
			@Param("dedQbNum")double dedQbNum, @Param("returnMoney")double d, 
			 @Param("orderId")String orderId);
	
	//退金币refundSumPrice-order.getActualPay()
	int returnQb(@Param("Qb")double Qb, @Param("userId")String userId);
	
	//将退款后的记录更新到订单表中
	void updateOrderMessage(
		@Param("orderId") String orderId
			);

	void saveRefundMessToSaleIncome(
			@Param("saleId")String saleId,
			@Param("orderId")String orderId, 
			@Param("haoCaiRefundSumMoney")Double haoCaiRefundSumMoney,
			@Param("toolRefundSumMoney")Double toolRefundSumMoney
			);

	int saveRefundMessages(@Param("userId")String userId,@Param("haoCaiRefundSumMoney") Double haoCaiRefundSumMoney, 
			@Param("toolRefundSumMoney")Double toolRefundSumMoney, @Param("dedQbNum")double dedQbNum,
			@Param("returnMoney")double d, @Param("returnQbNum")double e,  @Param("orderId")String orderId);
	
}
