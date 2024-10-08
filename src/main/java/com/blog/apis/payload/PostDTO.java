package com.blog.apis.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.apis.entities.Category;
import com.blog.apis.entities.Comment;
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
	
	private Set<CommentDTO> comments = new HashSet<>();


}
