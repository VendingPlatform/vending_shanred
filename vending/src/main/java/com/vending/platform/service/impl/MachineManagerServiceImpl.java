package com.vending.platform.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IMachineDAO;
import com.vending.platform.dao.IUserManagerDao;
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

	@Override
	public List<MachineOperater> getOprMachines(UserInfo userInfo, MachineOperater machineOperater) {
		if (machineOperater == null || userInfo == null) {
			return null;
		}
		int roleId = userInfo.getRoleId();
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
}
