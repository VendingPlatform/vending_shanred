package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleAuthInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.domain.UserRoleInfo;

public interface IUserManagerService {

    /** 用户角色 */
    void insertUserRoleInfo(UserRoleInfo userRoleInfo);

    List<UserRoleInfo> getAllUserRoleInfos(UserRoleInfo userRoleInfo);
    
    UserRoleInfo getUserRoleInfoById(Integer userRoleId);

    void deleteUserRoleInfo(Integer userRoleId);

    /** 角色权限 */

    void insertRoleAuthInfo(RoleAuthInfo roleAuthInfo);

    List<RoleAuthInfo> getAllRoleAuthInfos(RoleAuthInfo roleAuthInfo);

    RoleAuthInfo getRoleAuthInfoById(Integer roleAuthId);

    void deleteRoleAuthInfo(Integer roleAuthId);

    /** 用户登录 */
    public UserInfo login(UserInfo userInfo);

    void insertUserInfo(UserInfo userInfo);

    UserInfo getUserInfoById(Integer id);

    List<UserInfo> getAllUserInfos(UserInfo userInfo);

    /** 修改密码 */
    void updateUserInfo(UserInfo userInfo);

    void deleteUserInfo(Integer id);

    void insertRole(RoleInfo roleInfo);

    void updateRole(RoleInfo roleInfo);

    RoleInfo getRoleById(Integer id);

    List<RoleInfo> getAllRoles(RoleInfo roleInfo);

    void deleteRole(Integer Id);

    void insertAuthority(AuthorityInfo authorityInfo);

    AuthorityInfo getAuthorityById(Integer id);

    List<AuthorityInfo> getAllAuthoritys(AuthorityInfo authorityInfo);

    void updateAuthority(AuthorityInfo authorityInfo);

    void deleteAuthority(Integer id);
}
