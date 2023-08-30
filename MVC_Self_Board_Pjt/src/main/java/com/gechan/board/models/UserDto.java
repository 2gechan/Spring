package com.gechan.board.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@lombok.Builder
public class UserDto {
	
	private String u_id;
	private String u_password;
	private String u_name;
	private String u_tel;
	private String u_addr;

}
