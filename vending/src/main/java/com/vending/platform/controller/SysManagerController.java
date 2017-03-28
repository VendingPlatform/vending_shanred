package com.vending.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.FirmInfo;
import com.vending.platform.service.IFirmAndGroupService;

@Controller
@SessionAttributes("user")
@RequestMapping("/manager")
public class SysManagerController extends UtilsAction {
	private static final long serialVersionUID = -5466394451153962610L;
	@Autowired
	private IFirmAndGroupService firmAndGroupService;

	@Description("获取所有商家信息")
	@RequestMapping(value = "/getAllFirms", method = RequestMethod.POST)
	public String getAllFirms(FirmInfo firmInfo, ModelMap map) {
		List<FirmInfo> allFirmInfos = firmAndGroupService.getAllFirmInfos(firmInfo);
		map.addAttribute("allFirmInfos", allFirmInfos);
		return "genview/ManagerFirm";
	}
}
