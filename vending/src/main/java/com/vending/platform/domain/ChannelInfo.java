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
	/**商品编号*/
	private String wareCode;
	/** 商品名称 */
	private String wareName;
	/** 商品价格 */
	private double warePrice;
	/** 是否特价 */
	private int isDiscount;
	/** 额定存货量 */
	private Integer stockNum;
	/** 当前存货量 */
	private Integer stockNumNow;
	/** 新增存货量 */
	private Integer stockNumAdd;
	/**所属货道组ID*/
	private Integer channelGroupId;
	/** 所属售货机 */
	private Integer machineId;
	/** 是否为历史信息：0：否；1：是 */
	private Integer isHistory;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

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

	public String getWareCode() {
		return wareCode;
	}

	public void setWareCode(String wareCode) {
		this.wareCode = wareCode;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public double getWarePrice() {
		return warePrice;
	}

	public void setWarePrice(double warePrice) {
		this.warePrice = warePrice;
	}

	public int getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
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

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public Integer getIsHistory() {
		return isHistory;
	}

	public void setIsHistory(Integer isHistory) {
		this.isHistory = isHistory;
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
		return "ChannelInfo [channelId=" + channelId + ", channelNo=" + channelNo + ", wareCode=" + wareCode
				+ ", wareName=" + wareName + ", warePrice=" + warePrice + ", isDiscount=" + isDiscount + ", stockNum="
				+ stockNum + ", stockNumNow=" + stockNumNow + ", stockNumAdd=" + stockNumAdd + ", machineId="
				+ machineId + ", isHistory=" + isHistory + ", operateId=" + operateId + ", operateDate=" + operateDate
				+ "]";
	}

}
