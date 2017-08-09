package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleAuthInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.domain.UserRoleInfo;

/** @author Miley_Ren */
public class IUserManagerSqlProvider {
    
    public String insertUserRoleInfo(UserRoleInfo userRoleInfo){
        return "INSERT INTO userrole (userId,roleId) VALUES (#{userId}, #{roleId})";
    }
    
    public String getAllUserRoleInfos(UserRoleInfo userRoleInfo){
        return new SQL(){{
            SELECT("*").FROM("userrole");
            if(userRoleInfo.getUserId()!=null)
                WHERE("userId=#{userId}");
            if(userRoleInfo.getRoleId()!=null)
                WHERE("roleId=#{roleId}");
        }}.toString();
    }
    
    public String getUserRoleInfoById(Integer userRoleId){
        return "SELECT * FROM userrole WHERE userRoleId="+userRoleId;
    }
    
    public String deleteUserRoleInfo(Integer userRoleId){
        return "DELETE FROM userrole WHERE userRoleId="+userRoleId;
    }
    
    public String insertRoleAuthInfo(RoleAuthInfo roleAuthInfo){
        return "insert into roleauth (roleId, authId) values (#{roleId}, #{authId})";
    }
    
    public String getAllRoleAuthInfos(RoleAuthInfo roleAuthInfo){
        return new SQL(){{
            SELECT("*").FROM("roleauth");
            if(roleAuthInfo.getRoleId()!=null)
                WHERE("roleId=#{roleId}");
            if(roleAuthInfo.getAuthId()!=null)
                WHERE("authId=#{authId}");
        }}.toString();
    }
    public String getRoleAuthInfoById(Integer roleAuthId){
        return "SELECT * FROM roleAuthId WHERE roleAuthId="+roleAuthId;
    }
    public String deleteRoleAuthInfo(Integer roleAuthId){
        return "DELETE FROM roleAuthId WHERE roleAuthId="+roleAuthId;
    }

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
				if(StringUtils.isNotBlank(authorityInfo.getAuthDesc())){
					VALUES("authDesc", "#{authDesc}");
				}
				if(authorityInfo.getAuthType()!=null){
					VALUES("authType", "#{authType}");
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
					
					if(StringUtils.isNotBlank(authorityInfo.getAuthDesc())){
						SET("authDesc=#{authDesc}");
					}
					if(authorityInfo.getAuthType()!=null){
						SET("authType=#{authType}");
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
					if(StringUtils.isNotBlank(authorityInfo.getAuthDesc())){
						WHERE("authDesc=#{authDesc}");
					}
					if(authorityInfo.getAuthType()!=null){
						WHERE("authType=#{authType}");
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
					VALUES("roleName", "#{roleName}");
				}
				if (roleInfo.getFirmType() != null) {
                    VALUES("firmType", "#{firmType}");
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
						SET("roleName=#{roleName}");
					}
					if (roleInfo.getFirmType() != null) {
						SET("firmType =#{firmType}");
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
					WHERE("roleName=#{roleName}");
				}
				if (roleInfo.getFirmType() != null) {
					WHERE("firmType =#{firmType}");
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
					if (userInfo.getGroupManager() != null)
	                    SET("groupManager=#{groupManager}");
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
				SELECT("a.*").FROM("userinfo a ,firminfo b");
				if (userInfo.getUserNo() != null) {
					WHERE("a.userNo=#{userNo}");
				}
				if (StringUtils.isNotBlank(userInfo.getUserName())) {
					WHERE("a.userName=#{userName}");
				}
				if (StringUtils.isNotBlank(userInfo.getPassword())) {
					WHERE("a.password=#{password}");
				}
				if (StringUtils.isNotBlank(userInfo.getMobilePhone())) {
					WHERE("a.mobilePhone=#{mobilePhone}");
				}
				if (StringUtils.isNotBlank(userInfo.getEmail())) {
					WHERE("a.email=#{email}");
				}
				if (userInfo.getRoleId() != null) {
					WHERE("a.roleId=#{roleId}");
				}
				if (StringUtils.isNotBlank(userInfo.getRoleName())) {
					WHERE("a.roleName=#{roleName}");
				}
                if (userInfo.getGroupManager() != null)
                    WHERE("a.groupManager=#{groupManager}");
				if (userInfo.getGroupId() != null) {
					if (userInfo.getGroupId() == -1) {
						WHERE("a.groupId is null");
					} else {
						WHERE("a.groupId=#{groupId}");
					}
				}
				if (userInfo.getStatus() != null) {
					WHERE("a.status=#{status}");
				}
				if (userInfo.getFirmId() != null) {
					WHERE("a.firmId=#{firmId}");
				}
				if(userInfo.getFirmInfo()!=null&&userInfo.getFirmInfo().getFirmNo()!=null){
					WHERE("b.firmNo=#{firmInfo.firmNo}");
				}
				if (userInfo.getParentUserId() != null) {
					WHERE("a.parentUserId=#{parentUserId}");
				}
				if (userInfo.getOperateId() != null) {
					WHERE("a.doperateId=#{operateId}");
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
