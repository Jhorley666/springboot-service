package com.bibavix.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bibavix.dto.PostDto;
import com.bibavix.dto.PostDtoResponse;
import com.bibavix.dto.SearchPostInput;
import com.bibavix.dto.SearchPostOutput;
import com.bibavix.serviceImpl.PostServiceImpl;

@RestController
@RequestMapping(value = "/api/post")
public class PostApi {
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public PostDtoResponse save(@RequestBody PostDto post) {
		return postServiceImpl.save(post);
	}
	
	@RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
	public PostDtoResponse getAll() {
		return postServiceImpl.getAll();
	}
	
	@RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
	public PostDtoResponse getById(@PathVariable("id") int id) {
		return postServiceImpl.get(id);
	}
	
	@RequestMapping(value = "/user/{id}", produces = "application/json", method = RequestMethod.GET)
	public PostDtoResponse getByIdUser(@PathVariable("id") int id) {
		return postServiceImpl.getByIdUser(id);
	}
	
	@PostMapping(value = "/delete/{id}", produces = "application/json")
	public void deletePost(@PathVariable("id") int id) {
		postServiceImpl.delete(id);
	}
	
	/*
	 * @RequestBody The body of the request.
	 * @param un DTOInput 
	 * 	JSON EXAMPLE: {"idUser":1}
	 * @return Lista de DTOOuput 
	 * 	JSON EXAMPLE: {
	 * 					{	"idPost": 2, 
	 * 						"idUser": 0
	 * 					}
	 * 				 } 
	 * */
	
	@GetMapping(value = "/find")
	public List<SearchPostOutput> searchPost(@RequestBody SearchPostInput searchPostInput){
		return postServiceImpl.searchPost(searchPostInput);
	}
	
}
