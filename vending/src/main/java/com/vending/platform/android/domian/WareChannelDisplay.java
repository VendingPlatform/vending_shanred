package com.vending.platform.android.domian;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class WareChannelDisplay implements Serializable {

	private static final long serialVersionUID = 5262569567984065238L;

	private Integer channelId;
	private String channelNo;
	private String wareName;
	private Integer stockNumNow;
	private Double price;
	private String wareDesc;
	private Integer isDiscount;
	private Integer mOperaterId;

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public Integer getStockNumNow() {
		return stockNumNow;
	}

	public void setStockNumNow(Integer stockNumNow) {
		this.stockNumNow = stockNumNow;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getWareDesc() {
		return wareDesc;
	}

	public void setWareDesc(String wareDesc) {
		this.wareDesc = wareDesc;
	}

	public Integer getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(Integer isDiscount) {
		this.isDiscount = isDiscount;
	}

	public Integer getmOperaterId() {
		return mOperaterId;
	}

	public void setmOperaterId(Integer mOperaterId) {
		this.mOperaterId = mOperaterId;
	}

	public JSONObject getJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("channelId", channelId);
		jsonObject.put("channelNo", channelNo);
		jsonObject.put("wareName", wareName);
		jsonObject.put("stockNumNow", stockNumNow);
		jsonObject.put("price", price);
		jsonObject.put("wareDesc", wareDesc);
		jsonObject.put("isDiscount", isDiscount);
		jsonObject.put("mOperaterId", mOperaterId);
		return jsonObject;
	}
}
