package com.vending.platform.domain;

import java.util.Date;

public class ChannelHistory {
	/** 货道ID */
	private Integer channelHistory;
	private String machineName;
	private String wareName;
	private Double price;

	/** 货道编号 */
	private String channelNo;
	/** 新增存货量 */
	private Integer stockNumAdd;

	private Integer firmId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	public ChannelHistory() {
		super();
	}

	public ChannelHistory(  String machineName, String wareName, Double price, String channelNo,
			Integer stockNumAdd, Integer firmId, Integer operateId) {
		super();
		this.machineName = machineName;
		this.wareName = wareName;
		this.price = price;
		this.channelNo = channelNo;
		this.stockNumAdd = stockNumAdd;
		this.firmId = firmId;
		this.operateId = operateId;
	}

	public Integer getChannelHistory() {
		return channelHistory;
	}

	public void setChannelHistory(Integer channelHistory) {
		this.channelHistory = channelHistory;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public Integer getStockNumAdd() {
		return stockNumAdd;
	}

	public void setStockNumAdd(Integer stockNumAdd) {
		this.stockNumAdd = stockNumAdd;
	}

	public Integer getFirmId() {
		return firmId;
	}

	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}


}
