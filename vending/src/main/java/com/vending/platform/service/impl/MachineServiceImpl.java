package com.vending.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IMachineDAO;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.service.MachineService;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	private IMachineDAO machinedao;

	@Override
	public List<MachineOperater> getmachineOperater(MachineOperater operater) {
		return (List<MachineOperater>) machinedao.getmachineOperater(operater);
	}

}
