package com.vending.platform.domain;

import java.util.Date;

public class SaaSRentOrder {

	private String rentOrderId;
	private Integer firmId;
	private Integer machineNum;
	private Double sumPrice;
	private String startTime;
	private String endTime;

	public SaaSRentOrder() {
		super();
	}

	public String getRentOrderId() {
		return rentOrderId;
	}

	public void setRentOrderId(String rentOrderId) {
		this.rentOrderId = rentOrderId;
	}

	public Integer getFirmId() {
		return firmId;
	}

	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
	}

	public Integer getMachineNum() {
		return machineNum;
	}

	public void setMachineNum(Integer machineNum) {
		this.machineNum = machineNum;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "SaaSRentOrder [rentOrderId=" + rentOrderId + ", firmId=" + firmId + ", machineNum=" + machineNum
				+ ", sumPrice=" + sumPrice + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}