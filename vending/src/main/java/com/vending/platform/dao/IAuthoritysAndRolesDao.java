package com.vending.platform.dao;

import java.util.List;

import javax.management.relation.Role;

import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.IAuthoritysAndRolesSqlProvider;
import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.exception.SQLFormatException;

/**
 * 用户权限DAO
 * 
 * @author Miley_Ren
 */
public interface IAuthoritysAndRolesDao {

    /**
     * 插入新的权限信息；注意：同一公司不能有编码一样的权限
     * 
     * @param authorityInfo
     *            新增的权限信息类;插入信息时，authName、authCode、firmId都不能为空，否则会抛出异常
     */
    @SelectProvider(type = IAuthoritysAndRolesSqlProvider.class, method = "insertAuthorityInfo")
    public void insertAuthorityInfo(AuthorityInfo authorityInfo)
            throws SQLFormatException;

    /**
     * 更新权限信息
     * 
     * @param authorityInfo
     *            新增的权限信息类
     */
    @SelectProvider(type = IAuthoritysAndRolesSqlProvider.class, method = "updateAutorityInfo")
    public void updateAutorityInfo(AuthorityInfo authorityInfo);

    /**
     * 查询所有的权限信息 1、查询所有的权限信息 2、查询所有的该公司的权限信息 3、
     * 
     * @param authorityInfo
     *            查询的权限信息类
     * @return List<AuthorityInfo> 返回一个实体类列表
     */
    @SelectProvider(type = IAuthoritysAndRolesSqlProvider.class, method = "getAllAuthorityInfos")
    public List<AuthorityInfo> getAllAuthorityInfos(
            AuthorityInfo authorityInfo);

    /**
     * 按ID号查询权限信息
     * 
     * @param authorityInfo
     *            查询信息
     * @return AuthorityInfo 返回一个实体类
     */
    @SelectProvider(type = IAuthoritysAndRolesSqlProvider.class, method = "selectAuthorityInfoById")
    public AuthorityInfo selectAuthorityInfoById(Integer authId);

    /**
     * 删除权限
     * 
     * @param authId
     */
    @SelectProvider(type = IAuthoritysAndRolesSqlProvider.class, method = "deleteAuthorityInfo")
    public void deleteAuthorityInfo(Integer authId);

    /**插入用户角色
     * @param roleInfo*/
    public void insertRoleInfo(RoleInfo roleInfo) throws SQLFormatException;
    
    /**修改用户角色
     * @param roleInfo*/
    public void updateRoleInfo(RoleInfo roleInfo);
    /**查询所有用户角色*/
    public List<RoleInfo> getAllRoles(RoleInfo roleInfo);
}
