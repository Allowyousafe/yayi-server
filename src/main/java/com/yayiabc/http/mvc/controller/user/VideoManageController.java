package com.yayiabc.http.mvc.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yayiabc.http.mvc.pojo.jpa.ItemInfo;
import com.yayiabc.http.mvc.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayiabc.common.annotation.AdminLog;
import com.yayiabc.common.annotation.AdminTokenValidate;
import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.pojo.jpa.VidManage;
import com.yayiabc.http.mvc.service.VideoManageService;

@Controller
@RequestMapping("api/vid")
public class VideoManageController {
     @Autowired
     private VideoManageService videoManageService;

    // @Autowired
     private RedisService redisService;
    
     //
     @RequestMapping("showVid")
     @ResponseBody
     public DataWrapper<Object> showVid(
             @RequestParam(value="rule",required = false,defaultValue = "3") Integer rule,//1,最多播放//2.最多评论
             @RequestParam(value="videoCategory",required = false)Integer videoCategory,//1.外科2.内科3.修复4.种植5.正畸
             @RequestParam(value="currentPage",required=false,defaultValue="1") Integer currentPage,
             @RequestParam(value="numberPerPage",required=false,defaultValue="10") Integer numberPerPage,
             @RequestHeader(value="token",required = false) String token
    		 ){
     	return videoManageService.showVid(rule,videoCategory,currentPage,numberPerPage,null,token);
     }
     
   //update
     @RequestMapping("updateVid")
     @ResponseBody
     @AdminTokenValidate
     @AdminLog(description="更改视频管理列表")
     public DataWrapper<Void> updateVid(
    		 @RequestHeader(value="adminToken",required=true) String adminToken,
     		@ModelAttribute VidManage vidManage
     		){
     	return videoManageService.updateVid(vidManage);
     }
     
     //insert
     @RequestMapping("insertVid")
     @ResponseBody
     public DataWrapper<Void> insertVid(
    		 @RequestHeader(value="adminToken",required=true) String adminToken,
    		 @ModelAttribute VidManage vidManage
     		){
         return videoManageService.insertVid(vidManage);
     }
     
   //delete
     @RequestMapping("deleteVid")
     @ResponseBody
     @AdminTokenValidate
     @AdminLog(description="删除视频管理列表")
     public DataWrapper<Void> deleteVid(
    		 @RequestHeader(value="adminToken",required=true) String adminToken,
     		@RequestParam(value="viId") Integer viId
     		){
     	return videoManageService.deleteVid(viId);
     }

     //播放视频
    @RequestMapping("play")
    @ResponseBody
    public DataWrapper<Void> play(
            @RequestParam(value="viId",required = true)Integer viId
    ){
    	return videoManageService.play(viId);
    }

    //获取视频详情
    @RequestMapping("detail")
    @ResponseBody
    public DataWrapper<VidManage> detail(
            @RequestParam(value="viId",required = true) Integer viId
    ){
            return videoManageService.detail(viId);
    }

    //添加收藏或者取消收藏
    @RequestMapping("star")
    @ResponseBody
    public DataWrapper<Void> star(
            @RequestHeader(value="token",required = true) String token,
            @RequestParam(value="viId",required = true) Integer viId
    ){
                return videoManageService.star(token,viId);
    }

    //视频相关商品
    public DataWrapper<ItemInfo> videoItem(
            @RequestParam(value="viId",required = true) Integer viId
    ){
            return videoManageService.videoItem(viId);
    }



}
