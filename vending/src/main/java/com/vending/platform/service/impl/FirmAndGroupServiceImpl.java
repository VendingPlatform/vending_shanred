package com.vending.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vending.platform.dao.IFrimAndGroupDAO;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.OperMgr;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IFirmAndGroupService;

@Service
public class FirmAndGroupServiceImpl implements IFirmAndGroupService {

	@Autowired
	private IFrimAndGroupDAO firmAndGroupDao;

	@Override
	public void insertFirm(FirmInfo firmInfo) {
		firmAndGroupDao.insertFirm(firmInfo);
	}

	@Override
	public void updateFirm(FirmInfo firmInfo) {
		firmAndGroupDao.updateFirm(firmInfo);
	}

	@Override
	public List<FirmInfo> getAllFirmInfos(FirmInfo firmInfo) {
		return firmAndGroupDao.getAllFirmInfos(firmInfo);
	}

	@Override
	public FirmInfo getFirmInfo(Integer firmId) {
		return firmAndGroupDao.getFirmInfoById(firmId);
	}

	@Override
	public void deleteFirmInfo(Integer firmId) {
		firmAndGroupDao.deleteFirmInfo(firmId);
	}

	@Override
	public boolean insertGroup(GroupInfo groupInfo,UserInfo userInfo) {
		GroupInfo group = new GroupInfo();
		group.setFirmId(userInfo.getFirmInfo().getFirmId());
		group.setGroupType(groupInfo.getGroupType());
		group.setGroupName(groupInfo.getGroupName());
		List<GroupInfo> groupInfos = this.getAllGroupInfos(group);
		if (groupInfos != null && groupInfos.size() > 0) {
			return false;
		} else {
			groupInfo.setFirmId(userInfo.getFirmInfo().getFirmId());
			groupInfo.setOperateId(userInfo.getUserId());
			firmAndGroupDao.insertGroupInfo(groupInfo);
			return true;
		}
	}

	@Override
	public void updateGroup(GroupInfo groupInfo) {
		firmAndGroupDao.updateGroupInfo(groupInfo);
	}

	@Override
	public List<GroupInfo> getAllGroupInfos(GroupInfo groupInfo) {
		return firmAndGroupDao.getAllGroupInfos(groupInfo);
	}

	@Override
	public GroupInfo getGroupInfoById(Integer groupId) {
		return firmAndGroupDao.getGroupInfoById(groupId);
	}

	@Override
	public void deleteGroupInfo(Integer groupId) {
		firmAndGroupDao.deleteGroupInfo(groupId);
	}

	@Override
	public void insertOperMgr(OperMgr operMgr) {
		firmAndGroupDao.insertOperMgr(operMgr);
	}

	@Override
	public void updateOperMgr(OperMgr operMgr) {
		firmAndGroupDao.updateOperMgr(operMgr);
	}

	@Override
	public List<OperMgr> getAllOperMgrs(OperMgr operMgr) {
		return firmAndGroupDao.getAllOperMgrs(operMgr);
	}

	@Override
	public OperMgr getOperMgrById(Integer id) {
		return firmAndGroupDao.getOperMgrById(id);
	}

	@Override
	public void deleteOperMgr(Integer id) {
		firmAndGroupDao.deleteOperMgr(id);
	}

}
