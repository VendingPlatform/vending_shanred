package com.vending.platform.controller;

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

import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserLoginController {
	private static Logger logger = Logger.getLogger(UserLoginController.class);
	@Autowired
	private IUserManagerService userManagerService;

	@Description("用户登录")
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@ModelAttribute("user")
	public ModelAndView login(UserInfo userInfo, ModelMap modelMap) {
		UserInfo user = userManagerService.login(userInfo);
		ModelAndView modelAndView = new ModelAndView();
		if (user != null) {
			if (user.getFirmInfo().getFirmStatus() == 1 && user.getStatus() == 1) {
				modelAndView.setViewName("genview/home");
				modelAndView.addObject("user", user);
				modelMap.addAttribute("user", user);
				logger.debug(user.toString() + "：登录信息");
			}
		} else {
			modelAndView.setViewName("/login");
		}
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
