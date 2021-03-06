package com.yayiabc.http.mvc.service;

import java.util.List;

import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.model.ItemStatistics;

public interface ItemStatisticsService {
	DataWrapper<List<ItemStatistics>> query(String itemName,String itemId,String itemSKU,String itemBrandName,String startDate,String endDate,Integer currentPage,Integer numberPerPage,Integer state);
}
