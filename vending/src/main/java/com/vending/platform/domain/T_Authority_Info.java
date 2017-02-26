package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Authority_Info映射表：用户权限映射表
 * 
 * @author Miley_Ren
 */
public class T_Authority_Info implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = -1610238727257309621L;
	/** 权限ID */
	private Integer auth_id;
	/** 权限名 */
	private String auth_name;
	/** 权限编码 */
	private String auth_code;
	/** 操作者ID */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public T_Authority_Info() {
		super();
	}

	public T_Authority_Info(Integer auth_id, String auth_name, String auth_code, Integer operate_id,
			Date operate_date) {
		super();
		this.auth_id = auth_id;
		this.auth_name = auth_name;
		this.auth_code = auth_code;
		this.operate_id = operate_id;
		this.operate_date = operate_date;
	}

	public Integer getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(Integer auth_id) {
		this.auth_id = auth_id;
	}

	public String getAuth_name() {
		return auth_name;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
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
		return "T_Authority_Info [auth_id=" + auth_id + ", auth_name=" + auth_name + ", auth_code=" + auth_code
				+ ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}
}
