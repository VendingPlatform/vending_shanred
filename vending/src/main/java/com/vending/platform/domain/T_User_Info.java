package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_User_Info用户映射表：用户信息表，用户分为系统管理员、厂商管理员、运营商管理员
 * 
 * @author Miley_Ren
 */
public class T_User_Info implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = 912338831195864691L;
	/** 用户ID */
	private Integer user_id;
	/** 用户编号，用于登录 */
	private String user_no;
	/** 用户名 */
	private String user_name;
	/** 用户密码 */
	private String password;
	/** 手机号码 */
	private String mobile_phone;
	/** E-mail */
	private String email;
	/** 用户角色 */
	private Integer role_id;
	/** 所属用户组 */
	private Integer group_id;
	/** 用户状态：0：不可用，1：可用 */
	private Integer status;
	/** 所属公司ID */
	private Integer firm_id;
	/** 上级管理员 */
	private Integer parent_user_id;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public T_User_Info() {
		super();
	}

	public T_User_Info(Integer user_id, String user_no, String user_name, String password, String mobile_phone,
			String email, Integer role_id, Integer group_id, Integer status, Integer firm_id, Integer parent_user_id,
			Integer operate_id, Date operate_date) {
		super();
		this.user_id = user_id;
		this.user_no = user_no;
		this.user_name = user_name;
		this.password = password;
		this.mobile_phone = mobile_phone;
		this.email = email;
		this.role_id = role_id;
		this.group_id = group_id;
		this.status = status;
		this.firm_id = firm_id;
		this.parent_user_id = parent_user_id;
		this.operate_id = operate_id;
		this.operate_date = operate_date;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFirm_id() {
		return firm_id;
	}

	public void setFirm_id(Integer firm_id) {
		this.firm_id = firm_id;
	}

	public Integer getParent_user_id() {
		return parent_user_id;
	}

	public void setParent_user_id(Integer parent_user_id) {
		this.parent_user_id = parent_user_id;
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
		return "T_User_Info [user_id=" + user_id + ", user_no=" + user_no + ", user_name=" + user_name + ", password="
				+ password + ", mobile_phone=" + mobile_phone + ", email=" + email + ", role_id=" + role_id
				+ ", group_id=" + group_id + ", status=" + status + ", firm_id=" + firm_id + ", parent_user_id="
				+ parent_user_id + ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}
}
