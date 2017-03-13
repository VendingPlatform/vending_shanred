package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.ChannelManagerSqlProvider;
import com.vending.platform.domain.ChannelGroup;

/**
 * 货道管理 <br>
 * 1、货道组管理<br>
 * 2、货道信息管理
 */
public interface IChannelManagerDAO {

	/** 添加货道组 */
	@SelectProvider(type = ChannelManagerSqlProvider.class, method = "insertChannelGroup")
	public void insertChannelGroup(ChannelGroup channelGroup);

	/** 更新货道组 */
	@SelectProvider(type = ChannelManagerSqlProvider.class, method = "updateChannelGroup")
	public void updateChannelGroup(ChannelGroup channelGroup);

	/** 按条件查找所有货道组 */
	@SelectProvider(type = ChannelManagerSqlProvider.class, method = "getAllChannelGroup")
	public List<ChannelGroup> getAllChannelGroup(ChannelGroup channelGroup);

	/** 按Id查找货道组 */
	@SelectProvider(type = ChannelManagerSqlProvider.class, method = "getChannelGroupById")
	public ChannelGroup getChannelGroupById(Integer channelGroupId);

	/** 删除货道组 */
	@SelectProvider(type = ChannelManagerSqlProvider.class, method = "deleteChannelGroup")
	public void deleteChannelGroup(Integer channelGroupId);

}
