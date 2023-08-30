package com.gechan.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gechan.board.dao.UserDao;
import com.gechan.board.models.UserDto;
import com.gechan.board.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {
	
	protected final UserDao userDao;
	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int insert(UserDto userDto) {
		// TODO Auto-generated method stub
		return userDao.insert(userDto);
	}

	@Override
	public List<UserDto> selectAll() {
		
		return userDao.selectAll();
	}

	@Override
	public String login(String u_id, String u_password) {
		UserDto userDto = userDao.findById(u_id);
		if(userDto != null) {
			if(userDto.getU_password().equals(u_password)) {
				return "LOGINOK";
			} else {
				return "PWDMISS";
			}
		} else {
			return "IDMISS";
		}
	}

	@Override
	public String join_check(UserDto userDto) {
		userDto = userDao.findById(userDto.getU_id());
		if(userDto != null) {
			return "SAMEID";
		} else {
			return "IDOK";
		}
	}

	@Override
	public UserDto findById(String u_id) {
		// TODO Auto-generated method stub
		return userDao.findById(u_id);
	}


}
