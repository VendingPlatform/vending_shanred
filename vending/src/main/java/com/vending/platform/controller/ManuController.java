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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.MachineInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.OperMgr;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IChannelManagerService;
import com.vending.platform.service.IFirmAndGroupService;
import com.vending.platform.service.IMachineManagerService;

@Controller
@SessionAttributes({ "user", "machineTypes", "operMgrs" })
@RequestMapping("/manu")
public class ManuController extends UtilsAction {
	private static final long serialVersionUID = -5888803867214434197L;
	@Autowired
	private IFirmAndGroupService firmAndGroupService;
	@Autowired
	private IMachineManagerService machineManagerService;
	@Autowired
	private IChannelManagerService channelService;

	@Description("厂商查看关联运营商")
	@RequestMapping(value = "/getAllOperateFirms", method = RequestMethod.GET)
	public String getAllOperateFirms(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		Integer firmId = userInfo.getFirmInfo().getFirmId();
		// 获取所有厂商的运营商表
		OperMgr operMgr = new OperMgr();
		operMgr.setManuId(firmId);
		List<OperMgr> operMgrs = firmAndGroupService.getAllOperMgrs(operMgr);

		// 获取所有运营商列表
		FirmInfo firmInfo = new FirmInfo();
		firmInfo.setFirmType(1);
		firmInfo.setFirmStatus(1);// 状态为可用的
		List<FirmInfo> firmInfos = firmAndGroupService.getAllFirmInfos(firmInfo);
		List<FirmInfo> firmInfosNotInManus = new ArrayList<FirmInfo>();
		// 判断所有未被加入的运营商列表
		for (FirmInfo fInfo : firmInfos) {
			Integer id = fInfo.getFirmId();
			if (operMgrs.size() == 0) {
				firmInfosNotInManus.add(fInfo);
			} else {
				boolean flag = true;
				for (OperMgr oper : operMgrs) {
					if (id == oper.getOperFirm().getFirmId()) {
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
	public String insertFirmToManu(Integer[] firmIds, @ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		if (firmIds == null || firmIds.length == 0)
			return "redirect:/manu/getAllOperateFirms";
		int result = 0;
		for (int i = 0; i < firmIds.length; i++) {
			OperMgr operMgr = new OperMgr();
			operMgr.setFirmId(firmIds[i]);
			if (firmAndGroupService.getAllOperMgrs(operMgr).size() > 0) {
				continue;
			} else {
				operMgr.setManuId(userInfo.getFirmInfo().getFirmId());
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
	public String getMachineInfoById(Integer machineId, ModelMap modelMap) {
		MachineInfo machineInfo = machineManagerService.getMachineInfoById(machineId);
		modelMap.addAttribute("machineInfo", machineInfo);
		try {
			writeJson(machineInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "genview/MMachineInfo";
	}

	@Description("获取所有售货机")
	@RequestMapping(value = "/getAllMachines")
	public String getAllMachines(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		Integer manuFirmId = userInfo.getFirmInfo().getFirmId();
		MachineInfo machineInfo = new MachineInfo();
		machineInfo.setManuFirmId(manuFirmId);
		List<MachineInfo> machineInfos = machineManagerService.getAllMachineInfos(machineInfo);

		MachineType machineType = new MachineType();
		machineType.setFirmId(manuFirmId);
		List<MachineType> machineTypes = machineManagerService.getAllMachineTypes(machineType);

		// 获取所有厂商的运营商表
		OperMgr operMgr = new OperMgr();
		operMgr.setManuId(userInfo.getFirmId());
		List<OperMgr> operMgrs = firmAndGroupService.getAllOperMgrs(operMgr);

		modelMap.addAttribute("machineInfos", machineInfos);
		modelMap.addAttribute("machineTypes", machineTypes);
		modelMap.addAttribute("operMgrs", operMgrs);
		return "genview/MMachineInfo";
	}

	@Description("添加售货机")
	@RequestMapping(value = "/addMachine")
	public String addMachine(MachineInfo machineInfo) {
		machineManagerService.insertMachine(machineInfo);
		return "genview/MMachineInfo";
	}

	@Description("更新售货机信息")
	@RequestMapping(value = "/updateMachine")
	public String updateMachine(MachineInfo machineInfo, ModelMap modelMap) {
		if (machineInfo.getManuMachineStatus() == 1) {
			// 售货机已出售，不允许修改
			try {
				write("售货机已出售，不允许进行修改");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "genview/MMachineInfo";
		} else {
			machineManagerService.updateMachineInfo(machineInfo);
			try {
				write("更新成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "genview/MMachineInfo";
		}

	}

	@Description("删除售货机")
	@RequestMapping(value = "/deleteMachineInfo")
	public String delMachine(Integer machineId) {
		boolean result = machineManagerService.deleteMachineInfo(machineId);
		try {
			write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "genview/MMachineInfo";
	}

	@Description("分配售货机信息")
	@RequestMapping(value = "/assignMachine")
	public String assignMachine(MachineInfo machineInfo, ModelMap modelMap) throws IOException {
		MachineInfo mInfo = machineManagerService.getMachineInfoById(machineInfo.getMachineId());
		if (mInfo.getManuMachineStatus() == 1) {
			// 已分配，不再分配
			write("已分配，不再进行分配");
		} else {
			ChannelInfo channelInfo = new ChannelInfo();
			channelInfo.setMachineId(mInfo.getMachineId());
			if (channelService.getAllChannelInfos(channelInfo).size() == 0) {
				write("还未定义货道，请先定义货道在分配！");
			} else {
				// 分配售货机
				mInfo.setOperFirmId(machineInfo.getOperFirmInfo().getFirmId());
				mInfo.setManuMachineStatus(1);
				machineManagerService.updateMachineInfo(mInfo);
				// 更新运营商表
				MachineOperater operater = new MachineOperater();
				operater.setMachineId(mInfo.getMachineId());
				operater.setMachineAssign(0);
				operater.setOperFirmId(machineInfo.getOperFirmInfo().getFirmId());
				machineManagerService.inserMachineOperater(operater);
				
				MachineOperater mOperater  = machineManagerService.getMachineOperaterBymachine(mInfo.getMachineId());
				channelService.assignChannel(mInfo.getMachineId(), mOperater);
				write("分配成功");
			}
		}
		return "genview/MMachineInfo";
	}

	@Description("查找所有类型")
	@RequestMapping(value = "/getAllTypes")
	public String getAllTypes(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		Integer firmId = userInfo.getFirmId();
		MachineType machineType = new MachineType();
		machineType.setFirmId(firmId);
		List<MachineType> machineTypes = machineManagerService.getAllMachineTypes(machineType);
		modelMap.addAttribute("machineTypes", machineTypes);
		return "genview/MMachineType";
	}

	@Description("查找类型")
	@RequestMapping(value = "/getTypeById")
	public String getTypeById(Integer tModelId, ModelMap modelMap) {
		MachineType machineType = machineManagerService.getMachineTypeById(tModelId);
		modelMap.addAttribute("machineType", machineType);
		try {
			writeJson(machineType.gettModelName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "genview/MMachineType";
	}

	@Description("更新类型")
	@RequestMapping(value = "/updateType")
	public String updateType(MachineType machineType, ModelMap modelMap) {
		machineManagerService.updateMachineType(machineType);
		return "genview/MMachineType";
	}

	@Description("获取货道信息")
	@RequestMapping(value = "/getMachineInfoChannel")
	public String getMachineInfoChannel(@RequestParam("machineId") Integer machineId, ModelMap modelMap) {
		MachineInfo machineInfo = machineManagerService.getMachineInfoById(machineId);
		ChannelInfo channelInfo = new ChannelInfo();
		channelInfo.setMachineId(machineId);
		List<ChannelInfo> channelInfos = channelService.getAllChannelInfos(channelInfo);
		modelMap.addAttribute("machineChannelInfos", channelInfos);
		modelMap.addAttribute("machineInfo", machineInfo);
		return "genview/MMachineInfoDetail";
	}

	@Description("添加货道")
	@RequestMapping(value = "/addChannelInfo")
	public String addChannelInfo(ChannelInfo channelInfo) throws IOException {
		ChannelInfo c = new ChannelInfo();
		c.setChannelNo(channelInfo.getChannelNo());
		c.setMachineId(channelInfo.getMachineId());
		if (channelService.getAllChannelInfos(channelInfo).size() > 0) {
			write("该编号已存在");
			return "genview/MMachineInfoDetail";
		}
		//插入货道
		channelService.insertChannelInfo(channelInfo);
		
		write("插入成功");
		return "genview/MMachineInfoDetail";
	}

	@Description("删除货道")
	@RequestMapping(value = "/deleteChannel")
	public String deleteChannel(@RequestParam("channelId") Integer channelId) {
		channelService.deleteChannelInfo(channelId);
		return "genview/MMachineInfoDetail";
	}
}
