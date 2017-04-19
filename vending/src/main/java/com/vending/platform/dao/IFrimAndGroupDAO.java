package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
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
	@Results({
			@Result(property = "userInfos", column = "userId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getAllUsers")),
			@Result(property = "userInfo", column = "userId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getUserById")),
			@Result(property = "machineInfos", column= "machineId", many= @Many(select = "com.vending.platform.dao.IMachineDAO.getAllGroupInfos")),
            @Result(property = "machineInfo", column= "machineId", many= @Many(select = "com.vending.platform.dao.IMachineDAO.getMachineInfoById"))})
	public List<FirmInfo> getAllFirmInfos(FirmInfo firmInfo);

	/** 按Id查找公司 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getFirmInfoById")
	@Results({
	        @Result(property = "channelGroups", column = "channelGroupId", many = @Many(select = "com.vending.platform.dao.IChannelManagerDAO.getChannelGroupById")),
			@Result(property = "machineType", column = "tModelId", many = @Many(select = "com.vending.platform.dao.IMachineDAO.getMachineTypeById")),
			@Result(property = "operMgrs", column= "operMgrId", many= @Many(select = "com.vending.platform.dao.IMachineDAO.getAllOperMgrs")),
			@Result(property = "operMgr", column= "operMgrId", many= @Many(select = "com.vending.platform.dao.IMachineDAO.getOperMgrById")),
			@Result(property = "groupInfos", column= "groupId", many= @Many(select = "com.vending.platform.dao.IMachineDAO.getAllOperMgrs")),
            @Result(property = "groupInfo", column= "groupId", many= @Many(select = "com.vending.platform.dao.IMachineDAO.getGroupInfoById")),
            @Result(property = "wareInfos", column= "wareId", many= @Many(select = "com.vending.platform.dao.IWareManagerDAO.getAllWareInfos")),
            @Result(property = "wareInfo", column= "wareId", many= @Many(select = "com.vending.platform.dao.IWareManagerDAO.getWareInfoById"))
	})
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
	@Results({
        @Result(property = "firmInfo" , column = "firmId",one= @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getFirmInfoById"))
        })
	public List<GroupInfo> getAllGroupInfos(GroupInfo groupInfo);

	/** 按Id查看分组信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getGroupInfoById")
	@Results({
			@Result(property = "machineOperaters", column = "mOperaterId", many = @Many(select = "com.vending.platform.dao.IMachineDAO.getAllMachineOperaters")),
			@Result(property = "machineOperater", column = "mOperaterId", many = @Many(select = "com.vending.platform.dao.IMachineDAO.getMachineOperaterById")),
			@Result(property = "userInfos", column = "userId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getAllUsers")),
			@Result(property = "userInfo", column = "userId", many = @Many(select = "com.vending.platform.dao.IUserManagerDao.getUserById")),
	        @Result(property = "firmInfo" , column = "firmId",one= @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getFirmInfoById"))
	})
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
	@Results({
        @Result(property = "operFirm" , column = "firmId",one= @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getFirmInfoById")),
        @Result(property = "manuFirm" , column = "manuId",one= @One(select = "com.vending.platform.dao.IFrimAndGroupDAO.getFirmInfoById"))
        })
	public List<OperMgr> getAllOperMgrs(OperMgr operMgr);

	/** 按Id查询公司管理信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "getOperMgrById")
	public OperMgr getOperMgrById(Integer operMgrId);

	/** 删除公司管理信息 */
	@SelectProvider(type = IFirmAndGroupSqlProvider.class, method = "deleteOperMgr")
	public void deleteOperMgr(Integer operMgrId);

}
