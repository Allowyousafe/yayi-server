package com.yayiabc.http.mvc.service;

import java.util.HashMap;
import java.util.List;

import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.jpa.UserWith;
import com.yayiabc.http.mvc.pojo.model.UserWithExtend;

public interface UserWithdrawalsService {
	 DataWrapper<Object> submit(UserWith userWith,String token,String vCode);

	DataWrapper<Object> yesOrNo(String withId, Integer sign);

	DataWrapper<Object> show(HashMap<String, Object> hm);

	DataWrapper<Object> setUpWitType(String token, String accountHolder, String cardNumber, String oBank, String cardNumber2);

	DataWrapper<Object> witSetUpShow(String token);

	DataWrapper<Object> showUserQbNum(String token);

	DataWrapper<Object> latelyWithRecord(String token);

	DataWrapper< List<UserWithExtend>> withHornPrompt();
	
	DataWrapper<Object> showUserQbNumPo(String token, String sumItemsPrice);
}
