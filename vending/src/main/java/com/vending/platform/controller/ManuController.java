package com.vending.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.OperMgr;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IFirmAndGroupService;
import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/manu")
public class ManuController extends UtilsAction {
	private static final long serialVersionUID = -5888803867214434197L;
	@Autowired
	private IUserManagerService userManagerService;
	@Autowired
	private IFirmAndGroupService firmAndGroupService;

	@Description("厂商查看关联运营商")
	@RequestMapping(value = "getAllOperateFirms", method = RequestMethod.GET)
	public String getAllOperateFirms(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		Integer firmId = userInfo.getFirmInfo().getFirmId();
		OperMgr operMgr = new OperMgr();
		operMgr.setManuId(firmId);
		List<OperMgr> operMgrs = firmAndGroupService.getAllOperMgrs(operMgr);
		modelMap.addAttribute("operMgrs", operMgrs);
		return "genview/MFirmManager";
	}
}
