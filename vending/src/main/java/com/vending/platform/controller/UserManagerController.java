package com.vending.platform.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleAuthInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.domain.UserRoleInfo;
import com.vending.platform.service.IUserManagerService;

@Controller
@SessionAttributes({ "user", "userAuth" })
@RequestMapping("user")
public class UserManagerController extends UtilsAction {
    private static final Logger logger = Logger
            .getLogger(UserManagerController.class);
    private static final long serialVersionUID = 6934405543902610637L;
    @Autowired
    private IUserManagerService userManagerService;

    @RequestMapping(value = "/getAllUsers")
    public String getAllUsers(@ModelAttribute("user") UserInfo userInfo,
            @ModelAttribute("userAuth") Set<AuthorityInfo> auths,
            ModelMap modelMap) {
        List<UserInfo> userInfos = userManagerService.getAllUsersByAuth(auths,
                userInfo);
        modelMap.addAttribute("userInfos", userInfos);
        return "genview/AllUsers";
    }

    @RequestMapping(value = "/getAllAuthoritys")
    public String getAllAuthoritys(@ModelAttribute("user") UserInfo userInfo,
            ModelMap modelMap) {
        List<AuthorityInfo> authorityInfos = userManagerService
                .getAllAuthoritys(new AuthorityInfo());
        modelMap.addAttribute("authorityInfos", authorityInfos);
        return "genview/AuthorityInfo";
    }

    @RequestMapping(value = "/getAllAuths")
    public String getAllAuths(@RequestParam("roleId") Integer roleId,
            @RequestParam("firmType") Integer firmType, ModelMap modelMap) {
        RoleAuthInfo authInfo = new RoleAuthInfo();
        authInfo.setRoleId(roleId);
        List<AuthorityInfo> authInfosAlready = new ArrayList<AuthorityInfo>();
        for (RoleAuthInfo r : userManagerService
                .getAllRoleAuthInfos(authInfo)) {
            authInfosAlready.add(r.getAuthorityInfo());
        }
        AuthorityInfo authorityInfo = new AuthorityInfo();
        if (firmType != 0) {
            authorityInfo.setAuthType(firmType);
        }
        List<AuthorityInfo> authorityInfos = userManagerService
                .getAllAuthoritys(authorityInfo);
        List<AuthorityInfo> auths = new ArrayList<>();
        for (AuthorityInfo a : authorityInfos) {
            if (!authInfosAlready.contains(a)) {
                auths.add(a);
            }
        }
        modelMap.addAttribute("auths", auths);
        try {
            writeJson(auths);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "genview/RoleInfo";
    }

    //// 还需根据不同权限进行查询，并不是所有人都可以查询用户角色
    // 或者让用户可以查看，但是不要进行其他操作
    @RequestMapping(value = "/getAllRoles")
    public String getAllRoles(@ModelAttribute("user") UserInfo userInfo,
            ModelMap modelMap) {
        Integer firmType = userInfo.getFirmInfo().getFirmType();
        List<RoleInfo> roleInfos = new ArrayList<RoleInfo>();
        if (firmType != 0) {
            // 若不为系统管理员，则只可查看自己拥有的角色
            UserRoleInfo userrole = new UserRoleInfo();
            userrole.setUserId(userInfo.getUserId());
            List<UserRoleInfo> userRoleInfos = userManagerService
                    .getAllUserRoleInfos(userrole);
            for (UserRoleInfo userRoleInfo : userRoleInfos) {
                roleInfos.add(userRoleInfo.getRoleInfo());
            }
        } else {
            // 若为系统管理员
            roleInfos = userManagerService.getAllRoles(new RoleInfo());
        }
        modelMap.addAttribute("allRoleInfos", roleInfos);
        return "genview/RoleInfo";
    }

    @RequestMapping(value = "/getRoleAuthInfo")
    public String getRoleAuthInfo(@RequestParam("roleId") Integer roleId,
            ModelMap modelMap) {
        RoleAuthInfo roleAuthInfo = new RoleAuthInfo();
        roleAuthInfo.setRoleId(roleId);
        List<RoleAuthInfo> roleAuthInfos = userManagerService
                .getAllRoleAuthInfos(roleAuthInfo);
        modelMap.addAttribute("roleAuthInfos", roleAuthInfos);
        return "genview/RoleAuthInfo";
    }

    @RequestMapping(value = "/insertRole")
    public String insertRole(RoleInfo roleInfo) {
        if (userManagerService.getAllRoles(roleInfo).size() > 0) {
            try {
                write("角色名被占用，请更换角色名重试。");
                return "genview/RoleInfo";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        userManagerService.insertRole(roleInfo);
        try {
            write("添加成功。");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "genview/RoleInfo";
    }

    @RequestMapping(value = "/getRoleById")
    public String getRoleById(@RequestParam("roleId") Integer roleId,
            ModelMap modelMap) {
        RoleInfo roleInfo = userManagerService.getRoleById(roleId);
        modelMap.addAttribute("roleInfo", roleInfo);
        try {
            writeJson(roleInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "genview/RoleInfo";
    }

    @RequestMapping(value = "/assignAuthToRole")
    public String assignAuthToRole(@RequestParam("authIds") Integer[] authIds,
            @RequestParam("roleId") Integer roleId) {
        RoleAuthInfo roleAuthInfo = new RoleAuthInfo();
        for (Integer authId : authIds) {
            roleAuthInfo.setRoleId(roleId);
            roleAuthInfo.setAuthId(authId);
            userManagerService.insertRoleAuthInfo(roleAuthInfo);
        }
        return "genview/RoleInfo";
    }

    @RequestMapping(value = "/updateRole")
    public String updateRole(RoleInfo roleInfo) {
        userManagerService.updateRole(roleInfo);
        return "genview/RoleInfo";
    }

    @RequestMapping(value = "/deleteRole")
    public String deleteRole(@RequestParam("roleId") Integer roleId) {
        RoleAuthInfo roleAuthInfo = new RoleAuthInfo();
        roleAuthInfo.setRoleId(roleId);
        List<RoleAuthInfo> roleAuths = userManagerService
                .getAllRoleAuthInfos(roleAuthInfo);
        for (RoleAuthInfo roleAuth : roleAuths) {
            String authCode = roleAuth.getAuthorityInfo().getAuthCode();
            if (authCode.equals("000") || authCode.equals("001")
                    || authCode.equals("002")) {
                try {
                    write("无法删除该角色");
                    return "genview/RoleInfo";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 删除角色
        userManagerService.deleteRole(roleId);
        try {
            write("删除角色成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "genview/RoleInfo";
    }
}
