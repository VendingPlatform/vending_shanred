package com.vending.platform.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.ChannelGroup;

public class ChannelManagerSqlProvider {

	public String insertChannelGroup(ChannelGroup channelGroup) {
		return new SQL() {
			{
			}
		}.toString();
	}

	public String updateChannelGroup(ChannelGroup channelGroup) {
		return new SQL() {
			{
			}
		}.toString();
	}

	public String getAllChannelGroup(ChannelGroup channelGroup) {
		return new SQL() {
			{
			}
		}.toString();
	}

	public String getChannelGroupById(Integer channelGroupId) {
		return "SELECT * FROM channelgroup WHERE channelGroupId=#{channelGroupId}";
	}

	public String deleteChannelGroup(Integer channelGroupId) {
		return "DELETE FROM channelgroup WHERE channelGroupId=#{channelGroupId}";
	}
}
