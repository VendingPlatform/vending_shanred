package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.MachineOperater;
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
    public List<MachineOperater> getOprMachines(UserInfo userInfo,
            MachineOperater machineOperater);
}
