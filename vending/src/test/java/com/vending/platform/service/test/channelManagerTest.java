package com.vending.platform.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.vending.platform.dao.IChannelManagerDAO;
import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelInfo;

/** @author Miley_Ren */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class channelManagerTest {
	@Autowired
	private IChannelManagerDAO channelManagerDAO;

	@Test
	public void testChannelGroup() {
		ChannelGroup channelGroup = new ChannelGroup();
		channelGroup.setChannelGroupName("货道组名称");
		channelManagerDAO.insertChannelGroup(channelGroup);

		channelGroup.setChannelGroupId(1);
		channelManagerDAO.updateChannelGroup(channelGroup);

		List<ChannelGroup> channelGroups = channelManagerDAO.getAllChannelGroups(channelGroup);
		for (ChannelGroup channelGroup2 : channelGroups) {
			System.out.println(channelGroup2.toString());
		}
		System.out.println(channelManagerDAO.getChannelGroupById(1).toString());
		channelManagerDAO.deleteChannelGroup(1);
	}

	@Test
	public void testChannelInfo() {
		ChannelInfo channelInfo = new ChannelInfo();
		channelInfo.setChannelNo("货道编号");
		channelInfo.setStockNum(1);
		channelManagerDAO.insertChannelInfo(channelInfo);

		channelInfo.setChannelId(1);
		channelManagerDAO.updateChannelInfo(channelInfo);

		List<ChannelInfo> channelInfos = channelManagerDAO.getAllChannelInfos(channelInfo);
		for (ChannelInfo channelInfo2 : channelInfos) {
			System.out.println(channelInfo2.toString());
		}

		System.out.println(channelManagerDAO.getChannelInfoById(1).toString());
		channelManagerDAO.deleteChannelInfo(1);

	}
}
