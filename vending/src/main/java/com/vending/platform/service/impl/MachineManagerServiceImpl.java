package com.vending.platform.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IFrimAndGroupDAO;
import com.vending.platform.dao.IMachineDAO;
import com.vending.platform.dao.IUserManagerDao;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IMachineManagerService;

@Service
public class MachineManagerServiceImpl implements IMachineManagerService {
	private static Logger logger = Logger.getLogger(MachineManagerServiceImpl.class);

	@Autowired
	private IMachineDAO machineDao;
	@Autowired
	private IUserManagerDao userManagerDao;
	@Autowired
	private IFrimAndGroupDAO firmandgroupDao;

	@Override
	public List<MachineOperater> getMachineOperaters(UserInfo userInfo, MachineOperater machineOperater) {
		if (machineOperater == null || userInfo == null) {
			return null;
		}
		int roleId = userInfo.getRoleInfo().getRoleId();
		RoleInfo roleInfo = userManagerDao.getRoleById(roleId);
		String authorityCode = roleInfo.getAuthorityCode();
		machineOperater = UtilsService.getCode(authorityCode, machineOperater, userInfo);
		List<MachineOperater> machineOperaters = machineDao.getAllMachineOperaters(machineOperater);
		return machineOperaters;
	}

	@Override
	public List<MachineType> getAllMachineTypes(MachineType machineType) {
		return machineDao.getAllMachineTypes(machineType);
	}

	@Override
	public MachineOperater getMachineOperaterById(Integer mOperaterId) {
		return machineDao.getMachineOperaterById(mOperaterId);
	}

	@Override
	public void updateMachineOperater(MachineOperater machineOperater, UserInfo userInfo) {
		machineOperater.setOperateId(userInfo.getUserId());
		machineDao.updateMachineOperate(machineOperater);
	}

	@Override
	public List<GroupInfo> getAllMachineGroups(GroupInfo groupInfo) {
		List<GroupInfo> groupInfos = firmandgroupDao.getAllGroupInfos(groupInfo);
		return groupInfos;
	}

	@Override
	public GroupInfo getGroupInfoById(Integer groupId) {
		return firmandgroupDao.getGroupInfoById(groupId);
	}

	@Override
	public void updateGroupInfo(GroupInfo groupInfo) {
		firmandgroupDao.updateGroupInfo(groupInfo);
	}

	@Override
	public boolean deleteGroupInfo(Integer groupId) {
		MachineOperater machineOperater = new MachineOperater();
		machineOperater.setGroupId(groupId);
		List<MachineOperater> machineOperaters = machineDao.getAllMachineOperaters(machineOperater);
		UserInfo userInfo = new UserInfo();
		userInfo.setGroupId(groupId);
		List<UserInfo> userInfos = userManagerDao.getAllUsers(userInfo);
		if ((machineOperaters == null || machineOperaters.size() == 0)
				&& (userInfos == null || userInfos.size() == 0)) {
			firmandgroupDao.deleteGroupInfo(groupId);
			return true;
		}
		return false;
	}

	@Override
	public boolean addGroupInfo(GroupInfo groupInfo, UserInfo userInfo) {
		GroupInfo group = new GroupInfo();
		group.setFirmId(userInfo.getFirmInfo().getFirmId());
		group.setGroupType(groupInfo.getGroupType());
		group.setGroupName(groupInfo.getGroupName());
		List<GroupInfo> groupInfos = firmandgroupDao.getAllGroupInfos(group);
		if (groupInfos != null && groupInfos.size() > 0) {
			return false;
		} else {
			groupInfo.setFirmId(userInfo.getFirmInfo().getFirmId());
			groupInfo.setOperateId(userInfo.getUserId());
			firmandgroupDao.insertGroupInfo(groupInfo);
			return true;
		}
	}

	@Override
	public List<MachineOperater> getAllMachineOperaters(MachineOperater machineOperater) {
		List<MachineOperater> machineOperaters = machineDao.getAllMachineOperaters(machineOperater);
		return machineOperaters;
	}
}
