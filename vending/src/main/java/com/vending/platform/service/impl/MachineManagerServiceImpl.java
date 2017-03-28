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
import com.vending.platform.domain.UserInfo;
import com.vending.platform.exception.SQLFormatException;
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
		/*
		 * int roleId = userInfo.getRoleInfo().getRoleId(); RoleInfo roleInfo =
		 * userManagerDao.getRoleById(roleId); String authorityCode =
		 * roleInfo.getAuthorityCode(); machineOperater =
		 * UtilsService.getCode(authorityCode, machineOperater, userInfo);
		 */List<MachineOperater> machineOperaters = machineDao.getAllMachineOperaters(machineOperater);
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
	public void updateMachineOperater(MachineOperater machineOperater) {
		machineDao.updateMachineOperate(machineOperater);
	}


	@Override
	public List<MachineOperater> getAllMachineOperaters(MachineOperater machineOperater) {
		List<MachineOperater> machineOperaters = machineDao.getAllMachineOperaters(machineOperater);
		return machineOperaters;
	}

	@Override
	public MachineType getMachineTypeById(Integer id) {
		return machineDao.getMachineTypeById(id);
	}

	@Override
	public void updateMachineType(MachineType machineType) {
		try {
			machineDao.updateMachineType(machineType);
			logger.debug("没有Id,更新失败");
			throw new SQLFormatException("没有Id,更新失败");
		} catch (SQLFormatException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertMachineType(MachineType machineType) {
		try {
			machineDao.inseretMachineType(machineType);
		} catch (SQLFormatException e) {
			logger.debug("数据格式不允许");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMachineType(Integer id) {
		machineDao.deleteMachineType(id);
	}
}
