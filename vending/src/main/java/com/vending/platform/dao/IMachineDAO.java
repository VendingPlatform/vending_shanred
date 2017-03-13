package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.IMachineSqlProvider;
import com.vending.platform.domain.MachineInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.exception.SQLFormatException;

/**
 * 售貨机DAO<br>
 * 
 * 1、厂商售货机管理 ;<br>
 * 2、运营商售货机分配 ;<br>
 * 3、厂商售货机类型管理<br>
 * 
 * @author Miley_Ren
 */
public interface IMachineDAO {
	/**
	 * 为运营商添加售货机操作
	 * 
	 * @param machineOperater
	 *            售货机参数，参数中必须包含machineId、machineName、machinePannel、machineAssign、tModel、machineSatus、operFirmId,否则将抛出异常，并且插入数据不成功
	 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "insertMachineOperate")
	public void insertMachineOperate(MachineOperater machineOperater) throws Exception;

	/** 删除运营商中售货机信息 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "deleteMachineOperateById")
	public void deleteMachineOperateById(Integer mOperateId);

	/**
	 * 不定参更新售货机信息 ，根据售货机操作表Id进行不定参更新
	 * 
	 * @param machineOperater
	 *            售货机参数
	 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "updateMachineOperate")
	public void updateMachineOperate(MachineOperater machineOperater);

	/**
	 * 按售货机操作表中Id查询售货机
	 * 
	 * @param mOperaterId
	 *            数据库操作表（machineoperater）中的Id
	 * @return MachineOperater 返回对应的售货机信息
	 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "getMachineOperaterById")
	@Results(@Result(property = "machineInfo", column = "machineId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineInfoById")))
	public MachineOperater getMachineOperaterById(Integer mOperaterId);

	/**
	 * 按条件查询所有运营商售货机，管理员查看所有售货机，（one-to-one关联查询）
	 * 
	 * @param userInfo
	 *            用户信息，其中包含所属公司ID等信息
	 * @param machineOperater
	 *            运营商售货机信息，包含运营商要查询的条件
	 * @return List<MachineOperater> 运营商售货机列表
	 */

	@SelectProvider(type = IMachineSqlProvider.class, method = "getAllMachineOperaters")
	@Results(@Result(property = "machineInfo", column = "machineId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineInfoById")))
	public List<MachineOperater> getAllMachineOperaters(UserInfo userInfo, MachineOperater machineOperater);

	/** 添加售货机类型 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "inseretMachineType")
	public void inseretMachineType(MachineType machineType) throws SQLFormatException;

	/** 修改售货机类型 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "updateMachineType")
	public void updateMachineType(MachineType machineType);

	/** 按条件查询所有售货机类型 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "getAllMachineType")
	public List<MachineType> getAllMachineType(MachineType machineType);

	/** 按Id查询售货机 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "getMachineTypeById")
	public MachineType getMachineTypeById(Integer tModeId);

	/** 删除售货机类型 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "deleteMachineType")
	public void deleteMachineType(Integer tModeId);

	/** 厂商添加售货机 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "insertMachineInfo")
	public void insertMachineInfo(MachineInfo machineInfo);

	/** 更新厂商售货机 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "updateMachineInfo")
	public void updateMachineInfo(MachineInfo machineInfo);

	/** 按条件查询所有售货机 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "getAllMachineInfos")
	public List<MachineInfo> getAllMachineInfos(MachineInfo machineInfo);

	/** 按照Id查询MachineInfo中信息 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "getMachineInfoById")
	public MachineInfo getMachineInfoById(Integer machineId);

	/** 删除售货机 */
	@SelectProvider(type = IMachineSqlProvider.class, method = "deleteMachineInfo")
	public void deleteMachineInfo(Integer machineId);
}
