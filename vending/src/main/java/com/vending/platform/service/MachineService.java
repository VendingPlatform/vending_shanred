package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.MachineOperater;

/**
 * 售貨机service
 * 
 * 1、售货机分组管理 ;<br>
 * 2、售货机分配 ;<br>
 * 3、售货机货道管理<br>
 */
public interface MachineService {
	/** 根据条件查询运营商的售货机信息 */
	List<MachineOperater> getmachineOperater(MachineOperater operater);
}
