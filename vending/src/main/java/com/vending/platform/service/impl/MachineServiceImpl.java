package com.vending.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IMachineDAO;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.MachineService;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	private IMachineDAO machinedao;

	@Override
	public List<MachineOperater> getAllMachine(UserInfo userInfo, MachineOperater machineOperater) {
		return machinedao.getAllMachine(userInfo, machineOperater);
	}

	@Override
	public MachineOperater getMachineOperaterById(Integer mOperaterId) {
		return machinedao.getMachineOperaterById(mOperaterId);
	}

	@Override
	public void changeMachineStatus(int status, Integer mOperateId) {
		machinedao.changeMachineStatus(status, mOperateId);
	}

}
