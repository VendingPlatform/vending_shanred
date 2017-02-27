package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Machine_Type：售货机类型
 * 
 * @author Miley_Ren
 */
public class T_Machine_Type implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 5344374703114752178L;
	/** 类型主键 */
	private Integer t_model_id;
	/** 类型名称 */
	private String t_model_name;
	/** 厂商ID */
	private Integer firm_id;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;
	public T_Machine_Type() {
		super();
	}
	public Integer getT_model_id() {
		return t_model_id;
	}
	public void setT_model_id(Integer t_model_id) {
		this.t_model_id = t_model_id;
	}
	public String getT_model_name() {
		return t_model_name;
	}
	public void setT_model_name(String t_model_name) {
		this.t_model_name = t_model_name;
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
		return "T_Machine_Type [t_model_id=" + t_model_id + ", t_model_name=" + t_model_name + ", firm_id=" + firm_id
				+ ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}
}
