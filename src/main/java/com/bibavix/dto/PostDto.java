package com.bibavix.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements _DtoEntity{
	private int idPost;
	private String textPost;
	private int idUser;
}
