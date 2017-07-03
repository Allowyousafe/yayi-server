package com.yayiabc.http.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yayiabc.common.utils.Page;
import com.yayiabc.http.mvc.pojo.jpa.QbRecord;

@Repository
public interface UserMyQbDao {
	int add(QbRecord qbRecord);
	List<QbRecord> query(@Param("page")Page page,@Param("userId")String userId,@Param("type")Integer type);
	int getCount(@Param("userId")String userId);
}
