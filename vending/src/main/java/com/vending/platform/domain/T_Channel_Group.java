package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Channel_Group:货道组
 *
 * @author Miley_Ren
 **/
public class T_Channel_Group implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = -759033563075067030L;
	/** 货道组ID */
	private Integer channel_group_id;
	/** 货道组名称 */
	private String channel_group_name;
	/** 货道列表 */
	private String channel_num_list;
	/** 商品编号 */
	private String ware_code;
	/** 商品名称 */
	private String ware_name;
	/** 商品价格 */
	private double ware_price;
	/** 是否特价：0：否；1：是 */
	private Integer is_discount;
	/** 所属售货机组 */
	private Integer group_id;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public T_Channel_Group() {
		super();
	}

	public T_Channel_Group(Integer channel_group_id, String channel_group_name, String channel_num_list,
			String ware_code, String ware_name, double ware_price, Integer is_discount, Integer group_id,
			Integer operate_id, Date operate_date) {
		super();
		this.channel_group_id = channel_group_id;
		this.channel_group_name = channel_group_name;
		this.channel_num_list = channel_num_list;
		this.ware_code = ware_code;
		this.ware_name = ware_name;
		this.ware_price = ware_price;
		this.is_discount = is_discount;
		this.group_id = group_id;
		this.operate_id = operate_id;
		this.operate_date = operate_date;
	}

	public Integer getChannel_group_id() {
		return channel_group_id;
	}

	public void setChannel_group_id(Integer channel_group_id) {
		this.channel_group_id = channel_group_id;
	}

	public String getChannel_group_name() {
		return channel_group_name;
	}

	public void setChannel_group_name(String channel_group_name) {
		this.channel_group_name = channel_group_name;
	}

	public String getChannel_num_list() {
		return channel_num_list;
	}

	public void setChannel_num_list(String channel_num_list) {
		this.channel_num_list = channel_num_list;
	}

	public String getWare_code() {
		return ware_code;
	}

	public void setWare_code(String ware_code) {
		this.ware_code = ware_code;
	}

	public String getWare_name() {
		return ware_name;
	}

	public void setWare_name(String ware_name) {
		this.ware_name = ware_name;
	}

	public double getWare_price() {
		return ware_price;
	}

	public void setWare_price(double ware_price) {
		this.ware_price = ware_price;
	}

	public Integer getIs_discount() {
		return is_discount;
	}

	public void setIs_discount(Integer is_discount) {
		this.is_discount = is_discount;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getOperate_id() {
		return operate_id;
	}

	public void setOperate_id(Integer operate_id) {
		this.operate_id = operate_id;
	}

	public Date getOperate_date() {
		return operate_date;
	}

	public void setOperate_date(Date operate_date) {
		this.operate_date = operate_date;
	}

	@Override
	public String toString() {
		return "T_Channel_Group [channel_group_id=" + channel_group_id + ", channel_group_name=" + channel_group_name
				+ ", channel_num_list=" + channel_num_list + ", ware_code=" + ware_code + ", ware_name=" + ware_name
				+ ", ware_price=" + ware_price + ", is_discount=" + is_discount + ", group_id=" + group_id
				+ ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}
}
