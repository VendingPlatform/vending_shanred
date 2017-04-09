package com.vending.platform.domain;

/** 角色权限对应关系 */
public class RoleAuthInfo {
    private Integer roleAuthId;
    private Integer roleId;
    private Integer authId;
    private RoleInfo roleInfo;
    private AuthorityInfo authorityInfo;
    
    public RoleAuthInfo() {
        super();
    }
    public Integer getRoleAuthId() {
        return roleAuthId;
    }
    public void setRoleAuthId(Integer roleAuthId) {
        this.roleAuthId = roleAuthId;
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getAuthId() {
        return authId;
    }
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
    public RoleInfo getRoleInfo() {
        return roleInfo;
    }
    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
    public AuthorityInfo getAuthorityInfo() {
        return authorityInfo;
    }
    public void setAuthorityInfo(AuthorityInfo authorityInfo) {
        this.authorityInfo = authorityInfo;
    }
    @Override
    public String toString() {
        return "roleAuthInfo [roleAuthId=" + roleAuthId + ", roleId=" + roleId
                + ", authId=" + authId + ", roleInfo=" + roleInfo
                + ", authorityInfo=" + authorityInfo + "]";
    }
    

}
