package com.yayiabc.http.mvc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yayiabc.http.mvc.pojo.jpa.ItemClassify;
import com.yayiabc.http.mvc.pojo.jpa.ItemProperty;
import com.yayiabc.http.mvc.pojo.jpa.ItemPropertyd;
@Repository
public interface ItemManageDao {
	
	List<ItemProperty> queryProperty(String itemPropertyName);

	void deleteProperty(Integer itemPropertyId);

	void deletePropertyd(Integer itemPropertyId);

	void deletePropertydBySKU(String itemSKU);

	void updatePropertyd(ItemPropertyd itemPropertyd);

	void updateProperty(ItemProperty itemProperty);

	List<ItemClassify> showItemClassify(ItemClassify itemClassify);

	void deleteItemClassify(String itemClassifyName);
	//查询该商品分类是否为父类
	int queryItemClassify(String itemClassifyName);

	String queryItemClassifyName(Integer itemClassifyId);


	void addProperty(String itemPropertyName);

	

	void addItemClassify(ItemClassify itemClassify);

	void addPropertyd(List<String> itemPparamList);

	Integer queryItemPropertyIdByName(String itemPropertyName);

	void addPropertyd(Map<String, Object> map);

	void addPropertyd(ItemProperty itemProperty);

	void insertItemClassify(ItemClassify itemClassify);

	void insertItemClassifyTwo(ItemClassify itemClassify);

	void insertItemClassifyThree(ItemClassify itemClassify);

	void deleteItemClassify(ItemClassify itemClassify);

	void deleteItemClassifyTwo(ItemClassify itemClassify);

	void deleteItemClassifyThree(ItemClassify itemClassify);

	void updateItemClassify(ItemClassify itemClassify);
	
	void updateItemClassifyOne(ItemClassify itemClassify);
	
	void updateItemClassifyTwo(ItemClassify itemClassify);

	void updateItemClassifyThree(ItemClassify itemClassify);

	void deleteItemClassifyOneSon(ItemClassify itemClassify);

	void deleteItemClassifyTwoSon(ItemClassify itemClassify);

	String queryItemClassifyByName(ItemClassify itemClassify);

	void deleteItemClassifyOne(ItemClassify itemClassify);


	



	

	

}
