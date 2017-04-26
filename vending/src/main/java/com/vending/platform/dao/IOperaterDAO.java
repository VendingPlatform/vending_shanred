package com.vending.platform.dao;

import org.apache.ibatis.annotations.Select;

public interface IOperaterDAO {
    
    @Select("UPDATE machineOperater SET userId=NULL, machineAssign=0 WHERE mOperaterId=#{mOperaterId}")
    public void removeUserMachineOperater(Integer mOperaterId);
    
  
}
