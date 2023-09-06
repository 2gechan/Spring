package com.gechan.futsal.dao;

import org.apache.ibatis.annotations.Param;

public interface ReservationDao {
	
	public int insert(@Param("r_fname") String f_name, @Param("r_uteam") String u_team, @Param("r_uname") String u_name);
	
	public int delete(long seq);

}
