package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.IAuthorityInfoSqlProvider;
import com.vending.platform.domain.AuthorityInfo;

/**
 * 用户权限DAO
 * 
 * @author Miley_Ren
 */
public interface IAuthorityInfoDao {
	/**
	 * 插入新的权限信息；注意：同一公司不能有编码一样的权限
	 * 
	 * @param authorityInfo
	 *            新增的权限信息类;插入信息时，authName、authCode、firmId都不能为空，否则会抛出异常
	 */
	@SelectProvider(type = IAuthorityInfoSqlProvider.class, method = "insertAuthorityInfo")
	public void insertAuthorityInfo(AuthorityInfo authorityInfo) throws Exception;

	/**
	 * 更新权限信息
	 * 
	 * @param authorityInfo
	 *            新增的权限信息类
	 */
	@SelectProvider(type = IAuthorityInfoSqlProvider.class, method = "updateAutorityInfo")
	public void updateAutorityInfo(AuthorityInfo authorityInfo);

	/**
	 * 查询所有的权限信息 1、查询所有的权限信息 2、查询所有的该公司的权限信息 3、
	 * 
	 * @param authorityInfo
	 *            查询的权限信息类
	 * @return List<AuthorityInfo> 返回一个实体类列表
	 */
	public List<AuthorityInfo> selectAllAuthorityInfos(AuthorityInfo authorityInfo);

	/**
	 * 按编码或者ID号查询权限信息
	 * 
	 * @param authorityInfo
	 *            查询信息，按编码查询时时authCode和firmId不能为空
	 * @return AuthorityInfo 返回一个实体类
	 */
	public AuthorityInfo selectAuthorityInfoByauthCodeOrauthId(AuthorityInfo authorityInfo);

	/**
	 * 删除权限
	 * 
	 * @param authId
	 */
	public void deleteAuthorityInfo(Integer authId);
}
