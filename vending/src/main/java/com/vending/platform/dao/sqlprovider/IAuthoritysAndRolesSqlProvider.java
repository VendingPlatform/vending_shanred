package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.AuthorityInfo;

/** @author Miley_Ren */
public class IAuthoritysAndRolesSqlProvider {

    public String insertAuthorityInfo(AuthorityInfo authorityInfo) {
        return new SQL() {
            {
                INSERT_INTO("authorityinfo");
                VALUES("authName",
                        StringUtils.isNotBlank(authorityInfo.getAuthName())
                                ? "#{authName}" : null);
                VALUES("authCode",
                        StringUtils.isNotBlank(authorityInfo.getAuthCode())
                                ? "#{authCode}" : null);
                VALUES("firmId",
                        authorityInfo.getFirmId() != null ? "#{firmId}" : null);
                VALUES("operateId", authorityInfo.getOperateId() != null
                        ? "#{operateId}" : "''");
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
                    if (authorityInfo.getFirmId() != null) {
                        SET("firmId=#{firmId}");
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
                    if (authorityInfo.getFirmId() != null) {
                        WHERE("firmId=#{firmId}");
                    }
                }
            }
        }.toString();
    }

    public String selectAuthorityInfoById() {
        return "SELECT * FROM authorityinfo WHERE authId=#{authId}";
    }
    public String deleteAuthorityInfo(){
        return "DELETE FROM authorityinfo WHERE authId=#{authId}";
    }
}
