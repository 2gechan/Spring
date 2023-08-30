package com.gechan.futsal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FieldDto {
	private String f_cnumber;
	private String f_uid;
    private String f_name;
	private String f_tel;
}
