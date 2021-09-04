package com.bibavix.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibavix.dto.PostDto;
import com.bibavix.dto.PostDtoResponse;
import com.bibavix.dto.SearchPostInput;
import com.bibavix.dto.SearchPostOutput;
import com.bibavix.entities.Post;
import com.bibavix.repository.PostRepository;
import com.bibavix.service.PostService;
import com.bibavix.util.Mapeo;
import com.bibavix.util.PostMapper;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private Mapeo maper;
	
	@Autowired
	private PostMapper postMapper;
	
	@Override
	public PostDtoResponse save(PostDto dto) {
		Post obj = new Post();
		PostDtoResponse response = new PostDtoResponse();
		
		try {
			obj = (Post) maper.convertToEntity(dto, obj);
			obj = postRepository.save(obj);
			response.setListaDto(postRepository.get(obj.getIdPost()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public PostDtoResponse getAll() {
		PostDtoResponse response = new PostDtoResponse();
		try {
			response.setListaDto(postRepository.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public PostDtoResponse get(int id) {
		PostDtoResponse response = new PostDtoResponse();
		
		try {
			response.setListaDto(postRepository.get(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PostDtoResponse getByIdUser(int idUser) {
		PostDtoResponse response = new PostDtoResponse();
		try {
			response.setListaDto(postRepository.getByUser(idUser));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public void delete(int idPost) {
		try {
			postRepository.deleteById(idPost);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<SearchPostOutput> searchPost(SearchPostInput searchPostInput){
		List<Post> posts = new ArrayList<Post>();
		posts = postRepository.searchPost(searchPostInput.getIdUser());
		return postMapper.toDtoList(posts);
	}

}
