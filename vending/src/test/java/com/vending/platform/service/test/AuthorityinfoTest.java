package com.vending.platform.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vending.platform.dao.IAuthoritysAndRolesDao;
import com.vending.platform.domain.AuthorityInfo;
import com.vending.platform.exception.SQLFormatException;

/** @author Miley_Ren */
// 指定bean注入的配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
// 使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorityinfoTest {

    @Autowired
    private IAuthoritysAndRolesDao aDao;

    @Test
    public void insert() throws SQLFormatException {
        System.out.println("test");
        AuthorityInfo authorityInfo = new AuthorityInfo();
        authorityInfo.setOperateId(1);
        authorityInfo.setAuthName("测试权限2");
        authorityInfo.setAuthCode("001");
        // authorityInfo.setFirmId(1);
        try {
            aDao.insertAuthorityInfo(authorityInfo);
        } catch (Exception e) {
            throw new SQLFormatException("传入的参数不正确");
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
        List<AuthorityInfo> authorityInfos = aDao
                .getAllAuthorityInfos(authorityInfo);
        for (AuthorityInfo authorityInfo2 : authorityInfos) {
            System.out.println(authorityInfo2.toString());
        }
    }

    @Test
    public void selectById() {
        AuthorityInfo aInfo = aDao.selectAuthorityInfoById(5);
        System.out.println(aInfo.toString());
    }

    @Test
    public void del() {
        aDao.deleteAuthorityInfo(9);
    }

    public void setaDao(IAuthoritysAndRolesDao aDao) {
        this.aDao = aDao;
    }

    public IAuthoritysAndRolesDao getaDao() {
        return aDao;
    }
}
