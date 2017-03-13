package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.WareInfo;

public class IWareManagerSqlProvider {
	public String inserWareInfo(WareInfo wareInfo) {
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
				if (StringUtils.isNotBlank(wareInfo.getWareBasePrice() + ""))
					VALUES("wareBasePrice", "#{wareBasePrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareMaxPrice() + ""))
					VALUES("wareMaxPrice", "#{wareMaxPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareMinPrice() + ""))
					VALUES("wareMinPrice", "#{wareMinPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareDesc()))
					VALUES("wareDesc", "#{wareDesc}");
				if (wareInfo.getWareStatus() != null)
					VALUES("wareStatus", "#{wareStatus}");
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
				if (StringUtils.isNotBlank(wareInfo.getWareBasePrice() + ""))
					SET("wareBasePrice=#{wareBasePrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareMaxPrice() + ""))
					SET("wareMaxPrice=#{wareMaxPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareMinPrice() + ""))
					SET("wareMinPrice=#{wareMinPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareDesc()))
					SET("wareDesc=#{wareDesc}");
				if (wareInfo.getWareStatus() != null)
					SET("wareStatus=#{wareStatus}");
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
				if (StringUtils.isNotBlank(wareInfo.getWareBasePrice() + ""))
					WHERE("wareBasePrice=#{wareBasePrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareMaxPrice() + ""))
					WHERE("wareMaxPrice=#{wareMaxPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareMinPrice() + ""))
					WHERE("wareMinPrice=#{wareMinPrice}");
				if (StringUtils.isNotBlank(wareInfo.getWareDesc()))
					WHERE("wareDesc=#{wareDesc}");
				if (wareInfo.getWareStatus() != null)
					WHERE("wareStatus=#{wareStatus}");
				if (wareInfo.getFirmId() != null)
					WHERE("firmId=#{firmId}");
				if (wareInfo.getOperateId() != null)
					WHERE("operateId=#{operateId}");
				WHERE("wareId=#{wareId}");
			}
		}.toString();
	}

	public String getWareInfoById(Integer wareId) {
		return "SELECT * FROM wareinfo WHERE wareId=#{wareId}";
	}

	public String deleteWareInfo(Integer wareId) {
		return "DELETE FROM wareinfo WHERE wareId=#{wareId}";
	}
}
