package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelInfo;

public class IChannelManagerSqlProvider {

	public String insertChannelGroup(ChannelGroup channelGroup) {
		return new SQL() {
			{
				INSERT_INTO("channelgroup");
				if (StringUtils.isNotBlank(channelGroup.getChannelGroupName()))
					VALUES("channelGroupName", "#{channelGroupName}");
				if (StringUtils.isNotBlank(channelGroup.getWareCode()))
					VALUES("wareCode", "#{wareCode}");
				if (StringUtils.isNotBlank(channelGroup.getWareName()))
					VALUES("wareName", "#{wareName}");
				if (StringUtils.isNotBlank(channelGroup.getWarePrice() + ""))
					VALUES("warePrice", "#{warePrice}");
				if (channelGroup.getIsDiscount() != null)
					VALUES("isDiscount", "#{isDiscount}");
				if (channelGroup.getGroupId() != null)
					VALUES("groupId", "#{groupId}");
				if (channelGroup.getOperateId() != null)
					VALUES("operateId", "#{operateId}");
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateChannelGroup(ChannelGroup channelGroup) {
		return new SQL() {
			{
				UPDATE("channelgroup");
				if (StringUtils.isNotBlank(channelGroup.getChannelGroupName()))
					SET("channelGroupName=#{channelGroupName}");
				if (StringUtils.isNotBlank(channelGroup.getWareCode()))
					SET("wareCode=#{wareCode}");
				if (StringUtils.isNotBlank(channelGroup.getWareName()))
					SET("wareName=#{wareName}");
				if (StringUtils.isNotBlank(channelGroup.getWarePrice() + ""))
					SET("warePrice=#{warePrice}");
				if (channelGroup.getIsDiscount() != null)
					SET("isDiscount=#{isDiscount}");
				if (channelGroup.getGroupId() != null)
					SET("groupId=#{groupId}");
				if (channelGroup.getOperateId() != null)
					SET("operateId=#{operateId}");
				WHERE("channelGroupId=#{channelGroupId}");
			}
		}.toString();
	}

	public String getAllChannelGroups(ChannelGroup channelGroup) {
		return new SQL() {
			{
				SELECT("*").FROM("channelgroup");
				if (StringUtils.isNotBlank(channelGroup.getChannelGroupName()))
					WHERE("channelGroupName=#{channelGroupName}");
				if (StringUtils.isNotBlank(channelGroup.getWareCode()))
					WHERE("wareCode=#{wareCode}");
				if (StringUtils.isNotBlank(channelGroup.getWareName()))
					WHERE("wareName=#{wareName}");
				if (StringUtils.isNotBlank(channelGroup.getWarePrice() + ""))
					WHERE("warePrice=#{warePrice}");
				if (channelGroup.getIsDiscount() != null)
					WHERE("isDiscount=#{isDiscount}");
				if (channelGroup.getGroupId() != null)
					WHERE("groupId=#{groupId}");
				if (channelGroup.getOperateId() != null)
					WHERE("operateId=#{operateId}");
			}
		}.toString();
	}

	public String getChannelGroupById(Integer channelGroupId) {
		return "SELECT * FROM channelgroup WHERE channelGroupId=#{channelGroupId}";
	}

	public String deleteChannelGroup(Integer channelGroupId) {
		return "DELETE FROM channelgroup WHERE channelGroupId=#{channelGroupId}";
	}

	public String insertChannelInfo(ChannelInfo channelInfo) {
		return new SQL() {
			{
				INSERT_INTO("channelinfo");
				if (StringUtils.isNotBlank(channelInfo.getChannelNo()))
					VALUES("channelNo", "#{channelNo}");
				if (StringUtils.isNotBlank(channelInfo.getWareCode()))
					VALUES("wareCode", "#{wareCode}");
				if (StringUtils.isNotBlank(channelInfo.getWareName()))
					VALUES("wareName", "#{wareName}");
				if (StringUtils.isNotBlank(channelInfo.getWarePrice() + ""))
					VALUES("warePrice", "#{warePrice}");
				if (channelInfo.getIsDiscount() != null)
					VALUES("isDiscount", "#{isDiscount}");
				if (channelInfo.getStockNum() != null)
					VALUES("stockNum", "#{stockNum}");
				if (channelInfo.getStockNumNow() != null)
					VALUES("stockNumnNow", "#{stockNumnNow}");
				if (channelInfo.getStockNumAdd() != null)
					VALUES("stockNumnAdd", "#{stockNumnAdd}");
				if (channelInfo.getChannelGroupId() != null)
					VALUES("channelGroupId", "#{channelGroupId}");
				if (channelInfo.getMachineId() != null)
					VALUES("machineId", "#{machineId}");
				if (channelInfo.getIsHistory() != null)
					VALUES("isHistory", "#{isHistory}");
				if (channelInfo.getOperateId() != null)
					VALUES("operateId", "#{operateId}");
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateChannelInfo(ChannelInfo channelInfo) {
		return new SQL() {
			{
				UPDATE("channelinfo");
				if (StringUtils.isNotBlank(channelInfo.getChannelNo()))
					SET("channelNo=#{channelNo}");
				if (StringUtils.isNotBlank(channelInfo.getWareCode()))
					SET("wareCode=#{wareCode}");
				if (StringUtils.isNotBlank(channelInfo.getWareName()))
					SET("wareName=#{wareName}");
				if (StringUtils.isNotBlank(channelInfo.getWarePrice() + ""))
					SET("warePrice=#{warePrice}");
				if (channelInfo.getIsDiscount() != null)
					SET("isDiscount=#{isDiscount}");
				if (channelInfo.getStockNum() != null)
					SET("stockNum=#{stockNum}");
				if (channelInfo.getStockNumNow() != null)
					SET("stockNumnNow=#{stockNumnNow}");
				if (channelInfo.getStockNumAdd() != null)
					SET("stockNumnAdd=#{stockNumnAdd}");
				if (channelInfo.getChannelGroupId() != null)
					SET("channelGroupId=#{channelGroupId}");
				if (channelInfo.getMachineId() != null)
					SET("machineId=#{machineId}");
				if (channelInfo.getIsHistory() != null)
					SET("isHistory=#{isHistory}");
				if (channelInfo.getOperateId() != null)
					SET("operateId=#{operateId}");
				SET("operateDate=(SELECT NOW())");
				WHERE("channelId=#{channelId}");
			}
		}.toString();
	}

	public String getAllChannelInfos(ChannelInfo channelInfo) {
		return new SQL() {
			{
				SELECT("*").FROM("channelinfo");
				if (StringUtils.isNotBlank(channelInfo.getChannelNo()))
					WHERE("channelNo=#{channelNo}");
				if (StringUtils.isNotBlank(channelInfo.getWareCode()))
					WHERE("wareCode=#{wareCode}");
				if (StringUtils.isNotBlank(channelInfo.getWareName()))
					WHERE("wareName=#{wareName}");
				if (StringUtils.isNotBlank(channelInfo.getWarePrice() + ""))
					WHERE("warePrice=#{warePrice}");
				if (channelInfo.getIsDiscount() != null)
					WHERE("isDiscount=#{isDiscount}");
				if (channelInfo.getStockNum() != null)
					WHERE("stockNum=#{stockNum}");
				if (channelInfo.getStockNumNow() != null)
					WHERE("stockNumnNow=#{stockNumnNow}");
				if (channelInfo.getStockNumAdd() != null)
					WHERE("stockNumnAdd=#{stockNumnAdd}");
				if (channelInfo.getChannelGroupId() != null)
					WHERE("channelGroupId=#{channelGroupId}");
				if (channelInfo.getMachineId() != null)
					WHERE("machineId=#{machineId}");
				if (channelInfo.getIsHistory() != null)
					WHERE("isHistory=#{isHistory}");
				if (channelInfo.getOperateId() != null)
					WHERE("operateId=#{operateId}");
			}
		}.toString();
	}

	public String getChannelInfoById(Integer channelId) {
		return "SELECT * FROM channelinfo WHERE channelId=#{channelId}";
	}

	public String deleteChannelInfo(Integer channelId) {
		return "DELETE FROM channelinfo WHERE channelId=#{channelId}";
	}
}
