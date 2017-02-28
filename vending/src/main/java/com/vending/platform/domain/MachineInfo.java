package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Machine_Info映射表：售货机信息表
 * 
 * @author Miley_Ren
 */
public class MachineInfo implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 8140170825790827210L;

	/** 售货机ID */
	private Integer machineId;
	/** 售货机名牌号 */
	private String machineName;
	/** 售货机主板号 */
	private String machinePannel;
	/** 厂商ID */
	private Integer manuFirmId;
	/** 售货机价格 */
	private double machinePrice;
	/** 售货机类型 */
	private String tModelName;
	/** 售货机出售状态 ：0：未售出；1：售出；2：回收 */
	private Integer manuMachineStatus;
	/** 卖给某运营商 */
	private Integer operFirmId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	public MachineInfo() {
		super();
	}

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getMachinePannel() {
		return machinePannel;
	}

	public void setMachinePannel(String machinePannel) {
		this.machinePannel = machinePannel;
	}

	public Integer getManuFirmId() {
		return manuFirmId;
	}

	public void setManuFirmId(Integer manuFirmId) {
		this.manuFirmId = manuFirmId;
	}

	public double getMachinePrice() {
		return machinePrice;
	}

	public void setMachinePrice(double machinePrice) {
		this.machinePrice = machinePrice;
	}

	public String gettModelName() {
		return tModelName;
	}

	public void settModelName(String tModelName) {
		this.tModelName = tModelName;
	}

	public Integer getManuMachineStatus() {
		return manuMachineStatus;
	}

	public void setManuMachineStatus(Integer manuMachineStatus) {
		this.manuMachineStatus = manuMachineStatus;
	}

	public Integer getOperFirmId() {
		return operFirmId;
	}

	public void setOperFirmId(Integer operFirmId) {
		this.operFirmId = operFirmId;
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
		return "MachineInfo [machineId=" + machineId + ", machineName=" + machineName + ", machinePannel="
				+ machinePannel + ", manuFirmId=" + manuFirmId + ", machinePrice=" + machinePrice + ", tModelName="
				+ tModelName + ", manuMachineStatus=" + manuMachineStatus + ", operFirmId=" + operFirmId
				+ ", operateId=" + operateId + ", operateDate=" + operateDate + "]";
	}

}
