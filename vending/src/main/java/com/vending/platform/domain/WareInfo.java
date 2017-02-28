package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Ware_Info:商品信息表
 *
 * @author Miley_Ren
 */
public class WareInfo implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = -3601449521375525963L;

	/** 商品ID */
	private Integer ware_id;
	/** 商品编号 */
	private String ware_code;
	/** 商品名称 */
	private String ware_name;
	/** 商品规格，如：每箱多少瓶 */
	private String ware_norm;
	/** 商品单位 */
	private String ware_unit;
	/** 商品进价 */
	private double ware_base_price;
	/** 最高售价 */
	private double ware_max_price;
	/** 最低售价 */
	private double ware_min_price;
	/** 商品描述 */
	private String ware_desc;
	/** 所属运营商ID */
	private Integer firm_id;
	/** 商品状态：0：可用；1：不可用 */
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public WareInfo() {
		super();
	}

	public Integer getWare_id() {
		return ware_id;
	}

	public void setWare_id(Integer ware_id) {
		this.ware_id = ware_id;
	}

	public String getWare_code() {
		return ware_code;
	}

	public void setWare_code(String ware_code) {
		this.ware_code = ware_code;
	}

	public String getWare_name() {
		return ware_name;
	}

	public void setWare_name(String ware_name) {
		this.ware_name = ware_name;
	}

	public String getWare_norm() {
		return ware_norm;
	}

	public void setWare_norm(String ware_norm) {
		this.ware_norm = ware_norm;
	}

	public String getWare_unit() {
		return ware_unit;
	}

	public void setWare_unit(String ware_unit) {
		this.ware_unit = ware_unit;
	}

	public double getWare_base_price() {
		return ware_base_price;
	}

	public void setWare_base_price(double ware_base_price) {
		this.ware_base_price = ware_base_price;
	}

	public double getWare_max_price() {
		return ware_max_price;
	}

	public void setWare_max_price(double ware_max_price) {
		this.ware_max_price = ware_max_price;
	}

	public double getWare_min_price() {
		return ware_min_price;
	}

	public void setWare_min_price(double ware_min_price) {
		this.ware_min_price = ware_min_price;
	}

	public String getWare_desc() {
		return ware_desc;
	}

	public void setWare_desc(String ware_desc) {
		this.ware_desc = ware_desc;
	}

	public Integer getFirm_id() {
		return firm_id;
	}

	public void setFirm_id(Integer firm_id) {
		this.firm_id = firm_id;
	}

	public Integer getOperate_id() {
		return operate_id;
	}

	public void setOperate_id(Integer operate_id) {
		this.operate_id = operate_id;
	}

	public Date getOperate_date() {
		return operate_date;
	}

	public void setOperate_date(Date operate_date) {
		this.operate_date = operate_date;
	}

	@Override
	public String toString() {
		return "T_Ware_Info [ware_id=" + ware_id + ", ware_code=" + ware_code + ", ware_name=" + ware_name
				+ ", ware_norm=" + ware_norm + ", ware_unit=" + ware_unit + ", ware_base_price=" + ware_base_price
				+ ", ware_max_price=" + ware_max_price + ", ware_min_price=" + ware_min_price + ", ware_desc="
				+ ware_desc + ", firm_id=" + firm_id + ", operate_id=" + operate_id + ", operate_date=" + operate_date
				+ "]";
	}

}
