package com.bibavix.service;

import com.bibavix.dto.UserDto;
import com.bibavix.dto.UserDtoResponse;

public interface UserService {
	public UserDtoResponse register(UserDto user);
	public UserDtoResponse getAll();
	public UserDtoResponse get(int id);
}
