package com.vending.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.platform.dao.IWareManagerDAO;
import com.vending.platform.domain.Shipments;
import com.vending.platform.domain.WareInfo;
import com.vending.platform.service.IWareManagerService;

@Service
public class WareManagerServiceInpl implements IWareManagerService {

    @Autowired
    private IWareManagerDAO wareDao;

    @Override
    public List<WareInfo> getAllWareInfos(WareInfo wareInfo) {
        return wareDao.getAllWareInfos(wareInfo);
    }

    @Override
    public void insertWareInfo(WareInfo wareInfo) {
        wareDao.insertWareInfo(wareInfo);
    }

    @Override
    public WareInfo getWareInoById(Integer wareId) {
        return wareDao.getWareInfoById(wareId);
    }

    @Override
    public void updateWareInfo(WareInfo wareInfo) {
        wareDao.updateWareInfo(wareInfo);
    }

	@Override
	public Shipments getShipmentById(Integer shipId) {
		return wareDao.getShipmentsById(shipId);
	}

	@Override
	public void insertShipments(Shipments shipments) {
		wareDao.insertShipments(shipments);
	}

	@Override
	public void updateShipments(Shipments shipments) {
		wareDao.updateShipments(shipments);
	}

	@Override
	public List<Shipments> getAllShipmentses(Shipments shipments) {
		return wareDao.getAllShipments(shipments);
	}

}
