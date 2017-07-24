package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.OperMgr;

public class IFirmAndGroupSqlProvider {
	public String insertFirm(FirmInfo firmInfo) {
		return new SQL() {
			{
				INSERT_INTO("firminfo");
				if (StringUtils.isNotBlank(firmInfo.getFirmNo())) {
					VALUES("firmNo", "#{firmNo}");
				}
				if (StringUtils.isNotBlank(firmInfo.getFirmName())) {
					VALUES("firmName", "#{firmName}");
				}
				if (StringUtils.isNotBlank(firmInfo.getFirmDesc())) {
					VALUES("firmDesc", "#{firmDesc}");
				}
				if (firmInfo.getFirmType() != null) {
					VALUES("firmType", "#{firmType}");
				}
				if (firmInfo.getFirmStatus() != null) {
					VALUES("firmStatus", "#{firmStatus}");
				}
				if (firmInfo.getOperateId() != null) {
					VALUES("operateId", "#{operateId}");
				}
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateFirm(FirmInfo firmInfo) {
		return new SQL() {
			{
				if (firmInfo.getFirmId() != null) {
					UPDATE("firminfo");
					if (StringUtils.isNotBlank(firmInfo.getFirmNo())) {
						SET("firmNo=#{firmNo}");
					}
					if (StringUtils.isNotBlank(firmInfo.getFirmName())) {
						SET("firmName=#{firmName}");
					}
					if (StringUtils.isNotBlank(firmInfo.getFirmDesc())) {
						SET("firmDesc=#{firmDesc}");
					}
					if (firmInfo.getFirmType() != null) {
						SET("firmType=#{firmType}");
					}
					if (firmInfo.getFirmStatus() != null) {
						SET("firmStatus=#{firmStatus}");
					}
					if (firmInfo.getOperateId() != null) {
						SET("operateId=#{operateId}");
					}
					SET("operateDate=(SELECT NOW())");
					WHERE("firmId=#{firmId}");
				}
			}
		}.toString();
	}

	public String getAllFirmInfos(FirmInfo firmInfo) {
		return new SQL() {
			{
				SELECT("*").FROM("firminfo");
				if (StringUtils.isNotBlank(firmInfo.getFirmNo())) {
					WHERE("firmNo=#{firmNo}");
				}
				if (StringUtils.isNotBlank(firmInfo.getFirmName())) {
					WHERE("firmName=#{firmName}");
				}
				if (StringUtils.isNotBlank(firmInfo.getFirmDesc())) {
					WHERE("firmDesc=#{firmDesc}");
				}
				if (firmInfo.getFirmType() == null) {
					WHERE("firmType != 0");
				}
				if (firmInfo.getFirmType() != null) {
					WHERE("firmType=#{firmType}");
				}
				if (firmInfo.getFirmStatus() != null) {
					WHERE("firmStatus=#{firmStatus}");
				}
				if (firmInfo.getOperateId() != null) {
					WHERE("operateId=#{operateId}");
				}
			}
		}.toString();
	}

	public String getFirmInfoById(Integer firmId) {
		return "SELECT * FROM firminfo WHERE firmId=#{firmId}";
	}

	public String deleteFirmInfo(Integer firmId) {
		return "DELETE FROM firminfo WHERE firmId=#{firmId}";
	}

	public String insertGroupInfo(GroupInfo groupInfo) {
		return new SQL() {
			{
				INSERT_INTO("groupinfo");
				if (StringUtils.isNotBlank(groupInfo.getGroupName()))
					VALUES("groupName", "#{groupName}");
				if (groupInfo.getGroupType() != null)
					VALUES("groupType", "#{groupType}");
				if (StringUtils.isNotBlank(groupInfo.getGroupDesc()))
					VALUES("groupDesc", "#{groupDesc}");
				if (groupInfo.getFirmId() != null)
					VALUES("firmId", "#{firmId}");
				if (groupInfo.getOperateId() != null)
					VALUES("operateId", "#{operateId}");
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateGroupInfo(GroupInfo groupInfo) {
		return new SQL() {
			{
				UPDATE("groupinfo");
				if (StringUtils.isNotBlank(groupInfo.getGroupName()))
					SET("groupName=#{groupName}");
				if (groupInfo.getGroupType() != null)
					SET("groupType=#{groupType}");
				if (StringUtils.isNotBlank(groupInfo.getGroupDesc()))
					SET("groupDesc=#{groupDesc}");
				if (groupInfo.getFirmId() != null)
					SET("firmId=#{firmId}");
				if (groupInfo.getOperateId() != null)
					SET("operateId=#{operateId}");
				SET("operateDate=(SELECT NOW())");
				WHERE("groupId=#{groupId}");
			}
		}.toString();
	}

	public String getAllGroupInfos(GroupInfo groupInfo) {
		return new SQL() {
			{
				SELECT("*").FROM("groupinfo");
				if (StringUtils.isNotBlank(groupInfo.getGroupName()))
					WHERE("groupName=#{groupName}");
				if (groupInfo.getGroupType() != null)
					WHERE("groupType=#{groupType}");
				if (StringUtils.isNotBlank(groupInfo.getGroupDesc()))
					WHERE("groupDesc=#{groupDesc}");
				if (groupInfo.getFirmId() != null)
					WHERE("firmId=#{firmId}");
				if (groupInfo.getOperateId() != null)
					WHERE("operateId=#{operateId}");
			}
		}.toString();
	}

	public String getGroupInfoById(Integer groupId) {
		return "SELECT * FROM groupinfo WHERE groupId=#{groupId}";
	}

	public String deleteGroupInfo(Integer integer) {
		return "DELETE FROM groupinfo WHERE groupId=#{groupId}";
	}

	public String insertOperMgr(OperMgr operMgr) {
		return new SQL() {
			{
				INSERT_INTO("opermgr");
				if (operMgr.getFirmId() != null)
					VALUES("firmId", "#{firmId}");
				if (operMgr.getManuId() != null)
					VALUES("manuId", "#{manuId}");
				if (operMgr.getOperateId() != null)
					VALUES("operateId", "#{operateId}");
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateOperMgr(OperMgr operMgr) {
		return new SQL() {
			{
				UPDATE("opermgr");
				if (operMgr.getFirmId() != null)
					SET("firmId=#{firmId}");
				if (operMgr.getManuId() != null)
					SET("manuId=#{manuId}");
				if (operMgr.getOperateId() != null)
					SET("operateId=#{operateId}");
				SET("operateDate=(SELECT NOW())");
				WHERE("operMgrId=#{operMgrId}");
			}
		}.toString();
	}

	public String getAllOperMgrs(OperMgr operMgr) {
		return new SQL() {
			{
				SELECT("*").FROM("opermgr");
				if (operMgr.getFirmId() != null)
					WHERE("firmId=#{firmId}");
				if (operMgr.getManuId() != null)
					WHERE("manuId=#{manuId}");
				if (operMgr.getOperateId() != null)
					WHERE("operateId=#{operateId}");
			}
		}.toString();
	}

	public String getOperMgrById(Integer operMgrId) {
		return "SELECT * FROM opermgr WHERE operMgrId=#{operMgrId}";
	}

	public String deleteOperMgr(Integer operMgrId) {
		return "DELETE FROM opermgr WHERE operMgrId=#{operMgrId}";
	}

}
