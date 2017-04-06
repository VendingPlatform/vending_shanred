/*
SQLyog Community v12.4.1 (64 bit)
MySQL - 5.5.54 : Database - vending
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

/*Table structure for table `channelgroup` */

DROP TABLE IF EXISTS `channelgroup`;

CREATE TABLE `channelgroup` (
  `channelGroupId` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道组id',
  `channelGroupName` varchar(50) NOT NULL DEFAULT 'null' COMMENT '货道组名称',
  `wareCode` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `wareName` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `warePrice` double DEFAULT NULL COMMENT '商品价格',
  `isDiscount` int(1) DEFAULT NULL COMMENT '是否特价',
  `groupId` int(11) DEFAULT NULL COMMENT '所属售货机组',
  `operateId` int(11) DEFAULT NULL COMMENT '操作人',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`channelGroupId`),
  KEY `groupId` (`groupId`),
  CONSTRAINT `t_channel_group_ibfk_1` FOREIGN KEY (`groupId`) REFERENCES `groupinfo` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `channelgroup` */

/*Table structure for table `channelinfo` */

DROP TABLE IF EXISTS `channelinfo`;

CREATE TABLE `channelinfo` (
  `channelId` int(11) NOT NULL AUTO_INCREMENT COMMENT '货道id',
  `channelNo` varchar(50) NOT NULL DEFAULT 'null' COMMENT '货道编号',
  `wareCode` varchar(50) NOT NULL DEFAULT 'null' COMMENT '商品编号',
  `wareName` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `warePrice` double DEFAULT NULL COMMENT '商品价格',
  `isDiscount` int(11) DEFAULT NULL COMMENT '是否特价',
  `stockNum` int(11) NOT NULL DEFAULT '0' COMMENT '额定存货量',
  `stockNumnNow` int(11) DEFAULT NULL COMMENT '当前存货量',
  `stockNumnAdd` int(11) DEFAULT NULL COMMENT '新增存货量',
  `channelGroupId` int(11) DEFAULT NULL COMMENT '所属货道组id',
  `machineId` int(11) DEFAULT NULL COMMENT '所属售货机id',
  `isHistory` int(1) NOT NULL DEFAULT '0' COMMENT '是否为历史信息',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`channelId`),
  KEY `channelGroupId` (`channelGroupId`),
  KEY `machineId` (`machineId`),
  CONSTRAINT `t_channel_info_ibfk_1` FOREIGN KEY (`channelGroupId`) REFERENCES `channelgroup` (`channelGroupId`),
  CONSTRAINT `t_channel_info_ibfk_2` FOREIGN KEY (`machineId`) REFERENCES `machineinfo` (`machineId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `channelinfo` */

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `firminfo` */

insert  into `firminfo`(`firmId`,`firmNo`,`firmName`,`firmDesc`,`firmType`,`firmStatus`,`operateId`,`operateDate`) values 
(1,'000','system','system',0,1,1,'2017-02-27 12:13:38'),
(2,'001','运营商1','运营商1的描述信息_update',1,1,1,'2017-03-30 21:38:42'),
(3,'002','厂商','厂商1的描述信息',2,1,1,'2017-02-27 17:00:49'),
(4,'003','运营商2','运营商2描述',1,1,1,'2017-03-30 22:09:48'),
(21,'004','004','004',2,1,1,'2017-03-30 23:18:09');

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
  KEY `firmId` (`firmId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `groupinfo` */

insert  into `groupinfo`(`groupId`,`groupName`,`groupType`,`groupDesc`,`firmId`,`operateId`,`operateDate`) values 
(1,'system',0,'系统管理员分组，此分组用作区分用户角色',1,1,'2017-03-20 16:59:54'),
(2,'售货机组1',2,'售货机组1测试',2,1,'2017-03-27 11:19:08'),
(30,'售货机组测试1',2,'测试',2,2,'2017-03-20 23:33:03'),
(31,'售货机组测试2',2,'测试2\r\n',2,2,'2017-03-23 21:14:47');

/*Table structure for table `machineinfo` */

DROP TABLE IF EXISTS `machineinfo`;

CREATE TABLE `machineinfo` (
  `machineId` int(11) NOT NULL AUTO_INCREMENT COMMENT '售货机id',
  `machineName` varchar(100) NOT NULL COMMENT '售货机铭牌号',
  `machinePannel` varchar(50) NOT NULL COMMENT '售货机主板号',
  `manuFirmId` int(11) NOT NULL COMMENT '厂商ID',
  `machinePrice` decimal(10,0) DEFAULT NULL COMMENT '售货机价格',
  `tModelName` varchar(20) DEFAULT NULL COMMENT '售货机类型/型号',
  `manuMachineStatus` int(11) NOT NULL DEFAULT '0' COMMENT '0:未售出，1：已售出，2：回收',
  `operFirmId` int(11) DEFAULT NULL COMMENT '卖给某运营商ID',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`machineId`),
  KEY `manuFirmId` (`manuFirmId`),
  KEY `operFirmId` (`operFirmId`),
  CONSTRAINT `t_machine_info_ibfk_1` FOREIGN KEY (`manuFirmId`) REFERENCES `firminfo` (`firmId`),
  CONSTRAINT `t_machine_info_ibfk_2` FOREIGN KEY (`operFirmId`) REFERENCES `firminfo` (`firmId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `machineinfo` */

insert  into `machineinfo`(`machineId`,`machineName`,`machinePannel`,`manuFirmId`,`machinePrice`,`tModelName`,`manuMachineStatus`,`operFirmId`,`operateId`,`operateDate`) values 
(1,'售货机名牌1','售货机主板1',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),
(2,'售货机名牌2','售货机主板2',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),
(3,'售货机名牌3','售货机主板3',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),
(4,'售货机名牌4','售货机主板4',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),
(5,'售货机测试1','测试1',3,12222,'类型1',1,2,3,'2017-04-05 22:01:27'),
(6,'售货机测试2','测试2',3,2333,'类型1',1,2,3,'2017-04-05 22:01:42'),
(7,'test1','test1',3,32,'类型1',1,2,3,'2017-04-05 22:02:19'),
(8,'test2','test2',3,233,'类型2',1,2,3,'2017-04-05 22:02:31');

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
  CONSTRAINT `machineoperater_ibfk_1` FOREIGN KEY (`machineId`) REFERENCES `machineinfo` (`machineId`),
  CONSTRAINT `MachineOperater_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`),
  CONSTRAINT `MachineOperater_ibfk_3` FOREIGN KEY (`groupId`) REFERENCES `groupinfo` (`groupId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `machineoperater` */

insert  into `machineoperater`(`mOperaterId`,`machineId`,`machineAssign`,`userId`,`machineAddress`,`groupId`,`operFirmId`,`operateId`,`operateDate`) values 
(1,1,0,NULL,'普陀修改q',2,2,2,'2017-04-04 15:03:10'),
(2,2,0,NULL,'普陀',2,2,3,'2017-02-27 21:02:07'),
(3,3,0,NULL,'华师大',2,2,2,'2017-04-05 22:13:16'),
(4,4,0,NULL,'闵行',2,2,2,'2017-04-05 22:13:16'),
(5,5,0,NULL,NULL,NULL,2,NULL,'2017-04-05 22:01:59'),
(6,6,0,NULL,NULL,NULL,2,NULL,'2017-04-05 22:02:03'),
(7,7,0,NULL,NULL,NULL,2,NULL,'2017-04-05 22:02:36'),
(8,8,0,NULL,NULL,NULL,2,NULL,'2017-04-05 22:02:45');

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
  CONSTRAINT `MachineType_ibfk_1` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `machinetype` */

insert  into `machinetype`(`tModelId`,`tModelName`,`firmId`,`operateId`,`operateDate`) values 
(1,'类型1',3,1,'2017-02-27 17:07:25'),
(2,'类型2',3,1,'2017-03-16 23:08:23');

/*Table structure for table `opermgr` */

DROP TABLE IF EXISTS `opermgr`;

CREATE TABLE `opermgr` (
  `operMgrId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `firmNo` varchar(50) NOT NULL COMMENT '公司编号',
  `firmId` int(11) NOT NULL COMMENT '合作的运营商id',
  `firmName` varchar(80) NOT NULL COMMENT '运营商姓名',
  `manuId` int(11) NOT NULL COMMENT '厂商ID',
  `manuName` varchar(50) DEFAULT NULL COMMENT '厂商姓名',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`operMgrId`),
  KEY `firmId` (`firmId`),
  KEY `OperMgr_ibfk_2` (`manuId`),
  CONSTRAINT `OperMgr_ibfk_1` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`),
  CONSTRAINT `OperMgr_ibfk_2` FOREIGN KEY (`manuId`) REFERENCES `firminfo` (`firmId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `opermgr` */

insert  into `opermgr`(`operMgrId`,`firmNo`,`firmId`,`firmName`,`manuId`,`manuName`,`operateId`,`operateDate`) values 
(5,'001',2,'运营商1',3,'厂商',3,'2017-04-05 22:00:54'),
(6,'003',4,'运营商2',3,'厂商',3,'2017-04-05 22:00:54');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `roleauth` */

insert  into `roleauth`(`roleAuthId`,`roleId`,`authId`) values 
(1,1,1),
(2,2,2),
(3,3,3),
(4,9,4),
(5,2,4);

/*Table structure for table `roleinfo` */

DROP TABLE IF EXISTS `roleinfo`;

CREATE TABLE `roleinfo` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色id',
  `roleName` varchar(50) NOT NULL COMMENT '角色名称（唯一）',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0：不可用；1：可用',
  `firmId` int(11) DEFAULT NULL COMMENT '所属公司',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者(用户id)',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `roleinfo` */

insert  into `roleinfo`(`roleId`,`roleName`,`status`,`firmId`,`operateId`,`operateDate`) values 
(1,'system',1,1,1,'2017-02-27 12:54:59'),
(2,'oper_admin',1,2,1,'2017-02-27 16:10:10'),
(3,'manu_admin',1,3,1,'2017-02-27 17:03:15'),
(9,'group_admin',1,2,1,'2017-04-06 16:03:17');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `userNo` varchar(15) NOT NULL COMMENT '用户编号（用员工号进行登陆）',
  `userName` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `mobilePhone` char(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT 'email',
  `roleId` int(11) NOT NULL COMMENT '角色id(角色不为空)',
  `groupId` int(11) DEFAULT NULL COMMENT '用户组id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态，0：不可用，1：可用',
  `firmId` int(11) NOT NULL COMMENT '所属公司（系统管理员属于单独的公司）',
  `parentUserId` int(11) DEFAULT NULL COMMENT '父管理员id（默认为自己）',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  KEY `groupId` (`groupId`),
  KEY `firmId` (`firmId`),
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `roleinfo` (`roleId`),
  CONSTRAINT `userinfo_ibfk_2` FOREIGN KEY (`groupId`) REFERENCES `groupinfo` (`groupId`),
  CONSTRAINT `userinfo_ibfk_3` FOREIGN KEY (`firmId`) REFERENCES `firminfo` (`firmId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userId`,`userNo`,`userName`,`password`,`mobilePhone`,`email`,`roleId`,`groupId`,`status`,`firmId`,`parentUserId`,`operateDate`,`operateId`) values 
(1,'000','system','123456',NULL,NULL,1,1,1,1,1,'2017-02-27 12:58:14',1),
(2,'00101','user1','123',NULL,NULL,2,NULL,1,2,1,'2017-02-27 16:12:00',1),
(3,'00201','system001','123456',NULL,NULL,3,NULL,1,3,1,'2017-02-27 17:04:19',1),
(4,'00102','运营商user2','123455',NULL,NULL,2,1,1,2,1,NULL,1),
(5,'00401','system004','system004',NULL,NULL,3,NULL,1,21,NULL,'2017-03-30 23:18:11',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `userrole` */

insert  into `userrole`(`userRoleId`,`userId`,`roleId`) values 
(1,1,1),
(2,2,2),
(3,3,3),
(4,4,2),
(5,5,3),
(6,2,9);

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
  `wareStatus` int(1) NOT NULL COMMENT '是否可用',
  `firmId` int(11) DEFAULT NULL COMMENT '运营商id',
  `operateId` int(11) DEFAULT NULL COMMENT '操作者',
  `operateDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`wareId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wareinfo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
