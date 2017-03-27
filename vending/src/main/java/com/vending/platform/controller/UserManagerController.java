package com.vending.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserManagerController extends UtilsAction {
	private static final long serialVersionUID = 6934405543902610637L;
	@Autowired
	private IUserManagerService userManagerService;

	@Description("查看所有权限")
	@RequestMapping(value="getAllAuthority")
	public String getAllAuthority(){
		
		return "";
	}

}
