package com.vending.platform.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vending.platform.domain.ChannelHistory;
import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;
import com.vending.platform.domain.MachineInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IChannelManagerService;
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
	@Autowired
	private IChannelManagerService channelService;

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
				sBuilder.append(machineOperaters.get(i).toString() + "] ");
			}
		}

		String rString = URLEncoder.encode(sBuilder.toString(), "UTF-8");
		return rString;
	}

	@ResponseBody
	@RequestMapping(value = "/clientAddStock")
	public String addStockNum(HttpServletRequest request, HttpServletResponse response) {
		String machineName = request.getParameter("machineName");
		String channelNo = request.getParameter("channelNo");
		Integer stockNum = Integer.valueOf(request.getParameter("stockNum"));
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		// 对当前货道进行更新
		ChannelInfo channel = new ChannelInfo();
		MachineInfo machineInfo = new MachineInfo();
		machineInfo.setMachineName(machineName);
		channel.setMachineInfo(machineInfo);
		channel.setChannelNo(channelNo);
		channel = channelService.getAllChannelInfos(channel).get(0);
		//更新channel表,更新加货量，现货量，操作员
		ChannelInfo newChannel = new ChannelInfo();
		newChannel.setChannelId(channel.getChannelId());
		newChannel.setStockNumAdd(stockNum);
		newChannel.setOperateId(userId);
		newChannel.setStockNumNow(channel.getStockNumNow()+stockNum);
		channelService.updateChannelInfo(newChannel);
		// 将家伙信息添加至历史信息
		// 获取货道商品信息
		ChannelWareInfo channelWareInfo = channelService.getChannelWareInfo(channel.getChannelId());
		ChannelHistory channelHistory = new ChannelHistory(machineName, channelWareInfo.getWareInfo().getWareName(),
				channelWareInfo.getWareInfo().getWareBasePrice(), channelNo, stockNum, channel.getFirmId(), userId);
		channelService.insertChannelHistory(channelHistory);
		return "success";
	}

}
