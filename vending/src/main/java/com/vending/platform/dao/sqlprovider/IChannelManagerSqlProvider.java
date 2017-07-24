package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelHistory;
import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;

public class IChannelManagerSqlProvider {

	public String insertChannelHistory(ChannelHistory channelHistory) {
		return new SQL() {
			{
				INSERT_INTO("channelinfohistory");
				if (StringUtils.isNotBlank(channelHistory.getMachineName()))
					VALUES("machineName", "#{machineName}");
				if (StringUtils.isNotBlank(channelHistory.getChannelNo()))
					VALUES("channelNo", "#{channelNo}");
				if (StringUtils.isNotBlank(channelHistory.getWareName()))
					VALUES("wareName", "#{wareName}");
				if (channelHistory.getPrice() != null)
					VALUES("price", "#{price}");
				if (channelHistory.getFirmId() != null)
					VALUES("firmId", "#{firmId}");
				if (channelHistory.getStockNumAdd() != null)
					VALUES("stockNumAdd", "#{stockNumAdd}");
				if (channelHistory.getOperateId() != null)
					VALUES("operateId", "#{operateId}");
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String getAllChannelInfosBySearch(Integer firmId, String machineName, String channelNo, String wareName) {
		String SQL = new SQL() {
			{
				SELECT(" b.* FROM (channelinfo a LEFT JOIN  machineinfo c  ON a.machineId=c.machineId)LEFT JOIN (channelwareinfo b LEFT JOIN wareinfo d ON b.wareId=d.wareId) ON a.channelId=b.channelId");
				if (firmId != null)
					WHERE("a.firmId=" + firmId);
				if (StringUtils.isNotBlank(machineName))
					WHERE("c.machineName='" + machineName + "'");
				if (StringUtils.isNotBlank(channelNo))
					WHERE("a.channelNo='" + channelNo + "'");
				if (StringUtils.isNotBlank(wareName))
					WHERE("d.wareName='" + wareName + "'");
			}
		}.toString();
		return SQL;
	}

	public String insertChannelGroup(ChannelGroup channelGroup) {
		return new SQL() {
			{
				INSERT_INTO("channelgroup");
				if (StringUtils.isNotBlank(channelGroup.getChannelGroupName()))
					VALUES("channelGroupName", "#{channelGroupName}");
				if (channelGroup.getOperateId() != null)
					VALUES("operateId", "#{operateId}");
				if (channelGroup.getFirmId() != null)
					VALUES("firmId", "#{firmId}");

				if (channelGroup.getWareId() != null)
					VALUES("wareId", "#{wareId}");
				if (channelGroup.getPrice() != null)
					VALUES("price", "#{price}");
				if (channelGroup.getIsDiscount() != null)
					VALUES("isDiscount", "#{isDiscount}");

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
				if (channelGroup.getOperateId() != null)
					SET("operateId=#{operateId}");
				if (channelGroup.getFirmId() != null)
					SET("firmId=#{firmId}");

				if (channelGroup.getWareId() != null)
					SET("wareId=#{wareId}");
				if (channelGroup.getPrice() != null)
					SET("price=#{price}");
				if (channelGroup.getIsDiscount() != null)
					SET("isDiscount=#{isDiscount}");

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
				if (channelGroup.getFirmId() != null)
					WHERE("firmId=#{firmId}");
				if (channelGroup.getOperateId() != null)
					WHERE("operateId=#{operateId}");

				if (channelGroup.getWareId() != null)
					WHERE("wareId=#{wareId}");
				if (channelGroup.getPrice() != null)
					WHERE("price=#{price}");
				if (channelGroup.getIsDiscount() != null)
					WHERE("isDiscount=#{isDiscount}");

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
				if (channelInfo.getStockNum() != null)
					VALUES("stockNum", "#{stockNum}");
				if (channelInfo.getStockNumNow() != null)
					VALUES("stockNumNow", "#{stockNumNow}");
				if (channelInfo.getStockNumAdd() != null)
					VALUES("stockNumAdd", "#{stockNumAdd}");
				if (channelInfo.getChannelGroupId() != null)
					VALUES("channelGroupId", "#{channelGroupId}");
				if (channelInfo.getmOperaterId() != null)
					VALUES("mOperaterId", "#{mOperaterId}");
				if (channelInfo.getMachineId() != null)
					VALUES("machineId", "#{machineId}");
				if (channelInfo.getFirmId() != null)
					VALUES("firmId", "#{firmId}");
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
				if (channelInfo.getStockNum() != null)
					SET("stockNum=#{stockNum}");
				if (channelInfo.getStockNumNow() != null)
					SET("stockNumNow=#{stockNumNow}");
				if (channelInfo.getStockNumAdd() != null)
					SET("stockNumAdd=#{stockNumAdd}");
				if (channelInfo.getChannelGroupId() != null)
					SET("channelGroupId=#{channelGroupId}");
				if (channelInfo.getmOperaterId() != null)
					SET("mOperaterId=#{mOperaterId}");
				if (channelInfo.getMachineId() != null)
					SET("machineId=#{machineId}");
				if (channelInfo.getOperateId() != null)
					SET("operateId=#{operateId}");
				if (channelInfo.getFirmId() != null)
					SET("firmId=#{firmId}");
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
				if (channelInfo.getStockNum() != null)
					WHERE("stockNum=#{stockNum}");
				if (channelInfo.getStockNumNow() != null)
					WHERE("stockNumNow=#{stockNumNow}");
				if (channelInfo.getStockNumAdd() != null)
					WHERE("stockNumAdd=#{stockNumAdd}");
				if (channelInfo.getChannelGroupId() != null)
					WHERE("channelGroupId=#{channelGroupId}");
				if (channelInfo.getmOperaterId() != null)
					WHERE("mOperaterId=#{mOperaterId}");
				if (channelInfo.getMachineId() != null)
					WHERE("machineId=#{machineId}");
				if (channelInfo.getFirmId() != null)
					WHERE("firmId=#{firmId}");
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

	public String getAllChannelWareInfos(ChannelWareInfo channelWareInfo) {
		return new SQL() {
			{
				// SELECT a.* FROM channelwareinfo a LEFT JOIN channelinfo b ON
				// a.channelId=b.channelId WHERE b.firmId=22
				SELECT("a.*").FROM("channelwareinfo a LEFT JOIN channelinfo b ON a.channelId=b.channelId");
				if (channelWareInfo.getChannelId() != null)
					WHERE("a.channelId=#{channelId}");
				if (channelWareInfo.getWareId() != null)
					WHERE("a.wareId=#{wareId}");
				if (channelWareInfo.getPrice() != null)
					WHERE("a.price=#{price}");
				if (channelWareInfo.getIsDiscount() != null)
					WHERE("a.isDiscount=#{isDiscount}");
				if (channelWareInfo.getmOperaterId() != null)
					WHERE("a.mOperaterId=#{mOperaterId}");
				if (channelWareInfo.getChannelInfo() != null) {
					if (channelWareInfo.getChannelInfo().getFirmId() != null)
						WHERE("b.firmId=#{channelInfo.firmId}");
				}
			}
		}.toString();
	}

	public String insertChannelWareInfo(ChannelWareInfo channelWareInfo) {
		return new SQL() {
			{
				INSERT_INTO("channelwareinfo");
				if (channelWareInfo.getChannelId() != null)
					VALUES("channelId", "#{channelId}");
				if (channelWareInfo.getWareId() != null)
					VALUES("wareId", "#{wareId}");
				if (channelWareInfo.getPrice() != null)
					VALUES("price", "#{price}");
				if (channelWareInfo.getIsDiscount() != null)
					VALUES("isDiscount", "#{isDiscount}");
				if (channelWareInfo.getmOperaterId() != null)
					VALUES("mOperaterId", "#{mOperaterId}");
			}
		}.toString();
	}

	public String updateChannelWareInfo(ChannelWareInfo channelWareInfo) {
		return new SQL() {
			{
				UPDATE("channelwareinfo");
				if (channelWareInfo.getChannelId() != null)
					SET("channelId=#{channelId}");
				if (channelWareInfo.getWareId() != null)
					SET("wareId=#{wareId}");
				if (channelWareInfo.getPrice() != null)
					SET("price=#{price}");
				if (channelWareInfo.getIsDiscount() != null)
					SET("isDiscount=#{isDiscount}");
				if (channelWareInfo.getmOperaterId() != null)
					SET("mOperaterId=#{mOperaterId}");
				WHERE("channelId=#{channelId}");
			}
		}.toString();
	}

	public String getAllChannelWareInfoById(Integer channelId) {
		return "SELECT * FROM channelwareinfo WHERE channelId=#{channelId}";
	}
}
