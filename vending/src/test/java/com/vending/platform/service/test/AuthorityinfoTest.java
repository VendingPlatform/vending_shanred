package com.vending.platform.service.test;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.domain.User;
import com.vending.platform.dao.IUserManagerDao;
import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.domain.RoleInfo;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.exception.SQLFormatException;

/** @author Miley_Ren */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorityinfoTest {

	@Autowired
	private IUserManagerDao aDao;

	@Test
	public void insetUser() throws SQLFormatException {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserNo("111");
		userInfo.setUserName("123");
		userInfo.setPassword("123");
		userInfo.setRoleId(2);
		userInfo.setStatus(1);
		userInfo.setFirmId(2);
		userInfo.setParentUserId(2);
		aDao.insertUser(userInfo);
	}

	@Test
	public void UpdateUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(5);
		userInfo.setUserNo("12345");
		userInfo.setUserName("update");
		userInfo.setPassword("123");
		userInfo.setRoleId(2);
		userInfo.setStatus(1);
		userInfo.setFirmId(2);
		userInfo.setParentUserId(2);
		userInfo.setMobilePhone("1232423");
		aDao.updateUser(userInfo);
	}

	@Test
	public void testGetUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("update");
		userInfo.setRoleId(2);
		userInfo.setStatus(1);
		List<UserInfo> userInfos = aDao.getAllUsers(userInfo);
		for (UserInfo userInfo2 : userInfos) {
			System.out.println(userInfo2.toString());
		}

		System.out.println(aDao.getUserById(1).toString());
	}

	@Test
	public void insertRole() throws SQLFormatException {
		RoleInfo roleInfo = new RoleInfo();
		// roleInfo.setRoleName("test");
		roleInfo.setAuthorityCode("ttt;");
		roleInfo.setAuthorityName("ttt;");
		roleInfo.setStatus(1);
		// roleInfo.setFirmId(1);
		// roleInfo.setOperateId(null);
		try {
			aDao.insertRoleInfo(roleInfo);
		} catch (Exception e) {
			System.out.println("输入格式不正确");
		}
	}

	@Test
	public void updateRole() {
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleId(6);
		roleInfo.setRoleName("testuPDATE5");
		roleInfo.setAuthorityCode("ttt_UPDATE;");
		roleInfo.setAuthorityName("ttt;");
		roleInfo.setStatus(1);
		aDao.updateRoleInfo(roleInfo);
	}

	@Test
	public void getAllRoles() {
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleName("testuPDATE5");
		roleInfo.setAuthorityCode("ttt_UPDATE;");
		roleInfo.setAuthorityName("ttt;");
		roleInfo.setStatus(1);
		List<RoleInfo> roleInfos = aDao.getAllRoles(roleInfo);
		for (RoleInfo roleInfo2 : roleInfos) {
			System.out.println(roleInfo2.toString());
		}
	}

	@Test
	public void getRoleById() {
		System.out.println(aDao.getRoleById(2).toString());
	}

	@Test
	public void insert() throws SQLFormatException {
		System.out.println("test");
		AuthorityInfo authorityInfo = new AuthorityInfo();
		// authorityInfo.setOperateId(1);
		authorityInfo.setAuthName("测试权限2");
		authorityInfo.setAuthCode("001");
		// authorityInfo.setFirmId(1);
		try {
			aDao.insertAuthorityInfo(authorityInfo);
		} catch (Exception e) {
			throw new SQLFormatException("传入的参数不完善");
		}
	}

	@Test
	public void update() {
		AuthorityInfo authorityInfo = new AuthorityInfo();
		authorityInfo.setOperateId(1);
		authorityInfo.setAuthName("修改权限2");
		// authorityInfo.setAuthCode("001");
		// authorityInfo.setFirmId(1);
		authorityInfo.setAuthId(8);
		try {
			aDao.updateAutorityInfo(authorityInfo);
		} catch (Exception e) {
			System.out.println("插入数据不符合规定：" + e.getMessage());
		}
	}

	@Test
	public void selectAll() {
		AuthorityInfo authorityInfo = new AuthorityInfo();
		authorityInfo.setAuthName("测试权限2");
		List<AuthorityInfo> authorityInfos = aDao.getAllAuthorityInfos(authorityInfo);
		for (AuthorityInfo authorityInfo2 : authorityInfos) {
			System.out.println(authorityInfo2.toString());
		}
	}

	@Test
	public void selectById() {
		AuthorityInfo aInfo = aDao.getAuthorityInfoById(5);
		System.out.println(aInfo.toString());
	}

	@Test
	public void del() {
		aDao.deleteAuthorityInfo(9);
	}

}
