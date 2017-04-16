package com.vending.platform.domain;

public class ChannelGroupWareInfo {

    private Integer channelGroupId;
    private Integer wareId;
    private Double price;
    private Integer isDiscount;

    public ChannelGroupWareInfo() {
        super();
    }

    public Integer getChannelGroupId() {
        return channelGroupId;
    }

    public void setChannelGroupId(Integer channelGroupId) {
        this.channelGroupId = channelGroupId;
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

}
