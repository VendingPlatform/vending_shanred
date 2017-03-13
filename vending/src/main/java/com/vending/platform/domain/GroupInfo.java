package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Group_Info映射表：分組信息映射表
 * 
 * @author Miley_Ren
 */
public class GroupInfo implements Serializable {

	/** 序列号 */
	private static final long serialVersionUID = 4998771266910693602L;
	/** 分組ID */
	private Integer groupId;
	/** 分组名称 */
	private String groupName;
	/** 分组类型：0：用户组；1：售货机组 */
	private Integer groupType;
	/** 分组描述 */
	private String groupDesc;
	/** 公司 */
	private Integer firmId;
	/** 操作者 */
	private Integer operateId;
	/** 操作时间 */
	private Date operateDate;

	public GroupInfo() {
		super();
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getGroupType() {
		return groupType;
	}

	public void setGroupType(Integer groupType) {
		this.groupType = groupType;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public Integer getFirmId() {
		return firmId;
	}

	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Override
	public String toString() {
		return "GroupInfo [groupId=" + groupId + ", groupName=" + groupName + ", groupType=" + groupType
				+ ", groupDesc=" + groupDesc + ", firmId=" + firmId + ", operateId=" + operateId + ", operateDate="
				+ operateDate + "]";
	}

}
