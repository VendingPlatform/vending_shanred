package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Channel_Info:货道信息
 * 
 * @author Miley_Ren
 */
public class ChannelInfo implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 8761114712738792976L;
	/** 货道ID */
	private Integer channel_id;
	/** 货道编号 */
	private String channel_no;
	/** 商品名称 */
	private String ware_name;
	/** 商品价格 */
	private double ware_price;
	/** 是否特价 */
	private int is_discount;
	/** 额定存货量 */
	private Integer stock_num;
	/** 当前存货量 */
	private Integer stock_num_now;
	/** 新增存货量 */
	private Integer stock_num_add;
	/** 所属售货机 */
	private Integer machine_id;
	/** 是否为历史信息：0：否；1：是 */
	private Integer is_history;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public ChannelInfo() {
		super();
	}

	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}

	public String getChannel_no() {
		return channel_no;
	}

	public void setChannel_no(String channel_no) {
		this.channel_no = channel_no;
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

	public int getIs_discount() {
		return is_discount;
	}

	public void setIs_discount(int is_discount) {
		this.is_discount = is_discount;
	}

	public Integer getStock_num() {
		return stock_num;
	}

	public void setStock_num(Integer stock_num) {
		this.stock_num = stock_num;
	}

	public Integer getStock_num_now() {
		return stock_num_now;
	}

	public void setStock_num_now(Integer stock_num_now) {
		this.stock_num_now = stock_num_now;
	}

	public Integer getStock_num_add() {
		return stock_num_add;
	}

	public void setStock_num_add(Integer stock_num_add) {
		this.stock_num_add = stock_num_add;
	}

	public Integer getMachine_id() {
		return machine_id;
	}

	public void setMachine_id(Integer machine_id) {
		this.machine_id = machine_id;
	}

	public Integer getIs_history() {
		return is_history;
	}

	public void setIs_history(Integer is_history) {
		this.is_history = is_history;
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
		return "T_Channel_Info [channel_id=" + channel_id + ", channel_no=" + channel_no + ", ware_name=" + ware_name
				+ ", ware_price=" + ware_price + ", is_discount=" + is_discount + ", stock_num=" + stock_num
				+ ", stock_num_now=" + stock_num_now + ", stock_num_add=" + stock_num_add + ", machine_id=" + machine_id
				+ ", is_history=" + is_history + ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}
}
