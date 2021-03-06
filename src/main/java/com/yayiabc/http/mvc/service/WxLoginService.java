package com.yayiabc.http.mvc.service;

import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.jpa.Certification;
import com.yayiabc.http.mvc.pojo.jpa.SaleInfo;
import com.yayiabc.http.mvc.pojo.jpa.User;

/**
 *
 * Created by Jo on 2017/8/2.
 */
public interface WxLoginService {
    DataWrapper<Object> login(String code);

    DataWrapper<Object> bindUser(String phone, String verifyCode, String type);

	DataWrapper<User> updateUserInfo(User user,Certification certification,Integer number,String openid);

	DataWrapper<SaleInfo> updateSaleInfo(SaleInfo saleInfo, Integer number,String openid);

	DataWrapper<Object> judgeOpenid(String openid, String state);
}
