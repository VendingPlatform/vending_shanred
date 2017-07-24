package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Channel_Info:货道信息
 * 
 * @author Miley_Ren
 */
public class ChannelInfo implements Serializable {

    /** 序列号 */
    private static final long serialVersionUID = 8761114712738792976L;
    /** 货道ID */
    private Integer channelId;
    /** 货道编号 */
    private String channelNo;
    /** 额定存货量 */
    private Integer stockNum;
    /** 当前存货量 */
    private Integer stockNumNow;
    /** 新增存货量 */
    private Integer stockNumAdd;
    /** 所属货道组ID */
    private Integer channelGroupId;
    /** 所属售货机 */
    private Integer mOperaterId;
    private Integer machineId;
    private Integer firmId;
    /** 操作者 */
    private Integer operateId;
    /** 操作时间 */
    private Date operateDate;

    private MachineInfo machineInfo;
    private MachineOperater machineOperater;


    public ChannelInfo() {
    	super();
	}
    
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getStockNumNow() {
        return stockNumNow;
    }

    public void setStockNumNow(Integer stockNumNow) {
        this.stockNumNow = stockNumNow;
    }

    public Integer getStockNumAdd() {
        return stockNumAdd;
    }

    public void setStockNumAdd(Integer stockNumAdd) {
        this.stockNumAdd = stockNumAdd;
    }

    public Integer getChannelGroupId() {
        return channelGroupId;
    }

    public void setChannelGroupId(Integer channelGroupId) {
        this.channelGroupId = channelGroupId;
    }

    public Integer getmOperaterId() {
        return mOperaterId;
    }

    public void setmOperaterId(Integer mOperaterId) {
        this.mOperaterId = mOperaterId;
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

    public MachineOperater getMachineOperater() {
        return machineOperater;
    }

    public void setMachineOperater(MachineOperater machineOperater) {
        this.machineOperater = machineOperater;
    }

    public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public MachineInfo getMachineInfo() {
		return machineInfo;
	}

	public void setMachineInfo(MachineInfo machineInfo) {
		this.machineInfo = machineInfo;
	}

	public Integer getFirmId() {
        return firmId;
    }

    public void setFirmId(Integer firmId) {
        this.firmId = firmId;
    }

    @Override
    public String toString() {
        return "ChannelInfo [channelId=" + channelId + ", channelNo="
                + channelNo + ", stockNum=" + stockNum + ", stockNumNow="
                + stockNumNow + ", stockNumAdd=" + stockNumAdd
                + ", channelGroupId=" + channelGroupId + ", mOperaterId="
                + mOperaterId + ", operateId=" + operateId + ", operateDate="
                + operateDate + "]";
    }

}
