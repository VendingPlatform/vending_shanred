package com.vending.platform.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.management.relation.Role;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IUserManagerDao;
import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.exception.SQLFormatException;
import com.vending.platform.service.IUserManagerService;

/** 用户管理Service */
@Service
public class UserManagerServiceImpl implements IUserManagerService, Serializable {
	private static final long serialVersionUID = -5147230002673392653L;
	private static Logger logger = Logger.getLogger(UserManagerServiceImpl.class);

	@Autowired
	private IUserManagerDao userManagerDao;

	@Override
	public UserInfo login(UserInfo userInfo) {
		if (userManagerDao.getAllUsers(userInfo).size() > 1) {
			logger.debug("用户名密码多次匹配，用户错误");
			return null;
		} else if (userManagerDao.getAllUsers(userInfo).size() < 1) {
			logger.debug("登录失败");
			return null;
		} else {
			logger.debug("登录成功");
			return userManagerDao.getAllUsers(userInfo).get(0);
		}
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userManagerDao.updateUser(userInfo);
	}

	@Override
	public List<UserInfo> getAllUserInfos(UserInfo userInfo) {
		return userManagerDao.getAllUsers(userInfo);
	}

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		try {
			userManagerDao.insertUser(userInfo);
		} catch (SQLFormatException e) {
			logger.debug("插入用户失败");
			e.printStackTrace();
		}
	}

	@Override
	public UserInfo getUserInfoById(Integer id) {
		return userManagerDao.getUserById(id);
	}

	@Override
	public void deleteUserInfo(Integer id) {
		userManagerDao.deleteUser(id);
	}

	@Override
	public void insertRole(RoleInfo roleInfo) {
		try {
			userManagerDao.insertRoleInfo(roleInfo);
		} catch (SQLFormatException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRole(RoleInfo roleInfo) {
		userManagerDao.updateRoleInfo(roleInfo);
	}

	@Override
	public RoleInfo getRoleById(Integer id) {
		return userManagerDao.getRoleById(id);
	}

	@Override
	public List<RoleInfo> getAllRoles(RoleInfo roleInfo) {
		return userManagerDao.getAllRoles(roleInfo);
	}

	@Override
	public void deleteRole(Integer Id) {
		userManagerDao.deleteRole(Id);
	}

	@Override
	public void insertAuthority(AuthorityInfo authorityInfo) {
		try {
			userManagerDao.insertAuthorityInfo(authorityInfo);
		} catch (SQLFormatException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AuthorityInfo getAuthorityById(Integer id) {
		return userManagerDao.getAuthorityInfoById(id);
	}

	@Override
	public List<AuthorityInfo> getAllAuthoritys(AuthorityInfo authorityInfo) {
		return userManagerDao.getAllAuthorityInfos(authorityInfo);
	}

	@Override
	public void updateAuthority(AuthorityInfo authorityInfo) {
		userManagerDao.updateAutorityInfo(authorityInfo);
	}

	@Override
	public void deleteAuthority(Integer id) {
		userManagerDao.deleteAuthorityInfo(id);
	}
}
