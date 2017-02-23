/* 测试信息表 */
/*Table structure for table `t_user` */

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
