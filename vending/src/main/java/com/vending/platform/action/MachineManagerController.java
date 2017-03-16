package com.vending.platform.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IMachineManagerService;

@Controller
@RequestMapping("/machine")
public class MachineManagerController {
    private static Logger logger = Logger
            .getLogger(MachineManagerController.class);
    @Autowired
    private IMachineManagerService machineManagerService;

    @Description("获取运营商的售货机")
    @RequestMapping(value = "/machineInfo")
    public ModelAndView getOprMachineInfo(MachineOperater machineOperater,
            ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        if (machineOperater != null) {
            List<MachineOperater> machineOperaters = machineManagerService
                    .getOprMachines((UserInfo) modelMap.get("user"),
                            machineOperater);
            if (machineOperaters != null) {
                modelAndView.addObject(machineOperaters);
                for (MachineOperater machineOperater2 : machineOperaters) {
                    System.out.println("及其信息：" + machineOperater2.toString());
                }
            }
            modelAndView.setViewName("genview/smachine");

        } else {
            modelAndView.setViewName("genview/smachine");
        }
        return modelAndView;
    }
}
