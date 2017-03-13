package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.IWareManagerSqlProvider;
import com.vending.platform.domain.WareInfo;

/**
 * 商品管理DAO<br>
 * 1、商品信息管理<br>
 */
public interface IWareManagerDAO {
	/** 添加商品 */
	@SelectProvider(type = IWareManagerSqlProvider.class, method = "inserWareInfo")
	public void inserWareInfo(WareInfo wareInfo);

	/** 修改商品 */
	@SelectProvider(type = IWareManagerSqlProvider.class, method = "updateWareInfo")
	public void updateWareInfo(WareInfo wareInfo);

	/** 按条件查询所有商品 */
	@SelectProvider(type = IWareManagerSqlProvider.class, method = "getAllWareInfos")
	public List<WareInfo> getAllWareInfos(WareInfo wareInfo);

	/** 按Id查询商品 */
	@SelectProvider(type = IWareManagerSqlProvider.class, method = "getWareInfoById")
	public WareInfo getWareInfoById(Integer wareId);

	/** 删除商品 */
	@SelectProvider(type = IWareManagerSqlProvider.class, method = "deleteWareInfo")
	public void deleteWareInfo(Integer wareId);

}
