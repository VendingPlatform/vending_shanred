/* 厂商信息表 */

/*公司信息表*/
CREATE TABLE `t_firm_info` (
  `FIRM_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司主键',
  `FIRM_NAME` varchar(80) NOT NULL,
  `FIRM_DESC` text,
  `FIRM_TYPE` int(1) NOT NULL COMMENT '公司类型，0：系统管理员，不属于任何公司；1:运营商；2：厂商',
  `FIRM_STATUS` int(1) NOT NULL COMMENT '公司状态，0：不可用；1：可用',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作人',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`FIRM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*售货机类型表*/
CREATE TABLE `t_machine_type` (
  `T_MODEL_ID` int(11) NOT NULL COMMENT '主键',
  `T_MODEL_NAME` varchar(50) NOT NULL COMMENT '售货机型号/类型名称',
  `T_FIRM_ID` int(11) NOT NULL COMMENT '所属厂商',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`T_MODEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*售货机字典表*/
CREATE TABLE `t_machine_info` (
  `MACHINE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '售货机Id',
  `MACHINE_NAME` varchar(100) NOT NULL COMMENT '售货机铭牌号',
  `MACHINE_PANNEL` varchar(50) NOT NULL COMMENT '售货机主板号',
  `MANU_FIRM_ID` int(11) NOT NULL COMMENT '厂商ID',
  `MANCHINE_PRICE` double NOT NULL COMMENT '售货机价格',
  `T_MODEL_NAME` varchar(20) NOT NULL COMMENT '售货机类型/型号',
  `MANU_MANCHINE_STATUS` int(11) NOT NULL COMMENT '0:未售出，1：已售出，2：回收',
  `OPER_FIRM_ID` int(11) DEFAULT NULL COMMENT '卖给某运营商',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`MACHINE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*运营商管理表*/
CREATE TABLE `t_oper_mgr` (
  `OPER_MGR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `FIRM_ID` int(11) NOT NULL COMMENT '运营商ID',
  `FIRM_NAME` varchar(80) NOT NULL COMMENT '运营商姓名',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`OPER_MGR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*角色信息表*/
CREATE TABLE `t_role_info` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色Id',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名称（唯一）',
  `AUTHORITY_CODE` varchar(100) NOT NULL COMMENT '权限编码（集合）',
  `AUTHORITY_NAME` varchar(100) NOT NULL COMMENT '权限名称（集合）',
  `STATUS` int(1) NOT NULL COMMENT '0：不可用；1：可用',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者(用户Id)',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*权限信息表*/
CREATE TABLE `t_authority_info` (
  `AUTH_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限Id',
  `AUTH_NAME` varchar(50) NOT NULL COMMENT '权限名称（唯一性）',
  `AUTH_CODE` varchar(10) NOT NULL COMMENT '权限编码（唯一性）',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`AUTH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**用户信息表*/
CREATE TABLE `t_use_info` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `USER_NO` varchar(15) NOT NULL COMMENT '员工号（用员工号进行登陆）',
  `USER_NAME` varchar(50) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) NOT NULL COMMENT '密码',
  `MOBILE_PHONE` int(11) DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT 'email',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色Id(角色不为空)',
  `GROUP_ID` int(11) DEFAULT NULL COMMENT '用户组Id',
  `PARENT_USER_ID` int(11) NOT NULL COMMENT '父管理员Id（默认为自己）',
  `FIRM_ID` int(11) DEFAULT NULL COMMENT '所属公司',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  `STATUS` int(11) NOT NULL COMMENT '状态，0：不可用，1：可用',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
