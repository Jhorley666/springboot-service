package com.bibavix.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bibavix.dto._DtoEntity;

@Component
public class Mapeo {

	public _DtoEntity convertToDto(Object obj, _DtoEntity dto) {
		ModelMapper modelMapper = new ModelMapper(); 
		return modelMapper.map(obj, dto.getClass());
	}
	
	public Object convertToEntity(_DtoEntity dto, Object obj) {
		ModelMapper modelMapper = new ModelMapper(); 
		return modelMapper.map(dto, obj.getClass());
	}
	
}
