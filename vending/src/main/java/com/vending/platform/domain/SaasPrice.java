package com.vending.platform.domain;

import java.io.Serializable;

public class SaasPrice implements Serializable{
	private static final long serialVersionUID = 8417411660985661210L;
	//定价名称
	private String priceName;
	//定价，以分为单位
	private Integer price;
	//折扣比率
	private Integer discount;
	public SaasPrice() {
		super();
	}
	public String getPriceName() {
		return priceName;
	}
	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
