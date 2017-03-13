package com.vending.platform.service.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vending.platform.dao.IFrimAndGroupDAO;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.OperMgr;

/** @author Miley_Ren */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FirmAndGroupTest {

	@Autowired
	private IFrimAndGroupDAO firm;

	@Test
	public void testOpgemGR() {
		OperMgr operMgr = new OperMgr();
		operMgr.setFirmNo("公司编号");
		operMgr.setFirmId(1);
		operMgr.setFirmName("公司名称");
		operMgr.setManuId(1);
		firm.insertOperMgr(operMgr);
		operMgr.setOperMgrId(1);
		operMgr.setManuName("厂商名称");
		firm.updateOperMgr(operMgr);
		List<OperMgr> operMgrs = firm.getAllOperMgrs(operMgr);
		for (OperMgr operMgr2 : operMgrs) {
			System.out.println(operMgr2.toString());
		}
		System.out.println(firm.getOperMgrById(1).toString());
		firm.deleteOperMgr(1);
	}

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
