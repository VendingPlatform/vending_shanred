package com.vending.platform.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleAuthInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes({"user","userAuth"})
@RequestMapping("user")
public class UserManagerController extends UtilsAction {
	private static final long serialVersionUID = 6934405543902610637L;
	@Autowired
	private IUserManagerService userManagerService;

	@RequestMapping(value="/getAllUsers")
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

	@RequestMapping(value="/getAllAuthoritys")
	public String getAllAuthoritys(@ModelAttribute("user") UserInfo userInfo,@ModelAttribute("userAuth") Set<AuthorityInfo> userAuth, ModelMap modelMap) {
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
	//或者让用户可以查看，但是不要进行其他操作
	@RequestMapping(value="/getAllRoles")
	public String getAllRoles(@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		Integer firmId = userInfo.getFirmInfo().getFirmId();
		Integer firmType = userInfo.getFirmInfo().getFirmType();
		RoleInfo roleInfo = new RoleInfo();
		if(firmType!=0){
		    roleInfo.setFirmId(firmId);
		}
		
		roleInfo.setStatus(1);
		List<RoleInfo> roleInfos =userManagerService.getAllRoles(roleInfo);
		modelMap.addAttribute("allRoleInfos", roleInfos);
		return "genview/RoleInfo";
	}
	
	@RequestMapping(value="/getRoleAuthInfo")
	public String getRoleAuthInfo(@RequestParam("roleId") Integer roleId,ModelMap modelMap){
	    RoleAuthInfo roleAuthInfo = new RoleAuthInfo();
	    roleAuthInfo.setRoleId(roleId);
	    List<RoleAuthInfo> roleAuthInfos =  userManagerService.getAllRoleAuthInfos(roleAuthInfo);
	    modelMap.addAttribute("roleAuthInfos", roleAuthInfos);
	    return "genview/RoleAuthInfo";
	}
}
