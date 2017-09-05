package com.vending.platform.dao.sqlprovider;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.SaaSRentOrder;
import com.vending.platform.domain.SaasNumPrice;
import com.vending.platform.domain.SaasPrice;

public class ISaasRentSqlProvider {
	public String getAllSaasPrice(SaasPrice saasPrice) {
		return new SQL() {
			{
				SELECT("*").FROM("saasprice");
				if (saasPrice != null) {
					if (StringUtils.isNotBlank(saasPrice.getPriceName())) {
						WHERE("priceName=#{priceName}");
					}
					if (saasPrice.getPrice() != null) {
						WHERE("saasPrice=#{saasPrice}");
					}
					if (saasPrice.getDiscount() != null)
						WHERE("discount=#{discount}");
				}
			}
		}.toString();
	}

	public String getAllSaasNumPrice(SaasNumPrice numPrice) {
		return new SQL() {
			{
				SELECT("*").FROM("saasnumprice");
				if (numPrice != null) {
					if (numPrice.getFirmType() != null) {
						WHERE("firmType=#{firmType}");
					}
					if (numPrice.getNumPrice() != null) {
						WHERE("numPrice=#{numPrice}");
					}
				}
			}
		}.toString();
	}

	public String insetSaasOrder(SaaSRentOrder saaSRentOrder) {
		return new SQL() {
			{
				INSERT_INTO("saasrentorder");
				if (StringUtils.isNotBlank(saaSRentOrder.getEndTime())) {
					VALUES("endTime", "#{endTime}");
				}
				if (StringUtils.isNotBlank(saaSRentOrder.getStartTime())) {
					VALUES("startTime", "#{startTime}");
				}
				if (saaSRentOrder.getFirmId() != null) {
					VALUES("firmId", "#{firmId}");
				}
				if (saaSRentOrder.getMachineNum() != null) {
					VALUES("machineNum", "#{machineNum}");
				}
				if (saaSRentOrder.getSumPrice() != null) {
					VALUES("sumPrice", "#{sumPrice}");
				}
				if (StringUtils.isNotBlank(saaSRentOrder.getRentOrderId()))
					VALUES("rentOrderId", "#{rentOrderId}");
			}
		}.toString();
	}
}
