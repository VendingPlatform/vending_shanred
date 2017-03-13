package com.vending.platform.service.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vending.platform.dao.IWareManagerDAO;
import com.vending.platform.domain.WareInfo;

/** @author Miley_Ren */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IWareManagerTest {

	@Autowired
	private IWareManagerDAO wareManagerDAO;

	@Test
	public void testWare() {
		WareInfo wareInfo = new WareInfo();
		wareInfo.setWareCode("001");
		wareInfo.setWareName("可乐");
		wareInfo.setWareNorm("24瓶/箱");
		wareInfo.setWareUnit("单位");
		wareInfo.setWareStatus(1);
		wareInfo.setFirmId(2);
		wareManagerDAO.inserWareInfo(wareInfo);

		wareInfo.setWareId(1);
		wareInfo.setWareDesc("dsafsdf");
		wareManagerDAO.updateWareInfo(wareInfo);

		List<WareInfo> wareInfos = wareManagerDAO.getAllWareInfos(wareInfo);
		for (WareInfo wareInfo2 : wareInfos) {
			System.out.println(wareInfo2.toString());
		}

		System.out.println(wareManagerDAO.getWareInfoById(1).toString());

		wareManagerDAO.deleteWareInfo(1);
	}
}
