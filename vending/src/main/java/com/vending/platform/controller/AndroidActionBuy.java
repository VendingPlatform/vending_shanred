package com.vending.platform.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.vending.platform.android.domian.WareChannelDisplay;
import com.vending.platform.domain.ChannelWareInfo;
import com.vending.platform.service.IChannelManagerService;

@Controller
@RequestMapping(value = "clientbuy")
public class AndroidActionBuy extends UtilsAction {

	private static final long serialVersionUID = -8965313954374673525L;
	@Autowired
	private IChannelManagerService channelService;

	/**
	 * 显示当前售货机的货道信息
	 * 
	 * @param mOperaterId
	 *            运营商售货机ID
	 * @return 返回Map格式的货道键值对信息
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping(value = "/{mOperaterId}")
	public String getclientChannelMap(@PathVariable int mOperaterId) throws UnsupportedEncodingException {
		ChannelWareInfo channelWareInfo = new ChannelWareInfo();
		channelWareInfo.setmOperaterId(mOperaterId);
		List<ChannelWareInfo> channelWares = channelService.getAllChannelWareInfos(channelWareInfo);
		JSONArray jsonArray = new JSONArray();

		WareChannelDisplay display = new WareChannelDisplay();
		for (ChannelWareInfo channelware : channelWares) {
			display.setChannelId(channelware.getChannelInfo().getChannelId());
			display.setChannelNo(channelware.getChannelInfo().getChannelNo());
			display.setPrice(channelware.getPrice());
			display.setStockNumNow(channelware.getChannelInfo().getStockNumNow());
			display.setWareName(channelware.getWareInfo() != null ? channelware.getWareInfo().getWareName() : "无货");
			display.setWareDesc(channelware.getWareInfo() != null ? channelware.getWareInfo().getWareDesc() : "无描述信息");
			display.setIsDiscount(channelware.getIsDiscount());
			display.setmOperaterId(channelware.getmOperaterId());

			jsonArray.add(display.getJsonObject());
		}
		return URLEncoder.encode(jsonArray.toJSONString(), "UTF-8");
	}

}
