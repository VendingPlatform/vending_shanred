package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Machine_Info映射表：售货机信息表
 * 
 * @author Miley_Ren
 */
public class T_Machine_Info implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 8140170825790827210L;

	/** 售货机ID */
	private Integer machine_id;
	/** 售货机名牌号 */
	private String machine_name;
	/** 售货机主板号 */
	private String machine_pannel;
	/** 厂商ID */
	private Integer manu_firm_id;
	/** 售货机价格 */
	private double machine_price;
	/** 售货机类型 */
	private String t_model_name;
	/** 售货机出售状态 ：0：未售出；1：售出；2：回收 */
	private Integer manu_machine_status;
	/** 卖给某运营商 */
	private Integer oper_firm_id;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public T_Machine_Info() {
		super();
	}

	public T_Machine_Info(Integer machine_id, String machine_name, String machine_pannel, Integer manu_firm_id,
			double machine_price, String t_model_name, Integer manu_machine_status, Integer oper_firm_id,
			Integer operate_id, Date operate_date) {
		super();
		this.machine_id = machine_id;
		this.machine_name = machine_name;
		this.machine_pannel = machine_pannel;
		this.manu_firm_id = manu_firm_id;
		this.machine_price = machine_price;
		this.t_model_name = t_model_name;
		this.manu_machine_status = manu_machine_status;
		this.oper_firm_id = oper_firm_id;
		this.operate_id = operate_id;
		this.operate_date = operate_date;
	}

	public Integer getMachine_id() {
		return machine_id;
	}

	public void setMachine_id(Integer machine_id) {
		this.machine_id = machine_id;
	}

	public String getMachine_name() {
		return machine_name;
	}

	public void setMachine_name(String machine_name) {
		this.machine_name = machine_name;
	}

	public String getMachine_pannel() {
		return machine_pannel;
	}

	public void setMachine_pannel(String machine_pannel) {
		this.machine_pannel = machine_pannel;
	}

	public Integer getManu_firm_id() {
		return manu_firm_id;
	}

	public void setManu_firm_id(Integer manu_firm_id) {
		this.manu_firm_id = manu_firm_id;
	}

	public double getMachine_price() {
		return machine_price;
	}

	public void setMachine_price(double machine_price) {
		this.machine_price = machine_price;
	}

	public String getT_model_name() {
		return t_model_name;
	}

	public void setT_model_name(String t_model_name) {
		this.t_model_name = t_model_name;
	}

	public Integer getManu_machine_status() {
		return manu_machine_status;
	}

	public void setManu_machine_status(Integer manu_machine_status) {
		this.manu_machine_status = manu_machine_status;
	}

	public Integer getOper_firm_id() {
		return oper_firm_id;
	}

	public void setOper_firm_id(Integer oper_firm_id) {
		this.oper_firm_id = oper_firm_id;
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
		return "T_Machine_Info [machine_id=" + machine_id + ", machine_name=" + machine_name + ", machine_pannel="
				+ machine_pannel + ", manu_firm_id=" + manu_firm_id + ", machine_price=" + machine_price
				+ ", t_model_name=" + t_model_name + ", manu_machine_status=" + manu_machine_status + ", oper_firm_id="
				+ oper_firm_id + ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}
}
