package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.UserInfo;

/** 售货机管理Service */
public interface IMachineManagerService {
	/**
	 * 查询厂商售货机
	 * 
	 * @param userInfo
	 *            用户信息
	 * @param machineOperater
	 *            售货机查询条件
	 * @return MachineOperater
	 */
	public List<MachineOperater> getOprMachines(UserInfo userInfo, MachineOperater machineOperater);

	/** 查询所有售货机的类型 */
	public List<MachineType> getAllMachineTypes(MachineType machineType);

	MachineOperater getMachineOperaterById(Integer mOperaterId);

	void updateMachineOperater(MachineOperater machineOperater, UserInfo userInfo);
}
