package com.yayiabc.http.mvc.pojo.jpa;

import java.util.Date;

/**
 * 
 * @author xiaojiang 销售员收入表
 */
public class SaleIncome extends BasePojo {
	private Integer saleIncomeId;

	private String saleId;

	private String orderId;

	private Integer getMoney;

	private Integer getState;
	private Date updated;
	private Ordera order;
	private MakerTime makerTime;
    private SaleInfo saleInfo;
    
	public SaleInfo getSaleInfo() {
		return saleInfo;
	}


	public MakerTime getMakerTime() {
		return makerTime;
	}


	public void setMakerTime(MakerTime makerTime) {
		this.makerTime = makerTime;
	}


	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}

	public Ordera getOrder() {
		return order;
	}

	public void setOrder(Ordera order) {
		this.order = order;
	}

	public Integer getSaleIncomeId() {
		return saleIncomeId;
	}

	public void setSaleIncomeId(Integer saleIncomeId) {
		this.saleIncomeId = saleIncomeId;
	}

	@Override
    public Date getUpdated() {
		return updated;
	}

	@Override
    public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public Integer getGetMoney() {
		return getMoney;
	}

	public void setGetMoney(Integer getMoney) {
		this.getMoney = getMoney;
	}

	public Integer getGetState() {
		return getState;
	}

	public void setGetState(Integer getState) {
		this.getState = getState;
	}

	@Override
	public String toString() {
		return "SaleIncome [getMoney=" + getMoney + ", update=" + updated + "]";
	}

	
}