package com.vending.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IFirmAndGroupService;
import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes({ "user", "userAuth", "userAuthCodes" })
@RequestMapping("/user")
public class UserGroupController {
    @Autowired
    private IFirmAndGroupService firmAndGroupService;
    @Autowired 
    private IUserManagerService userService;

    @RequestMapping(value = "/getAllGroups")
    public String getAllGroups(@ModelAttribute("user") UserInfo userInfo,
            ModelMap modelMap) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setFirmId(userInfo.getFirmInfo().getFirmId());
        groupInfo.setGroupType(1);// type为1,表示用户组
        List<GroupInfo> userGroupInfos = firmAndGroupService
                .getAllGroupInfos(groupInfo);
        modelMap.addAttribute("userGroupInfos", userGroupInfos);
        return "genview/UserGroups";
    }

    @RequestMapping(value = "/createUserGroup")
    public String createUserGroup(GroupInfo groupInfo,
            @ModelAttribute("user") UserInfo userInfo) {
        firmAndGroupService.insertGroup(groupInfo, userInfo);
        return "genview/UserGroups";
    }
    @RequestMapping(value="/{groupId}")
    public String getGroupUsers(@PathVariable Integer groupId, ModelMap map){
    	UserInfo user = new UserInfo();
    	user.setGroupId(groupId);
    	List<UserInfo> userInfos = userService.getAllUserInfos(user);
    	map.addAttribute("groupUsers", userInfos);
    	return "genview/UserGroupDetails";
    }
}
