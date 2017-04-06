package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import com.vending.platform.dao.sqlprovider.IUserManagerSqlProvider;
import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.exception.SQLFormatException;

/**
 * 用户管理DAO：权限管理、角色管理、用户信息管理
 * 
 * @author Miley_Ren
 */
public interface IUserManagerDao {

	/**
	 * 插入新的权限信息；注意：同一公司不能有编码一样的权限
	 * 
	 * @param authorityInfo
	 *            新增的权限信息类;插入信息时，authName、authCode、firmId都不能为空，否则会抛出异常
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "insertAuthorityInfo")
	public void insertAuthorityInfo(AuthorityInfo authorityInfo) throws SQLFormatException;

	/**
	 * 更新权限信息
	 * 
	 * @param authorityInfo
	 *            新增的权限信息类
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "updateAutorityInfo")
	public void updateAutorityInfo(AuthorityInfo authorityInfo);

	/**
	 * 查询所有的权限信息 1、查询所有的权限信息 2、查询所有的该公司的权限信息 3、
	 * 
	 * @param authorityInfo
	 *            查询的权限信息类
	 * @return List<AuthorityInfo> 返回一个实体类列表
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "getAllAuthorityInfos")
	public List<AuthorityInfo> getAllAuthorityInfos(AuthorityInfo authorityInfo);

	/**
	 * 按ID号查询权限信息
	 * 
	 * @param authorityInfo
	 *            查询信息
	 * @return AuthorityInfo 返回一个实体类
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "getAuthorityInfoById")
	@Results({
		@Result(property = "roleInfos", column = "roleId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getAllRoles")),
		@Result(property = "roleInfo", column = "roleId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getRoleById")) 
	})
	public AuthorityInfo getAuthorityInfoById(Integer authId);

	/**
	 * 删除权限
	 * 
	 * @param authId
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "deleteAuthorityInfo")
	public void deleteAuthorityInfo(Integer authId);

	/**
	 * 插入用户角色
	 * 
	 * @param roleInfo,roleInfo.authorityCode以分号隔开，表示多个权限
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "insertRoleInfo")
	public void insertRoleInfo(RoleInfo roleInfo) throws SQLFormatException;

	/**
	 * 修改用户角色
	 * 
	 * @param roleInfo
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "updateRoleInfo")
	public void updateRoleInfo(RoleInfo roleInfo);

	/**
	 * 查询所有用户角色
	 * 
	 * @param roleInfo
	 *            角色信息
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "getAllRoles")
	@Results({
		@Result(property = "authorityInfo", column = "authId", one = @One(select = "com.vending.platform.dao.IUserManagerDao.getAuthorityInfoById"))
	})
	public List<RoleInfo> getAllRoles(RoleInfo roleInfo);

	/**
	 * 按id查询
	 * 
	 * @param roleId
	 *            角色ID
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "getRoleById")
	@Results({
			@Result(property = "userInfos", column = "userId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getAllUsers")),
			@Result(property = "userInfo", column = "userId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getUserById")) })
	public RoleInfo getRoleById(Integer roleId);

	/** 删除角色 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "deleteRole")
	public void deleteRole(Integer roleId);

	/**
	 * 添加用户
	 * 
	 * @param userInfo
	 *            用户信息
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "insertUser")
	public void insertUser(UserInfo userInfo) throws SQLFormatException;

	/**
	 * 更新用户
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "updateUser")
	public void updateUser(UserInfo userInfo);

	/**
	 * 按条件查询所有用户
	 * 
	 * @param userInfo
	 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "getAllUsers")
	@Results({
			@Result(property = "roleInfo", column = "roleId", one = @One(select = "com.vending.platform.dao.IUserManagerDao.getRoleById")),
			@Result(property = "firmInfo", column = "firmId", one = @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getFirmInfoById")),
			@Result(property = "groupInfo", column = "groupId", one = @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getGroupInfoById")) })
	public List<UserInfo> getAllUsers(UserInfo userInfo);

	/** 按Id查找用户 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "getUserById")
	@Results({
			@Result(property = "roleInfo", column = "roleId", one = @One(select = "com.vending.platform.dao.IUserManagerDao.getRoleById")),
			@Result(property = "firmInfo", column = "firmId", one = @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getFirmInfoById")),
			@Result(property = "groupInfo", column = "groupId", one = @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getGroupInfoById")) })
	public UserInfo getUserById(Integer integer);

	/** 删除用户 */
	@SelectProvider(type = IUserManagerSqlProvider.class, method = "deleteUser")
	public void deleteUser(Integer integer);

}
