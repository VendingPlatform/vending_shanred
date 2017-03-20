package com.vending.platform.service;

import com.vending.platform.domain.UserInfo;

public interface IUserManagerService {
	/** 用户登录 */
	public UserInfo login(UserInfo userInfo);

	/**修改密码*/
	void updatePwd(UserInfo userInfo);  
}
