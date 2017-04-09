package com.vending.platform.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleAuthInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.domain.UserRoleInfo;
import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes({"user","userAuth","userAuthCodes"})
@RequestMapping("/user")
public class UserLoginController {
	private static Logger logger = Logger.getLogger(UserLoginController.class);
	@Autowired
	private IUserManagerService userManagerService;

	@ModelAttribute("userAuth")
	public Set<AuthorityInfo> getUserAuth(){
	    return new HashSet<AuthorityInfo>();
	}
	@ModelAttribute("userAuthCodes")
	public List<String> getuserAuthList(){
	    return new ArrayList<String>();
	}
	
	@Description("用户登录")
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@ModelAttribute("user")
	public ModelAndView login(UserInfo userInfo, @ModelAttribute("userAuth")Set<AuthorityInfo> userAuth, 
	        @ModelAttribute("userAuthCodes")List<String> userAuthCodes,ModelMap modelMap) {
		UserInfo user = userManagerService.login(userInfo);
		ModelAndView modelAndView = new ModelAndView();
		if (user != null) {
			if (user.getFirmInfo().getFirmStatus() == 1 && user.getStatus() == 1) {
				modelAndView.setViewName("genview/home");
				
				//查找用户拥有的所有权限,先查用户角色表，再查角色权限表
				UserRoleInfo userRoleInfo = new UserRoleInfo();
				userRoleInfo.setUserId(user.getUserId());
				List<UserRoleInfo> userRoleInfos = userManagerService.getAllUserRoleInfos(userRoleInfo);
				
				for (UserRoleInfo userRole : userRoleInfos) {
                    Integer roleId = userRole.getRoleInfo().getRoleId();
                    RoleAuthInfo roleAuthInfo = new RoleAuthInfo();
                    roleAuthInfo.setRoleId(roleId);
                    List<RoleAuthInfo> roleAuthInfos = userManagerService.getAllRoleAuthInfos(roleAuthInfo);
                    for (RoleAuthInfo roleAuth : roleAuthInfos) {
                       userAuth.add(roleAuth.getAuthorityInfo());
                    }
                }
				userAuthCodes = userManagerService.getAuthTop(userAuth);
				modelMap.addAttribute("user", user);
				modelMap.addAttribute("userAuth", userAuth);
				modelMap.addAttribute("userAuthCodes",userAuthCodes);
				logger.debug(user.toString() + "：登录信息");
			}
		} else {
			modelAndView.setViewName("/login");
		}
		modelAndView.addAllObjects(modelMap);
		return modelAndView;
	}

	@Description("查看用户信息")
	@RequestMapping(value = "/userInfo")
	public String getUserInfo(ModelMap modelMap) {
		return "genview/UserInfo";
	}

	@Description("修改密码页面")
	@RequestMapping(value = "/changepwd")
	public String updatePwd(@ModelAttribute("user") UserInfo userInfo) {
		return "genview/UserPwd";
	}

	@Description("执行修改密码")
	@RequestMapping(value = "/changepwdexecute")
	public String updatePwdExecute(UserInfo userInfo, SessionStatus sessionStatus) {
		userManagerService.updateUserInfo(userInfo);
		sessionStatus.setComplete();
		return "login";
	}

	@Description("退出登录")
	@RequestMapping(value = "/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "login";
	}
}
