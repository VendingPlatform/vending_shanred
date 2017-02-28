package com.lin.dao;

import org.apache.ibatis.annotations.*;

import com.lin.domain.User;

/**
 * 功能概要：User的DAO类
 * 
 * @author linbingwen
 * @since 2015年9月28日
 */
public interface UserDao {
	/*若pojo类字段名和数据库表一致，可以省略results*/
	@Select("SELECT * FROM t_test WHERE user_id = #{userId}")
	/*@Results({ @Result(id = true, column = "USER_ID", property = "userId"),
			@Result(column = "USER_NAME", property = "userName"),
			@Result(column = "USER_PASSWORD", property = "userPassword"),
			@Result(column = "USER_EMAIL", property = "userEmail") })*/
	public User selectUserById(Integer userId);

}