package com.callor.mycar.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.mycar.models.MyCarDto;

public interface MyCarDao {

	@Select("select * from tbl_mycar order by mc_seq")
	public List<MyCarDto> selectAll();
	
	@Select("select * from tbl_mycar where mc_seq = #{id}")
	public MyCarDto findById(String id);
	
	public int insert(MyCarDto dto);
	
	public int update(MyCarDto dto);
	
	@Delete("delete from tbl_mycar where mc_seq = #{id}")
	public int delete(String id);
}
