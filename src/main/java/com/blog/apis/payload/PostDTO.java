package com.blog.apis.payload;

import java.util.Date;

import com.blog.apis.entities.Category;
import com.blog.apis.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {
	
	private Integer postId;

	private String title;

	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDTO category;
	
	private UserDTO user;


}
