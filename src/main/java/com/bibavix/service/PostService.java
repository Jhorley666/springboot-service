package com.bibavix.service;

import com.bibavix.dto.PostDto;
import com.bibavix.dto.PostDtoResponse;

public interface PostService {
	public PostDtoResponse save(PostDto dto);
	public PostDtoResponse getAll();
	public PostDtoResponse get(int id);
	public PostDtoResponse getByIdUser(int idUser);
	public void delete(int idPost);
}
