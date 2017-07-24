package com.vending.platform.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vending.platform.dao.IFrimAndGroupDAO;
import com.vending.platform.dao.IUserManagerDao;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;
import com.vending.platform.domain.OperMgr;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.domain.UserRoleInfo;
import com.vending.platform.exception.SQLFormatException;
import com.vending.platform.service.IFirmAndGroupService;

@Service
public class FirmAndGroupServiceImpl implements IFirmAndGroupService {
    private static Logger logger = Logger
            .getLogger(FirmAndGroupServiceImpl.class);

    @Autowired
    private IFrimAndGroupDAO firmAndGroupDao;
    @Autowired
    private IUserManagerDao userManagerDao;

    @Override
    public boolean insertFirm(FirmInfo firmInfo,UserInfo user) {
        FirmInfo firmAlready = new FirmInfo();
        firmAlready.setFirmNo(firmInfo.getFirmNo());
        List<FirmInfo> firmInfos = firmAndGroupDao.getAllFirmInfos(firmAlready);
        if (firmInfos.size() > 0) {
            return false;
        } else {
            firmAndGroupDao.insertFirm(firmInfo);
            Integer firmId = firmAndGroupDao.getAllFirmInfos(firmInfo).get(0)
                    .getFirmId();
            firmInfo.setFirmId(firmId);
            // 添加管理员
            boolean result = this.addFirmManager(firmInfo,user);
            if (result == false)
                firmAndGroupDao.deleteFirmInfo(firmId);
            return true;
        }
    }

    /** 添加管理员 */
    public boolean addFirmManager(FirmInfo firmInfo,UserInfo user) {
        UserInfo userInfo = new UserInfo();
        UserRoleInfo userRoleInfo = new UserRoleInfo();
        userInfo.setFirmId(firmInfo.getFirmId());
        userInfo.setUserName("system" + firmInfo.getFirmNo() + "01");
        if (userManagerDao.getAllUsers(userInfo).size() > 0) {
            logger.debug("用户已存在。。。");
            return false;
        }
        userInfo.setPassword("system" + firmInfo.getFirmNo() + "01");
        userInfo.setUserNo(firmInfo.getFirmNo() + "01");
        userInfo.setStatus(1);
        
        Integer roleId = 0;
        if (firmInfo.getFirmType() == 1) {// 运营商
        	userInfo.setParentUserId(user.getUserId());
            roleId = 2;
        }
        if (firmInfo.getFirmType() == 2) {// 厂商
        	userInfo.setParentUserId(user.getUserId());
            roleId = 3;
        }
        if (firmInfo.getFirmType() == 0) {// 管理员
            roleId = 1;
        }
        try {
            userManagerDao.insertUser(userInfo);// 创建用户
        } catch (SQLFormatException e) {
            logger.debug("创建用户失败。。。");
            e.printStackTrace();
        }
        Integer userId = userManagerDao.getAllUsers(userInfo).get(0)
                .getUserId();
        userRoleInfo.setRoleId(roleId);
        userRoleInfo.setUserId(userId);
        userManagerDao.insertUserRoleInfo(userRoleInfo);// 为用户关联角色
        return true;
    }

    @Override
    public void updateFirm(FirmInfo firmInfo) {
        firmAndGroupDao.updateFirm(firmInfo);
    }

    @Override
    public List<FirmInfo> getAllFirmInfos(FirmInfo firmInfo) {
        return firmAndGroupDao.getAllFirmInfos(firmInfo);
    }

    @Override
    public FirmInfo getFirmInfoById(Integer firmId) {
        return firmAndGroupDao.getFirmInfoById(firmId);
    }

    @Override
    public void deleteFirmInfo(Integer firmId) {
        firmAndGroupDao.deleteFirmInfo(firmId);
    }

    @Override
    public boolean insertGroup(GroupInfo groupInfo, UserInfo userInfo) {
        GroupInfo group = new GroupInfo();
        group.setFirmId(userInfo.getFirmInfo().getFirmId());
        group.setGroupType(groupInfo.getGroupType());
        group.setGroupName(groupInfo.getGroupName());
        List<GroupInfo> groupInfos = this.getAllGroupInfos(group);
        if (groupInfos != null && groupInfos.size() > 0) {
            return false;
        } else {
            groupInfo.setFirmId(userInfo.getFirmInfo().getFirmId());
            groupInfo.setOperateId(userInfo.getUserId());
            firmAndGroupDao.insertGroupInfo(groupInfo);
            return true;
        }
    }

    @Override
    public void updateGroup(GroupInfo groupInfo) {
        firmAndGroupDao.updateGroupInfo(groupInfo);
    }

    @Override
    public List<GroupInfo> getAllGroupInfos(GroupInfo groupInfo) {
        return firmAndGroupDao.getAllGroupInfos(groupInfo);
    }

    @Override
    public GroupInfo getGroupInfoById(Integer groupId) {
        return firmAndGroupDao.getGroupInfoById(groupId);
    }

    @Override
    public void deleteGroupInfo(Integer groupId) {
        firmAndGroupDao.deleteGroupInfo(groupId);
    }

    @Override
    public void insertOperMgr(OperMgr operMgr) {
        firmAndGroupDao.insertOperMgr(operMgr);
    }

    @Override
    public void updateOperMgr(OperMgr operMgr) {
        firmAndGroupDao.updateOperMgr(operMgr);
    }

    @Override
    public List<OperMgr> getAllOperMgrs(OperMgr operMgr) {
        return firmAndGroupDao.getAllOperMgrs(operMgr);
    }

    @Override
    public OperMgr getOperMgrById(Integer id) {
        return firmAndGroupDao.getOperMgrById(id);
    }

    @Override
    public void deleteOperMgr(Integer id) {
        firmAndGroupDao.deleteOperMgr(id);
    }

}
