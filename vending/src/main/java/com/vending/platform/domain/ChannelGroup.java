package com.vending.platform.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * T_Channel_Group:货道组
 *
 * @author Miley_Ren
 **/
public class ChannelGroup implements Serializable {

    /** 序列号 */
    private static final long serialVersionUID = -759033563075067030L;
    /** 货道组ID */
    private Integer channelGroupId;
    /** 货道组名称 */
    private String channelGroupName;
    /** 所属售货机组 */
    private Integer groupId;
    /** 操作者 */
    private Integer operateId;
    /** 操作时间 */
    private Date operateDate;

    private GroupInfo groupInfo;

    public ChannelGroup() {
        super();
    }

    public Integer getChannelGroupId() {
        return channelGroupId;
    }

    public void setChannelGroupId(Integer channelGroupId) {
        this.channelGroupId = channelGroupId;
    }

    public String getChannelGroupName() {
        return channelGroupName;
    }

    public void setChannelGroupName(String channelGroupName) {
        this.channelGroupName = channelGroupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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

    public GroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    @Override
    public String toString() {
        return "ChannelGroup [channelGroupId=" + channelGroupId
                + ", channelGroupName=" + channelGroupName + ", groupId="
                + groupId + ", operateId=" + operateId + ", operateDate="
                + operateDate + "]";
    }

}
