/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community : Database - vending_machine
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vending_machine` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `vending_machine`;

/*Table structure for table `t_authority_info` */

DROP TABLE IF EXISTS `t_authority_info`;

CREATE TABLE `t_authority_info` (
  `auth_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `auth_name` varchar(50) NOT NULL COMMENT '权限名称（唯一性）',
  `auth_code` varchar(10) NOT NULL COMMENT '权限编码（唯一性）',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_authority_info` */

insert  into `t_authority_info`(`auth_id`,`auth_name`,`auth_code`,`operate_id`,`operate_date`) values (1,'system','000',1,'2017-02-27 12:55:37'),(2,'firm_admin','001',1,'2017-02-27 16:09:36'),(3,'manu_admin','002',1,'2017-02-27 17:02:29');

/*Table structure for table `t_channel_group` */

DROP TABLE IF EXISTS `t_channel_group`;

CREATE TABLE `t_channel_group` (
  `channel_group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道组id',
  `channel_group_name` varchar(50) NOT NULL COMMENT '货道组名称',
  `ware_code` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `ware_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `ware_price` double DEFAULT NULL COMMENT '商品价格',
  `is_discount` int(1) DEFAULT NULL COMMENT '是否特价',
  `group_id` int(11) DEFAULT NULL COMMENT '所属售货机组',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作人',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`channel_group_id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `t_channel_group_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `t_group_info` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_channel_group` */

/*Table structure for table `t_channel_info` */

DROP TABLE IF EXISTS `t_channel_info`;

CREATE TABLE `t_channel_info` (
  `channel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道id',
  `channel_no` varchar(50) NOT NULL COMMENT '货道编号',
  `ware_code` varchar(50) NOT NULL COMMENT '商品编号',
  `ware_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `ware_price` double DEFAULT NULL COMMENT '商品价格',
  `is_discount` int(11) DEFAULT NULL COMMENT '是否特价',
  `stock_num` int(11) NOT NULL COMMENT '额定存货量',
  `stock_num_now` int(11) DEFAULT NULL COMMENT '当前存货量',
  `stock_num_add` int(11) DEFAULT NULL COMMENT '新增存货量',
  `channel_group_id` int(11) DEFAULT NULL COMMENT '所属货道组id',
  `machine_id` int(11) NOT NULL COMMENT '所属售货机id',
  `is_history` int(1) NOT NULL COMMENT '是否为历史信息',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`channel_id`),
  KEY `channel_group_id` (`channel_group_id`),
  KEY `machine_id` (`machine_id`),
  CONSTRAINT `t_channel_info_ibfk_1` FOREIGN KEY (`channel_group_id`) REFERENCES `t_channel_group` (`channel_group_id`),
  CONSTRAINT `t_channel_info_ibfk_2` FOREIGN KEY (`machine_id`) REFERENCES `t_machine_info` (`machine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_channel_info` */

/*Table structure for table `t_firm_info` */

DROP TABLE IF EXISTS `t_firm_info`;

CREATE TABLE `t_firm_info` (
  `firm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司主键',
  `firm_name` varchar(80) NOT NULL,
  `firm_desc` text,
  `firm_type` int(1) NOT NULL COMMENT '公司类型，0：系统管理员，不属于任何公司；1:运营商；2：厂商',
  `firm_status` int(1) NOT NULL COMMENT '公司状态，0：不可用；1：可用',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作人',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`firm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_firm_info` */

insert  into `t_firm_info`(`firm_id`,`firm_name`,`firm_desc`,`firm_type`,`firm_status`,`operate_id`,`operate_date`) values (1,'system','system',0,1,1,'2017-02-27 12:13:38'),(2,'运营商1','运营商1的描述信息',1,1,1,'2017-02-27 13:02:06'),(3,'厂商','厂商1的描述信息',2,1,1,'2017-02-27 17:00:49');

/*Table structure for table `t_group_info` */

DROP TABLE IF EXISTS `t_group_info`;

CREATE TABLE `t_group_info` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组信息表',
  `group_name` varchar(50) NOT NULL COMMENT '组名（唯一）',
  `group_type` int(1) NOT NULL COMMENT '分组类型，0:系統管理員；1：用户组；2：售货机组',
  `group_desc` text COMMENT '分组描述',
  `firm_id` int(11) NOT NULL COMMENT '公司id（运营商）',
  `operate_name` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`group_id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `t_group_info_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `t_firm_info` (`firm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_group_info` */

insert  into `t_group_info`(`group_id`,`group_name`,`group_type`,`group_desc`,`firm_id`,`operate_name`,`operate_date`) values (1,'system',0,'system group',1,1,'2017-02-27 12:57:36'),(2,'售货机组1',2,'售货机组1测试',2,1,'2017-02-27 15:50:10');

/*Table structure for table `t_machine_info` */

DROP TABLE IF EXISTS `t_machine_info`;

CREATE TABLE `t_machine_info` (
  `machine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '售货机id',
  `machine_name` varchar(100) NOT NULL COMMENT '售货机铭牌号',
  `machine_pannel` varchar(50) NOT NULL COMMENT '售货机主板号',
  `manu_firm_id` int(11) NOT NULL COMMENT '厂商id',
  `manchine_price` double NOT NULL COMMENT '售货机价格',
  `t_model_name` varchar(20) NOT NULL COMMENT '售货机类型/型号',
  `manu_manchine_status` int(11) NOT NULL COMMENT '0:未售出，1：已售出，2：回收',
  `oper_firm_id` int(11) DEFAULT NULL COMMENT '卖给某运营商',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`machine_id`),
  KEY `manu_firm_id` (`manu_firm_id`),
  KEY `oper_firm_id` (`oper_firm_id`),
  CONSTRAINT `t_machine_info_ibfk_1` FOREIGN KEY (`manu_firm_id`) REFERENCES `t_firm_info` (`firm_id`),
  CONSTRAINT `t_machine_info_ibfk_2` FOREIGN KEY (`oper_firm_id`) REFERENCES `t_firm_info` (`firm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_machine_info` */

insert  into `t_machine_info`(`machine_id`,`machine_name`,`machine_pannel`,`manu_firm_id`,`manchine_price`,`t_model_name`,`manu_manchine_status`,`oper_firm_id`,`operate_id`,`operate_date`) values (1,'售货机名牌1','售货机主板1',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),(2,'售货机名牌2','售货机主板2',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),(3,'售货机名牌3','售货机主板3',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),(4,'售货机名牌4','售货机主板4',3,30,'类型1',1,2,3,'2017-02-27 17:09:27');

/*Table structure for table `t_machine_operater` */

DROP TABLE IF EXISTS `t_machine_operater`;

CREATE TABLE `t_machine_operater` (
  `m_operater_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '售货机信息id',
  `machine_id` int(11) NOT NULL COMMENT '售货机id',
  `machine_assign` int(1) NOT NULL COMMENT '是否分配',
  `t_model_name` varchar(50) NOT NULL COMMENT '售货机类型',
  `user_id` int(11) DEFAULT NULL COMMENT '分配给某员工',
  `machine_address` varchar(150) DEFAULT NULL COMMENT '售货机地址',
  `machine_status` int(1) NOT NULL COMMENT '售货机是否可用',
  `group_id` int(11) DEFAULT NULL COMMENT '售货机组id',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`m_operater_id`),
  KEY `machine_id` (`machine_id`),
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `t_machine_operater_ibfk_1` FOREIGN KEY (`machine_id`) REFERENCES `t_machine_info` (`machine_id`),
  CONSTRAINT `t_machine_operater_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_use_info` (`user_id`),
  CONSTRAINT `t_machine_operater_ibfk_3` FOREIGN KEY (`group_id`) REFERENCES `t_group_info` (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_machine_operater` */

insert  into `t_machine_operater`(`m_operater_id`,`machine_id`,`machine_assign`,`t_model_name`,`user_id`,`machine_address`,`machine_status`,`group_id`,`operate_id`,`operate_date`) values (1,1,0,'类型1',NULL,'松江',1,NULL,3,'2017-02-27 20:57:25'),(2,2,0,'类型1',NULL,'普陀',1,NULL,3,'2017-02-27 21:02:07'),(3,3,0,'类型1',NULL,'华师大',1,NULL,3,'2017-02-27 21:03:12'),(4,4,0,'类型1',NULL,'闵行',1,NULL,3,'2017-02-27 21:03:53');

/*Table structure for table `t_machine_type` */

DROP TABLE IF EXISTS `t_machine_type`;

CREATE TABLE `t_machine_type` (
  `t_model_id` int(11) NOT NULL COMMENT '主键',
  `t_model_name` varchar(50) NOT NULL COMMENT '售货机型号/类型名称',
  `t_firm_id` int(11) NOT NULL COMMENT '所属厂商',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`t_model_id`),
  KEY `t_firm_id` (`t_firm_id`),
  CONSTRAINT `t_machine_type_ibfk_1` FOREIGN KEY (`t_firm_id`) REFERENCES `t_firm_info` (`firm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_machine_type` */

insert  into `t_machine_type`(`t_model_id`,`t_model_name`,`t_firm_id`,`operate_id`,`operate_date`) values (1,'类型1',3,1,'2017-02-27 17:07:25');

/*Table structure for table `t_oper_mgr` */

DROP TABLE IF EXISTS `t_oper_mgr`;

CREATE TABLE `t_oper_mgr` (
  `oper_mgr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `firm_id` int(11) NOT NULL COMMENT '运营商id',
  `firm_name` varchar(80) NOT NULL COMMENT '运营商姓名',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_mgr_id`),
  KEY `firm_id` (`firm_id`),
  CONSTRAINT `t_oper_mgr_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `t_firm_info` (`firm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_oper_mgr` */

/*Table structure for table `t_role_info` */

DROP TABLE IF EXISTS `t_role_info`;

CREATE TABLE `t_role_info` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称（唯一）',
  `authority_code` varchar(100) NOT NULL COMMENT '权限编码（集合）',
  `authority_name` varchar(100) NOT NULL COMMENT '权限名称（集合）',
  `status` int(1) NOT NULL COMMENT '0：不可用；1：可用',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者(用户id)',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_info` */

insert  into `t_role_info`(`role_id`,`role_name`,`authority_code`,`authority_name`,`status`,`operate_id`,`operate_date`) values (1,'system','000,','system,',1,1,'2017-02-27 12:54:59'),(2,'firm_admin','001,','firm_admin,',1,1,'2017-02-27 16:10:10'),(3,'manu_admin','002,','manu_admin,',1,1,'2017-02-27 17:03:15');

/*Table structure for table `t_test` */

DROP TABLE IF EXISTS `t_test`;

CREATE TABLE `t_test` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` char(30) NOT NULL,
  `user_password` char(10) NOT NULL,
  `user_email` char(30) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `idx_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_test` */

insert  into `t_test`(`user_id`,`user_name`,`user_password`,`user_email`) values (1,'林炳文','1234567@','ling20081005@126.com'),(2,'evan','123','fff@126.com'),(3,'kaka','cadg','fwsfg@126.com'),(4,'simle','cscs','fsaf@126.com'),(5,'arthur','csas','fsaff@126.com'),(6,'小德','yuh78','fdfas@126.com'),(7,'小小','cvff','fsaf@126.com'),(8,'林林之家','gvv','lin@126.com'),(9,'林炳文evankaka','dfsc','ling2008@126.com'),(10,'apple','uih6','ff@qq.com');

/*Table structure for table `t_use_info` */

DROP TABLE IF EXISTS `t_use_info`;

CREATE TABLE `t_use_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_no` varchar(15) NOT NULL COMMENT '用户编号（用员工号进行登陆）',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `mobile_phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT 'email',
  `role_id` int(11) NOT NULL COMMENT '角色id(角色不为空)',
  `group_id` int(11) DEFAULT NULL COMMENT '用户组id',
  `status` int(11) NOT NULL COMMENT '状态，0：不可用，1：可用',
  `firm_id` int(11) NOT NULL COMMENT '所属公司（系统管理员属于单独的公司）',
  `parent_user_id` int(11) NOT NULL COMMENT '父管理员id（默认为自己）',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`user_id`),
  KEY `role_id` (`role_id`),
  KEY `group_id` (`group_id`),
  KEY `firm_id` (`firm_id`),
  KEY `parent_user_id` (`parent_user_id`),
  CONSTRAINT `t_use_info_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role_info` (`role_id`),
  CONSTRAINT `t_use_info_ibfk_3` FOREIGN KEY (`group_id`) REFERENCES `t_group_info` (`group_id`),
  CONSTRAINT `t_use_info_ibfk_4` FOREIGN KEY (`firm_id`) REFERENCES `t_firm_info` (`firm_id`),
  CONSTRAINT `t_use_info_ibfk_5` FOREIGN KEY (`parent_user_id`) REFERENCES `t_use_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_use_info` */

insert  into `t_use_info`(`user_id`,`user_no`,`user_name`,`password`,`mobile_phone`,`email`,`role_id`,`group_id`,`status`,`firm_id`,`parent_user_id`,`operate_date`,`operate_id`) values (1,'000','system','system',NULL,NULL,1,1,1,1,1,'2017-02-27 12:58:14',1),(2,'00101','运营商user1','123456',NULL,NULL,2,NULL,1,2,1,'2017-02-27 16:12:00',1),(3,'00201','厂商user1','123456',NULL,NULL,3,NULL,1,3,1,'2017-02-27 17:04:19',1);

/*Table structure for table `t_ware_info` */

DROP TABLE IF EXISTS `t_ware_info`;

CREATE TABLE `t_ware_info` (
  `ware_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `ware_code` varchar(50) NOT NULL COMMENT '商品编号',
  `ware_name` varchar(50) NOT NULL COMMENT '商品名称',
  `ware_norm` varchar(20) NOT NULL COMMENT '商品规格（如每箱多少瓶）',
  `ware_unit` varchar(20) NOT NULL COMMENT '商品单位（如瓶）',
  `ware_base_price` double DEFAULT NULL COMMENT '商品进价',
  `ware_max_price` double DEFAULT NULL COMMENT '最高售价',
  `ware_min_price` double DEFAULT NULL COMMENT '最低售价',
  `ware_desc` varchar(225) DEFAULT NULL COMMENT '商品描述',
  `ware_sattus` int(1) NOT NULL COMMENT '是否可用',
  `frim_id` int(11) NOT NULL COMMENT '运营商id',
  `operate_id` int(11) DEFAULT NULL COMMENT '操作者',
  `operate_date` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`ware_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_ware_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
