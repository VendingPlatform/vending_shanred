package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.vending.platform.domain.MachineOperater;

/**
 * 售貨机dao
 * 
 * 1、售货机分组管理 ;<br>
 * 2、售货机分配 ;<br>
 * 3、售货机货道<br>
 */
public interface IMachineDAO {

	/**
	 * 售货机查询
	 * 
	 * @param operater
	 *            查询条件，售货机查询条件
	 * @return List<T_Machine_Operater> 返回T_Machine_Operater的列表
	 */
	public List<MachineOperater> getmachineOperater(MachineOperater operater);

}
