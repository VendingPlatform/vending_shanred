package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * T_Ware_Info:商品信息表
 *
 * @author Miley_Ren
 */
public class WareInfo implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = -3601449521375525963L;

    /** 商品ID */
    private Integer wareId;
    /** 商品编号 */
    private String wareCode;
    /** 商品名称 */
    private String wareName;
    /** 商品规格，如：每箱多少瓶 */
    private String wareNorm;
    /** 商品单位 */
    private String wareUnit;
    /** 商品进价 */
    private Double wareBasePrice;
    /** 最高售价 */
    private Double wareMaxPrice;
    /** 最低售价 */
    private Double wareMinPrice;
    /** 商品描述 */
    private String wareDesc;
    /** 所属运营商ID */
    private Integer firmId;
    /** 商品状态：0：可用；1：不可用 */
    /** 操作者 */
    private Integer operateId;
    /** 操作时间 */
    private Date operateDate;

    private FirmInfo firmInfo;
    private List<ChannelWareInfo> channelWareInfos;
    private List<ChannelGroup> channelGroups;
    
    private List<Shipments> shipmentses;
    
    
    public WareInfo() {
        super();
    }

    public Integer getWareId() {
        return wareId;
    }

    public void setWareId(Integer wareId) {
        this.wareId = wareId;
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

    public String getWareNorm() {
        return wareNorm;
    }

    public void setWareNorm(String wareNorm) {
        this.wareNorm = wareNorm;
    }

    public String getWareUnit() {
        return wareUnit;
    }

    public void setWareUnit(String wareUnit) {
        this.wareUnit = wareUnit;
    }

    public Double getWareBasePrice() {
        return wareBasePrice;
    }

    public void setWareBasePrice(Double wareBasePrice) {
        this.wareBasePrice = wareBasePrice;
    }

    public Double getWareMaxPrice() {
        return wareMaxPrice;
    }

    public void setWareMaxPrice(Double wareMaxPrice) {
        this.wareMaxPrice = wareMaxPrice;
    }

    public Double getWareMinPrice() {
        return wareMinPrice;
    }

    public void setWareMinPrice(Double wareMinPrice) {
        this.wareMinPrice = wareMinPrice;
    }

    public String getWareDesc() {
        return wareDesc;
    }

    public void setWareDesc(String wareDesc) {
        this.wareDesc = wareDesc;
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

    public List<ChannelWareInfo> getChannelWareInfos() {
        return channelWareInfos;
    }

    public void setChannelWareInfos(List<ChannelWareInfo> channelWareInfos) {
        this.channelWareInfos = channelWareInfos;
    }

    public List<ChannelGroup> getChannelGroups() {
        return channelGroups;
    }

    public void setChannelGroups(List<ChannelGroup> channelGroups) {
        this.channelGroups = channelGroups;
    }

	public List<Shipments> getShipmentses() {
		return shipmentses;
	}

	public void setShipmentses(List<Shipments> shipmentses) {
		this.shipmentses = shipmentses;
	}

	@Override
    public String toString() {
        return "WareInfo [wareId=" + wareId + ", wareCode=" + wareCode
                + ", wareName=" + wareName + ", wareNorm=" + wareNorm
                + ", wareUnit=" + wareUnit + ", wareBasePrice=" + wareBasePrice
                + ", wareMaxPrice=" + wareMaxPrice + ", wareMinPrice="
                + wareMinPrice + ", wareDesc=" + wareDesc + ", firmId=" + firmId
                + ", operateId=" + operateId + ", operateDate=" + operateDate
                + ", firmInfo=" + firmInfo + "]";
    }

}
