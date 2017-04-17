package com.vending.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vending.platform.service.IChannelManagerService;

@Controller
@SessionAttributes({ "user" })
@RequestMapping("/channel")
public class ChannelController extends UtilsAction {

    private static final long serialVersionUID = -1048332953525631103L;

    @Autowired
    private IChannelManagerService channelService;


}
