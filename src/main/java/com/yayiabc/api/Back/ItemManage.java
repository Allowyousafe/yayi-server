package com.yayiabc.api.Back;

public interface ItemManage {
	/**
	 * 
	 * @api {post} /api/item/queryItemBrand  （后台）根据商品品牌名称和品牌产地来查询品牌
	 * @apiName queryItemBrand
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  获取品牌分类,支持品牌名称和产地查询
	 * 
	 * @apiParam {String} itemBrandName  品牌名称
	 * @apiParam {String} itemBrandHome  品牌产地
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data (List):{
	 * itemBrandId:15645345345641,
	 * itemBrandLogo:"牙具",
	 * itemBrandHome:"国产",
	 * itemBrandName:"牙博士"
	 * }
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:0, 
	 * currentPage:0, 
	 * totalNumber:0,
	 * totalPage:0 
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:0, 
	 * currentPage:0,
	 * totalNumber:0, 
	 * totalPage:0 
	 * }
	 * 
	 */
	
	/**
	 * 
	 * @api {post} /api/item/deleteItemBrand  （后台）删除商品品牌
	 * @apiName deleteItemBrand
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  删除商品品牌
	 * 
	 * @apiParam {Integer} itemBrandId  品牌id(必须)
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data :null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	
	/**
	 * 
	 * @api {post} /api/item/updateItemBrand  （后台）修改商品品牌
	 * @apiName updateItemBrand
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  修改商品品牌
	 * 
	 * @apiParam {Integer} itemBrandId  品牌id(必须)
	 * @apiParam {String} itemBrandName  品牌名称(必须)
	 * @apiParam {String} itemBrandLogo  品牌logo(必须)
	 * @apiParam {String} itemBrandHome  品牌产地(必须)
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data :null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * 
	 * @api {post} /api/item/addItemBrand  （后台）增加商品品牌
	 * @apiName addItemBrand
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  增加商品品牌
	 * 
	 * @apiParam {String} itemBrandName  品牌名称(必须)
	 * @apiParam {String} itemBrandHome  品牌产地(必须)
	 * @apiParam {String} itemBrandLogo  品牌logo(必须)
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data :null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * 
	 * @api {post} /api/item/queryProperty  （后台）查询属性及显示属性列表
	 * @apiName updateItemBrand
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  查询属性及显示属性列表
	 * 
	 * @apiParam {String} itemPropertyName  属性名称(非必须)
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data (List):{
	 * itemPropertyId:5541364123,
	 * itemPropertyName:"属性名称",
	 * itempropertydList (List) :{
	 * 		itemSKU:14654111651652,
	 * 		itemPparam:"属性值",
	 * 		isEnable:1
	 * 		}
	 * },
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	
	/**
	 * 
	 * @api {post} /api/item/deleteProperty  （后台）删除属性
	 * @apiName deleteProperty
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  删除属性
	 * 
	 * @apiParam {Integer} itemPropertyId  属性Id
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data:null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * 
	 * @api {post} /api/item/deletePropertyd  （后台）删除属性值
	 * @apiName deletePropertyd
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  删除属性值
	 * 
	 * @apiParam {Integer} itemPropertyId  商品属性详情的id值
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data:null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	
	/**
	 * 
	 * @api {post} /api/item/updatePropertyd  （后台）修改属性值
	 * @apiName updatePropertyd
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  修改属性值
	 * 
	 * @apiParam {Integer} itemPropertyId  商品属性详情的id值
	 * @apiParam {String} itemPparam 商品属性值
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data:null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * @api {post} /api/item/updateProperty  （后台）保存修改属性
	 * @apiName updateProperty
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  保存修改属性
	 * 
	 * @apiParam  {Integer} itemPropertyId  商品属性id
	 * @apiParam  {String} itemPropertyName 商品属性名称
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data:null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * @api {post} /api/item/addProperty  （后台）添加属性
	 * @apiName addProperty
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  添加属性
	 * 
	 * @apiParam  {String} itemPropertyName  属性值
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data:null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * 
	 * @api {post} /api/item/addToPropertyd  （后台）添加属性值
	 * @apiName addToPropertyd
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  添加属性值
	 * 
	 * @apiParam  {Integer} itemPid     属性名称Id
	 * @apiParam  {String} itemPparam   属性值
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data:null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * 
	 * @api {post} /api/item/addPropertydAndPropertyName  （后台）添加属性值
	 * @apiName addPropertydAndPropertyName
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  添加属性值
	 * 
	 * @apiParam  {String} itemPropertyName  属性名
	 * @apiParam  {String} itemPparam       属性值
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data:null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	
	
	/**
	 * 
	 * @api {post} /api/item/showItemClassify  （后台）分类显示
	 * @apiName showItemClassify
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  分类列表显示
	 * 
	 * @apiParam  {String} itemClassifyName 商品分类名称
	 * @apiParam  {String} itemPreviousClassify  上级分类名称
	 * 
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data (List):{
	 * itemClassifyId:14564336,
	 * itemClassifyGrade:"分类等级",
	 * itemClassifyName:"分类名称",
	 * itemPreviousClassify:"上级分类名称"
	 * },
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	
	/**
	 * 
	 * @api {post} /api/item/deleteItemClassify  （后台）删除分类
	 * @apiName deleteItemClassify
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  删除分类
	 * 
	 * @apiParam  {Integer} itemClassifyId     商品分类Id
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data :null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	
	/**
	 * 
	 * @api {post} /api/item/deleteItemClassify  （后台）修改商品分类
	 * @apiName updateItemClassify
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  修改商品分类
	 * 
	 * @apiParam  {Integer} itemClassifyId     商品分类Id
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data :null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	/**
	 * 
	 * @api {get} /api/item/addItemClassify  （后台）新增商品分类
	 * @apiName addItemClassify
	 * @apiGroup itemManage
	 * @apiVersion 0.1.0
	 * @apiDescription  添加商品分类
	 * 
	 * @apiParam  {String} itemClassifyName    商品分类名称
	 * @apiParam  {String} itemPreviousClassify 父级分类的名称
	 * 
	 * @apiSuccessExample {json} Success-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"SUCCEED", 
	 * errorCode:"No_Error",
	 * data :null,
	 * token:"SK1d7a4fe3-c2cd-417f-8f6f-bf7412592996",
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"正确"
	 *}
	 * 
	 * @apiSuccessExample {json} Error-Response: 
	 * HTTP/1.1 200 OK 
	 * {
	 * callStatus:"FAILED", 
	 * errorCode:"Error", 
	 * data:null,
	 * token:null, 
	 * numberPerPage:null, 
	 * currentPage:null, 
	 * totalNumber:null,
	 * totalPage:null,
	 * num:null,
	 * msg:"错误"
	 * }
	 * 
	 */
	
	
	
}
