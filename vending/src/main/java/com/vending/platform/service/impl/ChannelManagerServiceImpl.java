package com.vending.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IChannelManagerDAO;
import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelHistory;
import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;
import com.vending.platform.domain.MachineOperater;
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

    @Override
    public List<ChannelWareInfo> getAllChannelWareInfos(
            ChannelWareInfo channelWareInfo) {
        return channelManagerDao.getAllChannelWareInfos(channelWareInfo);
    }

    @Override
    public ChannelWareInfo getChannelWareInfo(Integer channelId) {
        return channelManagerDao.getAllChannelWareInfoById(channelId);
    }

    @Override
    public void insetChannelWareInfo(ChannelWareInfo channelWareInfo) {
        channelManagerDao.insertChannelWareInfo(channelWareInfo);
    }

    @Override
    public void assignChannel(Integer machineId,MachineOperater mOperater) {
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setMachineId(machineId);
        List<ChannelInfo> channelInfos = channelManagerDao.getAllChannelInfos(channelInfo);
        ChannelWareInfo channelWareInfo = new ChannelWareInfo();
        for (ChannelInfo channel : channelInfos) {
            channelInfo.setmOperaterId(mOperater.getmOperaterId());
            channelInfo.setFirmId(mOperater.getOperFirmId());
            channelInfo.setChannelId(channel.getChannelId());
            channelManagerDao.updateChannelInfo(channelInfo);
            
            channelWareInfo.setChannelId(channel.getChannelId());
            channelWareInfo.setmOperaterId(mOperater.getmOperaterId());
            channelManagerDao.insertChannelWareInfo(channelWareInfo);
        }
    }

    @Override
    public List<ChannelWareInfo> getAllChannelInfos(Integer firmId,
            String machineName, String channelNo, String wareName) {
        return  channelManagerDao.getAllChannelInfosBySearch(firmId, machineName, channelNo, wareName);
    }

    @Override
    public ChannelInfo getChannelInfoByNo(String channelNo, Integer machineId) {
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setChannelNo(channelNo);
        channelInfo.setMachineId(machineId);
        ChannelInfo cInfo= channelManagerDao.getAllChannelInfos(channelInfo).get(0);
        return cInfo;
    }

    @Override
    public void updateChannelWareInfo(ChannelWareInfo channelWareInfo) {
        channelManagerDao.updateChannelWareInfo(channelWareInfo);
    }

	@Override
	public List<ChannelInfo> getAllChannelInfosNotAssign(Integer firmId) {
		return channelManagerDao.getAllChannelInfosNotAssign(firmId);
	}

	@Override
	public List<ChannelWareInfo> getChannelsByGroupId(Integer channelGroupId) {
		return channelManagerDao.getChannelInofByGroupId(channelGroupId);
	}

	@Override
	public void insertChannelHistory(ChannelHistory channelHistory) {
		channelManagerDao.insertChannelHistory(channelHistory);
	}
}
 