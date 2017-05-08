package com.vending.platform.service;

import java.util.List;

import com.vending.platform.domain.Shipments;
import com.vending.platform.domain.WareInfo;

public interface IWareManagerService {

	void insertWareInfo(WareInfo wareInfo);

	WareInfo getWareInoById(Integer wareId);

	List<WareInfo> getAllWareInfos(WareInfo wareInfo);

	void updateWareInfo(WareInfo wareInfo);

	void insertShipments(Shipments shipments);

	void updateShipments(Shipments shipments);

	Shipments getShipmentById(Integer shipId);

	List<Shipments> getAllShipmentses(Shipments shipments);
}
