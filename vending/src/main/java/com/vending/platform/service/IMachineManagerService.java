package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.MachineInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.UserInfo;

/** 售货机管理Service */
public interface IMachineManagerService {
    
    MachineInfo getMachineInfoById(Integer machineId);
    
    void insertMachine(MachineInfo machineInfo);
    /**查询厂商所有售货机*/
    List<MachineInfo> getAllMachineInfos(MachineInfo machineInfo);
    
    void updateMachineInfo(MachineInfo machineInfo);
    
    boolean deleteMachineInfo(Integer machineId);
    
	/** 查询所有售货机的类型 */
	List<MachineType> getAllMachineTypes(MachineType machineType);

	MachineType getMachineTypeById(Integer id);

	void updateMachineType(MachineType machineType);

	void insertMachineType(MachineType machineType);

	void deleteMachineType(Integer id);
	/** 查询运营商售货机 */
	List<MachineOperater> getMachineOperaters(UserInfo userInfo, MachineOperater machineOperater);
	
	List<MachineOperater> getAllMachineOperaters(MachineOperater machineOperater);
	/** 查询groupId售货机组内所有售货机信息 */
	MachineOperater getMachineOperaterById(Integer mOperaterId);

	MachineOperater getMachineOperaterBymachine(Integer machineId);
	
	void updateMachineOperater(MachineOperater machineOperater);
	
	void inserMachineOperater(MachineOperater machineOperater);
	
	void removeMachineOperaterFromUser(Integer mOperaterId);
	

}
