package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;

/** 使用SQL构建器进行复杂语句的构建 */
public class IMachineSqlProvider {

	public String insertMachineOperate(MachineOperater machineOperater) {
		return new SQL() {
			{
				INSERT_INTO("machineoperater");
				if (machineOperater != null && machineOperater.getMachineId() != null) {
					VALUES("machineId", "'" + machineOperater.getMachineId() + "'");
					VALUES("machineName", "'" + machineOperater.getMachineName() + "'");
					VALUES("machinePannel", "'" + machineOperater.getMachinePannel() + "'");
					VALUES("tModelName", "'" + machineOperater.gettModelName() + "'");
					if (machineOperater.getMachineAssign() != null) {
						VALUES("machineAssign", "'" + machineOperater.getMachineAssign() + "'");
					}
					if (machineOperater.getMachineStatus() != null) {
						VALUES("machineStatus", "'" + machineOperater.getMachineStatus() + "'");
					}
					if (machineOperater.getOperFirmId() != null) {
						VALUES("operFirmId", "'" + machineOperater.getOperFirmId() + "'");
					}
					if (machineOperater.getOperateId() != null) {
						VALUES("operateId", "'" + machineOperater.getOperateId() + "'");
					}
					VALUES("operateDate", "(select now())");
				}
			}
		}.toString();
	}

	public String deleteMachineOperateById(Integer machinId) {
		return new SQL() {
			{
				DELETE_FROM("machineoperater");
				WHERE("mOperaterId=" + machinId);
			}
		}.toString();
	}

	public String updateMachineOperate(MachineOperater machineOperater) {
		return new SQL() {
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
					SET("operateDate=(select now())");

					WHERE("mOperaterId=" + machineOperater.getmOperaterId());
				}
			}
		}.toString();
	}

	public String getMachineOperaterById(Integer id) {
		return "SELECT * FROM machineoperater WHERE mOperaterId=" + id;
	}

	public String getAllMachineOperaters(UserInfo userInfo, MachineOperater machineOperater) {
		return new SQL() {
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
	}

	public String getMachineInfoById(Integer id) {
		return "SELECT * FROM machineinfo WHERE machineId=" + id;
	}
}
