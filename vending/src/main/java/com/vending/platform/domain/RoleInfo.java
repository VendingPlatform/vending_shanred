package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	private String roleName;
	//private Integer authId;
	/** 权限编号集合，用逗号隔开 */
	//private String authorityCode;
	/** 权限名称集合，与编号一一对应 */
	//private String authorityName;
	/** 权限状态:0:不可用；1：可用 */
	private Integer status;
	/** 所属公司 */
	private Integer firmId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	private List<UserInfo> userInfos;
	private List<RoleAuthInfo> roleAuthInfo;
	private List<UserRoleInfo> userRoleInfos; 
	//private List<RoleInfo> roleInfos;

	public RoleInfo() {
		super();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getFirmId() {
		return firmId;
	}

	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
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

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<RoleAuthInfo> getRoleAuthInfo() {
        return roleAuthInfo;
    }

    public void setRoleAuthInfo(List<RoleAuthInfo> roleAuthInfo) {
        this.roleAuthInfo = roleAuthInfo;
    }


    public List<UserRoleInfo> getUserRoleInfos() {
        return userRoleInfos;
    }

    public void setUserRoleInfos(List<UserRoleInfo> userRoleInfos) {
        this.userRoleInfos = userRoleInfos;
    }

    @Override
	public String toString() {
		return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName + ",  status=" + status
				+ ", firmId=" + firmId + ", operateId=" + operateId + ", operateDate=" + operateDate + ", userInfos="
				+ userInfos + "]";
	}

}
