package com.vending.platform.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectProvider;
import com.vending.platform.dao.sqlprovider.FirmAndGroupSqlProvider;
import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.GroupInfo;

/**
 * 公司及分组信息管理<br>
 * 1、公司信息管理 <br>
 * 2、分组管理<br>
 * 
 * @author Miley_Ren<br>
 */
public interface IFrimAndGroupDAO {
	/** 增加公司信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "insertFirm")
	public void insertFirm(FirmInfo firmInfo);

	/** 修改公司信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "updateFirm")
	public void updateFirm(FirmInfo firmInfo);

	/** 按条件查找所有公司信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "getAllFirmInfos")
	public List<FirmInfo> getAllFirmInfos(FirmInfo firmInfo);

	/** 按Id查找公司 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "getFirmInfoById")
	public FirmInfo getFirmInfoById(Integer firmId);

	/** 删除公司信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "deleteFirmInfo")
	public void deleteFirmInfo(Integer firmId);

	/** 增加分组信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "insertGroupInfo")
	public void insertGroupInfo(GroupInfo groupInfo);

	/** 更新分组信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "updateGroupInfo")
	public void updateGroupInfo(GroupInfo groupInfo);

	/** 按条件查询分组信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "getAllGroupInfos")
	public List<GroupInfo> getAllGroupInfos(GroupInfo groupInfo);

	/** 按Id查看分组信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "getGroupInfoById")
	public GroupInfo getGroupInfoById(Integer groupId);

	/** 删除分组信息 */
	@SelectProvider(type = FirmAndGroupSqlProvider.class, method = "deleteGroupInfo")
	public void deleteGroupInfo(Integer integer);

}
