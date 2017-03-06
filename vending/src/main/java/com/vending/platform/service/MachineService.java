package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;

/**
 * 售貨机service
 * 
 * 1、售货机分组管理 ;<br>
 * 2、售货机分配 ;<br>
 * 3、售货机货道管理<br>
 */
public interface MachineService {
	/***/
	public void changeMachineStatus(int status, Integer mOperateId);

	/** 根据machineoperate表中Id查询售货机 */
	public MachineOperater getMachineOperaterById(Integer mOperaterId);

	/** 根据条件进行查询运营商所属的售货机 */
	public List<MachineOperater> getAllMachine(UserInfo userInfo, MachineOperater machineOperater);

}
