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
    private Integer firmId;
    private Integer wareId;
    private Double price;
    private Integer isDiscount;
    /** 操作者 */
    private Integer operateId;
    /** 操作时间 */
    private Date operateDate;

    private WareInfo wareInfo;

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


    public Integer getFirmId() {
        return firmId;
    }

    public void setFirmId(Integer firmId) {
        this.firmId = firmId;
    }

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount;
    }

    public WareInfo getWareInfo() {
        return wareInfo;
    }

    public void setWareInfo(WareInfo wareInfo) {
        this.wareInfo = wareInfo;
    }

    @Override
    public String toString() {
        return "ChannelGroup [channelGroupId=" + channelGroupId
                + ", channelGroupName=" + channelGroupName + ", firmId="
                + firmId + ", wareId=" + wareId + ", price=" + price
                + ", isDiscount=" + isDiscount + ", operateId=" + operateId
                + ", operateDate=" + operateDate + "]";
    }

}
