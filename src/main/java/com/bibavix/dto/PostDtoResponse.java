package com.bibavix.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PostDtoResponse {
	List<PostDto> listaDto;
	public PostDtoResponse () {
		super();
		listaDto = new ArrayList<>();
	}
	
	public void addListDto(PostDto postDto)
	{
		listaDto.add(postDto);
	}
}
