package com.vending.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.ISaaSRentDAO;
import com.vending.platform.domain.SaaSRentOrder;
import com.vending.platform.domain.SaasNumPrice;
import com.vending.platform.domain.SaasPrice;
import com.vending.platform.service.ISaaSRentService;

@Service
public class SaaSRentServiceImpl implements ISaaSRentService {

	@Autowired
	private ISaaSRentDAO saasRentDao;

	@Override
	public List<SaasPrice> getAllSaaPrice(SaasPrice saasPrice) {
		return saasRentDao.getAllSaasPrice(saasPrice);
	}

	@Override
	public List<SaasNumPrice> getAllSaasNumPrice(SaasNumPrice saasNumPrice) {
		return saasRentDao.getAllSaasNumPrice(saasNumPrice);
	}

	@Override
	public void insetSaasRentOrder(SaaSRentOrder saaSRentOrder) {
		saasRentDao.insetSaasOrder(saaSRentOrder);
	}

}
