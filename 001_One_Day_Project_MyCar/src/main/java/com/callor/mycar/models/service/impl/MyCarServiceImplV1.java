package com.callor.mycar.models.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.callor.mycar.dao.MyCarDao;
import com.callor.mycar.models.MyCarDto;
import com.callor.mycar.models.service.MyCarService;

@Service
public class MyCarServiceImplV1 implements MyCarService {

	protected final MyCarDao mcDao;
	
	public MyCarServiceImplV1(MyCarDao mcDao) {
		this.mcDao = mcDao;
	}

	@Override
	public List<MyCarDto> selectAll() {
		List<MyCarDto> mcList = mcDao.selectAll();
		return mcList;
	}
	
	@Override
	public MyCarDto findById(String id) {
		MyCarDto dto = mcDao.findById(id);
		return dto;
	}

	@Override
	public MyCarDto insert(MyCarDto dto) {
		mcDao.insert(dto);
		return dto;
	}

	@Override
	public MyCarDto update(MyCarDto dto) {
		mcDao.update(dto);
		return dto;
	}
	
	@Override
	public int delete(String id) {
		int result = mcDao.delete(id);
		return result;
	}
	
	@Override
	public String date() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String nowDate = dateFormat.format(date);
		return nowDate;
	}

	@Override
	public String time() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		String nowTime  = timeFormat.format(date);
		return nowTime;
	}



	
}
