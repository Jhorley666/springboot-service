package com.bibavix.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibavix.dto.UserDto;
import com.bibavix.dto.UserDtoResponse;
import com.bibavix.entities.User;
import com.bibavix.repository.UserRepository;
import com.bibavix.service.UserService;
import com.bibavix.util.Mapeo;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private Mapeo maper;
	
	@Override
	public UserDtoResponse register(UserDto user) {
		User obj = new User();
		UserDtoResponse response = new UserDtoResponse();
		try {
			obj = (User) maper.convertToEntity(user, obj);
			obj = repository.save(obj);
			
			response.setListaDto(repository.getUserById(obj.getIdUser()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public UserDtoResponse getAll() {
		UserDtoResponse response = new UserDtoResponse();
		
		try {
			response.setListaDto(repository.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public UserDtoResponse get(int id) {
		UserDtoResponse response = new UserDtoResponse();
		try {
			response.setListaDto(repository.getUserById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
