package com.yayiabc.http.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.yayiabc.common.utils.Page;
import com.yayiabc.http.mvc.pojo.jpa.SaleInfo;
@Repository
public interface SaleListDao {
	List<SaleInfo> query(@Param("saleId")String saleId,@Param("phone")String phone,@Param("trueName")String trueName,@Param("isBindUser")Integer isBindUser,@Param("page")Page page);

	int getCount(@Param("saleId")String saleId,@Param("phone")String phone,@Param("trueName")String trueName,@Param("isBindUser")Integer isBindUser);
}
