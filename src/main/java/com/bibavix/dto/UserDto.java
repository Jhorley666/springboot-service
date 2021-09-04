package com.bibavix.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements _DtoEntity{
	private int idUser;
	private String name;
	private String email;
	private String password;
}
