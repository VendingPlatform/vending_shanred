package com.vending.platform.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.lin.domain.User;
import com.lin.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;

	@RequestMapping("/reg")
	public String register() {
		return "reg";
	}

	@RequestMapping("/show")
	public String toIndex(HttpServletRequest request, ModelMap model,HttpSession httpSession) {
		String testModelMap = (String) httpSession.getAttribute("test");
		System.out.println("***************"+testModelMap);
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.selectUserById(userId);
		model.addAttribute("user", user);
		logger.debug("user=" + JSON.toJSONString(user));
		return "show";
	}

}
