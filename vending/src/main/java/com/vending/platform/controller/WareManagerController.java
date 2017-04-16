package com.vending.platform.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.UserInfo;
import com.vending.platform.domain.WareInfo;
import com.vending.platform.service.IWareManagerService;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/ware")
public class WareManagerController extends UtilsAction {
    private static final long serialVersionUID = 3027923261243983L;
    @Autowired
    private IWareManagerService wareService;

    @RequestMapping(value = "/getAllWareInfos")
    public String getAllWareInfos(@ModelAttribute("user") UserInfo userInfo,
            ModelMap map) {
        WareInfo ware = new WareInfo();
        ware.setFirmId(userInfo.getFirmInfo().getFirmId());
        List<WareInfo> wareInfos = wareService.getAllWareInfos(ware);
        map.addAttribute("allWareInfos", wareInfos);
        return "genview/WareInfo";
    }

    @RequestMapping(value = "/getWareInoById")
    public String getWareInoById(@RequestParam("wareId") Integer wareId,
            ModelMap map) {
        WareInfo wareInfo = wareService.getWareInoById(wareId);
        map.addAttribute("wareInfoToUpdate", wareInfo);
        try {
            writeJson(wareInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "genview/WareInfo";
    }

    @RequestMapping(value = "/insertWareInfo")
    public String insertWareInfo(@ModelAttribute("user") UserInfo userInfo,
            WareInfo wareInfo) throws IOException {
        WareInfo w = new WareInfo();
        w.setWareCode(wareInfo.getWareCode());
        if (wareService.getAllWareInfos(w).size() > 0) {
            write("该编号已被占用");
            return "genview/WareInfo";
        }
        wareInfo.setFirmId(userInfo.getFirmInfo().getFirmId());
        wareService.insertWareInfo(wareInfo);
        write("创建成功");
        return "genview/WareInfo";
    }

    @RequestMapping(value = "/updateWareInfo")
    public String updateWareInfo(@ModelAttribute("user") UserInfo userInfo,
            WareInfo wa) {
        wa.setOperateId(userInfo.getUserId());
        wareService.updateWareInfo(wa);
         return "genview/WareInfo";
    }
}
