package com.vending.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IChannelManagerDAO;
import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.service.IChannelManagerService;

@Service
public class ChannelManagerServiceImpl implements IChannelManagerService {

	@Autowired
	private IChannelManagerDAO channelManagerDao;

	@Override
	public void insertChannelInfo(ChannelInfo channelInfo) {
		channelManagerDao.insertChannelInfo(channelInfo);
	}

	@Override
	public void updateChannelInfo(ChannelInfo channelInfo) {
		channelManagerDao.updateChannelInfo(channelInfo);
	}

	@Override
	public ChannelInfo getChannelInfoById(Integer channelId) {
		return channelManagerDao.getChannelInfoById(channelId);
	}

	@Override
	public List<ChannelInfo> getAllChannelInfos(ChannelInfo channelInfo) {
		return channelManagerDao.getAllChannelInfos(channelInfo);
	}

	@Override
	public void deleteChannelInfo(Integer channelId) {
		channelManagerDao.deleteChannelInfo(channelId);
	}

	@Override
	public void inserChannelGroup(ChannelGroup channelGroup) {
		channelManagerDao.insertChannelGroup(channelGroup);
	}

	@Override
	public void updateChannelGroup(ChannelGroup channelGroup) {
		channelManagerDao.updateChannelGroup(channelGroup);
	}

	@Override
	public ChannelGroup getChannelGroupById(Integer channelGroupId) {
		return channelManagerDao.getChannelGroupById(channelGroupId);
	}

	@Override
	public List<ChannelGroup> getAllChannelGroups(ChannelGroup channelGroup) {
		return channelManagerDao.getAllChannelGroups(channelGroup);
	}

	@Override
	public void deleteChannelGroup(Integer channelGroupId) {
		channelManagerDao.deleteChannelGroup(channelGroupId);
	}
}
