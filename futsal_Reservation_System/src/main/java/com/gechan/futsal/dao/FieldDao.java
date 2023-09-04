package com.gechan.futsal.dao;

import java.util.List;

import com.gechan.futsal.models.FieldDto;

public interface FieldDao {
	
	public int insert(FieldDto fieldDto);

	public List<FieldDto> selectAll();
	
	public FieldDto findById(long cnumber);
	
	public int update(FieldDto fieldDto);
	
	public int delete(long cnumber);

}
