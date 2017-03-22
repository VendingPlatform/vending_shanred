package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import com.vending.platform.dao.sqlprovider.IFirmAndGroupSqlProvider;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.OperMgr;

/**
 * 公司及分组信息管理<br>
 * 1、公司信息管理 <br>
 * 2、分组管理<br>
 * 
 * @author Miley_Ren<br>
 */
public interface IFrimAndGroupDAO {
	/** 增加公司信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "insertFirm")
	public void insertFirm(FirmInfo firmInfo);

	/** 修改公司信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "updateFirm")
	public void updateFirm(FirmInfo firmInfo);

	/** 按条件查找所有公司信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getAllFirmInfos")
	public List<FirmInfo> getAllFirmInfos(FirmInfo firmInfo);

	/** 按Id查找公司 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getFirmInfoById")
	public FirmInfo getFirmInfoById(Integer firmId);

	/** 删除公司信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "deleteFirmInfo")
	public void deleteFirmInfo(Integer firmId);

	/** 增加分组信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "insertGroupInfo")
	public void insertGroupInfo(GroupInfo groupInfo);

	/** 更新分组信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "updateGroupInfo")
	public void updateGroupInfo(GroupInfo groupInfo);

	/** 按条件查询分组信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getAllGroupInfos")
	public List<GroupInfo> getAllGroupInfos(GroupInfo groupInfo);

	/** 按Id查看分组信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getGroupInfoById")
	@Results({
			@Result(property = "machineOperaters", column = "mOperaterId", many = @Many(select = "com.vending.platform.dao.IMachineDAO.getAllMachineOperaters")),
			@Result(property = "machineOperater", column = "mOperaterId", many = @Many(select = "com.vending.platform.dao.IMachineDAO.getMachineOperaterById")) })
	public GroupInfo getGroupInfoById(Integer groupId);

	/** 删除分组信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "deleteGroupInfo")
	public void deleteGroupInfo(Integer integer);

	/** 添加公司管理信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "insertOperMgr")
	public void insertOperMgr(OperMgr operMgr);

	/** 修改公司管理信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "updateOperMgr")
	public void updateOperMgr(OperMgr operMgr);

	/** 按条件查询多有公司管理信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getAllOperMgrs")
	public List<OperMgr> getAllOperMgrs(OperMgr operMgr);

	/** 按Id查询公司管理信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getOperMgrById")
	public OperMgr getOperMgrById(Integer operMgrId);

	/** 删除公司管理信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "deleteOperMgr")
	public void deleteOperMgr(Integer operMgrId);

}
