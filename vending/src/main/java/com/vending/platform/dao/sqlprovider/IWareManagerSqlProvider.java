package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

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
				if (wareInfo.getWareBasePrice()!=null)
					VALUES("wareBasePrice", "#{wareBasePrice}");
				if (wareInfo.getWareMaxPrice()!=null)
					VALUES("wareMaxPrice", "#{wareMaxPrice}");
				if (wareInfo.getWareMinPrice()!=null)
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
				if (wareInfo.getWareBasePrice()!=null)
					SET("wareBasePrice=#{wareBasePrice}");
				if (wareInfo.getWareMaxPrice()!=null)
					SET("wareMaxPrice=#{wareMaxPrice}");
				if (wareInfo.getWareMinPrice()!=null)
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
				if (wareInfo.getWareBasePrice()!=null)
					WHERE("wareBasePrice=#{wareBasePrice}");
				if (wareInfo.getWareMaxPrice()!=null)
					WHERE("wareMaxPrice=#{wareMaxPrice}");
				if (wareInfo.getWareMinPrice() !=null)
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
}
