package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Group_Info映射表：分組信息映射表
 * 
 * @author Miley_Ren
 */
public class T_Group_Info implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 4998771266910693602L;
	/** 分組ID */
	private Integer group_id;
	/** 分组名称 */
	private String group_name;
	/** 分组类型：0：用户组；1：售货机组 */
	private int group_type;
	/** 分组描述 */
	private String group_desc;
	/** 操作者 */
	private Integer operate_id;
	/** 操作时间 */
	private Date operate_date;

	public T_Group_Info() {
		super();
	}

	public T_Group_Info(Integer group_id, String group_name, int group_type, String group_desc, Integer operate_id,
			Date operate_date) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
		this.group_type = group_type;
		this.group_desc = group_desc;
		this.operate_id = operate_id;
		this.operate_date = operate_date;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public int getGroup_type() {
		return group_type;
	}

	public void setGroup_type(int group_type) {
		this.group_type = group_type;
	}

	public String getGroup_desc() {
		return group_desc;
	}

	public void setGroup_desc(String group_desc) {
		this.group_desc = group_desc;
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
		return "T_Group_Info [group_id=" + group_id + ", group_name=" + group_name + ", group_type=" + group_type
				+ ", group_desc=" + group_desc + ", operate_id=" + operate_id + ", operate_date=" + operate_date + "]";
	}
}
