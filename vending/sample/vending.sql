/*
SQLyog Community v12.4.1 (64 bit)
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

/*Table structure for table `authorityinfo` */

DROP TABLE IF EXISTS `authorityinfo`;

CREATE TABLE `authorityinfo` (
  `authId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `authName` varchar(50) NOT NULL COMMENT '权限名称（唯一性）',
  `authCode` varchar(10) NOT NULL COMMENT '权限编码（唯一性）',
  `authDesc` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `authType` int(1) NOT NULL COMMENT '权限类型，0，管理员，1，运营商，2，厂商',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `authorityinfo` */

LOCK TABLES `authorityinfo` WRITE;

insert  into `authorityinfo`(`authId`,`authName`,`authCode`,`authDesc`,`authType`,`operateId`,`operateDate`) values 
(1,'系统权限','000','具有整个系统的管理权限',0,1,'2017-02-27 12:55:37'),
(2,'运营商管理员权限','001','具有运营商内的所有管理权限（包括角色管理）',1,1,'2017-02-27 16:09:36'),
(3,'厂商管理员权限','002','具有厂商内的所有管理权限（包括角色管理）',2,1,'2017-02-27 17:02:29'),
(4,'运营商分组管理权限','00101','可管理用户组内组员及售货机信息（不包括角色管理）',1,1,'2017-04-05 22:30:44'),
(5,'运营商普通管理权限','0010101','仅可管理自己的售货机及自身信息',1,1,'2017-04-05 22:31:43'),
(6,'运营商商品管理权限','00102','可管理商品',1,1,'2017-04-05 22:31:56'),
(7,'运营商订单管理权限','00103','可管理订单',1,1,'2017-04-05 23:19:36'),
(8,'运营商仓库管理权限','00104','可管理库存',1,1,'2017-04-05 23:25:00'),
(9,'运营商财务管理权限','00105','可管理财务',1,1,'2017-04-05 23:25:44');

UNLOCK TABLES;

/*Table structure for table `channelgroup` */

DROP TABLE IF EXISTS `channelgroup`;

CREATE TABLE `channelgroup` (
  `channelGroupId` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道组id',
  `channelGroupName` varchar(50) NOT NULL DEFAULT 'null' COMMENT '货道组名称',
  `stockNum` int(11) DEFAULT NULL COMMENT '存货量',
  `firmId` int(11) DEFAULT NULL COMMENT '所属公司',
  `operateId` int(11) DEFAULT NULL COMMENT '操作人',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`channelGroupId`),
  KEY `groupId` (`firmId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `channelgroup` */

LOCK TABLES `channelgroup` WRITE;

insert  into `channelgroup`(`channelGroupId`,`channelGroupName`,`stockNum`,`firmId`,`operateId`,`operateDate`) values 
(1,'testChannelGroup',11,32,NULL,'2017-04-16 17:03:12');

UNLOCK TABLES;

/*Table structure for table `channelgroupwareinfo` */

DROP TABLE IF EXISTS `channelgroupwareinfo`;

CREATE TABLE `channelgroupwareinfo` (
  `channelGroupId` int(11) NOT NULL COMMENT '货道组Id',
  `wareId` int(11) NOT NULL COMMENT '商品Id',
  `price` double DEFAULT NULL COMMENT '价格',
  `isDiscount` int(11) DEFAULT NULL COMMENT '是否折扣',
  PRIMARY KEY (`channelGroupId`),
  KEY `wareId` (`wareId`),
  CONSTRAINT `channelgroupwareinfo_ibfk_1` FOREIGN KEY (`channelGroupId`) REFERENCES `channelgroup` (`channelGroupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `channelgroupwareinfo_ibfk_2` FOREIGN KEY (`wareId`) REFERENCES `wareinfo` (`wareId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `channelgroupwareinfo` */

LOCK TABLES `channelgroupwareinfo` WRITE;

UNLOCK TABLES;

/*Table structure for table `channelinfo` */

DROP TABLE IF EXISTS `channelinfo`;

CREATE TABLE `channelinfo` (
  `channelId` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道id',
  `channelNo` varchar(50) NOT NULL COMMENT '货道编号',
  `stockNum` int(11) DEFAULT NULL COMMENT '额定存货量',
  `stockNumNow` int(11) DEFAULT NULL COMMENT '当前存货量',
  `stockNumAdd` int(11) DEFAULT NULL COMMENT '新增存货量',
  `channelGroupId` int(11) DEFAULT NULL COMMENT '所属货道组id',
  `mOperaterId` int(11) DEFAULT NULL COMMENT '所属售货机id',
  `machineId` int(11) DEFAULT NULL COMMENT '所属售货机',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`channelId`),
  KEY `channelGroupId` (`channelGroupId`),
  KEY `machineId` (`mOperaterId`),
  KEY `machineId_2` (`machineId`),
  CONSTRAINT `channelinfo_ibfk_1` FOREIGN KEY (`mOperaterId`) REFERENCES `machineoperater` (`mOperaterId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `channelinfo_ibfk_2` FOREIGN KEY (`channelGroupId`) REFERENCES `channelgroup` (`channelGroupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `channelinfo_ibfk_3` FOREIGN KEY (`machineId`) REFERENCES `machineinfo` (`machineId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `channelinfo` */

LOCK TABLES `channelinfo` WRITE;

insert  into `channelinfo`(`channelId`,`channelNo`,`stockNum`,`stockNumNow`,`stockNumAdd`,`channelGroupId`,`mOperaterId`,`machineId`,`operateId`,`operateDate`) values 
(1,'001',11,0,0,1,9,9,NULL,'2017-04-16 17:33:15'),
(11,'002',11,NULL,NULL,NULL,9,9,NULL,'2017-04-16 21:48:59'),
(15,'003',11,0,0,NULL,NULL,9,NULL,'2017-04-17 20:47:15'),
(16,'004',11,0,0,NULL,NULL,9,NULL,'2017-04-17 20:47:21'),
(17,'005',11,0,0,NULL,NULL,9,NULL,'2017-04-17 20:47:27'),
(18,'006',11,0,0,NULL,NULL,9,NULL,'2017-04-17 20:47:34'),
(19,'007',11,0,0,NULL,NULL,9,NULL,'2017-04-17 20:47:40');

UNLOCK TABLES;

/*Table structure for table `channelinfohistory` */

DROP TABLE IF EXISTS `channelinfohistory`;

CREATE TABLE `channelinfohistory` (
  `channelHistory` int(11) NOT NULL AUTO_INCREMENT COMMENT '历史Id',
  `machineName` varchar(11) DEFAULT NULL COMMENT '售货机名称',
  `channelNo` varchar(50) NOT NULL COMMENT '货道编号',
  `channelGroupName` varchar(50) DEFAULT NULL COMMENT '货道组名称',
  `wareName` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `price` double DEFAULT NULL COMMENT '价格',
  `stockNum` int(11) DEFAULT '0' COMMENT '额定存货量',
  `stockNumnNow` int(11) DEFAULT NULL COMMENT '当前存货量',
  `stockNumnAdd` int(11) DEFAULT NULL COMMENT '新增存货量',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`channelHistory`),
  KEY `channelGroupId` (`channelGroupName`),
  KEY `machineId` (`machineName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `channelinfohistory` */

LOCK TABLES `channelinfohistory` WRITE;

insert  into `channelinfohistory`(`channelHistory`,`machineName`,`channelNo`,`channelGroupName`,`wareName`,`price`,`stockNum`,`stockNumnNow`,`stockNumnAdd`,`operateId`,`operateDate`) values 
(1,NULL,'',NULL,NULL,NULL,0,NULL,NULL,NULL,'0000-00-00 00:00:00');

UNLOCK TABLES;

/*Table structure for table `channelwareinfo` */

DROP TABLE IF EXISTS `channelwareinfo`;

CREATE TABLE `channelwareinfo` (
  `channelId` int(11) NOT NULL COMMENT '货道Id',
  `wareId` int(11) NOT NULL COMMENT '商品Id',
  `price` double DEFAULT NULL COMMENT '商品售卖价格',
  `isDiscount` int(11) NOT NULL DEFAULT '0' COMMENT '是否特价',
  `mOperaterId` int(11) NOT NULL COMMENT '售货机',
  PRIMARY KEY (`channelId`),
  KEY `wareId` (`wareId`),
  CONSTRAINT `channelwareinfo_ibfk_1` FOREIGN KEY (`channelId`) REFERENCES `channelinfo` (`channelId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `channelwareinfo_ibfk_2` FOREIGN KEY (`wareId`) REFERENCES `wareinfo` (`wareId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `channelwareinfo` */

LOCK TABLES `channelwareinfo` WRITE;

insert  into `channelwareinfo`(`channelId`,`wareId`,`price`,`isDiscount`,`mOperaterId`) values 
(1,1,NULL,0,9),
(11,2,2.5,0,9);

UNLOCK TABLES;

/*Table structure for table `firminfo` */

DROP TABLE IF EXISTS `firminfo`;

CREATE TABLE `firminfo` (
  `firmId` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司主键',
  `firmNo` varchar(50) NOT NULL DEFAULT 'null' COMMENT '公司编号',
  `firmName` varchar(80) NOT NULL DEFAULT 'null' COMMENT '公司名称',
  `firmDesc` text COMMENT '公司描述',
  `firmType` int(11) NOT NULL COMMENT '公司类型，0：系统管理员，不属于任何公司；1:运营商；2：厂商',
  `firmStatus` int(11) NOT NULL DEFAULT '0' COMMENT '公司状态，0：不可用；1：可用',
  `operateId` int(11) DEFAULT NULL COMMENT '操作人',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`firmId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `firminfo` */

LOCK TABLES `firminfo` WRITE;

insert  into `firminfo`(`firmId`,`firmNo`,`firmName`,`firmDesc`,`firmType`,`firmStatus`,`operateId`,`operateDate`) values 
(1,'000','system','system',0,1,1,'2017-02-27 12:13:38'),
(3,'002','厂商1','厂商1的描述信息',2,1,1,'2017-04-10 15:43:11'),
(4,'003','运营商1','运营商1描述',1,1,1,'2017-04-09 18:27:16'),
(22,'005','运营商2','运营商描述',1,1,1,'2017-04-09 18:27:24'),
(23,'006','运营商3','test describe',1,1,1,'2017-04-09 18:27:32'),
(26,'007','test','test1',1,1,3,'2017-04-17 16:16:50');

UNLOCK TABLES;

/*Table structure for table `groupinfo` */

DROP TABLE IF EXISTS `groupinfo`;

CREATE TABLE `groupinfo` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组信息ID',
  `groupName` varchar(50) NOT NULL DEFAULT 'null' COMMENT '组名（唯一）',
  `groupType` int(1) NOT NULL COMMENT '分组类型，0:系統管理員；1：用户组；2：售货机组',
  `groupDesc` text COMMENT '分组描述',
  `firmId` int(11) NOT NULL COMMENT '公司id（运营商）',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`groupId`),
  KEY `firmId` (`firmId`),
  CONSTRAINT `firmInfo` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `groupinfo` */

LOCK TABLES `groupinfo` WRITE;

insert  into `groupinfo`(`groupId`,`groupName`,`groupType`,`groupDesc`,`firmId`,`operateId`,`operateDate`) values 
(1,'system',0,'系统管理员分组，此分组用作区分用户角色',1,1,'2017-03-20 16:59:54'),
(32,'售货机组1',2,'售货机组1',22,6,'2017-04-09 19:26:00'),
(33,'售货机组2',2,'售货机组2',22,6,'2017-04-09 19:26:51'),
(35,'test',1,'TEST',22,6,'2017-04-10 22:03:06');

UNLOCK TABLES;

/*Table structure for table `machineinfo` */

DROP TABLE IF EXISTS `machineinfo`;

CREATE TABLE `machineinfo` (
  `machineId` int(11) NOT NULL AUTO_INCREMENT COMMENT '售货机id',
  `machineName` varchar(100) NOT NULL COMMENT '售货机铭牌号',
  `machinePannel` varchar(50) NOT NULL COMMENT '售货机主板号',
  `manuFirmId` int(11) NOT NULL COMMENT '厂商ID',
  `machinePrice` decimal(10,0) DEFAULT NULL COMMENT '售货机价格',
  `tModelId` int(11) DEFAULT NULL COMMENT '售货机类型',
  `tModelName` varchar(20) DEFAULT NULL COMMENT '售货机类型/型号',
  `manuMachineStatus` int(11) NOT NULL DEFAULT '0' COMMENT '0:未售出，1：已售出，2：回收',
  `operFirmId` int(11) DEFAULT NULL COMMENT '卖给某运营商ID',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`machineId`),
  KEY `manuFirmId` (`manuFirmId`),
  KEY `operFirmId` (`operFirmId`),
  KEY `tModelId` (`tModelId`),
  CONSTRAINT `machineinfo_ibfk_1` FOREIGN KEY (`tModelId`) REFERENCES `machinetype` (`tModelId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_machine_info_ibfk_1` FOREIGN KEY (`manuFirmId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_machine_info_ibfk_2` FOREIGN KEY (`operFirmId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `machineinfo` */

LOCK TABLES `machineinfo` WRITE;

insert  into `machineinfo`(`machineId`,`machineName`,`machinePannel`,`manuFirmId`,`machinePrice`,`tModelId`,`tModelName`,`manuMachineStatus`,`operFirmId`,`operateId`,`operateDate`) values 
(9,'售货机1','售货机1',3,20,1,'类型1',1,22,3,'2017-04-09 18:29:07'),
(10,'售货机2','售货机2',3,20,1,'类型1',1,22,3,'2017-04-09 18:29:21'),
(11,'售货机3','售货机3',3,30,1,'类型1',1,22,3,'2017-04-09 18:31:13'),
(12,'售货机4','售货机4',3,20,1,'类型1',1,22,3,'2017-04-09 18:31:56'),
(13,'售货机5','售货机5',3,20,1,'类型2',1,22,3,'2017-04-09 18:33:03'),
(16,'tes','sdf',3,23,2,'类型2',1,22,3,'2017-04-10 11:31:05');

UNLOCK TABLES;

/*Table structure for table `machineoperater` */

DROP TABLE IF EXISTS `machineoperater`;

CREATE TABLE `machineoperater` (
  `mOperaterId` int(11) NOT NULL AUTO_INCREMENT COMMENT '售货机信息id',
  `machineId` int(11) NOT NULL COMMENT '售货机id',
  `machineAssign` int(1) NOT NULL DEFAULT '0' COMMENT '是否分配给某员工',
  `userId` int(11) DEFAULT NULL COMMENT '分配给某员工',
  `machineAddress` varchar(150) DEFAULT NULL COMMENT '售货机地址',
  `groupId` int(11) DEFAULT NULL COMMENT '售货机组id',
  `operFirmId` int(11) NOT NULL COMMENT '运营商ID',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`mOperaterId`),
  KEY `machineId` (`machineId`),
  KEY `userId` (`userId`),
  KEY `groupId` (`groupId`),
  CONSTRAINT `machineoperater_ibfk_1` FOREIGN KEY (`machineId`) REFERENCES `machineinfo` (`machineId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MachineOperater_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MachineOperater_ibfk_3` FOREIGN KEY (`groupId`) REFERENCES `groupinfo` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `machineoperater` */

LOCK TABLES `machineoperater` WRITE;

insert  into `machineoperater`(`mOperaterId`,`machineId`,`machineAssign`,`userId`,`machineAddress`,`groupId`,`operFirmId`,`operateId`,`operateDate`) values 
(9,9,1,10,NULL,32,22,6,'2017-04-15 17:09:18'),
(10,10,1,6,NULL,32,22,6,'2017-04-15 18:58:52'),
(11,11,0,NULL,NULL,NULL,22,6,'2017-04-15 17:09:26'),
(12,12,0,NULL,NULL,33,22,6,'2017-04-15 17:36:31'),
(13,13,0,NULL,NULL,NULL,22,NULL,'2017-04-15 17:36:28'),
(14,16,1,6,NULL,32,22,6,'2017-04-15 18:58:54');

UNLOCK TABLES;

/*Table structure for table `machinetype` */

DROP TABLE IF EXISTS `machinetype`;

CREATE TABLE `machinetype` (
  `tModelId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tModelName` varchar(50) NOT NULL COMMENT '售货机型号/类型名称',
  `firmId` int(11) NOT NULL COMMENT '所属厂商ID',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`tModelId`),
  KEY `firmId` (`firmId`),
  CONSTRAINT `MachineType_ibfk_1` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `machinetype` */

LOCK TABLES `machinetype` WRITE;

insert  into `machinetype`(`tModelId`,`tModelName`,`firmId`,`operateId`,`operateDate`) values 
(1,'类型1',3,1,'2017-02-27 17:07:25'),
(2,'类型2',3,3,'2017-03-16 23:08:23');

UNLOCK TABLES;

/*Table structure for table `opermgr` */

DROP TABLE IF EXISTS `opermgr`;

CREATE TABLE `opermgr` (
  `operMgrId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `firmId` int(11) NOT NULL COMMENT '合作的运营商id',
  `manuId` int(11) NOT NULL COMMENT '厂商ID',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`operMgrId`),
  KEY `firmId` (`firmId`),
  KEY `OperMgr_ibfk_2` (`manuId`),
  CONSTRAINT `OperMgr_ibfk_1` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OperMgr_ibfk_2` FOREIGN KEY (`manuId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `opermgr` */

LOCK TABLES `opermgr` WRITE;

insert  into `opermgr`(`operMgrId`,`firmId`,`manuId`,`operateId`,`operateDate`) values 
(10,22,3,3,'2017-04-09 18:34:49'),
(11,23,3,3,'2017-04-09 18:34:49'),
(13,4,3,3,'2017-04-09 19:11:38');

UNLOCK TABLES;

/*Table structure for table `roleauth` */

DROP TABLE IF EXISTS `roleauth`;

CREATE TABLE `roleauth` (
  `roleAuthId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` int(11) NOT NULL COMMENT '角色Id',
  `authId` int(11) NOT NULL COMMENT '权限Id',
  PRIMARY KEY (`roleAuthId`),
  KEY `roleId` (`roleId`),
  KEY `authId` (`authId`),
  CONSTRAINT `roleauth_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `roleinfo` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `roleauth_ibfk_2` FOREIGN KEY (`authId`) REFERENCES `authorityinfo` (`authId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `roleauth` */

LOCK TABLES `roleauth` WRITE;

insert  into `roleauth`(`roleAuthId`,`roleId`,`authId`) values 
(1,1,1),
(2,2,2),
(3,3,3),
(4,9,4),
(5,2,4),
(15,2,5),
(16,2,6),
(17,2,7),
(18,2,8),
(19,2,9),
(20,11,6),
(21,11,8),
(22,12,7),
(23,12,9),
(24,10,5);

UNLOCK TABLES;

/*Table structure for table `roleinfo` */

DROP TABLE IF EXISTS `roleinfo`;

CREATE TABLE `roleinfo` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `roleName` varchar(50) NOT NULL COMMENT '角色名称（唯一）',
  `firmType` int(11) NOT NULL COMMENT '角色类型：0：系统管理员，1：运营商；2：厂商',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `roleinfo` */

LOCK TABLES `roleinfo` WRITE;

insert  into `roleinfo`(`roleId`,`roleName`,`firmType`,`operateDate`) values 
(1,'系统管理员',0,'2017-04-07 17:27:47'),
(2,'运营商管理员',1,'2017-04-07 17:27:13'),
(3,'厂商管理员',2,'2017-04-07 17:26:28'),
(9,'用户组管理员',1,'2017-04-07 17:27:27'),
(10,'操作员',1,'2017-04-07 15:52:10'),
(11,'库存管理员',1,'2017-04-09 14:48:08'),
(12,'财务管理员',1,'2017-04-09 14:49:19');

UNLOCK TABLES;

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `userNo` varchar(15) NOT NULL COMMENT '用户编号（用员工号进行登陆）',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `mobilePhone` char(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT 'email',
  `groupManager` int(11) DEFAULT NULL COMMENT '是否为小组管理员',
  `groupId` int(11) DEFAULT NULL COMMENT '用户组id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态，0：不可用，1：可用',
  `firmId` int(11) NOT NULL COMMENT '所属公司（系统管理员属于单独的公司）',
  `parentUserId` int(11) DEFAULT NULL COMMENT '父管理员id（默认为自己）',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`userId`),
  KEY `groupId` (`groupId`),
  KEY `firmId` (`firmId`),
  CONSTRAINT `userinfo_ibfk_2` FOREIGN KEY (`groupId`) REFERENCES `groupinfo` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userinfo_ibfk_3` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

LOCK TABLES `userinfo` WRITE;

insert  into `userinfo`(`userId`,`userNo`,`userName`,`password`,`mobilePhone`,`email`,`groupManager`,`groupId`,`status`,`firmId`,`parentUserId`,`operateDate`,`operateId`) values 
(1,'000','system','111',NULL,NULL,1,1,1,1,1,'2017-02-27 12:58:14',1),
(3,'00201','system001','111',NULL,NULL,1,NULL,1,3,1,'2017-02-27 17:04:19',1),
(6,'00501','sys5','111',NULL,NULL,1,NULL,1,22,1,'2017-04-07 14:09:59',NULL),
(7,'00601','system00601','system00601',NULL,NULL,1,NULL,1,23,1,'2017-04-07 14:19:12',NULL),
(10,'00502','sys6','111',NULL,NULL,NULL,NULL,1,22,NULL,'2017-04-09 22:59:35',6),
(12,'00701','system00701','system00701',NULL,NULL,NULL,NULL,1,26,1,'2017-04-10 15:43:28',NULL),
(13,'00503','sys7','1111',NULL,NULL,0,NULL,1,22,NULL,'2017-04-10 20:06:06',6);

UNLOCK TABLES;

/*Table structure for table `userrole` */

DROP TABLE IF EXISTS `userrole`;

CREATE TABLE `userrole` (
  `userRoleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色Id',
  `userId` int(11) NOT NULL COMMENT '用户Id',
  `roleId` int(11) NOT NULL COMMENT '角色Id',
  PRIMARY KEY (`userRoleId`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `userrole_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userrole_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `roleinfo` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `userrole` */

LOCK TABLES `userrole` WRITE;

insert  into `userrole`(`userRoleId`,`userId`,`roleId`) values 
(1,1,1),
(3,3,3),
(8,7,2),
(21,12,2),
(27,10,9),
(28,10,10),
(29,10,11),
(30,10,12),
(31,13,10),
(46,6,2),
(47,6,9),
(48,6,10),
(49,6,11),
(50,6,12);

UNLOCK TABLES;

/*Table structure for table `wareinfo` */

DROP TABLE IF EXISTS `wareinfo`;

CREATE TABLE `wareinfo` (
  `wareId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `wareCode` varchar(50) NOT NULL COMMENT '商品编号',
  `wareName` varchar(50) NOT NULL COMMENT '商品名称',
  `wareNorm` varchar(20) NOT NULL COMMENT '商品规格（如每箱多少瓶）',
  `wareUnit` varchar(20) NOT NULL COMMENT '商品单位（如瓶）',
  `wareBasePrice` double DEFAULT NULL COMMENT '商品进价',
  `wareMaxPrice` double DEFAULT NULL COMMENT '最高售价',
  `wareMinPrice` double DEFAULT NULL COMMENT '最低售价',
  `wareDesc` varchar(225) DEFAULT NULL COMMENT '商品描述',
  `firmId` int(11) DEFAULT NULL COMMENT '运营商id',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`wareId`),
  KEY `firmId` (`firmId`),
  CONSTRAINT `wareinfo_ibfk_1` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `wareinfo` */

LOCK TABLES `wareinfo` WRITE;

insert  into `wareinfo`(`wareId`,`wareCode`,`wareName`,`wareNorm`,`wareUnit`,`wareBasePrice`,`wareMaxPrice`,`wareMinPrice`,`wareDesc`,`firmId`,`operateId`,`operateDate`) values 
(1,'YL-BSKL-G330','百事可乐300ml','24罐/箱','罐',1.75,0,0,'百事可乐gengxin',22,6,'2017-04-16 13:58:00'),
(2,'YL-BSKL-G331','可口可乐500ml','24罐/箱','罐',1.75,NULL,NULL,'可口可乐',22,6,'2017-04-16 13:55:29');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
