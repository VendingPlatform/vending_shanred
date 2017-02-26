/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community : Database - vending
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vending` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vending`;

/*Table structure for table `t_authority_info` */

DROP TABLE IF EXISTS `t_authority_info`;

CREATE TABLE `t_authority_info` (
  `AUTH_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限Id',
  `AUTH_NAME` varchar(50) NOT NULL COMMENT '权限名称（唯一性）',
  `AUTH_CODE` varchar(10) NOT NULL COMMENT '权限编码（唯一性）',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`AUTH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_authority_info` */

/*Table structure for table `t_channel_group` */

DROP TABLE IF EXISTS `t_channel_group`;

CREATE TABLE `t_channel_group` (
  `CHANNEL_GROUP_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道组ID',
  `CHANNEL_GROUP_NAME` varchar(50) NOT NULL COMMENT '货道名称',
  `CHANNEL_NUM_LIST` varchar(225) DEFAULT NULL COMMENT '货道ID列表',
  `WARE_CODE` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `WARE_NAME` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `WARE_PRICE` double DEFAULT NULL COMMENT '商品价格',
  `IS_DISCOUNT` int(1) DEFAULT NULL COMMENT '是否特价',
  `GROUP_ID` int(11) DEFAULT NULL COMMENT '所属售货机组',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作人',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`CHANNEL_GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_channel_group` */

/*Table structure for table `t_channel_info` */

DROP TABLE IF EXISTS `t_channel_info`;

CREATE TABLE `t_channel_info` (
  `CHANNEL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道ID',
  `CHANNEL_NO` varchar(50) NOT NULL COMMENT '货道编号',
  `WARE_CODE` varchar(50) NOT NULL COMMENT '商品编号',
  `WARE_NAME` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `STOCK_NUM` int(11) NOT NULL COMMENT '额定存货量',
  `STOCK_NUM_NOW` int(11) DEFAULT NULL COMMENT '当前存货量',
  `STOCK_NUM_ADD` int(11) DEFAULT NULL COMMENT '新增存货量',
  `MACHINE_ID` int(11) NOT NULL COMMENT '所属售货机',
  `IS_HISTORY` int(1) NOT NULL COMMENT '是否为历史信息',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`CHANNEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_channel_info` */

/*Table structure for table `t_firm_info` */

DROP TABLE IF EXISTS `t_firm_info`;

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

/*Data for the table `t_firm_info` */

/*Table structure for table `t_group_info` */

DROP TABLE IF EXISTS `t_group_info`;

CREATE TABLE `t_group_info` (
  `GROUP_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组信息表',
  `GROUP_NAME` varchar(50) NOT NULL COMMENT '组名（唯一）',
  `GROUP_TYPE` int(1) NOT NULL COMMENT '分组类型，0：用户组；1：售货机组',
  `GROUP_DESC` text COMMENT '分组描述',
  `OPERATE_NAME` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_group_info` */

/*Table structure for table `t_machine_info` */

DROP TABLE IF EXISTS `t_machine_info`;

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

/*Data for the table `t_machine_info` */

/*Table structure for table `t_machine_operater` */

DROP TABLE IF EXISTS `t_machine_operater`;

CREATE TABLE `t_machine_operater` (
  `M_OPERATER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '售货机信息Id',
  `MACHINE_ID` int(11) NOT NULL COMMENT '售货机Id',
  `MACHINE_ADDIGN` int(1) NOT NULL COMMENT '是否分配',
  `T_MODEL_NAME` varchar(50) NOT NULL COMMENT '售货机类型',
  `USER_ID` int(11) DEFAULT NULL COMMENT '分配给某员工',
  `MACHINE_ADDRESS` varchar(150) DEFAULT NULL COMMENT '售货机地址',
  `MACHINE_STATUS` int(1) NOT NULL COMMENT '售货机是否可用',
  `GROUP_ID` int(11) DEFAULT NULL COMMENT '售货机组ID',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`M_OPERATER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_machine_operater` */

/*Table structure for table `t_machine_type` */

DROP TABLE IF EXISTS `t_machine_type`;

CREATE TABLE `t_machine_type` (
  `T_MODEL_ID` int(11) NOT NULL COMMENT '主键',
  `T_MODEL_NAME` varchar(50) NOT NULL COMMENT '售货机型号/类型名称',
  `T_FIRM_ID` int(11) NOT NULL COMMENT '所属厂商',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`T_MODEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_machine_type` */

/*Table structure for table `t_oper_mgr` */

DROP TABLE IF EXISTS `t_oper_mgr`;

CREATE TABLE `t_oper_mgr` (
  `OPER_MGR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `FIRM_ID` int(11) NOT NULL COMMENT '运营商ID',
  `FIRM_NAME` varchar(80) NOT NULL COMMENT '运营商姓名',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`OPER_MGR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_oper_mgr` */

/*Table structure for table `t_role_info` */

DROP TABLE IF EXISTS `t_role_info`;

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

/*Data for the table `t_role_info` */

/*Table structure for table `t_use_info` */

DROP TABLE IF EXISTS `t_use_info`;

CREATE TABLE `t_use_info` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `USER_NO` varchar(15) NOT NULL COMMENT '员工号（用员工号进行登陆）',
  `USER_NAME` varchar(50) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) NOT NULL COMMENT '密码',
  `MOBILE_PHONE` int(11) DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT 'email',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色Id(角色不为空)',
  `GROUP_ID` int(11) DEFAULT NULL COMMENT '用户组Id',
  `STATUS` int(11) NOT NULL COMMENT '状态，0：不可用，1：可用',
  `FIRM_ID` int(11) NOT NULL COMMENT '所属公司（系统管理员属于单独的公司）',
  `PARENT_USER_ID` int(11) NOT NULL COMMENT '父管理员Id（默认为自己）',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_use_info` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` char(30) NOT NULL,
  `USER_PASSWORD` char(10) NOT NULL,
  `USER_EMAIL` char(30) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `IDX_NAME` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`USER_ID`,`USER_NAME`,`USER_PASSWORD`,`USER_EMAIL`) values (1,'林炳文','1234567@','ling20081005@126.com'),(2,'evan','123','fff@126.com'),(3,'kaka','cadg','fwsfg@126.com'),(4,'simle','cscs','fsaf@126.com'),(5,'arthur','csas','fsaff@126.com'),(6,'小德','yuh78','fdfas@126.com'),(7,'小小','cvff','fsaf@126.com'),(8,'林林之家','gvv','lin@126.com'),(9,'林炳文Evankaka','dfsc','ling2008@126.com'),(10,'apple','uih6','ff@qq.com');

/*Table structure for table `t_ware_info` */

DROP TABLE IF EXISTS `t_ware_info`;

CREATE TABLE `t_ware_info` (
  `WARE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `WARE_CODE` varchar(50) NOT NULL COMMENT '商品编号',
  `WARE_NAME` varchar(50) NOT NULL COMMENT '商品名称',
  `WARE_NORM` varchar(20) NOT NULL COMMENT '商品规格（如每箱多少瓶）',
  `WARE_UNIT` varchar(20) NOT NULL COMMENT '商品单位（如瓶）',
  `WARE_BASE_PRICE` double DEFAULT NULL COMMENT '商品进价',
  `WARE_MAX_PRICE` double DEFAULT NULL COMMENT '最高售价',
  `WARE_MIN_PRICE` double DEFAULT NULL COMMENT '最低售价',
  `WARE_DESC` varchar(225) DEFAULT NULL COMMENT '商品描述',
  `WARE_SATTUS` int(1) NOT NULL COMMENT '是否可用',
  `OPERATE_ID` int(11) DEFAULT NULL COMMENT '操作者',
  `OPERATE_DATE` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`WARE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_ware_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
