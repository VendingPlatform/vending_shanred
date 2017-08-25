package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.SaaSRentOrder;
import com.vending.platform.domain.SaasNumPrice;
import com.vending.platform.domain.SaasPrice;

public interface ISaaSRentService {

	List<SaasPrice> getAllSaaPrice(SaasPrice saasPrice);

	List<SaasNumPrice> getAllSaasNumPrice(SaasNumPrice saasNumPrice);

	void insetSaasRentOrder(SaaSRentOrder saaSRentOrder);
}
