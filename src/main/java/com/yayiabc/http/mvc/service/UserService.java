package com.yayiabc.http.mvc.service;

import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.jpa.User;

public interface UserService {

	DataWrapper<Void> getVerifyCode(String phone);

	DataWrapper<User> register(String phone, String password, String code,String openid);

	DataWrapper<User> noteLogin(String phone, String code);

	DataWrapper<User> pwdLogin(String phone, String password);

	DataWrapper<Void> reLogin(String token);

	DataWrapper<Void> forgetPwd(String phone, String code, String password);


	DataWrapper<Void> bindSale(String token, String salePhone);

	DataWrapper<User> wxRegister(String phone, String password, String openid);
}
