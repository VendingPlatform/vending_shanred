package com.vending.platform.controller;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IMachineManagerService;

@Controller
/*
 * 在需要访问 Session 属性的 controller 上加上 @SessionAttributes，然后在 action 需要的 User
 * 参数上加上 @ModelAttribute，并保证两者的属性名称一致。SpringMVC 就会自动将 @SessionAttributes
 * 定义的属性注入到 ModelMap 对象，在 setup action 的参数列表时，去 ModelMap
 * 中取到这样的对象，再添加到参数列表。只要我们不去调用 SessionStatus 的 setComplete() 方法，这个对象就会一直保留在
 * Session 中，从而实现 Session 信息的共享。
 */
@SessionAttributes({ "user", "machineOperaterInfo" })
@RequestMapping("/machine")
public class MachineManagerController {
	private static Logger logger = Logger.getLogger(MachineManagerController.class);
	@Autowired
	private IMachineManagerService machineManagerService;

	@Description("进入售货机页面")
	@RequestMapping(value = "/machineHome")
	@ModelAttribute("allMachineTypes")
	public ModelAndView getMachineHome(ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		List<MachineType> machineTypes = machineManagerService.getAllMachineTypes(new MachineType());
		modelMap.addAttribute("allMachineTypes", machineTypes);
		modelAndView.setViewName("genview/smachine");
		modelAndView.addObject("allMachineTypes", machineTypes);
		return modelAndView;
	}

	@Description("获取运营商的售货机")
	@ModelAttribute("machineOperaterInfo")
	@RequestMapping(value = "/machineInfo")
	public ModelAndView getAllOprMachineInfos(MachineOperater machineOperater,
			@ModelAttribute("user") UserInfo userInfo, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (machineOperater != null) {
			logger.debug("信息：" + userInfo.toString());
			List<MachineOperater> machineOperaters = machineManagerService.getOprMachines(userInfo, machineOperater);
			if (machineOperaters != null) {
				modelAndView.addObject("machineOperaterInfo", machineOperaters);
				modelMap.addAttribute("machineOperaterInfo", machineOperaters);
				for (MachineOperater machineOperater2 : machineOperaters) {
					System.out.println("机器信息：" + machineOperater2.toString());
				}
			}
			modelAndView.setViewName("genview/smachine");
		} else {
			modelAndView.setViewName("genview/smachine");
		}
		return modelAndView;
	}

	@Description("按Id查看某售货机详细信息")
	@RequestMapping(value = "/machineInfoDetail", method = RequestMethod.GET)
	public ModelAndView getMachineOperateById(@RequestParam("mOperaterId") Integer mOperaterId) {
		ModelAndView modelAndView = new ModelAndView();
		MachineOperater machineOperater = machineManagerService.getMachineOperaterById(mOperaterId);
		modelAndView.addObject("machineOperater", machineOperater);
		modelAndView.setViewName("genview/machineInfoDetail");
		return modelAndView;
	}

	@Description("更新machineOperate")
	@RequestMapping(value = "/machineInfoUpdateInfo", method = RequestMethod.GET)
	public ModelAndView updateMachineOperate(@RequestParam("mOperaterId") Integer mOperaterId,
			@ModelAttribute("user") UserInfo userInfo) {
		ModelAndView modelAndView = new ModelAndView();
		MachineOperater machineOperater = machineManagerService.getMachineOperaterById(mOperaterId);
		modelAndView.addObject("machineOperater", machineOperater);
		modelAndView.setViewName("genview/machineInfoUpdateInfo");

		return modelAndView;
	}

	@Description("执行更新数据库操作")
	@RequestMapping(value = "/machineInfoUpdate", method = RequestMethod.POST)
	public String updateMachineOperateExecute(@ModelAttribute("machineOperater") MachineOperater machineOperater,
			@ModelAttribute("user") UserInfo userInfo) {
		logger.debug("更新操作 ");
		machineManagerService.updateMachineOperater(machineOperater, userInfo);
		return "redirect:/machine/machineInfoDetail?mOperaterId=" + machineOperater.getmOperaterId();
	}
}
