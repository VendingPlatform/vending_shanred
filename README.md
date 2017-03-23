vending_shanred_platform 
--------

     后端：Spring4.x+SpringMVC+Mybatis+Maven+Mysql 
     前端：bootstrap 
     sample文件中的test.sql文件为测试文件；Manufacturer.sql为厂商所用到的数据库

# 系统用户分为三大类： 
- 系统管理员：管理整个系统的用户、权限、厂商、运营商的管理等；
- 厂商管理员：厂商为售货机的生产商家，厂商主要对合作的商家进行管理、对售货机的类型及添加、删除售货机、售货机的分配（销售）与回收进行管理。
- 运营商管理员：运营商管理员主要对用户权限、用户角色进行管理，对售货机及加货销售等进行管理。
 
# 管理员权限设置：
```
    注：权限及权限名称在用户角色表（roleinfo）中的存储必须以分号进行分隔。
```
- 系统管理员权限编码：`000`,只要包含编码`000`就具有超级权限，可操作所有信息；
- 运营商管理员权限编码：`001`，只要包含编码`001`就具有运营商的超级权限，可操作所有运营商相关的信息。
    - 运营商小组管理员权限编码：`00101`，只要包含编码`00101`就具有该组内的最高权限，可操作改组内的所有相关信息。
    - 运营商一般管理员权限：`00102`，只要包含编码`00102`就只能操作与自己相关的信息。
- 厂商管理员权限编码：`002`,只要包含编码`002`就具有厂商管理的最高权限，可造作所有厂商相关的信息。

# 系统主要分为两个模块： 
  即厂商模块和运营商模块。
### 厂商（厂商管理员）：
 - 管理员工；
 - 管理合作的运营商；
 - 管理售货机类型；
 - 管理售货机，添加售货机时要进行类型的选择；
 - 售货机的分配与回收

### 运营商 （运营商管理员）：
 * 用户管理
     * 角色管理
     * 权限管理
     * 分组管理
        >- 售货机分组中，若查询未分组的售货机，在controller中将查询条件`groupId`置为`-1`,SQL构建器定义，若`groupId=-1`, 则将查询条件置为`groupId is null`.
        >- 将售货机从分组中移除，在controller中将查询条件`groupId`置为`-1`，同上
        >- 用户组操作同上
        
 * 售货机管理
     * 分组管理
     * 售货机分配（可按售货机组分配，也可单台分配）
     * 货道管理 
        - 货道组管理(售货机中放同样商品的货道为一个货道组，其具有相同的商品及定价)
        - 货道管理
 * 商品管理 
 * 库存管理
     * 库存查询（查询货道中商品的数量，即查询其中的信息，若缺货，则进行补货）
     * 补货操作
 * 订单管理
 * 财务管理
     * 上缴营业额
     * 利润清算
    
### PS:管理员权限
 * 修改密码
 * 退出登录

# 数据库初始值设置

 * 1、为firminfo插入三条数据：(系统管理员公司、厂商和普通运营商)
```
     insert  into `firminfo`(`firmId`,`firmNo`,`firmName`,`firmDesc`,`firmType`,`firmStatus`,`operateId`,`operateDate`) 
     values (1,'000','system','system',0,1,1,'2017-02-27 12:13:38'),
     (2,'001','运营商1','运营商1的描述信息',1,1,1,'2017-02-27 13:02:06'),
     (3,'002','厂商','厂商1的描述信息',2,1,1,'2017-02-27 17:00:49');
``` 
* 2、 为authorityinfo插入三条数据：系统管理员权限编码、厂商和普通公司超级管理员编码；
```
     insert  into `authorityinfo`(`authId`,`authName`,`authCode`,`operateId`,`operateDate`) 
     values (1,'system','000',1,'2017-02-27 12:55:37'),
     (2,'oper_admin','001',1,'2017-02-27 16:09:36'),
     (3,'manu_admin','002',1,'2017-02-27 17:02:29');
```    
* 3、为roleinfo插入两条数据：系统管理员角色、厂商和普通运营商超级管理员角色；（权限信息以分号间隔）
``` 
     insert  into `roleinfo`(`roleId`,`roleName`,`authorityCode`,`authorityName`,`status`,`firmId`,`operateId`,`operateDate`) 
     values (1,'system','000;','system;',1,NULL,1,'2017-02-27 12:54:59'),
     (2,'oper_admin','001;','firm_admin;',1,NULL,1,'2017-02-27 16:10:10'),
     (3,'manu_admin','002;','manu_admin;',1,NULL,1,'2017-02-27 17:03:15');
```
* 4、为userinfo添加两条数据：系统管理员、厂商普通运营商超级管理员
```
     insert  into `userinfo`(`userId`,`userNo`,`userName`,`password`,`mobilePhone`,`email`,`roleId`,`roleName`,`groupId`,`status`,`firmId`,`parentUserId`,`operateDate`,`operateId`) 
     values (1,'000','system','system',NULL,NULL,1,NULL,1,1,1,1,'2017-02-27 12:58:14',1),
     (2,'00101','运营商user1','123456',NULL,NULL,2,NULL,NULL,1,2,1,'2017-02-27 16:12:00',1),
     (3,'00201','厂商user1','123456',NULL,NULL,3,NULL,NULL,1,3,1,'2017-02-27 17:04:19',1),
     (4,'00102','运营商user2','123455',NULL,NULL,2,NULL,1,1,2,1,NULL,1);
```    
* 5、为machinetype添加一条数据
```
     insert  into `machinetype`(`tModelId`,`tModelName`,`firmId`,`operateId`,`operateDate`) 
     values (1,'类型1',3,1,'2017-02-27 17:07:25');
```
* 6、为machineinfo添加几条数据
```
     insert  into `machineinfo`(`machineId`,`machineName`,`machinePannel`,`manuFirmId`,`machinePrice`,`tModelName`,`manuMachineStatus`,`operFirmId`,`operateId`,`operateDate`) 
     values (1,'售货机名牌1','售货机主板1',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),
     (2,'售货机名牌2','售货机主板2',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),
     (3,'售货机名牌3','售货机主板3',3,30,'类型1',1,2,3,'2017-02-27 17:09:27'),
     (4,'售货机名牌4','售货机主板4',3,30,'类型1',1,2,3,'2017-02-27 17:09:27');
```
* 7、根据machineinfo,初始化machineOperater
```
     iinsert  into `machineoperater`(`mOperaterId`,`machineId`,`machineName`,`machinePannel`,`machineAssign`,`tModelName`,`userId`,`machineAddress`,`machineStatus`,`groupId`,`operFirmId`,`operateId`,`operateDate`) 
     values 
     (1,1,'售货机名牌1','售货机主板1',0,'类型1',NULL,'普陀修改',1,2,2,2,'2017-03-08 21:23:06'),
     (2,2,'售货机名牌2','售货机主板2',0,'类型1',NULL,'普陀',1,NULL,2,3,'2017-02-27 21:02:07'),
     (3,3,'售货机名牌3','售货机主板3',0,'类型1',NULL,'华师大',1,NULL,2,3,'2017-02-27 21:03:12'),
     (4,4,'售货机名牌4','售货机主板4',0,'类型1',NULL,'闵行',1,NULL,2,3,'2017-02-27 21:03:53');
```
# 测试使用注解的SQL的构建方式
* 1、一般注解
```
    @Select("SELECT * FROM MachineOperater where  mOperaterId=#{operater.mOperaterId}")
    public List<MachineOperater> getmachineOperater(MachineOperater operater);

```
* 2、动态SQL的注解方式http://www.mybatis.org/mybatis-3/zh/dynamic-sql.html
```
    @Select("<script>SELECT * FROM MachineOperater "
    + "<where>"
    + "<if test=\"#{operater}!=null\"> "
    + "<if test=\"#{operater.mOperaterId}!=null\"> "
    + "mOperaterId=#{operater.mOperaterId} "
    + "</if></if>"
    + "</where> "
    + "</script>")
    public List<MachineOperater> getmachineOperater(@Param("operater") MachineOperater operater) ;
```
* 3、SQL语句构建器http://www.mybatis.org/mybatis-3/zh/statement-builders.html
     
     使用mybatis3.4.2，mybatis-spring1.3.1
```
    构建器类IMachineSqlProvider
    public class IMachineSqlProvider {
       /**
       * 测试Sql构建器
        */
      public String getmachineOperater(MachineOperater operater) {
          return new SQL().SELECT("*").FROM("MachineOperater").toString();
      }
      DAO接口IMachineDAO
    public interface IMachineDAO {
    @SelectProvider(type = IMachineSqlProvider.class, method = "getmachineOperater")
    public List<MachineOperater> getmachineOperater(MachineOperater operater);
    }
```

### 获取数据库时间
```
    （SELECT NOW()）
```
