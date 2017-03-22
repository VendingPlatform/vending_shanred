package com.vending.platform.service.impl;

import org.springframework.stereotype.Service;

import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.UserInfo;

@Service
public class UtilsService {

	/**
	 * 根据权限配置查找条件
	 * 
	 * @param authorityCodes
	 *            权限编码
	 * @param machineOperater
	 *            表单传入信息
	 * @param userInfo
	 *            用户信息
	 * @return MachineOperater 根据权限编码封装过后的查询信息
	 */
	public static MachineOperater getCode(String authorityCodes, MachineOperater machineOperater, UserInfo userInfo) {
		String[] aCodes = (String[]) authorityCodes.split(";");
		for (int i = 0; i < aCodes.length; i++) {
			if (aCodes[i].equals("000")) {
				// 000位系统管理员，可查看所有商家及用户符合条件的信息
				break;
			} else if (aCodes[i].equals("001") || aCodes[i].equals("002")) {
				// 001代表运营商超管；002代表厂商超管，可查看公司内所有售货机000
				if (machineOperater.getOperFirmId() == null) {
					machineOperater.setOperFirmId(userInfo.getFirmId());
					break;
				}
			} else if (aCodes[i].equals("00101")) {
				// 00101代表运营商小组长，可查询组内所有售货机
				machineOperater.setOperFirmId(userInfo.getFirmId());

			} else if (aCodes[i].equals("00102")) {
				// 00102代表普通管理员，仅可查看自身拥有的售货机
				machineOperater.setUserId(userInfo.getUserId());
			}
		}
		return machineOperater;
	}
}
