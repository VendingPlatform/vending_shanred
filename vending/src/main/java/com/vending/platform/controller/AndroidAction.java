package com.vending.platform.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IMachineManagerService;
import com.vending.platform.service.IUserManagerService;

@Controller
@RequestMapping(value = "client")
public class AndroidAction extends UtilsAction {
	private static final long serialVersionUID = 8698728595480693016L;
	@Autowired
	private IUserManagerService userManagerService;
	@Autowired
	private IMachineManagerService machineService;

	@ResponseBody
	@RequestMapping(value = "/clientLogin")
	public String androidLogin(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userName);
		userInfo.setPassword(password);
		UserInfo user = userManagerService.login(userInfo);

		return user.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/clientMachine")
	public String getAllMachine(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer userId = (Integer.parseInt(request.getParameter("userId")));
		MachineOperater machineOperater = new MachineOperater();
		machineOperater.setUserId(userId);
		List<MachineOperater> machineOperaters = machineService.getAllMachineOperaters(machineOperater);
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("[ ");
		for (int i = 0; i < machineOperaters.size(); i++) {
			if (i != machineOperaters.size() - 1) {
				sBuilder.append(machineOperaters.get(i).toString() + ",");
			} else {
				sBuilder.append(machineOperaters.get(i).toString()+"] ");
			}
		}
		 
		String rString = URLEncoder.encode(sBuilder.toString(),"UTF-8");
		return rString;
	}

}
