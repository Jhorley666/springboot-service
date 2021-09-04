package com.bibavix.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bibavix.dto.UserDto;
import com.bibavix.dto.UserDtoResponse;
import com.bibavix.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/user")
public class UserApi {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value = "/register", produces = "application/json", method = RequestMethod.POST)
	public UserDtoResponse register(@RequestBody UserDto userDto) {
		return userServiceImpl.register(userDto);
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	public UserDtoResponse getAll() {
		return userServiceImpl.getAll();
	}
	
	@RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
	public UserDtoResponse getOne(@PathVariable("id") int id) {
		return userServiceImpl.get(id);
	}
	
}
