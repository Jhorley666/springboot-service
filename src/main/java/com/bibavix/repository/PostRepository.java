package com.bibavix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bibavix.dto.PostDto;
import com.bibavix.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	String queryAll = "select new com.bibavix.dto.PostDto(t.idPost, t.textPost, t.user.idUser) " +
					 "from Post t " + 
					 "where 1=1";
	@Query(value = queryAll)
	public List<PostDto> getAll();
	
	@Query(value = queryAll + " and t.idPost=?1")
	public List<PostDto> get(int id);
	
	@Query(value = queryAll + " and t.user.idUser=?1")
	public List<PostDto> getByUser(int idUser);
	
	@Query("select P from Post P where P.user.idUser = :idUser")
	public List<Post> searchPost(int idUser);
	
}
