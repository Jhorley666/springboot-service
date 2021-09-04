package com.bibavix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bibavix.dto.UserDto;
import com.bibavix.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	String queryAll = "select new com.bibavix.dto.UserDto (t.idUser, t.name, t.email, t.password) " + 
                      "from User t " +
                      "where 1=1";
	@Query(value = queryAll)
	public List<UserDto> getAll();
	
	@Query (value = queryAll + " and t.id=?1")
	public List<UserDto> getUserById(int id);
	
}
