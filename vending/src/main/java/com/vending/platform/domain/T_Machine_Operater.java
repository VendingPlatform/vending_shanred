package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Machine_Operater:售货机详细信息表，记录在运营商处的分配
 * 
 * @author Miley_Ren
 */
public class T_Machine_Operater implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = -4564690143409202140L;
	/** 售货机信息ID */
	private Integer m_operater_id;
	/** 售货机ID */
	private Integer machine_id;
	/** 是否分配：0：未分配；1：已分配 */
	private Integer machine_assign;
	/** 售货机类型 */
	private String t_model_name;
	/** 分配给某员工 */
	private Integer user_id;
	/** 售货机详细地址 */
	private String machine_address;
	/** 售货机是否可用：0：不可用；1：可用 */
	private Integer machine_status;
	/** 所属售货机组 */
	private Integer group_id;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public T_Machine_Operater() {
		super();
	}

	public T_Machine_Operater(Integer m_operater_id, Integer machine_id, Integer machine_assign, String t_model_name,
			Integer user_id, String machine_address, Integer machine_status, Integer group_id, Integer operate_id,
			Date operate_date) {
		super();
		this.m_operater_id = m_operater_id;
		this.machine_id = machine_id;
		this.machine_assign = machine_assign;
		this.t_model_name = t_model_name;
		this.user_id = user_id;
		this.machine_address = machine_address;
		this.machine_status = machine_status;
		this.group_id = group_id;
		this.operate_id = operate_id;
		this.operate_date = operate_date;
	}

	public Integer getM_operater_id() {
		return m_operater_id;
	}

	public void setM_operater_id(Integer m_operater_id) {
		this.m_operater_id = m_operater_id;
	}

	public Integer getMachine_id() {
		return machine_id;
	}

	public void setMachine_id(Integer machine_id) {
		this.machine_id = machine_id;
	}

	public Integer getMachine_assign() {
		return machine_assign;
	}

	public void setMachine_assign(Integer machine_assign) {
		this.machine_assign = machine_assign;
	}

	public String getT_model_name() {
		return t_model_name;
	}

	public void setT_model_name(String t_model_name) {
		this.t_model_name = t_model_name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getMachine_address() {
		return machine_address;
	}

	public void setMachine_address(String machine_address) {
		this.machine_address = machine_address;
	}

	public Integer getMachine_status() {
		return machine_status;
	}

	public void setMachine_status(Integer machine_status) {
		this.machine_status = machine_status;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
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
		return "T_Machine_Operater [m_operater_id=" + m_operater_id + ", machine_id=" + machine_id + ", machine_assign="
				+ machine_assign + ", t_model_name=" + t_model_name + ", user_id=" + user_id + ", machine_address="
				+ machine_address + ", machine_status=" + machine_status + ", group_id=" + group_id + ", operate_id="
				+ operate_id + ", operate_date=" + operate_date + "]";
	}
}
