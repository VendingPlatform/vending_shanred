package com.vending.platform.controller;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes("user")
@RequestMapping("user")
public class UserManagerController extends UtilsAction {
	private static final long serialVersionUID = 6934405543902610637L;
	@Autowired
	private IUserManagerService userManagerService;

	@RequestMapping("/user/getAllUsers")
	public String getAllUsers(@ModelAttribute("user") UserInfo userInfo) {
		Integer firmId = userInfo.getFirmInfo().getFirmId();
		if (firmId == 0) {
			// 管理员，查看所有用户

		} else if (firmId == 1) {
			// 运营商，根据不同的角色查看用户
		} else if (firmId == 2) {
			// 查看厂商用户
		}
		return "";
	}

	@RequestMapping("/getAllAuthoritys")
	public String getAllAuthoritys(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		Integer firmType = userInfo.getFirmInfo().getFirmType();
		AuthorityInfo authorityInfo = new AuthorityInfo();
		if (firmType == 1) {
			// 运营商
			authorityInfo.setAuthType(1);
		} else if (firmType == 2) {
			// 厂商
			authorityInfo.setAuthType(2);
		}
		List<AuthorityInfo> authorityInfos = userManagerService.getAllAuthoritys(authorityInfo);
		modelMap.addAttribute("authorityInfos", authorityInfos);
		return "genview/AuthorityInfo";
	}
	////还需根据不同权限进行查询，并不是所有人都可以查询用户角色
	@RequestMapping("/getAllRoles")
	public String getAllRoles(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		Integer firmId = userInfo.getFirmInfo().getFirmId();
		Integer firmType = userInfo.getFirmInfo().getFirmType();
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setFirmId(firmId);
		roleInfo.setStatus(1);
		List<RoleInfo> roleInfos =userManagerService.getAllRoles(roleInfo);
		modelMap.addAttribute("allRoleInfos", roleInfos);
		return "genview/RoleInfo";
	}
}
