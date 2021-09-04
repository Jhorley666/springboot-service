package com.bibavix.util;

import org.mapstruct.Mapper;
import java.util.List;

import com.bibavix.dto.SearchPostInput;
import com.bibavix.dto.SearchPostOutput;
import com.bibavix.entities.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
	SearchPostInput toSearch(Post post);
	List<SearchPostOutput> toDtoList(List<Post> post);
}
