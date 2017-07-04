package com.yayiabc.http.mvc.controller.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.model.ItemStatistics;
import com.yayiabc.http.mvc.service.ItemStatisticsService;

@Controller
@RequestMapping("api/itemStatistics")
public class ItemStatisticsController {

	@Autowired
	ItemStatisticsService itemStatisticsService;
	
	/**
	 * 商品统计
	 */
	@RequestMapping(value="query",method=RequestMethod.GET)
	@ResponseBody
	public DataWrapper<List<ItemStatistics>> query(
			@RequestParam(value="itemName",required=true)String itemName,
			@RequestParam(value="itemId",required=true)String itemId,
			@RequestParam(value="itemSKU",required=true)String itemSKU,
			@RequestParam(value="itemBrandName",required=true)String itemBrandName,
			@RequestParam(value="currentPage",required=false,defaultValue="1") Integer currentPage,
    		@RequestParam(value="numberPerPage",required=false,defaultValue="10") Integer numberPerPage,
			@RequestParam(value="token",required=true)String token
	){
		return itemStatisticsService.query(itemName, itemId, itemSKU, itemBrandName,currentPage,numberPerPage);
	}
}