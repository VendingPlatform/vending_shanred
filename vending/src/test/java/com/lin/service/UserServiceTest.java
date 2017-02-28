package com.lin.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.lin.domain.User;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.service.MachineService;

/**
 * 功能概要：UserService单元测试
 * 
 * @author linbingwen
 * @since 2015年9月28日
 */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
// 使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private UserService userService;
	@Autowired
	private MachineService machineService;
	Logger logger = Logger.getLogger(UserServiceTest.class);

	@Test
	public void selectUserByIdTest() {
		User user = userService.selectUserById(10);
		logger.debug("查找结果" + user);
		logger.debug(JSON.toJSONString(user));
	}

	@Test
	public void getMachine() {
		MachineOperater mOperater = new MachineOperater();
		mOperater.setmOperaterId(1);
		List<MachineOperater> machineOperaters = machineService.getmachineOperater(mOperater);
		for (MachineOperater machineOperater : machineOperaters) {
			System.out.println(machineOperater.getMachineId() + "; " + machineOperater.gettModelName() + "; "
					+ machineOperater.getMachineAddress());
		}
	}
}
