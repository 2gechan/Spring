package com.callor.mycar.models.service;

import java.util.List;

import com.callor.mycar.models.MyCarDto;

public interface MyCarService {
	
	public List<MyCarDto> selectAll();
	public MyCarDto findById(String id);
	public MyCarDto insert(MyCarDto dto);
	public MyCarDto update(MyCarDto dto);
	public int delete(String id);
	
	public String date();
	public String time();

}
