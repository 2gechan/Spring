package com.gechan.board.dao;

import java.util.List;

import com.gechan.board.models.UserDto;

public interface UserDao {
	
	public List<UserDto> selectAll();
	
	public int insert(UserDto userDto);

	public UserDto findById(String u_id);

}
