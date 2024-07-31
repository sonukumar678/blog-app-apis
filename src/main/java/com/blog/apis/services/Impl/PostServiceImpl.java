package com.blog.apis.services.Impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entities.Category;
import com.blog.apis.entities.Post;
import com.blog.apis.entities.User;
import com.blog.apis.exceptions.ResourceNotFoundException;
import com.blog.apis.payload.PostDTO;
import com.blog.apis.repository.CategoryRepository;
import com.blog.apis.repository.PostRepository;
import com.blog.apis.repository.UserRepository;
import com.blog.apis.services.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public PostDTO createPost(PostDTO postDTO,Integer userId, Integer categoryId) {
		User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		Post post = this.modelMapper.map(postDTO, Post.class);
		post.setImageName("default.jpg");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost = this.postRepository.save(post);
		return this.modelMapper.map(newPost, PostDTO.class);
	}

	@Override
	public Post updatePost(PostDTO postDTO, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost(PostDTO postDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
