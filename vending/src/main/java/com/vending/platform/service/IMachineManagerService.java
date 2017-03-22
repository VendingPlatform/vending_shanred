package com.vending.platform.service;

import java.security.acl.Group;
import java.util.List;

import com.vending.platform.domain.GroupInfo;
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
	List<MachineOperater> getOprMachines(UserInfo userInfo, MachineOperater machineOperater);

	/** 查询所有售货机的类型 */
	List<MachineType> getAllMachineTypes(MachineType machineType);

	MachineOperater getMachineOperaterById(Integer mOperaterId);

	void updateMachineOperater(MachineOperater machineOperater, UserInfo userInfo);

	/** 查询售货机分组 */
	List<GroupInfo> getAllMachineGroups(GroupInfo groupInfo);

	GroupInfo getGroupInfoById(Integer groupId);

	void updateGroupInfo(GroupInfo groupInfo);

	/** 删除分组，只有当前分组不被任何人或机器引用才可以删除，否则不进行删除 */
	boolean deleteGroupInfo(Integer groupId);

	/** 添加分组 ，同一公司、同一类型的分组不能重名 */
	boolean addGroupInfo(GroupInfo groupInfo, UserInfo userInfo);
}
