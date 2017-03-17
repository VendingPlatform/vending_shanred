package com.vending.platform.action;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.MachineType;

@Controller
public class UtilsAction implements Serializable {
	private static final long serialVersionUID = -8348417258576966571L;
	private static Logger logger = Logger.getLogger(UtilsAction.class);

	@Description("进入home页")
	@RequestMapping(value = "/home")
	public String getHome() {
		return "genview/home";
	}
}
