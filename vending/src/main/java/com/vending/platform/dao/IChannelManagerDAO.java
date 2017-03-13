package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.IChannelManagerSqlProvider;
import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelInfo;

/**
 * 货道管理 <br>
 * 1、货道组管理<br>
 * 2、货道信息管理
 */
public interface IChannelManagerDAO {

	/** 添加货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "insertChannelGroup")
	public void insertChannelGroup(ChannelGroup channelGroup);

	/** 更新货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "updateChannelGroup")
	public void updateChannelGroup(ChannelGroup channelGroup);

	/** 按条件查找所有货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getAllChannelGroups")
	public List<ChannelGroup> getAllChannelGroups(ChannelGroup channelGroup);

	/** 按Id查找货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getChannelGroupById")
	public ChannelGroup getChannelGroupById(Integer channelGroupId);

	/** 删除货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "deleteChannelGroup")
	public void deleteChannelGroup(Integer channelGroupId);

	/** 添加货道 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "insertChannelInfo")
	public void insertChannelInfo(ChannelInfo channelInfo);

	/** 修改货道 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "updateChannelInfo")
	public void updateChannelInfo(ChannelInfo channelInfo);

	/** 按需求查询所有货道 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getAllChannelInfos")
	public List<ChannelInfo> getAllChannelInfos(ChannelInfo channelInfo);

	/** 按Id查询货道 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getChannelInfoById")
	public ChannelInfo getChannelInfoById(Integer channelId);

	/** 删除货道信息 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "deleteChannelInfo")
	public void deleteChannelInfo(Integer channelId);

}
