package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelHistory;
import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;
import com.vending.platform.domain.MachineOperater;

public interface IChannelManagerService {

	void insertChannelHistory(ChannelHistory channelHistory);
	void insertChannelInfo(ChannelInfo channelInfo);

	void updateChannelInfo(ChannelInfo channelInfo);

	ChannelInfo getChannelInfoById(Integer channelId);

	/** 根据编号和售货机查询货道 */
	ChannelInfo getChannelInfoByNo(String channelNo, Integer machineId);

	List<ChannelInfo> getAllChannelInfos(ChannelInfo channelInfo);

	List<ChannelInfo> getAllChannelInfosNotAssign(Integer firmId);

	List<ChannelWareInfo> getAllChannelInfos(Integer firmId, String machineName, String channelNo, String wareName);

	void deleteChannelInfo(Integer channelId);

	void inserChannelGroup(ChannelGroup channelGroup);

	void updateChannelGroup(ChannelGroup channelGroup);

	ChannelGroup getChannelGroupById(Integer channelGroupId);

	List<ChannelGroup> getAllChannelGroups(ChannelGroup channelGroup);

	void deleteChannelGroup(Integer channelGroupId);

	ChannelWareInfo getChannelWareInfo(Integer channelId);

	List<ChannelWareInfo> getAllChannelWareInfos(ChannelWareInfo channelWareInfo);

	void insetChannelWareInfo(ChannelWareInfo channelWareInfo);

	void updateChannelWareInfo(ChannelWareInfo channelWareInfo);

	void assignChannel(Integer machineId, MachineOperater mOperater);
	
	List<ChannelWareInfo> getChannelsByGroupId(Integer channelGroupId);
}
