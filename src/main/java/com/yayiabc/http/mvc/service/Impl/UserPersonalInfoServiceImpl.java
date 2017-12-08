package com.yayiabc.http.mvc.service.Impl;

import com.yayiabc.common.enums.ErrorCodeEnum;
import com.yayiabc.common.utils.DataWrapper;
import com.yayiabc.http.mvc.dao.UserPersonalInfoDao;
import com.yayiabc.http.mvc.dao.UtilsDao;
import com.yayiabc.http.mvc.pojo.jpa.Certification;
import com.yayiabc.http.mvc.pojo.jpa.User;
import com.yayiabc.http.mvc.pojo.model.UserPersonalInfo;
import com.yayiabc.http.mvc.service.UserPersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserPersonalInfoServiceImpl implements UserPersonalInfoService {

	@Autowired
	UserPersonalInfoDao userPersonalInfoDao;
	@Autowired
	UtilsDao utilsDao;

	@Override
	public DataWrapper<User> updateUser(User user, String token) {
		DataWrapper<User> dataWrapper = new DataWrapper<User>();
		String userId = utilsDao.getUserID(token);// 根据token查询userId
		user.setUserId(userId);
		Certification certification=user.getCertification();
		certification.setUserId(userId);
		userPersonalInfoDao.updateUser(user);
		userPersonalInfoDao.updateCertification(certification);
		return dataWrapper;
	}

	@Override
	public DataWrapper<Certification> updateCertification(
			Certification certification, String token) {
		DataWrapper<Certification> dataWrapper = new DataWrapper<Certification>();
		String userId = utilsDao.getUserID(token);
		certification.setUserId(userId);
		int i = userPersonalInfoDao.updateCertification(certification);
		if (i > 0) {
			UserPersonalInfo userPersonalInfo = userPersonalInfoDao.detail(userId);
			if(userPersonalInfo.getType()==1){
				if(userPersonalInfo.getDoctorPic() !=null ){
					userPersonalInfoDao.updateState(userId);
				}
			}else if(userPersonalInfo.getType()==2){
				if(userPersonalInfo.getMedicalLicense() !=null &&
					userPersonalInfo.getBusinessLicense() !=null &&
					userPersonalInfo.getTaxRegistration()!=null){
					userPersonalInfoDao.updateState(userId);
				}
			}
			dataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
		} else {
			dataWrapper.setErrorCode(ErrorCodeEnum.Error);
		}
		return dataWrapper;
	}

	@Override
	public DataWrapper<UserPersonalInfo> detail(String token) {
		DataWrapper<UserPersonalInfo> dataWrapper = new DataWrapper<UserPersonalInfo>();
		String userId = utilsDao.getUserID(token);
		if (userId == null) {
			dataWrapper.setErrorCode(ErrorCodeEnum.Error);
			dataWrapper.setMsg("token错误");
		} else {
			UserPersonalInfo userPersonalInfo = userPersonalInfoDao.detail(userId);
			dataWrapper.setData(userPersonalInfo);
		}
		return dataWrapper;
	}

	@Override
	public DataWrapper<Map<String, String>> queryBind(Integer state,String salePhone,String token) {
		DataWrapper<Map<String, String>> dataWrapper =new DataWrapper<Map<String, String>>();
		String userId=utilsDao.getUserID(token);
		Map<String, String> map =new HashMap<String, String>();
		if(userId==null){
			dataWrapper.setErrorCode(ErrorCodeEnum.Error);
			dataWrapper.setMsg("token错误");
		}else{
			if(state==1){
				List<String> list=userPersonalInfoDao.queryBind(userId);
					map.put("isBindSale", list.get(0));
					map.put("saleName", list.get(1));
					map.put("salePhone",list.get(2));
				dataWrapper.setData(map);
			}else{
				map=userPersonalInfoDao.querySale(salePhone);
				dataWrapper.setData(map);
			}
		}
		return dataWrapper;
	}

}
