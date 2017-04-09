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
    /** 运营商ID */
    private Integer firmId;
    /** 厂商ID */
    private Integer manuId;
    /** 操作者 */
    private Integer operateId;
    /** 操作时间 */
    private Date operateDate;

    private FirmInfo operFirm;
    private FirmInfo manuFirm;

    public OperMgr() {
        super();
    }

    public Integer getOperMgrId() {
        return operMgrId;
    }

    public void setOperMgrId(Integer operMgrId) {
        this.operMgrId = operMgrId;
    }

    public Integer getFirmId() {
        return firmId;
    }

    public void setFirmId(Integer firmId) {
        this.firmId = firmId;
    }

    public Integer getManuId() {
        return manuId;
    }

    public void setManuId(Integer manuId) {
        this.manuId = manuId;
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


    public FirmInfo getOperFirm() {
        return operFirm;
    }

    public void setOperFirm(FirmInfo operFirm) {
        this.operFirm = operFirm;
    }

    public FirmInfo getManuFirm() {
        return manuFirm;
    }

    public void setManuFirm(FirmInfo manuFirm) {
        this.manuFirm = manuFirm;
    }

    @Override
    public String toString() {
        return "OperMgr [operMgrId=" + operMgrId + ", firmId=" + firmId
                + ", manuId=" + manuId + ", operateId=" + operateId
                + ", operateDate=" + operateDate + ", operFirm=" + operFirm
                + ", manuFirm=" + manuFirm + "]";
    }

}
