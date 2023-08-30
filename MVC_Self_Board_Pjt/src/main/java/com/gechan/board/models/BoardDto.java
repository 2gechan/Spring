package com.gechan.board.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
	
	private long b_seq; // bigint primary key auto_increment,
	private String b_uid; // varchar(25),
	private String b_title; // varchar(125),
	private String b_content; // varchar(1000),
	private String b_nickname; // varchar(125),
	private String b_date; // varchar(10),
	private long b_viewcount; // long

}
