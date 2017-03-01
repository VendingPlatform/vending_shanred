package com.vending.platform.dao.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.MachineOperater;

/** 使用SQL构建器进行复杂语句的构建 */
public class IMachineSqlProvider {
	/**
	 * 测试Sql构建器
	 */
	public String getmachineOperater(MachineOperater operater) {
		return new SQL().SELECT("*").FROM("MachineOperater").toString();
	}
}
