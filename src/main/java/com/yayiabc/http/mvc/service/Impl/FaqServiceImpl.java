package com.yayiabc.http.mvc.service.Impl;

import com.yayiabc.common.enums.ErrorCodeEnum;
import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.common.utils.Page;
import com.yayiabc.http.mvc.dao.FaqDao;
import com.yayiabc.http.mvc.dao.UtilsDao;
import com.yayiabc.http.mvc.pojo.jpa.FaqAnswer;
import com.yayiabc.http.mvc.pojo.jpa.FaqQuestion;
import com.yayiabc.http.mvc.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqDao faqDao;

    @Autowired
    private UtilsDao utilsDao;
    @Override
    public DataWrapper<FaqQuestion> addQuestion(String token, FaqQuestion faqQuestion) {
        DataWrapper<FaqQuestion> dataWrapper=new DataWrapper<FaqQuestion>();
        //获取userId
        String userId=utilsDao.getUserID(token);
        faqQuestion.setUserId(userId);
        //保存进数据库
        int reflectRows=faqDao.addQuestion(faqQuestion);
        if(reflectRows==0){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
            return dataWrapper;
        }
        dataWrapper.setData(faqQuestion);
        return dataWrapper;
    }

    @Override
    public DataWrapper<FaqAnswer> addAnswer(String token, FaqAnswer faqAnswer,Integer faqQuestionId) {
        DataWrapper<FaqAnswer> dataWrapper=new DataWrapper<FaqAnswer>();
        //获取userId
        String userId=utilsDao.getUserID(token);
        faqAnswer.setUserId(userId);
        //保存进数据库
        int reflectRows=faqDao.addAnswer(faqAnswer,faqQuestionId);
        if(reflectRows==0){
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
            return dataWrapper;
        }
        dataWrapper.setData(faqAnswer);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<FaqQuestion>> list(Integer faqQuestionType, Integer order,Integer currentPage,Integer numberPerPage) {
        DataWrapper<List<FaqQuestion>> dataWrapper=new DataWrapper<List<FaqQuestion>>();
        Page page=new Page();
        page.setNumberPerPage(numberPerPage);
        page.setCurrentPage(currentPage);
        int totalNumber=faqDao.getFaqQuestionTotalNumber(faqQuestionType);
        dataWrapper.setPage(page,totalNumber);
        List<FaqQuestion> faqQuestionList=faqDao.getFaqQuestionList(faqQuestionType,order,page.getCurrentNumber(),numberPerPage);
        dataWrapper.setData(faqQuestionList);
        return dataWrapper;
    }

    @Override
    public DataWrapper<FaqQuestion> questionDetail(Integer faqQuestionId, Integer currentPage, Integer numberPerPage) {
        DataWrapper<FaqQuestion> dataWrapper=new DataWrapper<FaqQuestion>();
        Page page=new Page();
        page.setNumberPerPage(numberPerPage);
        page.setCurrentPage(currentPage);
        int totalNumber=faqDao.getAnswerTotalNum(faqQuestionId);
        dataWrapper.setPage(page,totalNumber);
        FaqQuestion faqQuestion=faqDao.questionDetail(faqQuestionId);
        List<FaqAnswer> faqAnswerList=faqDao.questionAnswerList(faqQuestionId,page.getCurrentNumber(),numberPerPage);
        faqQuestion.setFaqAnswerList(faqAnswerList);
        dataWrapper.setData(faqQuestion);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<FaqQuestion>> myQuestion(String token, Integer currentPage, Integer numberPerPage) {
        DataWrapper<List<FaqQuestion>> dataWrapper=new DataWrapper<List<FaqQuestion>>();
        if(token==null) return dataWrapper;
        Page page=new Page();
        page.setNumberPerPage(numberPerPage);
        page.setCurrentPage(currentPage);
        String userId=utilsDao.getUserID(token);
        int totalNumber=faqDao.getMyQuestionTotalNum(userId);
        dataWrapper.setPage(page,totalNumber);
        List<FaqQuestion> faqQuestionList=faqDao.getMyQuestionList(userId,page.getCurrentNumber(),numberPerPage);
        dataWrapper.setData(faqQuestionList);
        return dataWrapper;
    }

    @Override
    public DataWrapper<List<FaqQuestion>> myAnswer(String token, Integer currentPage, Integer numberPerPage) {
        DataWrapper<List<FaqQuestion>> dataWrapper=new DataWrapper<List<FaqQuestion>>();
        if(token==null) return dataWrapper;
        Page page=new Page();
        page.setNumberPerPage(numberPerPage);
        page.setCurrentPage(currentPage);
        String userId=utilsDao.getUserID(token);
        //获取的是问题的总条数
        int totalNumber=faqDao.getAnswerNumGroupByQuestionId(userId);
        dataWrapper.setPage(page,totalNumber);
        List<Integer> questionIdList=faqDao.getFaqQuestionIdList(userId);
        List<FaqQuestion> faqQuestionList=null;
        if(questionIdList!=null&&questionIdList.size()!=0){
            faqQuestionList=faqDao.getMyAnswerList(questionIdList,page.getCurrentNumber(),numberPerPage,userId);
        }
        dataWrapper.setData(faqQuestionList);
        return dataWrapper;
    }
}
