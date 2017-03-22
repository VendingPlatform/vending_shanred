package com.vending.platform.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IMachineManagerService;

@Controller
@SessionAttributes({ "user", "machineOperaterInfo", "allMachineTypes", "machineGroupInfos" })
@RequestMapping("/machine")
public class MachineManagerController extends UtilsAction {
	private static final long serialVersionUID = -8056726050883641564L;
	private static Logger logger = Logger.getLogger(MachineManagerController.class);
	@Autowired
	private IMachineManagerService machineManagerService;

	@Description("进入售货机页面")
	@RequestMapping(value = "/machineHome")
	@ModelAttribute("allMachineTypes")
	public ModelAndView getMachineHome(ModelMap modelMap) {
		List<MachineType> machineTypes = machineManagerService.getAllMachineTypes(new MachineType());
		modelMap.addAttribute("allMachineTypes", machineTypes);
		return new ModelAndView("genview/OMachineInfo", modelMap);
	}

	@Description("获取运营商的售货机")
	@ModelAttribute("machineOperaterInfo")
	@RequestMapping(value = "/machineInfo")
	public ModelAndView getAllOprMachineInfos(MachineOperater machineOperater,
			@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (machineOperater != null) {
			logger.debug("信息：" + userInfo.toString());
			List<MachineOperater> machineOperaters = machineManagerService.getMachineOperaters(userInfo,
					machineOperater);
			if (machineOperaters != null) {
				modelAndView.addObject("machineOperaterInfo", machineOperaters);
				modelMap.addAttribute("machineOperaterInfo", machineOperaters);
				for (MachineOperater machineOperater2 : machineOperaters) {
					System.out.println("机器信息：" + machineOperater2.toString());
				}
			}
			modelAndView.setViewName("genview/OMachineInfo");
		} else {
			modelAndView.setViewName("genview/OMachineInfo");
		}
		return modelAndView;
	}

	@Description("按Id查看某售货机详细信息")
	@RequestMapping(value = "/machineInfoDetail", method = RequestMethod.GET)
	public ModelAndView getMachineOperateById(@RequestParam("mOperaterId") Integer mOperaterId, ModelMap modelMap) {
		MachineOperater machineOperater = machineManagerService.getMachineOperaterById(mOperaterId);
		modelMap.addAttribute("machineOperater", machineOperater);
		return new ModelAndView("genview/OMachineInfoDetail", modelMap);
	}

	@Description("更新machineOperate")
	@RequestMapping(value = "/machineInfoUpdateInfo", method = RequestMethod.GET)
	public ModelAndView updateMachineOperate(@RequestParam("mOperaterId") Integer mOperaterId,
			@ModelAttribute("user") UserInfo userInfo) {
		ModelAndView modelAndView = new ModelAndView();
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setFirmId(userInfo.getFirmId());
		groupInfo.setGroupType(2);// type=2,表示查询售货机分组
		List<GroupInfo> groupInfos = machineManagerService.getAllMachineGroups(groupInfo);
		modelAndView.addObject("groupInfos", groupInfos);

		MachineOperater machineOperater = machineManagerService.getMachineOperaterById(mOperaterId);
		modelAndView.addObject("machineOperater", machineOperater);
		modelAndView.setViewName("genview/OMachineInfoUpdate");

		return modelAndView;
	}

	@Description("执行更新数据库操作")
	@RequestMapping(value = "/machineInfoUpdate", method = RequestMethod.POST)
	public String updateMachineOperateExecute(@ModelAttribute("machineOperater") MachineOperater machineOperater,
			@ModelAttribute("user") UserInfo userInfo) {
		logger.debug("更新操作 ");
		machineManagerService.updateMachineOperater(machineOperater, userInfo);
		return "redirect:/machine/machineInfoDetail?mOperaterId=" + machineOperater.getmOperaterId();
	}

	@Description("查看所有售货机分组信息")
	@RequestMapping(value = "/machineGroup")
	public ModelAndView getAllMachineGroups(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setFirmId(userInfo.getFirmId());
		groupInfo.setGroupType(2);// type=2,表示查询售货机分组
		List<GroupInfo> groupInfos = machineManagerService.getAllMachineGroups(groupInfo);
		modelMap.addAttribute("machineGroupInfos", groupInfos);
		return new ModelAndView("genview/OMachineGroup", modelMap);
	}

	@Description("编辑售货机分组")
	@RequestMapping(value = "/machinegroupInfo")
	public ModelAndView getMachineGroupInfo(@RequestParam("groupId") Integer groupId, ModelMap modelMap) {
		GroupInfo groupInfo = machineManagerService.getGroupInfoById(groupId);
		modelMap.addAttribute("groupInfo", groupInfo);
		return new ModelAndView("genview/OMachineGroupInfo", modelMap);
	}

	@Description("添加售货机分组")
	@RequestMapping(value = "/machineGroupCreate")
	public String createGroupInfo(GroupInfo groupInfo, @ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		boolean ret = machineManagerService.addGroupInfo(groupInfo, userInfo);
		int index = 0;
		if (ret) {
			index = 1;
		}
		try {
			write(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/genview/OMachineGroup";
	}

	@Description("更新售货机分组信息")
	@RequestMapping(value = "/machineGroupUpdate")
	public String updateGroupInfo(GroupInfo groupInfo) {
		machineManagerService.updateGroupInfo(groupInfo);
		return "redirect:/machine/machineGroup";
	}

	@Description("删除分组信息")
	@RequestMapping(value = "/machinegroupDelete")
	public String deleteGroupInfo(@RequestParam("groupId") Integer groupId) {
		boolean ret = machineManagerService.deleteGroupInfo(groupId);
		return "redirect:/machine/machineGroup";
	}

	@Description("查看组内信息")
	@RequestMapping(value = "/machineGroupDetialInfos")
	public String getMachineGroupInfos(@RequestParam("groupId") Integer groupId, ModelMap modelMap) {
		MachineOperater machineOperater = new MachineOperater();
		machineOperater.setGroupId(groupId);
		List<MachineOperater> machineOperaters = machineManagerService.getAllMachineOperaters(machineOperater);
		modelMap.addAttribute("machineGroupDetialInfos", machineOperaters);
		return "genview/OMachineGroupDetailInfos";
	}

	@Description("将售货机从分组中移除")
	@RequestMapping(value = "machineInfoRemoveGroup")
	public String removeMachineFromGroup(Integer mOperaterId, Integer groupId,
			@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		MachineOperater machineOperater = new MachineOperater();
		machineOperater.setGroupId(-1);// 表示移除，在sql构建器中判断，若为-1,则置空
		machineOperater.setmOperaterId(mOperaterId);
		machineManagerService.updateMachineOperater(machineOperater, userInfo);
		return "redirect:/machine/machineGroupDetialInfos?groupId=" + groupId;
	}

}
