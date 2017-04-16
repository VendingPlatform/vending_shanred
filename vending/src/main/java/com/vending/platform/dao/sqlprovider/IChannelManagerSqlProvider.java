package com.vending.platform.dao.sqlprovider;

import static org.hamcrest.CoreMatchers.nullValue;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import com.vending.platform.domain.ChannelGroup;
import com.vending.platform.domain.ChannelInfo;
import com.vending.platform.domain.ChannelWareInfo;

public class IChannelManagerSqlProvider {

    public String insertChannelGroup(ChannelGroup channelGroup) {
        return new SQL() {
            {
                INSERT_INTO("channelgroup");
                if (StringUtils.isNotBlank(channelGroup.getChannelGroupName()))
                    VALUES("channelGroupName", "#{channelGroupName}");
                if (channelGroup.getGroupId() != null)
                    VALUES("groupId", "#{groupId}");
                if (channelGroup.getOperateId() != null)
                    VALUES("operateId", "#{operateId}");
                VALUES("operateDate", "(SELECT NOW())");
            }
        }.toString();
    }

    public String updateChannelGroup(ChannelGroup channelGroup) {
        return new SQL() {
            {
                UPDATE("channelgroup");
                if (StringUtils.isNotBlank(channelGroup.getChannelGroupName()))
                    SET("channelGroupName=#{channelGroupName}");
                if (channelGroup.getGroupId() != null)
                    SET("groupId=#{groupId}");
                if (channelGroup.getOperateId() != null)
                    SET("operateId=#{operateId}");
                WHERE("channelGroupId=#{channelGroupId}");
            }
        }.toString();
    }

    public String getAllChannelGroups(ChannelGroup channelGroup) {
        return new SQL() {
            {
                SELECT("*").FROM("channelgroup");
                if (StringUtils.isNotBlank(channelGroup.getChannelGroupName()))
                    WHERE("channelGroupName=#{channelGroupName}");
                if (channelGroup.getGroupId() != null)
                    WHERE("groupId=#{groupId}");
                if (channelGroup.getOperateId() != null)
                    WHERE("operateId=#{operateId}");
            }
        }.toString();
    }

    public String getChannelGroupById(Integer channelGroupId) {
        return "SELECT * FROM channelgroup WHERE channelGroupId=#{channelGroupId}";
    }

    public String deleteChannelGroup(Integer channelGroupId) {
        return "DELETE FROM channelgroup WHERE channelGroupId=#{channelGroupId}";
    }

    public String insertChannelInfo(ChannelInfo channelInfo) {
        return new SQL() {
            {
                INSERT_INTO("channelinfo");
                if (StringUtils.isNotBlank(channelInfo.getChannelNo()))
                    VALUES("channelNo", "#{channelNo}");
                if (channelInfo.getStockNum() != null)
                    VALUES("stockNum", "#{stockNum}");
                if (channelInfo.getStockNumNow() != null)
                    VALUES("stockNumnNow", "#{stockNumnNow}");
                if (channelInfo.getStockNumAdd() != null)
                    VALUES("stockNumnAdd", "#{stockNumnAdd}");
                if (channelInfo.getChannelGroupId() != null)
                    VALUES("channelGroupId", "#{channelGroupId}");
                if (channelInfo.getmOperaterId() != null)
                    VALUES("mOperaterId", "#{mOperaterId}");
                if (channelInfo.getOperateId() != null)
                    VALUES("operateId", "#{operateId}");
                VALUES("operateDate", "(SELECT NOW())");
               
            }
        }.toString();
    }

    public String updateChannelInfo(ChannelInfo channelInfo) {
        return new SQL() {
            {
                UPDATE("channelinfo");
                if (StringUtils.isNotBlank(channelInfo.getChannelNo()))
                    SET("channelNo=#{channelNo}");
                if (channelInfo.getStockNum() != null)
                    SET("stockNum=#{stockNum}");
                if (channelInfo.getStockNumNow() != null)
                    SET("stockNumnNow=#{stockNumnNow}");
                if (channelInfo.getStockNumAdd() != null)
                    SET("stockNumnAdd=#{stockNumnAdd}");
                if (channelInfo.getChannelGroupId() != null)
                    SET("channelGroupId=#{channelGroupId}");
                if (channelInfo.getMachineOperater() != null)
                    SET("mOperaterId=#{mOperaterId}");
                if (channelInfo.getOperateId() != null)
                    SET("operateId=#{operateId}");
                SET("operateDate=(SELECT NOW())");
                WHERE("channelId=#{channelId}");
            }
        }.toString();
    }

    public String getAllChannelInfos(ChannelInfo channelInfo) {
        return new SQL() {
            {
                SELECT("*").FROM("channelinfo");
                if (StringUtils.isNotBlank(channelInfo.getChannelNo()))
                    WHERE("channelNo=#{channelNo}");
                if (channelInfo.getStockNum() != null)
                    WHERE("stockNum=#{stockNum}");
                if (channelInfo.getStockNumNow() != null)
                    WHERE("stockNumnNow=#{stockNumnNow}");
                if (channelInfo.getStockNumAdd() != null)
                    WHERE("stockNumnAdd=#{stockNumnAdd}");
                if (channelInfo.getChannelGroupId() != null)
                    WHERE("channelGroupId=#{channelGroupId}");
                if (channelInfo.getMachineOperater() != null)
                    WHERE("mOperaterId=#{mOperaterId}");
                if (channelInfo.getOperateId() != null)
                    WHERE("operateId=#{operateId}");
            }
        }.toString();
    }

    public String getChannelInfoById(Integer channelId) {
        return "SELECT * FROM channelinfo WHERE channelId=#{channelId}";
    }

    public String deleteChannelInfo(Integer channelId) {
        return "DELETE FROM channelinfo WHERE channelId=#{channelId}";
    }

    public String getAllChannelWareInfos(ChannelWareInfo channelWareInfo) {
        return new SQL() {
            {
                SELECT("*").FROM("channelwareinfo");
                if (channelWareInfo.getChannelId() != null)
                    WHERE("channelId=#{channelId}");
                if (channelWareInfo.getWareId() != null)
                    WHERE("wareId=#{wareId}");
                if (channelWareInfo.getPrice() != null)
                    WHERE("price=#{price}");
                if (channelWareInfo.getIsDiscount() != null)
                    WHERE("isDiscount=#{isDiscount}");
                if (channelWareInfo.getmOperaterId() != null)
                    WHERE("mOperaterId=#{mOperaterId}");
            }
        }.toString();
    }

    public String insertChannelWareInfo(ChannelWareInfo channelWareInfo) {
        return new SQL() {
            {
                INSERT_INTO("channelwareinfo");
                if (channelWareInfo.getChannelId() != null)
                    VALUES("channelId","#{channelId}");
                if (channelWareInfo.getWareId() != null)
                    VALUES("wareId","#{wareId}");
                if (channelWareInfo.getPrice() != null)
                    VALUES("price","#{price}");
                if (channelWareInfo.getIsDiscount() != null)
                    VALUES("isDiscount","#{isDiscount}");
                if (channelWareInfo.getmOperaterId() != null)
                    VALUES("mOperaterId","#{mOperaterId}");
            }
        }.toString();
    }
    
    public String getAllChannelWareInfoById(Integer channelId){
        return "SELECT * FROM channelwareinfo WHERE channelId=#{channelId}";
    }
}
