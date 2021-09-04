package com.bibavix.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDtoResponse {
	List<UserDto> listaDto;
	public UserDtoResponse () {
		super();
		listaDto = new ArrayList<>();
	}
	
	public void addListDto(UserDto userDto)
	{
		listaDto.add(userDto);
	}
	
}
