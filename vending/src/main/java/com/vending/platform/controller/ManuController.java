package com.vending.platform.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.MachineInfo;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.OperMgr;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IFirmAndGroupService;
import com.vending.platform.service.IMachineManagerService;

@Controller
@SessionAttributes({ "user", "machineTypes" })
@RequestMapping("/manu")
public class ManuController extends UtilsAction {
    private static final long serialVersionUID = -5888803867214434197L;
    @Autowired
    private IFirmAndGroupService firmAndGroupService;
    @Autowired 
    private IMachineManagerService machineManagerService;

    @Description("厂商查看关联运营商")
    @RequestMapping(value = "/getAllOperateFirms", method = RequestMethod.GET)
    public String getAllOperateFirms(@ModelAttribute("user") UserInfo userInfo,
            ModelMap modelMap) {
        Integer firmId = userInfo.getFirmInfo().getFirmId();
        // 获取所有厂商的运营商表
        OperMgr operMgr = new OperMgr();
        operMgr.setManuId(firmId);
        List<OperMgr> operMgrs = firmAndGroupService.getAllOperMgrs(operMgr);

        // 获取所有运营商列表
        FirmInfo firmInfo = new FirmInfo();
        firmInfo.setFirmType(1);
        firmInfo.setFirmStatus(1);// 状态为可用的
        List<FirmInfo> firmInfos = firmAndGroupService
                .getAllFirmInfos(firmInfo);
        List<FirmInfo> firmInfosNotInManus = new ArrayList<FirmInfo>();
        // 判断所有未被加入的运营商列表
        for (FirmInfo fInfo : firmInfos) {
            Integer id = fInfo.getFirmId();
            if (operMgrs.size() == 0) {
                firmInfosNotInManus.add(fInfo);
            } else {
                boolean flag = true;
                for (OperMgr oper : operMgrs) {
                    if (id == oper.getFirmId()) {
                        flag = false;
                        continue;
                    }
                }
                if (flag) {
                    firmInfosNotInManus.add(fInfo);
                }
            }
        }
        modelMap.addAttribute("firmInfosNotInManus", firmInfosNotInManus);
        modelMap.addAttribute("operMgrs", operMgrs);
        return "genview/MFirmManager";
    }

    @Description("将运营商添加至厂商和做运营商管理表中")
    @RequestMapping(value = "/insertFirmToManu", method = RequestMethod.POST)
    public String insertFirmToManu(Integer[] firmIds, @ModelAttribute("user") UserInfo userInfo,ModelMap modelMap) {
        if (firmIds == null || firmIds.length == 0)
            return "redirect:/manu/getAllOperateFirms";
        int result = 0;
        for (int i = 0; i < firmIds.length; i++) {
            FirmInfo firmInfo = firmAndGroupService.getFirmInfoById(firmIds[i]);
            OperMgr operMgr = new OperMgr();
            operMgr.setFirmId(firmIds[i]);
            if (firmAndGroupService.getAllOperMgrs(operMgr).size() > 0) {
                continue;
            } else {
                operMgr.setFirmNo(firmInfo.getFirmNo());
                operMgr.setFirmName(firmInfo.getFirmName());
                operMgr.setManuId(userInfo.getFirmInfo().getFirmId());
                operMgr.setManuName(userInfo.getFirmInfo().getFirmName());
                operMgr.setOperateId(userInfo.getUserId());
                firmAndGroupService.insertOperMgr(operMgr);
                result++;
            }
        }
        try {
            write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/manu/getAllOperateFirms";
    }

    @Description("将运营商移除")
    @RequestMapping(value = "/removeFirmToManu")
    public String removeFirmToManu(Integer operMgrId) {
        firmAndGroupService.deleteOperMgr(operMgrId);
        return "redirect:/manu/getAllOperateFirms";
    }
    @Description("获取售货机信息")
    @RequestMapping(value = "/getMachineInfoById")
    public String getMachineInfoById(Integer machineId,ModelMap modelMap) {
        MachineInfo machineInfo =  machineManagerService.getMachineInfoById(machineId);
        modelMap.addAttribute("machineInfo", machineInfo);
        try {
            writeJson(machineInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "genview/MMachineInfo";
    }
    
    @Description("获取所有售货机")
    @RequestMapping(value="/getAllMachines")
    public String getAllMachines(@ModelAttribute("user") UserInfo userInfo,ModelMap modelMap){
        Integer manuFirmId = userInfo.getFirmInfo().getFirmId();
        MachineInfo machineInfo = new MachineInfo();
        machineInfo.setManuFirmId(manuFirmId);
        List<MachineInfo> machineInfos = machineManagerService.getAllMachineInfos(machineInfo);
        
        MachineType machineType = new MachineType();
        machineType.setFirmId(manuFirmId);
        List<MachineType> machineTypes = machineManagerService.getAllMachineTypes(machineType);
        
        modelMap.addAttribute("machineInfos", machineInfos);
        modelMap.addAttribute("machineTypes", machineTypes);
        
        return "genview/MMachineInfo";
        }
    @Description("更新售货机信息")
    @RequestMapping(value = "/updateMachine")
    public String updateMachine(MachineInfo machineInfo,ModelMap modelMap) {
        //更新的同时要更新操作表，也可以设置操作表的对应关系
        return "genview/MMachineInfo";
    }
}
