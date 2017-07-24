package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.IChannelManagerSqlProvider;
import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelHistory;
import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;

/**
 * 货道管理 <br>
 * 1、货道组管理<br>
 * 2、货道信息管理
 */
public interface IChannelManagerDAO {

	@Select("SELECT a.* FROM channelwareinfo a LEFT JOIN channelinfo b ON a.channelId=b.channelId WHERE channelGroupId=#{channelGroupId}")
	@Results({
			@Result(property = "wareInfo", column = "wareId", one = @One(select = "com.vending.platform.dao.IWareManagerDAO.getWareInfoById")),
			@Result(property = "channelInfo", column = "channelId", one = @One(select = "com.vending.platform.dao.IChannelManagerDAO.getChannelInfoById")) })
	public List<ChannelWareInfo> getChannelInofByGroupId(Integer channelGroupId);
	
	@Select("SELECT * FROM channelInfo where firmId=#{firmId} and channelGroupId is null")
	@Results({
		@Result(property = "machineInfo", column = "machineId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineInfoById")),
		@Result(property = "machineOperater", column = "mOperaterId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineOperaterById")) })
	public List<ChannelInfo> getAllChannelInfosNotAssign(Integer firmId );

	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getAllChannelInfosBySearch")
	@Results({
			@Result(property = "wareInfo", column = "wareId", one = @One(select = "com.vending.platform.dao.IWareManagerDAO.getWareInfoById")),
			@Result(property = "channelInfo", column = "channelId", one = @One(select = "com.vending.platform.dao.IChannelManagerDAO.getChannelInfoById")) })
	public List<ChannelWareInfo> getAllChannelInfosBySearch(Integer firmId, String machineName, String channelNo,
			String wareName);

	/** 添加货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "insertChannelGroup")
	public void insertChannelGroup(ChannelGroup channelGroup);

	/** 更新货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "updateChannelGroup")
	public void updateChannelGroup(ChannelGroup channelGroup);

	/** 按条件查找所有货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getAllChannelGroups")
	@Results({
			@Result(property = "wareInfo", column = "wareId", one = @One(select = "com.vending.platform.dao.IWareManagerDAO.getWareInfoById")) })
	public List<ChannelGroup> getAllChannelGroups(ChannelGroup channelGroup);

	/** 按Id查找货道组 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getChannelGroupById")
	@Results({
			@Result(property = "wareInfo", column = "wareId", one = @One(select = "com.vending.platform.dao.IWareManagerDAO.getWareInfoById")) })
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
	@Results({
			@Result(property = "machineInfo", column = "machineId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineInfoById")),
			@Result(property = "machineOperater", column = "mOperaterId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineOperaterById")) })
	public List<ChannelInfo> getAllChannelInfos(ChannelInfo channelInfo);

	/** 按Id查询货道 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getChannelInfoById")
	@Results({
			@Result(property = "machineInfo", column = "machineId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineInfoById")),
			@Result(property = "machineOperater", column = "mOperaterId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineOperaterById")) })
	public ChannelInfo getChannelInfoById(Integer channelId);

	/** 删除货道信息 */
	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "deleteChannelInfo")
	public void deleteChannelInfo(Integer channelId);

	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getAllChannelWareInfos")
	@Results({
			@Result(property = "wareInfo", column = "wareId", one = @One(select = "com.vending.platform.dao.IWareManagerDAO.getWareInfoById")),
			@Result(property = "channelInfo", column = "channelId", one = @One(select = "com.vending.platform.dao.IChannelManagerDAO.getChannelInfoById")) })
	public List<ChannelWareInfo> getAllChannelWareInfos(ChannelWareInfo channelWareInfo);

	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "getAllChannelWareInfoById")
	@Results({
			@Result(property = "wareInfo", column = "wareId", one = @One(select = "com.vending.platform.dao.IWareManagerDAO.getWareInfoById")),
			@Result(property = "channelInfo", column = "channelId", one = @One(select = "com.vending.platform.dao.IChannelManagerDAO.getChannelInfoById")) })
	public ChannelWareInfo getAllChannelWareInfoById(Integer channelId);

	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "insertChannelWareInfo")
	public void insertChannelWareInfo(ChannelWareInfo channelWareInfo);

	@SelectProvider(type = IChannelManagerSqlProvider.class, method = "updateChannelWareInfo")
	public void updateChannelWareInfo(ChannelWareInfo channelWareInfo);

	@SelectProvider(type = IChannelManagerSqlProvider.class, method="insertChannelHistory")
	public void insertChannelHistory(ChannelHistory channelHistory);
}
