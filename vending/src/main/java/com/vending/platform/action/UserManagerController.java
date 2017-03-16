package com.vending.platform.action;

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
public class UserManagerController {
    private static Logger logger = Logger
            .getLogger(UserManagerController.class);
    @Autowired
    private IUserManagerService userManagerService;

    @Description("用户登录")
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ModelAttribute("user")
    public ModelAndView login(UserInfo userInfo,ModelMap modelMap) {
        UserInfo user = userManagerService.login(userInfo);
        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            modelAndView.setViewName("genview/home");
            modelAndView.addObject("user", user);
            modelMap.addAttribute("user", user);
            logger.debug(user.toString() + "：登录信息");
        } else {
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }

    @Description("查看用户信息")
    @RequestMapping(value = "/userInfo")
    public String getUserInfo(ModelMap modelMap, SessionStatus sessionStatus) {
        return "genview/userInfo";
    }

}
