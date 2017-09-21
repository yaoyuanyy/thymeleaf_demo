package com.yy.mapper;

import com.yy.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chuping.cui
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return
	 */
	User getUserByName(String name);

	long insert(User user);
	
}
