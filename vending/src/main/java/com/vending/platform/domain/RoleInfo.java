package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Role_Info映射表：角色表
 * 
 * @author Miley_Ren
 * 
 */
public class RoleInfo implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 4555319742101777793L;
	/** 角色ID */
	private Integer role_id;
	/** 角色名称 */
	private String role_name;
	/** 权限编号集合，用逗号隔开 */
	private String authority_code;
	/** 权限名称集合，与编号一一对应 */
	private String authority_name;
	/** 权限状态:0:不可用；1：可用 */
	private Integer status;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public RoleInfo() {
		super();
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getAuthority_code() {
		return authority_code;
	}

	public void setAuthority_code(String authority_code) {
		this.authority_code = authority_code;
	}

	public String getAuthority_name() {
		return authority_name;
	}

	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		return "T_Role_Info [role_id=" + role_id + ", role_name=" + role_name + ", authority_code=" + authority_code
				+ ", authority_name=" + authority_name + ", status=" + status + ", operate_id=" + operate_id
				+ ", operate_date=" + operate_date + "]";
	}
}
