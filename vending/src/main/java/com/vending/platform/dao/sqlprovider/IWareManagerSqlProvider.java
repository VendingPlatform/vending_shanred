package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.Shipments;
import com.vending.platform.domain.WareInfo;

public class IWareManagerSqlProvider {
	public String insertWareInfo(WareInfo wareInfo) {
		return new SQL() {
			{
				INSERT_INTO("wareinfo");
				if (StringUtils.isNotBlank(wareInfo.getWareCode()))
					VALUES("wareCode", "#{wareCode}");
				if (StringUtils.isNotBlank(wareInfo.getWareName()))
					VALUES("wareName", "#{wareName}");
				if (StringUtils.isNotBlank(wareInfo.getWareNorm()))
					VALUES("wareNorm", "#{wareNorm}");
				if (StringUtils.isNotBlank(wareInfo.getWareUnit()))
					VALUES("wareUnit", "#{wareUnit}");
				if (wareInfo.getWareBasePrice() != null)
					VALUES("wareBasePrice", "#{wareBasePrice}");
				if (wareInfo.getWareMaxPrice() != null)
					VALUES("wareMaxPrice", "#{wareMaxPrice}");
				if (wareInfo.getWareMinPrice() != null)
					VALUES("wareMinPrice", "#{wareMinPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareDesc()))
					VALUES("wareDesc", "#{wareDesc}");
				if (wareInfo.getFirmId() != null)
					VALUES("firmId", "#{firmId}");
				if (wareInfo.getOperateId() != null)
					VALUES("operateId", "#{operateId}");
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateWareInfo(WareInfo wareInfo) {
		return new SQL() {
			{
				UPDATE("wareinfo");
				if (StringUtils.isNotBlank(wareInfo.getWareCode()))
					SET("wareCode=#{wareCode}");
				if (StringUtils.isNotBlank(wareInfo.getWareName()))
					SET("wareName=#{wareName}");
				if (StringUtils.isNotBlank(wareInfo.getWareNorm()))
					SET("wareNorm=#{wareNorm}");
				if (StringUtils.isNotBlank(wareInfo.getWareUnit()))
					SET("wareUnit=#{wareUnit}");
				if (wareInfo.getWareBasePrice() != null)
					SET("wareBasePrice=#{wareBasePrice}");
				if (wareInfo.getWareMaxPrice() != null)
					SET("wareMaxPrice=#{wareMaxPrice}");
				if (wareInfo.getWareMinPrice() != null)
					SET("wareMinPrice=#{wareMinPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareDesc()))
					SET("wareDesc=#{wareDesc}");
				if (wareInfo.getFirmId() != null)
					SET("firmId=#{firmId}");
				if (wareInfo.getOperateId() != null)
					SET("operateId=#{operateId}");
				SET("operateDate=(SELECT NOW())");
				WHERE("wareId=#{wareId}");
			}
		}.toString();
	}

	public String getAllWareInfos(WareInfo wareInfo) {
		return new SQL() {
			{
				SELECT("*").FROM("wareinfo");
				if (StringUtils.isNotBlank(wareInfo.getWareCode()))
					WHERE("wareCode=#{wareCode}");
				if (StringUtils.isNotBlank(wareInfo.getWareName()))
					WHERE("wareName=#{wareName}");
				if (StringUtils.isNotBlank(wareInfo.getWareNorm()))
					WHERE("wareNorm=#{wareNorm}");
				if (StringUtils.isNotBlank(wareInfo.getWareUnit()))
					WHERE("wareUnit=#{wareUnit}");
				if (wareInfo.getWareBasePrice() != null)
					WHERE("wareBasePrice=#{wareBasePrice}");
				if (wareInfo.getWareMaxPrice() != null)
					WHERE("wareMaxPrice=#{wareMaxPrice}");
				if (wareInfo.getWareMinPrice() != null)
					WHERE("wareMinPrice=#{wareMinPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareDesc()))
					WHERE("wareDesc=#{wareDesc}");
				if (wareInfo.getFirmId() != null)
					WHERE("firmId=#{firmId}");
				if (wareInfo.getOperateId() != null)
					WHERE("operateId=#{operateId}");
			}
		}.toString();
	}

	public String getWareInfoById(Integer wareId) {
		return "SELECT * FROM wareinfo WHERE wareId=#{wareId}";
	}

	public String deleteWareInfo(Integer wareId) {
		return "DELETE FROM wareinfo WHERE wareId=#{wareId}";
	}

	public String insertShipments(Shipments shipments) {
		return new SQL() {
			{
				INSERT_INTO("shipments");
				if (shipments.getWareId() != null)
					VALUES("wareId", "#{wareId}");
				if (StringUtils.isNotBlank(shipments.getShipNo()))
					VALUES("shipNo", "#{shipNo}");
				if (shipments.getNum() != null)
					VALUES("num", "#{num}");
				if(shipments.getType()!=null)
					VALUES("type", "#{type}");
				if(shipments.getIsSend()!=null)
					VALUES("isSend", "#{isSend}");
				if (shipments.getUserId() != null)
					VALUES("userId", "#{userId}");
				if (StringUtils.isNotBlank(shipments.getDescr()))
					VALUES("descr", "#{descr}");
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateShipments(Shipments shipments) {
		return new SQL() {
			{
				UPDATE("shipments");
				if (shipments.getWareId() != null)
					SET("wareId=#{wareId}");
				if (StringUtils.isNotBlank(shipments.getShipNo()))
					SET("shipNo=#{shipNo}");
				if (shipments.getNum() != null)
					SET("num=#{num}");
				if(shipments.getType()!=null)
					SET("type=#{num}");
				if(shipments.getIsSend()!=null)
					SET("isSend=#{isSend}");
				if (shipments.getUserId() != null)
					SET("userId=#{userId}");
				if (StringUtils.isNotBlank(shipments.getDescr()))
					SET("descr=#{descr}");
				SET("operateDate=(SELECT NOW())");
				WHERE("shipId=#{shipId}");
			}
		}.toString();
	}

	public String getShipmentsById(Integer shipId) {
		return "SELECT * FROM shipments WHERE shipId=#{shipId}";
	}

	public String getAllShipments(Shipments shipments) {
		return new SQL() {
			{
				SELECT("a.*").FROM("shipments a LEFT JOIN userInfo b ON a.userId=b.userId");
				if (shipments != null) {
					if (shipments.getWareId() != null)
						SET("wareId=#{wareId}");
					if (StringUtils.isNotBlank(shipments.getShipNo()))
						SET("shipNo=#{shipNo}");
					if (shipments.getNum() != null)
						SET("num=#{num}");
					if (shipments.getUserId() != null)
						SET("userId=#{userId}");
					if(shipments.getType()!=null)
						SET("type=#{type}");
					if(shipments.getIsSend()!=null)
						SET("isSend=#{isSend}");
					if (shipments.getUserInfo() != null) {
						SET("fimrId=#{userInfo.firmId}");
					}
					if (StringUtils.isNotBlank(shipments.getDescr()))
						SET("descr=#{descr}");
					if (shipments.getOperateDate() != null)
						SET("operateDate=(SELECT NOW())");
				}
			}
		}.toString();
	}

}
