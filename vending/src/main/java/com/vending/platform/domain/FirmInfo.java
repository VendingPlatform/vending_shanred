package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Firm_Info映射类： 公司信息表，包括系统管理员、厂商和运营商
 * 
 * @author Miley_Ren
 */
public class FirmInfo implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = -3294054543209879646L;
	/** 公司ID */
	private Integer firm_id;
	/** 公司名称 */
	private String firm_name;
	/** 公司描述 */
	private String firm_desc;
	/** 公司类型：0：系统管理员；1：运营商；2：厂商 */
	private int firm_type;
	/** 公司状态：0：不可用；1：可用 */
	private int firm_status;
	/** 操作人ID */
	private int operate_id;
	/** 操作时间 */
	private Date operate_date;

	public FirmInfo() {
		super();
	}

	public Integer getFirm_id() {
		return firm_id;
	}

	public void setFirm_id(Integer firm_id) {
		this.firm_id = firm_id;
	}

	public String getFirm_name() {
		return firm_name;
	}

	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
	}

	public String getFirm_desc() {
		return firm_desc;
	}

	public void setFirm_desc(String firm_desc) {
		this.firm_desc = firm_desc;
	}

	public int getFirm_type() {
		return firm_type;
	}

	public void setFirm_type(int firm_type) {
		this.firm_type = firm_type;
	}

	public int getFirm_status() {
		return firm_status;
	}

	public void setFirm_status(int firm_status) {
		this.firm_status = firm_status;
	}

	public int getOperate_id() {
		return operate_id;
	}

	public void setOperate_id(int operate_id) {
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
		return "T_Firm_Info [firm_id=" + firm_id + ", firm_name=" + firm_name + ", firm_desc=" + firm_desc
				+ ", firm_type=" + firm_type + ", firm_status=" + firm_status + ", operate_id=" + operate_id
				+ ", operate_date=" + operate_date + "]";
	}

}
