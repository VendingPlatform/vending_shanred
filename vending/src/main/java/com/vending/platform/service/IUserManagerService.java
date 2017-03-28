package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;

public interface IUserManagerService {
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
