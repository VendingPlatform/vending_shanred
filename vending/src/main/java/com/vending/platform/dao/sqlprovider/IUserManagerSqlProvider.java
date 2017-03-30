package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;

/** @author Miley_Ren */
public class IUserManagerSqlProvider {

	public String insertAuthorityInfo(AuthorityInfo authorityInfo) {
		return new SQL() {
			{
				INSERT_INTO("authorityinfo");
				if (StringUtils.isNotBlank(authorityInfo.getAuthName())) {
					VALUES("authName", "#{authName}");
				}
				if (StringUtils.isNotBlank(authorityInfo.getAuthCode())) {
					VALUES("authCode", "#{authCode}");
				}
				if (authorityInfo.getOperateId() != null) {
					VALUES("operateId", "#{operateId}");
				}
				VALUES("operateDate", "(select now())");
			}
		}.toString();
	}

	public String updateAutorityInfo(AuthorityInfo authorityInfo) {
		return new SQL() {
			{
				if (authorityInfo.getAuthId() != null) {
					UPDATE("authorityinfo");
					if (StringUtils.isNotBlank(authorityInfo.getAuthName())) {
						SET("authName=#{authName}");
					}
					if (StringUtils.isNotBlank(authorityInfo.getAuthCode())) {
						SET("authCode=#{authCode}");
					}
					if (authorityInfo.getOperateId() != null) {
						SET("operateId=#{operateId}");
					}
					SET("operateDate=(select now())");
					WHERE("authId=#{authId}");
				}
			}
		}.toString();
	}

	public String getAllAuthorityInfos(AuthorityInfo authorityInfo) {
		return new SQL() {
			{
				if (authorityInfo != null) {
					SELECT("*").FROM("authorityinfo");
					if (StringUtils.isNotBlank(authorityInfo.getAuthName())) {
						WHERE("authName=#{authName}");
					}
					if (StringUtils.isNotBlank(authorityInfo.getAuthCode())) {
						WHERE("authCode=#{authCode}");
					}
				}
			}
		}.toString();
	}

	public String getAuthorityInfoById() {
		return "SELECT * FROM authorityinfo WHERE authId=#{authId}";
	}

	public String deleteAuthorityInfo() {
		return "DELETE FROM authorityinfo WHERE authId=#{authId}";
	}

	public String insertRoleInfo(RoleInfo roleInfo) {
		return new SQL() {
			{
				INSERT_INTO("roleinfo");
				if (StringUtils.isNotBlank(roleInfo.getRoleName())) {
					VALUES("authorityCode", "#{roleName}");
				}
				if (StringUtils.isNotBlank(roleInfo.getAuthorityCode())) {
					VALUES("authorityCode", "#{authorityCode}");
				}
				if (StringUtils.isNotBlank(roleInfo.getAuthorityName())) {
					VALUES("authorityName", "#{authorityName}");
				}
				if (roleInfo.getStatus() != null) {
					VALUES("status", "#{status}");
				}
				if (roleInfo.getFirmId() != null) {
					VALUES("firmId", "#{firmId}");
				}
				if (roleInfo.getOperateId() != null) {
					VALUES("operateId", "#{operateId}");
				}
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateRoleInfo(RoleInfo roleInfo) {
		return new SQL() {
			{
				if (roleInfo.getRoleId() != null) {
					UPDATE("roleinfo");
					if (StringUtils.isNotBlank(roleInfo.getRoleName())) {
						SET("authorityCode=#{roleName}");
					}
					if (StringUtils.isNotBlank(roleInfo.getAuthorityCode())) {
						SET("authorityCode=#{authorityCode}");
					}
					if (StringUtils.isNotBlank(roleInfo.getAuthorityName())) {
						SET("authorityName=#{authorityName}");
					}
					if (roleInfo.getStatus() != null) {
						SET("status=#{status}");
					}
					if (roleInfo.getFirmId() != null) {
						SET("firmId =#{firmId}");
					}
					if (roleInfo.getOperateId() != null) {
						SET("operateId=#{operateId}");
					}
					SET("operateDate=(SELECT NOW())");
					WHERE("roleId=#{roleId}");
				}
			}
		}.toString();
	}

	public String getAllRoles(RoleInfo roleInfo) {
		return new SQL() {
			{
				SELECT("*").FROM("roleinfo");
				if (StringUtils.isNotBlank(roleInfo.getRoleName())) {
					WHERE("authorityCode=#{roleName}");
				}
				if (StringUtils.isNotBlank(roleInfo.getAuthorityCode())) {
					WHERE("authorityCode=#{authorityCode}");
				}
				if (StringUtils.isNotBlank(roleInfo.getAuthorityName())) {
					WHERE("authorityName=#{authorityName}");
				}
				if (roleInfo.getStatus() != null) {
					WHERE("status=#{status}");
				}
				if (roleInfo.getFirmId() != null) {
					WHERE("firmId =#{firmId}");
				}
				if (roleInfo.getOperateId() != null) {
					WHERE("operateId=#{operateId}");
				}
			}
		}.toString();
	}

	public String getRoleById(Integer roleId) {
		return "select * from roleinfo where roleId=#{roleinfo}";
	}

	public String deleteRole(Integer roleId) {
		return "delete from roleinfo where roleId=#{roleId}";
	}

	public String insertUser(UserInfo userInfo) {
		return new SQL() {
			{
				INSERT_INTO("userinfo");
				if (userInfo.getUserNo() != null) {
					VALUES("userNo", "#{userNo}");
				}
				if (StringUtils.isNotBlank(userInfo.getUserName())) {
					VALUES("userName", "#{userName}");
				}
				if (StringUtils.isNotBlank(userInfo.getPassword())) {
					VALUES("password", "#{password}");
				}
				if (StringUtils.isNotBlank(userInfo.getMobilePhone())) {
					VALUES("mobilePhone", "#{mobilePhone}");
				}
				if (StringUtils.isNotBlank(userInfo.getEmail())) {
					VALUES("email", "#{email}");
				}
				if (userInfo.getRoleId() != null) {
					VALUES("roleId", "#{roleId}");
				}
				if (StringUtils.isNotBlank(userInfo.getRoleName())) {
					VALUES("roleName", "#{roleName}");
				}
				if (userInfo.getGroupId() != null) {
					VALUES("groupId", "#{groupId}");
				}
				if (userInfo.getStatus() != null) {
					VALUES("status", "#{status}");
				}
				if (userInfo.getFirmId() != null) {
					VALUES("firmId", "#{firmId}");
				}
				if (userInfo.getParentUserId() != null) {
					VALUES("parentUserId", "#{parentUserId}");
				}
				if (userInfo.getOperateId() != null) {
					VALUES("operateId", "#{operateId}");
				}
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateUser(UserInfo userInfo) {
		return new SQL() {
			{
				if (userInfo.getUserId() != null) {
					UPDATE("userinfo");
					if (userInfo.getUserNo() != null) {
						SET("userNo=#{userNo}");
					}
					if (StringUtils.isNotBlank(userInfo.getUserName())) {
						SET("userName=#{userName}");
					}
					if (StringUtils.isNotBlank(userInfo.getPassword())) {
						SET("password=#{password}");
					}
					if (StringUtils.isNotBlank(userInfo.getMobilePhone())) {
						SET("mobilePhone=#{mobilePhone}");
					}
					if (StringUtils.isNotBlank(userInfo.getEmail())) {
						SET("email=#{email}");
					}
					if (userInfo.getRoleId() != null) {
						SET("roleId=#{roleId}");
					}
					if (StringUtils.isNotBlank(userInfo.getRoleName())) {
						SET("roleName=#{roleName}");
					}
					if (userInfo.getGroupId() != null) {
						if (userInfo.getGroupId() == -1) {
							SET("groupId=null");
						} else {
							SET("groupId=#{groupId}");
						}
					}
					if (userInfo.getStatus() != null) {
						SET("status=#{status}");
					}
					if (userInfo.getFirmId() != null) {
						SET("firmId=#{firmId}");
					}
					if (userInfo.getParentUserId() != null) {
						SET("parentUserId=#{parentUserId}");
					}
					if (userInfo.getOperateId() != null) {
						SET("operateId=#{operateId}");
					}
					WHERE("userId=#{userId}");
				}
			}
		}.toString();
	}

	public String getAllUsers(UserInfo userInfo) {
		return new SQL() {
			{
				SELECT("*").FROM("userinfo");
				if (userInfo.getUserNo() != null) {
					WHERE("userNo=#{userNo}");
				}
				if (StringUtils.isNotBlank(userInfo.getUserName())) {
					WHERE("userName=#{userName}");
				}
				if (StringUtils.isNotBlank(userInfo.getPassword())) {
					WHERE("password=#{password}");
				}
				if (StringUtils.isNotBlank(userInfo.getMobilePhone())) {
					WHERE("mobilePhone=#{mobilePhone}");
				}
				if (StringUtils.isNotBlank(userInfo.getEmail())) {
					WHERE("email=#{email}");
				}
				if (userInfo.getRoleId() != null) {
					WHERE("roleId=#{roleId}");
				}
				if (StringUtils.isNotBlank(userInfo.getRoleName())) {
					WHERE("roleName=#{roleName}");
				}
				if (userInfo.getGroupId() != null) {
					if (userInfo.getGroupId() == -1) {
						WHERE("groupId is null");
					} else {
						WHERE("groupId=#{groupId}");
					}
				}
				if (userInfo.getStatus() != null) {
					WHERE("status=#{status}");
				}
				if (userInfo.getFirmId() != null) {
					WHERE("firmId=#{firmId}");
				}
				if (userInfo.getParentUserId() != null) {
					WHERE("parentUserId=#{parentUserId}");
				}
				if (userInfo.getOperateId() != null) {
					WHERE("operateId=#{operateId}");
				}
			}
		}.toString();
	}

	public String getUserById(Integer userId) {
		return "SELECT * FROM  userinfo WHERE userId=#{userId}";
	}

	public String deleteUser(Integer userId) {
		return "DELETE FROM userinfo WHERE userId=#{userId}";
	}
}
