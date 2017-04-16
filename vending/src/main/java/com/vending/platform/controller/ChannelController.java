package com.vending.platform.controller;

import java.io.IOException;

import org.aspectj.bridge.MessageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;
import com.vending.platform.service.IChannelManagerService;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/channel")
public class ChannelController extends UtilsAction {

    private static final long serialVersionUID = -1048332953525631103L;

    @Autowired
    private IChannelManagerService channelService;

    @RequestMapping(value = "/insertChannel")
    public String insertChannelInfo(ChannelInfo channelInfo,
            ChannelWareInfo channelWareInfo, Integer wareId,
            Integer mOperaterId) throws IOException {
        ChannelInfo cInfo = new ChannelInfo();
        cInfo.setChannelNo(channelInfo.getChannelNo());
        if (channelService.getAllChannelInfos(cInfo).size() > 0) {
            write("该货道编号已存在");
            return "genview/OMachineInfoDetail";
        } else {
            channelInfo.setmOperaterId(mOperaterId);
            channelService.insertChannelInfo(channelInfo);
            Integer index = channelService.getAllChannelInfos(channelInfo)
                    .get(0).getChannelId();
            channelWareInfo.setmOperaterId(mOperaterId);
            channelWareInfo.setChannelId(index);
            channelWareInfo.setWareId(wareId);
            channelService.insetChannelWareInfo(channelWareInfo);
            write("插入成功");
        }
        return "genview/OMachineInfoDetail";
    }

}
