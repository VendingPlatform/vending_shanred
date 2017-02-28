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
	private Integer roleId;
	/** 角色名称 */
	private String roleName;
	/** 权限编号集合，用逗号隔开 */
	private String authorityCode;
	/** 权限名称集合，与编号一一对应 */
	private String authorityName;
	/** 权限状态:0:不可用；1：可用 */
	private Integer status;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	public RoleInfo() {
		super();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName + ", authorityCode=" + authorityCode
				+ ", authorityName=" + authorityName + ", status=" + status + ", operateId=" + operateId
				+ ", operateDate=" + operateDate + "]";
	}

}
