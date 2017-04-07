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
	/** 角色类型：0：系统管理员，1：运营商；2：厂商 */
	private Integer firmType;
	/** 操作时间 */
	private Date operateDate;

	private List<UserInfo> userInfos;
	private List<RoleAuthInfo> roleAuthInfo;
	private List<UserRoleInfo> userRoleInfos; 

	public RoleInfo() {
		super();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getFirmType() {
        return firmType;
    }

    public void setFirmType(Integer firmType) {
        this.firmType = firmType;
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
        return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName
                + ", firmType=" + firmType
                + ", operateDate=" + operateDate
                + ", userInfos=" + userInfos + ", roleAuthInfo=" + roleAuthInfo
                + ", userRoleInfos=" + userRoleInfos + "]";
    }

}
