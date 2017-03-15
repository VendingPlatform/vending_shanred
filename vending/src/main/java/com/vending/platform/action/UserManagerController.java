package com.vending.platform.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user")
@SessionAttributes("user")
public class UserManagerController {
	private static Logger logger = Logger.getLogger(UserManagerController.class);
	@Autowired
	private IUserManagerService userManagerService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@ModelAttribute("user")
	public ModelAndView login(UserInfo userInfo) {
		UserInfo user = userManagerService.login(userInfo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("genview/main");
		modelAndView.addObject("user", user);
		logger.debug(user.toString() + "：登录信息");

		return modelAndView;
	}

	@RequestMapping(value = "/userInfo")
	public String getUserInfo(ModelMap modelMap, SessionStatus sessionStatus) {
		logger.debug("信息：" + modelMap.get("user").toString());
		return "genview/userInfo";
	}
}
