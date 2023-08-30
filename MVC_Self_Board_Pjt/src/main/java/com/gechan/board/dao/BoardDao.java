package com.gechan.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gechan.board.models.BoardDto;

public interface BoardDao {

	@Select("select * from tbl_board order by b_seq desc")
	public List<BoardDto> selectAll();

	public int insert(BoardDto boardDto);

	@Select("select * from tbl_board where b_seq = #{id}")
	public BoardDto findById(long id);

	public int update(BoardDto boardDto);

	
	
	@Select("select * from tbl_board limit #{limit} offset #{offset}")
	public List<BoardDto> selectPage(@Param("limit") int limit, @Param("offset") int offset);
	
	@Select("select count(*) from tbl_board")
	public int selectCount();

	@Select("select * from tbl_board where b_uid = #{u_id}")
	public List<BoardDto> findByUser(String u_id);
}
