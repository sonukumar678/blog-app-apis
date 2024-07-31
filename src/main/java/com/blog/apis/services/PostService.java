package com.blog.apis.services;

import java.util.List;

import com.blog.apis.entities.Post;
import com.blog.apis.payload.PostDTO;

public interface PostService {
	
	PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
	
	Post updatePost(PostDTO postDTO, Integer postId);
	
	void deletePost(Integer postId);
	
	List<Post> getAllPost(PostDTO postDTO);
	
	Post getPostById(Integer postId);
	
	List<Post> getPostsByCategory(Integer categoryId);
	
	List<Post> getPostsByUser(Integer userId);
	
	List<Post> searchPosts(String keyword);
}
