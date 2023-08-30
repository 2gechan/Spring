package com.callor.mycar.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyCarDto {
	private long mc_seq; 		//	bigint
	private String mc_div;		 
	private String mc_sdate; 	
	private String mc_stime; 	
	private String mc_sdistance;
	private String mc_edate; 
	private String mc_etime;
	private String mc_place;
	private String mc_edistance;
	private String mc_cost; 


}
