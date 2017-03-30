package com.vending.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vending.platform.dao.IFrimAndGroupDAO;
import com.vending.platform.dao.IUserManagerDao;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.OperMgr;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.exception.SQLFormatException;
import com.vending.platform.service.IFirmAndGroupService;

@Service
public class FirmAndGroupServiceImpl implements IFirmAndGroupService {

	@Autowired
	private IFrimAndGroupDAO firmAndGroupDao;
	@Autowired
	private IUserManagerDao userManagerDao;

	@Override
	public boolean insertFirm(FirmInfo firmInfo) {
		FirmInfo firmAlready = new FirmInfo();
		firmAlready.setFirmNo(firmInfo.getFirmNo());
		List<FirmInfo> firmInfos = firmAndGroupDao.getAllFirmInfos(firmAlready);
		if (firmInfos.size() > 0) {
			return false;
		} else {
			// 添加管理员
			UserInfo userInfo = new UserInfo();
			userInfo.setUserNo(firmInfo.getFirmNo() + "01");
			userInfo.setUserName("system" + firmInfo.getFirmNo());
			userInfo.setUserPassword("system" + firmInfo.getFirmNo());
			Integer roleId = 0;
			if (firmInfo.getFirmType() == 1) {// 运营商
				roleId = 2;
			}
			if (firmInfo.getFirmType() == 2) {// 厂商
				roleId = 3;
			}
			if (roleId != 2 && roleId != 3) {
				return false;
			}
			userInfo.setRoleId(roleId);
			userInfo.setStatus(1);
			firmAndGroupDao.insertFirm(firmInfo);
			Integer firmId = firmAndGroupDao.getAllFirmInfos(firmInfo).get(0).getFirmId();
			userInfo.setFirmId(firmId);
			userInfo.setOperateId(firmInfo.getOperateId());
			try {
				userManagerDao.insertUser(userInfo);
			} catch (SQLFormatException e) {
				firmAndGroupDao.deleteFirmInfo(firmId);
				e.printStackTrace();
			}
			return true;
		}

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
	public boolean insertGroup(GroupInfo groupInfo, UserInfo userInfo) {
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
