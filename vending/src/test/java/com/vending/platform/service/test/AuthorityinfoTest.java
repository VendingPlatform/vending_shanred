package com.vending.platform.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vending.platform.dao.IAuthorityInfoDao;
import com.vending.platform.domain.AuthorityInfo;

/** @author Miley_Ren */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
// 使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorityinfoTest {

	@Autowired
	private IAuthorityInfoDao aDao;

	@Test
	public void insert() {
		System.out.println("test");
		AuthorityInfo authorityInfo = new AuthorityInfo();
		authorityInfo.setOperateId(1);
		authorityInfo.setAuthName("测试权限2");
		authorityInfo.setAuthCode("001");
		authorityInfo.setFirmId(1);
		try {
			aDao.insertAuthorityInfo(authorityInfo);
		} catch (Exception e) {
			System.out.println("插入数据不符合规定：" + e.getMessage());
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

	public void setaDao(IAuthorityInfoDao aDao) {
		this.aDao = aDao;
	}

	public IAuthorityInfoDao getaDao() {
		return aDao;
	}
}
