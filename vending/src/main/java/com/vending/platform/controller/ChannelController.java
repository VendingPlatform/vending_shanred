package com.vending.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelWareInfo;
import com.vending.platform.service.IChannelManagerService;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/channel")
public class ChannelController extends UtilsAction {

    private static final long serialVersionUID = -1048332953525631103L;

    @Autowired
    private IChannelManagerService channelService;

    @RequestMapping(value = "/addChannelWare")
    public String addChannelWare(ChannelWareInfo channelWareInfo) {
        if(channelService.getChannelWareInfo(channelWareInfo.getChannelId())!=null){
            channelService.updateChannelWareInfo(channelWareInfo);
        }else{
        channelService.insetChannelWareInfo(channelWareInfo);
        }
        return "genview/OMachineInfoDetail";
    }

    @Description("获取所有货道信息")
    @RequestMapping(value = "/getAllChannels/{firmId}")
    public String getAllChannelWares(@PathVariable Integer firmId, String machineName, String channelNo, String wareName,
            ModelMap modelMap) {
        // 查询所有
        List<ChannelWareInfo> channelWareInfos =  channelService.getAllChannelInfos(firmId, machineName, channelNo, wareName);
        modelMap.addAttribute("allChannelWareInfos",channelWareInfos);
        return "genview/ChannelInfos";
    }
    
    @Description("获取货到组信息")
    @RequestMapping(value="/getAllChannelGroups/{firmId}")
    public String getAllChannelGroups(@PathVariable Integer firmId,ChannelGroup channelGroup,ModelMap modelMap){
        channelGroup.setFirmId(firmId); 
        List<ChannelGroup> channelGroups =  channelService.getAllChannelGroups(channelGroup);
        modelMap.addAttribute("channelGroups", channelGroups);
        return "genview/ChannelInfoGroups";
    }
    
    @Description("添加货道组信息")
    @RequestMapping(value = "/addChannelGroup")
    public String addChannelGroup(ChannelGroup channelGroup){
    	channelService.inserChannelGroup(channelGroup);
    	return "genview/ChannelInfoGroups";
    }
}
