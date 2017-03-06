package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;

/** 使用SQL构建器进行复杂语句的构建 */
public class IMachineSqlProvider {

	/****** 各种更新操作的SQL语句需判断是否提供了操作者ID ********/
	/**************************************************/
	/******** 思考是否可以把所有的更新操作整合到一个接口 *********************/
	public String updateMachineGroup(Integer groupId, Integer mOperateId) {
		return new SQL() {
			{
				UPDATE("machineoperater");
				SET("groupId=" + groupId);
				WHERE("mOperaterId=" + mOperateId);
			}
		}.toString();
	}

	public String changeMachineStatus(int status, Integer mOperateId) {
		return new SQL() {
			{
				UPDATE("machineoperater");
				if (status == 1) {
					// 由可用变为不可用
					SET("machineStatus=0");
				} else if (status == 0) {
					SET("machineStatus=1");
				}
				WHERE("mOperaterId=" + mOperateId);
			}
		}.toString();
	}

	public String getMachineOperaterById(Integer id) {
		return "SELECT * FROM machineoperater WHERE mOperaterId=" + id;
	}

	public String getAllMachine(UserInfo userInfo, MachineOperater machineOperater) {
		String SQL = null;
		SQL = new SQL() {
			{
				SELECT("*");
				FROM("machineoperater");
				if (machineOperater != null) {
					if (StringUtils.isNotBlank(machineOperater.getMachineName())) {
						WHERE("machineName='" + machineOperater.getMachineName() + "'");
					}
					if (StringUtils.isNotBlank(machineOperater.getMachinePannel())) {
						WHERE("machinePannel='" + machineOperater.getMachinePannel() + "'");
					}
					if (machineOperater.getMachineAssign() != null) {
						WHERE("machineAssign=" + machineOperater.getMachineAssign());
					}
					if (StringUtils.isNotBlank(machineOperater.gettModelName())) {
						WHERE("tModelName='" + machineOperater.gettModelName() + "'");
					}
				}
				WHERE("operFirmId=" + userInfo.getFirmId());
			}
		}.toString();
		return SQL;
	}

	public String getMachineInfoById(Integer id) {
		return "SELECT * FROM machineinfo WHERE machineId=" + id;
	}
}
