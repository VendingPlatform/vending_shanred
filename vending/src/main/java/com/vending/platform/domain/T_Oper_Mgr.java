package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Oper_Mgr运营商管理映射类，为厂商所用，映射了与厂商有合作的运营商
 * 
 * @author Miley_Ren
 */
public class T_Oper_Mgr implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = -6417710404887297902L;
	/** 主键 */
	private Integer oper_mge_id;
	/** 运营商ID */
	private Integer firm_id;
	/** 运营商名称 */
	private String firm_name;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public T_Oper_Mgr(Integer oper_mge_id, Integer firm_id, String firm_name, Integer operate_id, Date operate_date) {
		super();
		this.oper_mge_id = oper_mge_id;
		this.firm_id = firm_id;
		this.firm_name = firm_name;
		this.operate_id = operate_id;
		this.operate_date = operate_date;
	}

	public Integer getOper_mge_id() {
		return oper_mge_id;
	}

	public void setOper_mge_id(Integer oper_mge_id) {
		this.oper_mge_id = oper_mge_id;
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
		return "T_Oper_Mgr [oper_mge_id=" + oper_mge_id + ", firm_id=" + firm_id + ", firm_name=" + firm_name
				+ ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}

}
