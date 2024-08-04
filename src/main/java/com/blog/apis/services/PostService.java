package com.blog.apis.services;

import java.util.List;

import com.blog.apis.entities.Post;
import com.blog.apis.payload.PostDTO;
import com.blog.apis.payload.PostResponse;

public interface PostService {
	
	PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
	
	PostDTO updatePost(PostDTO postDTO, Integer postId);
	
	void deletePost(Integer postId);
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	
	PostDTO getPostById(Integer postId);
	
	PostResponse getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);
	
	PostResponse getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize);
	
	List<PostDTO> searchPosts(String keyword);
}
