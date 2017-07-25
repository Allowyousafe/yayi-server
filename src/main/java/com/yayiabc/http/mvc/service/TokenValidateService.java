package com.yayiabc.http.mvc.service;

public interface TokenValidateService {

	Integer getUserCountByLoginToken(String loginToken);

	Integer getUserStateByLoginToken(String loginToken);

	void updateUserLoginState(String loginToken);

	Integer getSaleCountByLoginToken(String loginToken);

	Integer getSaleStateByLoginToken(String loginToken);

	void updateSaleState(String loginToken);

	Integer getAdminCountByLoginToken(String loginToken);

}
