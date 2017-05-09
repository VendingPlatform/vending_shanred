package com.vending.platform.domain;

public class ChannelWareInfo {

    private Integer channelId;
    private Integer wareId;
    private Double price;
    private Integer isDiscount;
    private Integer mOperaterId;

    private ChannelInfo channelInfo;
    private WareInfo wareInfo;

    public ChannelWareInfo() {
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
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

    public Integer getmOperaterId() {
        return mOperaterId;
    }

    public void setmOperaterId(Integer mOperaterId) {
        this.mOperaterId = mOperaterId;
    }

    public ChannelInfo getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }

    public WareInfo getWareInfo() {
        return wareInfo;
    }

    public void setWareInfo(WareInfo wareInfo) {
        this.wareInfo = wareInfo;
    }

    @Override
    public String toString() {
        return "ChannelWareInfo [channelId=" + channelId + ", wareId=" + wareId
                + ", price=" + price + ", isDiscount=" + isDiscount + "]";
    }
}
