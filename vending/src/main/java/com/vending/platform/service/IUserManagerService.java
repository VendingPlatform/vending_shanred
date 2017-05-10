package com.vending.platform.service;

import java.util.List;
import java.util.Set;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleAuthInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.domain.UserRoleInfo;

public interface IUserManagerService {

    /** 判断用户是否已注册 */
    Boolean alreadyUser(UserInfo userInfo);

    /** 根据权限查询所有用户 */
    List<UserInfo> getAllUsersByAuth(Set<AuthorityInfo> auths,
            UserInfo userInfo);

    /** 查看当前用户权限编码列表 */
    List<String> getAuthTop(Set<AuthorityInfo> authorityInfos);

    /** 用户角色 */
    void insertUserRoleInfo(UserRoleInfo userRoleInfo);

    List<UserRoleInfo> getAllUserRoleInfos(UserRoleInfo userRoleInfo);

    UserRoleInfo getUserRoleInfoById(Integer userRoleId);

    void deleteUserRoleInfo(Integer userRoleId);
    
    void deletUserRoleByUserId(Integer userId);

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

    /** 修改用户信息*/
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
    
    /**获取该公司的所有操作员*/
    List<UserInfo> getAllUserAuthByFirmId(Integer firmId);
}
