package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Oper_Mgr运营商管理映射类，为厂商所用，映射了与厂商有合作的运营商
 * 
 * @author Miley_Ren
 */
public class OperMgr implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = -6417710404887297902L;
	/** 主键 */
	private Integer operMgrId;
	/** 公司编号 */
	private String firmNo;
	/** 运营商ID */
	private Integer firmId;
	/** 运营商名称 */
	private String firmName;
	/** 厂商ID */
	private Integer manuId;
	/** 厂商名 */
	private String manuName;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	public OperMgr() {
		super();
	}

	public Integer getOperMgrId() {
		return operMgrId;
	}

	public void setOperMgrId(Integer operMgrId) {
		this.operMgrId = operMgrId;
	}

	public String getFirmNo() {
		return firmNo;
	}

	public void setFirmNo(String firmNo) {
		this.firmNo = firmNo;
	}

	public Integer getFirmId() {
		return firmId;
	}

	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public Integer getManuId() {
		return manuId;
	}

	public void setManuId(Integer manuId) {
		this.manuId = manuId;
	}

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
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
		return "OperMgr [operMgrId=" + operMgrId + ", firmId=" + firmId + ", firmName=" + firmName + ", manuId="
				+ manuId + ", manuName=" + manuName + ", operateId=" + operateId + ", operateDate=" + operateDate + "]";
	}

}
