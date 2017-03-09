package com.vending.platform.service.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vending.platform.dao.IMachineDAO;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;

/**
 * @author Miley_Ren
 */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
// 使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class MachineServiceImplTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private IMachineDAO machineDAO;
	private UserInfo userInfo;
	private MachineOperater machineOperater;

	@Before
	public void init() {
		userInfo = new UserInfo();
		machineOperater = new MachineOperater();

		userInfo.setUserId(2);
		userInfo.setUserNo("00101");
		userInfo.setUserName("厂商user1");
		userInfo.setRoleId(2);
		userInfo.setStatus(1);
		userInfo.setFirmId(2);
		userInfo.setParentUserId(1);

		// machineOperater.setMachineAssign(0);
		// machineOperater.setMachineName("售货机名牌1");
		// machineOperater.setMachinePannel("售货机主板1");
	}

	@Test
	public void del() {
		Integer id = 9;
		machineDAO.deleteMachineOperateById(id);
	}

	@Test
	public void testcreate() {
		MachineOperater machineOperater = new MachineOperater();
		machineOperater.setMachineId(3);
		machineOperater.setMachineName("测试售货机");
		machineOperater.setOperFirmId(1);
		try {
			machineDAO.insertMachineOperate(machineOperater);
		} catch (Exception e) {
			System.out.println("error");
		}
	}

	@Test
	public void tesGetMachine() {
		List<MachineOperater> maOperaters = (List<MachineOperater>) machineDAO.getAllMachineOperaters(userInfo,
				machineOperater);
		System.out.println("-----------------------------------------------");
		System.out.println(maOperaters.size());
		for (int i = 0; i < maOperaters.size(); i++) {
			System.out.println("售货机：" + maOperaters.get(i).toString());
			System.out.println("售货机管理 :" + maOperaters.get(i).getMachineInfo().toString());
		}
	}

	@Test
	public void testUpdate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date ntime = new Date();
		/* System.out.println(ntime); */
		System.out.println(df.format(ntime));
		long nowtime = ntime.getTime();
		java.sql.Date operateDate = new java.sql.Date(nowtime);// 获取数据库时间
		System.out.println(operateDate.getTime());
		machineOperater.setmOperaterId(1);
		// machineOperater.setOperateId(userInfo.getUserId());
		// machineOperater.setMachineAddress("普陀修改");
		machineOperater.setOperateDate(operateDate);
		machineDAO.updateMachineOperate(machineOperater);
	}

	@Test
	public void getById() {
		machineOperater.setOperateId(1);
		MachineOperater mOperater = machineDAO.getMachineOperaterById(machineOperater.getOperateId());
		System.out.println("按Id查询：" + mOperater.toString());

	}

	@Test
	public void uodateGroup() {
		/*
		 * Integer groupId = 2; machineOperater.setmOperaterId(1);
		 * machineDAO.updateMachineGroup(groupId,
		 * machineOperater.getmOperaterId());
		 */
		MachineOperater machineOperater = new MachineOperater();
		machineOperater.setmOperaterId(1);
		machineOperater.setGroupId(2);
		machineDAO.updateMachineOperate(machineOperater);

	}

	@Test
	public void get() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date ntime = new Date();
		System.out.println(ntime);
		System.out.println(df.format(ntime));
		long nowtime = ntime.getTime();
		java.sql.Date operateDate = new java.sql.Date(nowtime);// 获取数据库时间
		System.out.println(operateDate);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date dt = sdf.parse(df.format(ntime));
			System.out.println("dt:" + dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
