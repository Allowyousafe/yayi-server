package com.yayiabc.http.mvc.pojo.jpa;

import java.util.Date;

/**
 * 
 * @author xiaojiang 乾币记录表
 */
public class QbRecord extends BasePojo {
	private Integer qbRid;

	private String userId;

	private Integer qbRget;

	private Integer qbRout;

	private String qbTime;

	private Integer qbBalances;

	private String remark;

	private Integer millisecond; // 毫秒

	private User user;
	private String qbType;
	public Integer getQbRid() {
		return qbRid;
	}
	public void setQbRid(Integer qbRid) {
		this.qbRid = qbRid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getQbRget() {
		return qbRget;
	}
	public void setQbRget(Integer qbRget) {
		this.qbRget = qbRget;
	}
	public Integer getQbRout() {
		return qbRout;
	}
	public void setQbRout(Integer qbRout) {
		this.qbRout = qbRout;
	}
	public String getQbTime() {
		return qbTime;
	}
	public void setQbTime(String qbTime) {
		this.qbTime = qbTime;
	}
	public Integer getQbBalances() {
		return qbBalances;
	}
	public void setQbBalances(Integer qbBalances) {
		this.qbBalances = qbBalances;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getMillisecond() {
		return millisecond;
	}
	public void setMillisecond(Integer millisecond) {
		this.millisecond = millisecond;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getQbType() {
		return qbType;
	}
	public void setQbType(String qbType) {
		this.qbType = qbType;
	}
	@Override
	public String toString() {
		return "QbRecord [qbRid=" + qbRid + ", userId=" + userId + ", qbRget=" + qbRget + ", qbRout=" + qbRout
				+ ", qbTime=" + qbTime + ", qbBalances=" + qbBalances + ", remark=" + remark + ", millisecond="
				+ millisecond + ", user=" + user + ", qbType=" + qbType + "]";
	}
}