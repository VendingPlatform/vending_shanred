package com.vending.platform.service.test;

import java.security.acl.Group;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vending.platform.dao.IFrimAndGroupDAO;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;

/** @author Miley_Ren */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FirmAndGroupTest {

	@Autowired
	private IFrimAndGroupDAO firm;

	@Test
	public void testGroup() {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setGroupName("groupName测试");
		groupInfo.setGroupType(1);
		groupInfo.setFirmId(2);
		firm.insertGroupInfo(groupInfo);

		groupInfo.setGroupId(3);
		groupInfo.setGroupDesc("描述测试");

		firm.updateGroupInfo(groupInfo);
		List<GroupInfo> groupInfos = firm.getAllGroupInfos(groupInfo);
		for (GroupInfo groupInfo2 : groupInfos) {
			System.out.println(groupInfo2.toString());
		}
		System.out.println(firm.getGroupInfoById(3));

		firm.deleteGroupInfo(3);
	}

	@Test
	public void testFirm() {
		FirmInfo firmInfo = new FirmInfo();
		firmInfo.setFirmNo("firmNo测试");
		firmInfo.setFirmName("firmName测试");
		firmInfo.setFirmType(2);
		firmInfo.setFirmStatus(1);
		firm.insertFirm(firmInfo);

		firmInfo.setFirmId(4);
		firmInfo.setFirmDesc("描述信息测试");
		firm.updateFirm(firmInfo);

		List<FirmInfo> firmInfos = firm.getAllFirmInfos(firmInfo);
		for (FirmInfo firmInfo2 : firmInfos) {
			System.out.println(firmInfo2.toString());
		}

		System.out.println(firm.getFirmInfoById(4).toString());

		firm.deleteFirmInfo(4);
	}

}
