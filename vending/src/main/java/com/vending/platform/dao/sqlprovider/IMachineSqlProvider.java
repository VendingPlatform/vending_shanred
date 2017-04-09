package com.vending.platform.dao.sqlprovider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.vending.platform.domain.MachineInfo;
import com.vending.platform.domain.MachineOperater;
import com.vending.platform.domain.MachineType;

/** @author Miley_Ren */
public class IMachineSqlProvider {

    public String insertMachineOperate(MachineOperater machineOperater) {
        return new SQL() {
            {
                INSERT_INTO("machineoperater");
                if (machineOperater != null && machineOperater.getMachineId() != null) {
                    VALUES("machineId", "'" + machineOperater.getMachineId() + "'");
                    if (machineOperater.getMachineAssign() != null) {
                        VALUES("machineAssign", "'" + machineOperater.getMachineAssign() + "'");
                    }
                    if (machineOperater.getOperFirmId() != null) {
                        VALUES("operFirmId", "'" + machineOperater.getOperFirmId() + "'");
                    }
                    if (machineOperater.getOperateId() != null) {
                        VALUES("operateId", "'" + machineOperater.getOperateId() + "'");
                    }
                    VALUES("operateDate", "(select now())");
                }
            }
        }.toString();
    }

	public String deleteMachineOperateById(Integer machinId) {
		return new SQL() {
			{
				DELETE_FROM("machineoperater");
				WHERE("mOperaterId=" + machinId);
			}
		}.toString();
	}
	public String updateMachineOperate(MachineOperater machineOperater) {
        return new SQL() {
            {
                if (machineOperater != null && machineOperater.getmOperaterId() != null) {
                    UPDATE("machineoperater");
                    if (machineOperater.getMachineId() != null) {
                        SET("machineId=#{machinId}");
                    }
                    if (machineOperater.getMachineAssign() != null) {
                        SET("machineAssign=" + machineOperater.getMachineAssign());
                    }
                    if (machineOperater.getUserId() != null) {
                        SET("userId=" + machineOperater.getUserId());
                    }
                    if (StringUtils.isNotBlank(machineOperater.getMachineAddress())) {
                        SET("machineAddress='" + machineOperater.getMachineAddress() + "'");
                    }
                    if (machineOperater.getGroupId() != null) {
                        if (machineOperater.getGroupId() == -1) {
                            SET("groupId=null");
                        } else {
                            SET("groupId=" + machineOperater.getGroupId());
                        }
                    }
                    if (machineOperater.getOperFirmId() != null) {
                        SET("operFirmId=" + machineOperater.getOperFirmId());
                    }
                    if (machineOperater.getOperateId() != null) {
                        SET("operateId=" + machineOperater.getOperateId());
                    }
                    SET("operateDate=(select now())");

                    WHERE("mOperaterId=" + machineOperater.getmOperaterId());
                }
            }
        }.toString();
    }

	public String getMachineOperaterById(Integer id) {
		return "SELECT * FROM machineoperater WHERE mOperaterId=" + id;
	}
	public String getAllMachineOperaters(MachineOperater machineOperater) {
        return new SQL() {
            {
                //SELECT o.* FROM machineoperater  o LEFT JOIN  machineInfo i ON o.machineId=i.machineId  WHERE i.manuMachineStatus=1;
                SELECT("o.* ");
                FROM("machineoperater o LEFT JOIN  machineInfo i ON o.machineId=i.machineId ");
                if (machineOperater != null) {
                    if(machineOperater.getMachineInfo()!=null){
                        if (StringUtils.isNotBlank(machineOperater.getMachineInfo().getMachineName())) {
                            WHERE("i.machineName='#{machineInfo.machineName}");
                        }
                        if (StringUtils.isNotBlank(machineOperater.getMachineInfo().getMachinePannel())) {
                            WHERE("i.machinePannel=#{machineInfo.machinePannel}");
                        }
                        if (StringUtils.isNotBlank(machineOperater.getMachineInfo().gettModelName())) {
                            WHERE("i.tModelName=#{machineInfo.tModelName}");
                        }
                        if (machineOperater.getMachineInfo().getManuMachineStatus() != null) {
                            WHERE("i.manuMachineStatus=#{machineInfo.manuMachineStatus}");
                        }
                    }
                    if (machineOperater.getMachineId() != null) {
                        WHERE("o.machineId=#{machineId}");
                    }
                    if (machineOperater.getMachineAssign() != null) {
                        WHERE("o.machineAssign=#{machineAssign}");
                    }
                    if (machineOperater.getUserId() != null) {
                        WHERE("o.userId=#{userId}");
                    }
                    if (StringUtils.isNotBlank(machineOperater.getMachineAddress())) {
                        WHERE("o.machineAddress=#{machineAddress}");
                    }
                  
                    if (machineOperater.getGroupId() != null) {
                        if (machineOperater.getGroupId() == -1) {
                            WHERE("o.groupId is null");
                        } else {
                            WHERE("o.groupId=#{groupId}");
                        }
                    }
                    if (machineOperater.getOperFirmId() != null) {
                        WHERE("o.operFirmId=#{operFirmId}");
                    }
                    if (machineOperater.getOperateId() != null) {
                        WHERE("o.operateId=#{operateId}");
                    }
                }
            }
        }.toString();
    }

	public String getMachineInfoById(Integer id) {
		return "SELECT * FROM machineinfo WHERE machineId=" + id;
	}

	public String inseretMachineType(MachineType machineType) {
		return new SQL() {
			{
				INSERT_INTO("machinetype");
				if (StringUtils.isNotBlank(machineType.gettModelName())) {
					VALUES("tModelName", "#{tModelName}");
				}
				if (machineType.getFirmId() != null) {
					VALUES("firmId", "#{firmId}");
				}
				if (machineType.getOperateId() != null) {
					VALUES("operateId", "#{operateId}");
				}
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateMachineType(MachineType machineType) {
		return new SQL() {
			{
				if (machineType.gettModelId() != null) {
					UPDATE("machinetype");
					if (StringUtils.isNotBlank(machineType.gettModelName())) {
						SET("tModelName=#{tModelName}");
					}
					if (machineType.getFirmId() != null) {
						SET("firmId=#{firmId}");
					}
					if (machineType.getOperateId() != null) {
						SET("operateId=#{operateId}");
					}
					WHERE("tModelId=#{tModelId}");
				}
			}
		}.toString();
	}

	public String getAllMachineTypes(MachineType machineType) {
		return new SQL() {
			{
				SELECT("*").FROM("machinetype");
				if (StringUtils.isNotBlank(machineType.gettModelName())) {
					WHERE("tModelName=#{tModelName}");
				}
				if (machineType.getFirmId() != null) {
					WHERE("firmId=#{firmId}");
				}
				if (machineType.getOperateId() != null) {
					WHERE("operateId=#{operateId}");
				}
			}
		}.toString();
	}

	public String getMachineTypeById(Integer tModelId) {
		return "SELECT * FROM machinetype WHERE tModelId=#{tModelId}";
	}

	public String deleteMachineType(Integer tModelId) {
		return "DELETE FROM machinetype WHERE tModelId=#{tModelId}";
	}

	public String insertMachineInfo(MachineInfo machineInfo) {
		return new SQL() {
			{
				INSERT_INTO("machineinfo");
				if (StringUtils.isNotBlank(machineInfo.getMachineName())) {
					VALUES("machineName", "#{machineName}");
				}
				if (StringUtils.isNotBlank(machineInfo.getMachinePannel())) {
					VALUES("machinePannel", "#{machinePannel}");
				}
				if (machineInfo.getManuFirmId() != null) {
					VALUES("manuFirmId", "#{manuFirmId}");
				}
				if (StringUtils.isNotBlank(machineInfo.getMachinePrice() + "")) {
					VALUES("machinePrice", "#{machinePrice}");
				}
				if (StringUtils.isNotBlank(machineInfo.gettModelName())) {
					VALUES("tModelName", "#{tModelName}");
				}
				if (machineInfo.getManuMachineStatus() != null) {
					VALUES("manuMachineStatus", "#{manuMachineStatus}");
				}
				if (machineInfo.getOperFirmId() != null) {
					VALUES("operFirmId", "#{operFirmId}");
				}
				if (machineInfo.getOperateId() != null) {
					VALUES("operateId", "#{operateId}");
				}
				VALUES("operateDate", "(SELECT NOW())");
			}
		}.toString();
	}

	public String updateMachineInfo(MachineInfo machineInfo) {
		return new SQL() {
			{
				if (machineInfo.getMachineId() != null) {
					UPDATE("machineinfo");
					if (StringUtils.isNotBlank(machineInfo.getMachineName())) {
						SET("machineName=#{machineName}");
					}
					if (StringUtils.isNotBlank(machineInfo.getMachinePannel())) {
						SET("machinePannel=#{machinePannel}");
					}
					if (machineInfo.getManuFirmId() != null) {
						SET("manuFirmId=#{manuFirmId}");
					}
					if (StringUtils.isNotBlank(machineInfo.getMachinePrice() + "")) {
						SET("machinePrice=#{machinePrice}");
					}
					if (StringUtils.isNotBlank(machineInfo.gettModelName())) {
						SET("tModelName=#{tModelName}");
					}
					if (machineInfo.getManuMachineStatus() != null) {
						SET("manuMachineStatus=#{manuMachineStatus}");
					}
					if (machineInfo.getOperFirmId() != null) {
						SET("operFirmId=#{operFirmId}");
					}
					if (machineInfo.getOperateId() != null) {
						SET("operateId=#{operateId}");
					}
					WHERE("machineId=#{machineId}");
				}
			}
		}.toString();
	}

	public String getAllMachineInfos(MachineInfo machineInfo) {
		return new SQL() {
			{
				SELECT("*").FROM("machineinfo");
				if (StringUtils.isNotBlank(machineInfo.getMachineName())) {
					WHERE("machineName=#{machineName}");
				}
				if (StringUtils.isNotBlank(machineInfo.getMachinePannel())) {
					WHERE("machinePannel=#{machinePannel}");
				}
				if (machineInfo.getManuFirmId() != null) {
					WHERE("manuFirmId=#{manuFirmId}");
				}
				if (machineInfo.getMachinePrice()!=null) {
					WHERE("machinePrice=#{machinePrice}");
				}
				if (StringUtils.isNotBlank(machineInfo.gettModelName())) {
					WHERE("tModelName=#{tModelName}");
				}
				if (machineInfo.getManuMachineStatus() != null) {
					WHERE("manuMachineStatus=#{manuMachineStatus}");
				}
				if (machineInfo.getOperFirmId() != null) {
					WHERE("operFirmId=#{operFirmId}");
				}
				if (machineInfo.getOperateId() != null) {
					WHERE("operateId=#{operateId}");
				}
			}
		}.toString();
	}

	public String deleteMachineInfo(Integer machineId) {
		return "DELETE FROM machineinfo WHERE machineId=#{machineId}";
	}
}
