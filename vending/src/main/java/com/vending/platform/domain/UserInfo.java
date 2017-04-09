package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * T_User_Info用户映射表：用户信息表，用户分为系统管理员、厂商管理员、运营商管理员
 * 
 * @author Miley_Ren
 */
public class UserInfo implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = 912338831195864691L;
	/** 用户ID */
	private Integer userId;
	/** 用户编号，用于登录 */
	private String userNo;
	/** 用户名 */
	private String userName;
	/** 用户密码 */
	private String password;
	/** 手机号码 */
	private String mobilePhone;
	/** E-mail */
	private String email;
	/** 用户角色 */
	private Integer roleId;
	/** 用户角色名称 */
	private String roleName;
	/**是否为对应小组的管理员*/
	private Integer groupManager;
	/** 所属用户组 */
	private Integer groupId;
	/** 用户状态：0：不可用，1：可用 */
	private Integer status;
	/** 所属公司ID */
	private Integer firmId;
	/** 上级管理员 */
	private Integer parentUserId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	private RoleInfo roleInfo;
	private FirmInfo firmInfo;
	private GroupInfo groupInfo;
	
	private List<UserRoleInfo> userRoleInfos;

	public UserInfo() {
		super();
	}

	public UserInfo(Integer userId, String userNo, String userName, String password, String mobilePhone, String email,
			Integer roleId, String roleName, Integer groupId, Integer status, Integer firmId, Integer parentUserId,
			Integer operateId, Date operateDate, RoleInfo roleInfo, FirmInfo firmInfo, GroupInfo groupInfo) {
		super();
		this.userId = userId;
		this.userNo = userNo;
		this.userName = userName;
		this.password = password;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.roleId = roleId;
		this.roleName = roleName;
		this.groupId = groupId;
		this.status = status;
		this.firmId = firmId;
		this.parentUserId = parentUserId;
		this.operateId = operateId;
		this.operateDate = operateDate;
		this.roleInfo = roleInfo;
		this.firmInfo = firmInfo;
		this.groupInfo = groupInfo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setUserPassword(String password) {
		this.password = password;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

	public Integer getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(Integer parentUserId) {
		this.parentUserId = parentUserId;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

	public FirmInfo getFirmInfo() {
		return firmInfo;
	}

	public void setFirmInfo(FirmInfo firmInfo) {
		this.firmInfo = firmInfo;
	}

	public GroupInfo getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(GroupInfo groupInfo) {
		this.groupInfo = groupInfo;
	}

	public List<UserRoleInfo> getUserRoleInfos() {
        return userRoleInfos;
    }

    public void setUserRoleInfos(List<UserRoleInfo> userRoleInfos) {
        this.userRoleInfos = userRoleInfos;
    }


    public Integer getGroupManager() {
        return groupManager;
    }

    public void setGroupManager(Integer groupManager) {
        this.groupManager = groupManager;
    }

    @Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userNo=" + userNo + ", userName=" + userName + ", password=" + password
				+ ", mobilePhone=" + mobilePhone + ", email=" + email + ", roleId=" + roleId + ", roleName=" + roleName
				+ ", groupId=" + groupId + ", status=" + status + ", firmId=" + firmId + ", parentUserId="
				+ parentUserId + ", operateId=" + operateId + ", operateDate=" + operateDate + "]";
	}

}
