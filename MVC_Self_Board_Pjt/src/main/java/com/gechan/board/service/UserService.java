package com.gechan.board.service;

import java.util.List;

import com.gechan.board.models.UserDto;

public interface UserService {
	
	public List<UserDto> selectAll();
	
	public int insert(UserDto userDto);

	public String login(String u_id, String string);

	public String join_check(UserDto userDto);

	public UserDto findById(String u_id);

}
