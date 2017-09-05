package com.vending.platform.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vending.platform.domain.FirmInfo;
import com.vending.platform.domain.SaaSRentOrder;
import com.vending.platform.domain.SaasNumPrice;
import com.vending.platform.domain.SaasPrice;
import com.vending.platform.domain.UserInfo;
import com.vending.platform.service.IFirmAndGroupService;
import com.vending.platform.service.ISaaSRentService;

@Controller
@RequestMapping("/saas")
public class RentSaaSController extends UtilsAction {
	Logger logger = Logger.getLogger(RentSaaSController.class);
	private static final long serialVersionUID = -152211967929477481L;
	@Autowired
	private IFirmAndGroupService firmAndGroupService;
	@Autowired
	private ISaaSRentService saasRentService;

	@Description("验证商户信息")
	@RequestMapping(value = "/validateSaasRent/{firmName}/{firmCode}")
	public String validateSaasRent(@PathVariable String firmName, @PathVariable String firmCode) {
		String response = "none";
		// 获取所有Firm
		List<FirmInfo> allFirmInfos = firmAndGroupService.getAllFirmInfos(null);
		for (FirmInfo firmInfo : allFirmInfos) {
			if (firmName != null) {
				if (firmName.equals(firmInfo.getFirmName())) {
					response = "repeatName";
				}
			}
			if (firmCode != null) {
				if (firmCode.equals(firmInfo.getFirmNo())) {
					response = "repeatCode";
				}
			}
		}
		try {
			write(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "genview/SaaSRentPage";
	}

	@Description("计算租金价格的方法")
	@RequestMapping(value = "/calculateMoney")
	public String calculateMoney(Integer firmType, Integer rentTime, Integer machineNum) {
		SaasNumPrice saasNumPrice = new SaasNumPrice();
		saasNumPrice.setFirmType(firmType);
		// 获取单个机器价格和所有价格
		SaasNumPrice sNumPrice = saasRentService.getAllSaasNumPrice(saasNumPrice).get(0);
		List<SaasPrice> saasPrices = saasRentService.getAllSaaPrice(null);
		int monthMoney = 0;
		for (SaasPrice saasPrice : saasPrices) {
			if (saasPrice.getPriceName().equals("1month")) {
				monthMoney = saasPrice.getPrice();
				break;
			}
		}
		double money = 0.0;
		if (rentTime == 0) {
			// 免费试用
			money = 0;
			logger.info("--------------------trymonry=" + money);
		} else if (rentTime < 12) {
			// 租用期限为一年内
			money = monthMoney * rentTime * machineNum * sNumPrice.getNumPrice();
			logger.info("------------------monthmonry=" + money);
		} else {
			// 租用期限为年的倍数
			// 找到租金折扣
			int discount = 1;
			for (SaasPrice saasPrice : saasPrices) {
				if (rentTime == 12 && "1year".equals(saasPrice.getPriceName())) {
					discount = saasPrice.getDiscount();
					break;
				} else if (rentTime == 24 && ("2year").equals(saasPrice.getPriceName())) {
					discount = saasPrice.getDiscount();
					break;
				} else if (rentTime == 36 && ("3year").equals(saasPrice.getPriceName())) {
					discount = saasPrice.getDiscount();
					break;
				}
			}
			money = monthMoney * rentTime * machineNum * sNumPrice.getNumPrice() * discount/100.0;
			logger.info("-------------------yearmonry=" + money);
		}
		try {
			write(money);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "genview/SaaSRentPage";
	}

	@Description("创建租户")
	@RequestMapping(value = "/createNewSaasRent")
	public String calculateMoney(Integer firmType, String firmName, String firmNo, String password, Double sumPrice,
			Integer rentTime, Integer machineNum) {

		// 获取起止时间
		GregorianCalendar now = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"), Locale.SIMPLIFIED_CHINESE);
		String startTime = sf.format(now.getTime());
		now.add(GregorianCalendar.MONTH, rentTime);
		String endTime = sf.format(now.getTime());

		FirmInfo firmInfo = new FirmInfo();
		firmInfo.setFirmName(firmName);
		firmInfo.setFirmType(firmType);
		firmInfo.setFirmNo(firmNo);
		firmInfo.setFirmStatus(1);
		firmInfo.setHasTry(1);
		firmInfo.setMachineNum(machineNum);
		firmInfo.setStartTime(startTime);
		firmInfo.setEndTime(endTime);

		UserInfo userInfo = new UserInfo();
		userInfo.setPassword(password);
		firmAndGroupService.insertFirm(firmInfo, userInfo);

		Integer firmId = firmAndGroupService.getAllFirmInfos(firmInfo).get(0).getFirmId();
		String rentOrderId = String.valueOf(System.currentTimeMillis() + firmId);
		SaaSRentOrder saaSRentOrder = new SaaSRentOrder();
		saaSRentOrder.setFirmId(firmId);
		saaSRentOrder.setMachineNum(machineNum);
		saaSRentOrder.setSumPrice(sumPrice);
		saaSRentOrder.setStartTime(startTime);
		saaSRentOrder.setEndTime(endTime);
		saaSRentOrder.setRentOrderId(rentOrderId);
		saasRentService.insetSaasRentOrder(saaSRentOrder);
		try {
			write("租用成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "login";
	}
}
