package com.yayiabc.http.mvc.service;

import java.util.HashMap;
import java.util.List;


import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.jpa.Balance;

public interface MyWalletService {

	
   
	
	/*//查看订单详情
	DataWrapper<SaleInfo> queryOrder(String orderId, String token);

	//------------------------
	DataWrapper<SaleInfo> queryTMD(String saleToken);



	DataWrapper<Void> getBalance(String token);


	DataWrapper<Void> getAllIn(String token);


	DataWrapper<Void> getAllOut(String token);


	DataWrapper<List<Balance>> myWalletDetails(String token, Integer state,
			String starTime, String endTime);


	DataWrapper<List<SaleMyWalletDetail>> viewDetail(Integer balanceId);*/
   
	
	//明细
	DataWrapper<List<Balance>> detail(HashMap<String, Object> hm,
			Integer currentPage,
			Integer numberPerpage,
			String token
			);
    
	//详情
	DataWrapper<Balance>  details(String balanceId);

	DataWrapper<List<Balance>> detailsss(HashMap<String, Object> hm, Integer currentPage, Integer numberPerpage);


}
