package com.vending.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IMachineDAO;
import com.vending.platform.service.MachineService;

@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	private IMachineDAO machinedao;

}
