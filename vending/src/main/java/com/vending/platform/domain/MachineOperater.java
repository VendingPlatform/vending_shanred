package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 售货机详细信息表，记录在运营商处的分配
 * 
 * @author Miley_Ren
 */
public class MachineOperater implements Serializable {
	/** 序列号 */
	private static final long serialVersionUID = -4564690143409202140L;
	/** 售货机信息ID */
	private Integer mOperaterId;
	/** 售货机ID */
	private Integer machineId;
	/** 是否分配：0：未分配；1：已分配 */
	private Integer machineAssign;
	/** 售货机类型 */
	private String tModelName;
	/** 分配给某员工 */
	private Integer userId;
	/** 售货机详细地址 */
	private String machineAddress;
	/** 售货机是否可用：0：不可用；1：可用 */
	private Integer machineStatus;
	/** 所属售货机组 */
	private Integer groupId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	public MachineOperater() {
		super();
	}

	public Integer getmOperaterId() {
		return mOperaterId;
	}

	public void setmOperaterId(Integer mOperaterId) {
		this.mOperaterId = mOperaterId;
	}

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public Integer getMachineAssign() {
		return machineAssign;
	}

	public void setMachineAssign(Integer machineAssign) {
		this.machineAssign = machineAssign;
	}

	public String gettModelName() {
		return tModelName;
	}

	public void settModelName(String tModelName) {
		this.tModelName = tModelName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMachineAddress() {
		return machineAddress;
	}

	public void setMachineAddress(String machineAddress) {
		this.machineAddress = machineAddress;
	}

	public Integer getMachineStatus() {
		return machineStatus;
	}

	public void setMachineStatus(Integer machineStatus) {
		this.machineStatus = machineStatus;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "MachineOperater [mOperaterId=" + mOperaterId + ", machineId=" + machineId + ", machineAssign="
				+ machineAssign + ", tModelName=" + tModelName + ", userId=" + userId + ", machineAddress="
				+ machineAddress + ", machineStatus=" + machineStatus + ", groupId=" + groupId + ", operateId="
				+ operateId + ", operateDate=" + operateDate + "]";
	}

}
