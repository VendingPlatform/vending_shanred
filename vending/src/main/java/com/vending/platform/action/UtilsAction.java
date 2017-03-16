package com.vending.platform.action;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilsAction implements Serializable {
    private static final long serialVersionUID = -8348417258576966571L;
    private static Logger logger = Logger.getLogger(UtilsAction.class);

    @Description("进入home页")
    @RequestMapping(value = "/home")
    public String getHome() {
        return "genview/home";
    }

    @Description("进入售货机接页面")
    @RequestMapping(value = "/machine/machineHome")
    public String getMachineHome() {
        return "genview/smachine";
    }
}
