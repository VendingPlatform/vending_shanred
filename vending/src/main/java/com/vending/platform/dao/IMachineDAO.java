package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.vending.platform.domain.MachineOperater;

/**
 * 售貨机DAO
 * 
 * 1、售货机分组管理 ;<br>
 * 2、售货机分配 ;<br>
 * 3、售货机货道管理<br>
 */
public interface IMachineDAO {
	/**
	 * 售货机查询
	 * 
	 * @param operater
	 *            查询条件，售货机查询条件
	 * @return List<T_Machine_Operater> 返回T_Machine_Operater的列表
	 */
	@Select("SELECT * FROM MachineOperater where mOperaterId=#{operater.mOperaterId}")
	public List<MachineOperater> getmachineOperater(@Param("operater") MachineOperater operater);

}
