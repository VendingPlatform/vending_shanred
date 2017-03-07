package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.IMachineSqlProvider;
import com.vending.platform.domain.MachineInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;

/**
 * 售貨机DAO
 * 
 * 1、售货机分组管理 ;<br>
 * 2、售货机分配 ;<br>
 * 3、售货机货道管理<br>
 */
public interface IMachineDAO {
    /**
     * 不定参更新售货机信息 ，根据售货机操作表Id进行不定参更新
     * 
     * @param machineOperater
     *            售货机参数
     */
    @SelectProvider(type = IMachineSqlProvider.class, method = "updateMachineOperate")
    public void updateMachineOperate(MachineOperater machineOperater);

    /**
     * 为当前售货机添加或修改分组
     * 
     * @param groupId
     *            售货机组ID
     * @param mOperateId
     *            售货机操作表Id
     */
    @SelectProvider(type = IMachineSqlProvider.class, method = "updateMachineGroup")
    public void updateMachineGroup(Integer groupId, Integer mOperateId);

    /**
     * 更改售货机可用状态
     * 
     * @param status
     *            售货机当前状态
     * @param mOperateId
     *            售货机操作表Id
     */
    @SelectProvider(type = IMachineSqlProvider.class, method = "changeMachineStatus")
    public void changeMachineStatus(int status, Integer mOperateId);

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

    @SelectProvider(type = IMachineSqlProvider.class, method = "getAllMachine")
    @Results(@Result(property = "machineInfo", column = "machineId", one = @One(select = "com.vending.platform.dao.IMachineDAO.getMachineInfoById")))
    public List<MachineOperater> getAllMachine(UserInfo userInfo,
            MachineOperater machineOperater);

    /**
     * 按照Id查询MachineInfo中信息
     * 
     * @param machineId
     */
    @SelectProvider(type = IMachineSqlProvider.class, method = "getMachineInfoById")
    public MachineInfo getMachineInfoById(Integer machineId);

}
