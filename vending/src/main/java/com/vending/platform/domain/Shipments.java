package com.vending.platform.domain;

/**商品出货类*/
import java.io.Serializable;
import java.util.Date;

public class Shipments implements Serializable {
	private static final long serialVersionUID = 62124098861495697L;
	private Integer shipId;
	private Integer wareId;
	private String shipNo;
	private Integer num;
	private Integer userId;
	private Integer type;
	private Integer isSend;
	private String descr;
	private Date operateDate;
	
	private WareInfo wareInfo;
	private UserInfo userInfo;
	
	public Shipments() {
		super();
	}


	public Integer getShipId() {
		return shipId;
	}


	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}


	public Integer getWareId() {
		return wareId;
	}


	public void setWareId(Integer wareId) {
		this.wareId = wareId;
	}


	public String getShipNo() {
		return shipNo;
	}


	public void setShipNo(String shipNo) {
		this.shipNo = shipNo;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public WareInfo getWareInfo() {
		return wareInfo;
	}


	public void setWareInfo(WareInfo wareInfo) {
		this.wareInfo = wareInfo;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public Integer getIsSend() {
		return isSend;
	}


	public void setIsSend(Integer isSend) {
		this.isSend = isSend;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public Date getOperateDate() {
		return operateDate;
	}


	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}


	@Override
	public String toString() {
		return "Shipments [shipId=" + shipId + ", wareId=" + wareId + ", shipNo=" + shipNo + ", num=" + num
				+ ", userId=" + userId + ", descr=" + descr + ", operateDate=" + operateDate + ", wareInfo=" + wareInfo
				+ ", userInfo=" + userInfo + "]";
	}
}
