package com.vending.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import org.apache.log4j.Logger;
import com.vending.platform.dao.IUserManagerDao;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IUserManagerService;

/** 用户管理Service */
@Service
public class UserManagerServiceImpl
        implements IUserManagerService, Serializable {
    private static final long serialVersionUID = -5147230002673392653L;
    private static Logger logger = Logger
            .getLogger(UserManagerServiceImpl.class);

    @Autowired
    private IUserManagerDao userManagerDao;

    @Override
    public UserInfo login(UserInfo userInfo) {
        if (userManagerDao.getAllUsers(userInfo).size() > 1) {
            logger.debug("用户名密码多次匹配，用户错误");
            return null;
        } else if (userManagerDao.getAllUsers(userInfo).size() < 1) {
            logger.debug("登录失败");
            return null;
        } else {
            logger.debug("登录成功");
            return userManagerDao.getAllUsers(userInfo).get(0);
        }
    }

}
