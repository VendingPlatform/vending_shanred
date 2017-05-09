package com.vending.platform.domain;

/** 用户角色表 */
public class UserRoleInfo {
    private Integer userRoleId;
    private Integer userId;
    private Integer roleId;
    
    private UserInfo userInfo;
    private RoleInfo roleInfo;
    public UserRoleInfo() {
        super();
    }
    public Integer getUserRoleId() {
        return userRoleId;
    }
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public UserInfo getUserInfo() {
        return userInfo;
    }
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    public RoleInfo getRoleInfo() {
        return roleInfo;
    }
    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
    @Override
    public String toString() {
        return "UserRole [userRoleId=" + userRoleId + ", userId=" + userId
                + ", roleId=" + roleId + ", userInfo=" + userInfo
                + ", roleInfo=" + roleInfo + "]";
    }
    
}
