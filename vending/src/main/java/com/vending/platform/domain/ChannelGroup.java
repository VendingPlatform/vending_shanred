package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Channel_Group:货道组
 *
 * @author Miley_Ren
 **/
public class ChannelGroup implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = -759033563075067030L;
	/** 货道组ID */
	private Integer channelGroupId;
	/** 货道组名称 */
	private String channelGroupName;
	/** 商品编号 */
	private String wareCode;
	/** 商品名称 */
	private String wareName;
	/** 商品价格 */
	private double warePrice;
	/** 是否特价：0：否；1：是 */
	private Integer isDiscount;
	/** 所属售货机组 */
	private Integer groupId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	public ChannelGroup() {
		super();
	}

	public Integer getChannelGroupId() {
		return channelGroupId;
	}

	public void setChannelGroupId(Integer channelGroupId) {
		this.channelGroupId = channelGroupId;
	}

	public String getChannelGroupName() {
		return channelGroupName;
	}

	public void setChannelGroupName(String channelGroupName) {
		this.channelGroupName = channelGroupName;
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

	public Integer getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(Integer isDiscount) {
		this.isDiscount = isDiscount;
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
		return "ChannelGroup [channelGroupId=" + channelGroupId + ", channelGroupName=" + channelGroupName
				+ ", wareCode=" + wareCode + ", wareName=" + wareName + ", warePrice=" + warePrice + ", isDiscount="
				+ isDiscount + ", groupId=" + groupId + ", operateId=" + operateId + ", operateDate=" + operateDate
				+ "]";
	}

}
