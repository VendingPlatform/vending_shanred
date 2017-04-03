package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Machine_Type：售货机类型
 * 
 * @author Miley_Ren
 */
public class MachineType implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 5344374703114752178L;
	/** 类型主键 */
	private Integer tModelId;
	/** 类型名称 */
	private String tModelName;
	/** 厂商ID */
	private Integer firmId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;
	private FirmInfo firmInfo;

	public MachineType() {
		super();
	}

    public Integer gettModelId() {
		return tModelId;
	}

	public void settModelId(Integer tModelId) {
		this.tModelId = tModelId;
	}

	public String gettModelName() {
		return tModelName;
	}

	public void settModelName(String tModelName) {
		this.tModelName = tModelName;
	}

	public Integer getFirmId() {
		return firmId;
	}

	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
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

	public FirmInfo getFirmInfo() {
		return firmInfo;
	}

	public void setFirmInfo(FirmInfo firmInfo) {
		this.firmInfo = firmInfo;
	}

	@Override
	public String toString() {
		return "MachineType [tModelId=" + tModelId + ", tModelName=" + tModelName + ", firmId=" + firmId
				+ ", operateId=" + operateId + ", operateDate=" + operateDate + "]";
	}
}
