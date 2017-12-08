package com.yayiabc.http.mvc.service.Impl;

import com.yayiabc.common.enums.ErrorCodeEnum;
import com.yayiabc.common.sessionManager.VerifyCodeManager;
import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.common.utils.MD5Util;
import com.yayiabc.common.utils.VerifiCodeValidateUtil;
import com.yayiabc.http.mvc.dao.AppUserDao;
import com.yayiabc.http.mvc.dao.UserDao;
import com.yayiabc.http.mvc.pojo.jpa.QbRecord;
import com.yayiabc.http.mvc.pojo.jpa.User;
import com.yayiabc.http.mvc.service.AppUserService;
import com.yayiabc.http.mvc.service.TokenService;
import com.yayiabc.http.mvc.service.UserMyQbService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 小月亮 on 2017/8/29.
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMyQbService userMyQbService;
    @Autowired
    private TokenService tokenService;
    @Override
    public DataWrapper<User> regiseter(User user,String code) {
        DataWrapper<User> dataWrapper = new DataWrapper<User>();
        if (userDao.getUserByPhone(user.getPhone()) == null) {
            ErrorCodeEnum codeEnum= VerifiCodeValidateUtil.verifiCodeValidate(user.getPhone(),code);
            dataWrapper.setErrorCode(codeEnum);
            if(!codeEnum.equals(ErrorCodeEnum.No_Error)){
                return dataWrapper;
            }
            user.setPwd(MD5Util.getMD5String(user.getPwd()));
            if (1 == userDao.register(user)) {
                VerifyCodeManager.removePhoneCodeByPhoneNum(user.getPhone());
                String token = tokenService.getToken(user.getUserId());
                QbRecord qbRecord=new QbRecord();
                qbRecord.setQbRget(60+"");
                qbRecord.setRemark("注册送60乾币");
                qbRecord.setQbType("qb_balance");
                userMyQbService.add(qbRecord, token);
                userDao.registerUserInfo(user);
                userDao.registerUserCertification(user);
                user.setCreated(new Date());
                dataWrapper.setData(user);
                dataWrapper.setToken(token);
            } else {
                dataWrapper.setErrorCode(ErrorCodeEnum.Register_Error);
            }
        } else {
            dataWrapper.setErrorCode(ErrorCodeEnum.Username_Already_Exist);
        }
        return dataWrapper;
    }


}
