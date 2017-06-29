package com.yayiabc.http.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yayiabc.http.mvc.pojo.jpa.Cart;
import com.yayiabc.http.mvc.pojo.jpa.ItemStar;

@Repository
public interface CartDao {
	List<Cart> list(String userId);
	
	int delete(@Param("userId")String userId,@Param("itemSKU")String itemSKU);
	
	int star(ItemStar itemStar);
	
	int add(Cart cart);
	
	int getCountItemSKU(String itemSKU);
	
	//每次数量+
	void updateOne(@Param("userId")String userId,@Param("itemSKU")String itemSKU,@Param("num")Integer num);
	
	//直接传值修改数量
	int updateNum(@Param("userId")String userId,@Param("num")Integer num,@Param("itemSKU")String itemSKU);
}
