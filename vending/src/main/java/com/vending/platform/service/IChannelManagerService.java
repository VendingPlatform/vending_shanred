package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelInfo;

public interface IChannelManagerService {

	void insertChannelInfo(ChannelInfo channelInfo);

	void updateChannelInfo(ChannelInfo channelInfo);

	ChannelInfo getChannelInfoById(Integer channelId);

	List<ChannelInfo> getAllChannelInfos(ChannelInfo channelInfo);

	void deleteChannelInfo(Integer channelId);

	void inserChannelGroup(ChannelGroup channelGroup);

	void updateChannelGroup(ChannelGroup channelGroup);

	ChannelGroup getChannelGroupById(Integer channelGroupId);

	List<ChannelGroup> getAllChannelGroups(ChannelGroup channelGroup);

	void deleteChannelGroup(Integer channelGroupId);
}
