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
	public String updateMachineOperate(MachineOperater machineOperater) {
		String SQL = new SQL() {
			{
				if (machineOperater != null && machineOperater.getmOperaterId() != null) {
					UPDATE("machineoperater");
					if (StringUtils.isNotBlank(machineOperater.getMachineName())) {
						SET("machineName='" + machineOperater.getMachineName() + "'");
					}
					if (StringUtils.isNotBlank(machineOperater.getMachinePannel())) {
						SET("machinePannel='" + machineOperater.getMachinePannel() + "'");
					}
					if (machineOperater.getMachineAssign() != null) {
						SET("machineAssign=" + machineOperater.getMachineAssign());
					}
					if (StringUtils.isNotBlank(machineOperater.gettModelName())) {
						SET("tModelName='" + machineOperater.gettModelName() + "'");
					}
					if (machineOperater.getUserId() != null) {
						SET("userId=" + machineOperater.getUserId());
					}
					if (StringUtils.isNotBlank(machineOperater.getMachineAddress())) {
						SET("machineAddress='" + machineOperater.getMachineAddress() + "'");
					}
					if (machineOperater.getMachineStatus() != null) {
						SET("machineStatus=" + machineOperater.getMachineStatus());
					}
					if (machineOperater.getGroupId() != null) {
						SET("groupId=" + machineOperater.getGroupId());
					}
					if (machineOperater.getOperFirmId() != null) {
						SET("operFirmId=" + machineOperater.getOperFirmId());
					}
					if (machineOperater.getOperateId() != null) {
						SET("operateId=" + machineOperater.getOperateId());
					}
					if (machineOperater.getOperateDate()!=null) {
						SET("operateDate='" + machineOperater.getOperateDate() + "'");

					}
					WHERE("mOperaterId=" + machineOperater.getmOperaterId());
				}
			}
		}.toString();
		return SQL;
	}

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
						WHERE("machineoperater.machineName='" + machineOperater.getMachineName() + "'");
					}
					if (StringUtils.isNotBlank(machineOperater.getMachinePannel())) {
						WHERE("machineoperater.machinePannel='" + machineOperater.getMachinePannel() + "'");
					}
					if (machineOperater.getMachineAssign() != null) {
						WHERE("machineoperater.machineAssign=" + machineOperater.getMachineAssign());
					}
					if (StringUtils.isNotBlank(machineOperater.gettModelName())) {
						WHERE("machineoperater.tModelName='" + machineOperater.gettModelName() + "'");
					}
				}
				WHERE("machineoperater.operFirmId=" + userInfo.getFirmId());
			}
		}.toString();
		return SQL;
	}

	public String getMachineInfoById(Integer id) {
		return "SELECT * FROM machineinfo WHERE machineId=" + id;
	}
}
