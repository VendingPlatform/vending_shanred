package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.OperMgr;
import com.vending.platform.domain.UserInfo;

public interface IFirmAndGroupService {

	void insertFirm(FirmInfo firmInfo);

	void updateFirm(FirmInfo firmInfo);

	List<FirmInfo> getAllFirmInfos(FirmInfo firmInfo);

	FirmInfo getFirmInfo(Integer firmId);

	void deleteFirmInfo(Integer firmId);

	boolean insertGroup(GroupInfo groupInfo, UserInfo userInfo);

	void updateGroup(GroupInfo groupInfo);

	List<GroupInfo> getAllGroupInfos(GroupInfo groupInfo);

	GroupInfo getGroupInfoById(Integer groupId);

	/** 删除分组，只有当前分组不被任何人或机器引用才可以删除，否则不进行删除 */
	void deleteGroupInfo(Integer groupId);

	void insertOperMgr(OperMgr operMgr);

	void updateOperMgr(OperMgr operMgr);

	List<OperMgr> getAllOperMgrs(OperMgr operMgr);

	OperMgr getOperMgrById(Integer id);

	void deleteOperMgr(Integer id);

}
