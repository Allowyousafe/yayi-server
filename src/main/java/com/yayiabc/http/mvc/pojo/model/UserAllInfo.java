package com.yayiabc.http.mvc.pojo.model;

import java.util.List;

import com.yayiabc.http.mvc.pojo.jpa.Receiver;

public class UserAllInfo {
	private String userId;

	private String trueName;

	private String phone;

	private Integer sex;

	private String bindTime;

	private String birthday;

	private String qq;

	private String userPic;

	private Integer type;

	private String companyName;

	private String part;

	private String workAddress;

	private String doctorPic;

	private Integer isBindSale;

	private String saleId;

	private String saleName;

	private String salePhone;

	private String saleCreated;

	private Integer bindUserNum;

	private String userCreated;

	private String certifyTime;

	private String latelyOrderDate;

	private Integer orderaCount;

	private Double orderaMoneyCount;

	private String medicalLicense; // 医疗机构执业许可证
	private String businessLicense; // 营业执照
	private String taxRegistration; // 税务登记证
	private String openingPermit; // 开户许可证
	private String radiologicalPermit; // 放射诊疗许可证
	private String idCardPositive; // 法人身份证正面
	private String idCardOtherside; // 法人身份证反面

	private List<Receiver> receiverList;

	public String getBindTime() {
		return bindTime;
	}

	public void setBindTime(String bindTime) {
		this.bindTime = bindTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getQq() {
		return qq;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getDoctorPic() {
		return doctorPic;
	}

	public void setDoctorPic(String doctorPic) {
		this.doctorPic = doctorPic;
	}

	public Integer getIsBindSale() {
		return isBindSale;
	}

	public void setIsBindSale(Integer isBindSale) {
		this.isBindSale = isBindSale;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public String getSalePhone() {
		return salePhone;
	}

	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getSaleCreated() {
		return saleCreated;
	}

	public void setSaleCreated(String saleCreated) {
		this.saleCreated = saleCreated;
	}

	public Integer getBindUserNum() {
		return bindUserNum;
	}

	public void setBindUserNum(Integer bindUserNum) {
		this.bindUserNum = bindUserNum;
	}

	public List<Receiver> getReceiverList() {
		return receiverList;
	}

	public void setReceiverList(List<Receiver> receiverList) {
		this.receiverList = receiverList;
	}

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public String getCertifyTime() {
		return certifyTime;
	}

	public void setCertifyTime(String certifyTime) {
		this.certifyTime = certifyTime;
	}

	public String getLatelyOrderDate() {
		return latelyOrderDate;
	}

	public void setLatelyOrderDate(String latelyOrderDate) {
		this.latelyOrderDate = latelyOrderDate;
	}

	public Integer getOrderaCount() {
		return orderaCount;
	}

	public void setOrderaCount(Integer orderaCount) {
		this.orderaCount = orderaCount;
	}

	public Double getOrderaMoneyCount() {
		return orderaMoneyCount;
	}

	public void setOrderaMoneyCount(Double orderaMoneyCount) {
		this.orderaMoneyCount = orderaMoneyCount;
	}

	public String getMedicalLicense() {
		return medicalLicense;
	}

	public void setMedicalLicense(String medicalLicense) {
		this.medicalLicense = medicalLicense;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getTaxRegistration() {
		return taxRegistration;
	}

	public void setTaxRegistration(String taxRegistration) {
		this.taxRegistration = taxRegistration;
	}

	public String getOpeningPermit() {
		return openingPermit;
	}

	public void setOpeningPermit(String openingPermit) {
		this.openingPermit = openingPermit;
	}

	public String getRadiologicalPermit() {
		return radiologicalPermit;
	}

	public void setRadiologicalPermit(String radiologicalPermit) {
		this.radiologicalPermit = radiologicalPermit;
	}

	public String getIdCardPositive() {
		return idCardPositive;
	}

	public void setIdCardPositive(String idCardPositive) {
		this.idCardPositive = idCardPositive;
	}

	public String getIdCardOtherside() {
		return idCardOtherside;
	}

	public void setIdCardOtherside(String idCardOtherside) {
		this.idCardOtherside = idCardOtherside;
	}

	public UserAllInfo() {
		super();
	}

	public UserAllInfo(String userId, String trueName, String phone,
			Integer sex, String birthday, String qq, String userPic,
			Integer type, String companyName, String part, String workAddress,
			String doctorPic, Integer isBindSale, String saleId,
			String saleName, String salePhone, String saleCreated,
			Integer bindUserNum, String userCreated, String certifyTime,
			String latelyOrderDate, Integer orderaCount, Double orderaMoneyCount, String medicalLicense,
			String businessLicense, String taxRegistration,
			String openingPermit, String radiologicalPermit,
			String idCardPositive, String idCardOtherside,
			List<Receiver> receiverList,String bindTime) {
		super();
		this.userId = userId;
		this.trueName = trueName;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.qq = qq;
		this.userPic = userPic;
		this.type = type;
		this.companyName = companyName;
		this.part = part;
		this.workAddress = workAddress;
		this.doctorPic = doctorPic;
		this.isBindSale = isBindSale;
		this.saleId = saleId;
		this.saleName = saleName;
		this.salePhone = salePhone;
		this.saleCreated = saleCreated;
		this.bindUserNum = bindUserNum;
		this.userCreated = userCreated;
		this.certifyTime = certifyTime;
		this.latelyOrderDate = latelyOrderDate;
		this.orderaCount = orderaCount;
		this.orderaMoneyCount = orderaMoneyCount;
		this.medicalLicense = medicalLicense;
		this.businessLicense = businessLicense;
		this.taxRegistration = taxRegistration;
		this.openingPermit = openingPermit;
		this.radiologicalPermit = radiologicalPermit;
		this.idCardPositive = idCardPositive;
		this.idCardOtherside = idCardOtherside;
		this.receiverList = receiverList;
		this.bindTime=bindTime;
	}

	@Override
	public String toString() {
		return "UserAllInfo [userId=" + userId + ", trueName=" + trueName
				+ ", phone=" + phone + ", sex=" + sex + ", birthday="
				+ birthday + ", qq=" + qq + ", userPic=" + userPic + ", type="
				+ type + ", companyName=" + companyName + ", part=" + part
				+ ", workAddress=" + workAddress + ", doctorPic=" + doctorPic
				+ ", isBindSale=" + isBindSale + ", saleId=" + saleId
				+ ", saleName=" + saleName + ", salePhone=" + salePhone
				+ ", saleCreated=" + saleCreated + ", bindUserNum="
				+ bindUserNum + ", userCreated=" + userCreated
				+ ", certifyTime=" + certifyTime + ", latelyOrderDate="
				+ latelyOrderDate + ", orderaCount=" + orderaCount
				+ ", orderaMoneyCount=" + orderaMoneyCount
				+ ", medicalLicense=" + medicalLicense + ", businessLicense="
				+ businessLicense + ", taxRegistration=" + taxRegistration
				+ ", openingPermit=" + openingPermit + ", radiologicalPermit="
				+ radiologicalPermit + ", idCardPositive=" + idCardPositive
				+ ", idCardOtherside=" + idCardOtherside + ", receiverList="
				+ receiverList + "]";
	}

}
