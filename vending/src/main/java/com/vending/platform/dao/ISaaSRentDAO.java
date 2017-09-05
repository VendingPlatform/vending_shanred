package com.vending.platform.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.vending.platform.dao.sqlprovider.ISaasRentSqlProvider;
import com.vending.platform.domain.SaaSRentOrder;
import com.vending.platform.domain.SaasNumPrice;
import com.vending.platform.domain.SaasPrice;

public interface ISaaSRentDAO {
	@SelectProvider(method = "getAllSaasPrice", type = ISaasRentSqlProvider.class)
	public List<SaasPrice> getAllSaasPrice(SaasPrice saasPrice);

	@SelectProvider(method = "getAllSaasNumPrice", type = ISaasRentSqlProvider.class)
	public List<SaasNumPrice> getAllSaasNumPrice(SaasNumPrice numPrice);

	@SelectProvider(method = "insetSaasOrder", type = ISaasRentSqlProvider.class)
	public void insetSaasOrder(SaaSRentOrder saaSRentOrder);

}
