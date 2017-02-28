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
	/** 若pojo类字段名和数据库表一致，可以省略results */
	@Select("SELECT * FROM t_test WHERE user_id = #{userId}")
	@Results({ @Result(id = true, column = "user_id", property = "user_id"),
			@Result(column = "user_name", property = "user_name"),
			@Result(column = "user_password", property = "user_password"),
			@Result(column = "user_email", property = "user_email") })
	public User selectUserById(Integer userId);

}