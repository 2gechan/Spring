package com.gechan.futsal.service;

import java.util.List;

import com.gechan.futsal.models.FieldDto;

public interface FieldService {

	public int insert(FieldDto filedDto);

	public int delete(long cnumber);

	public List<FieldDto> selectAll();

	public FieldDto findById(long cnumber);

	public int update(FieldDto fieldDto);

}
