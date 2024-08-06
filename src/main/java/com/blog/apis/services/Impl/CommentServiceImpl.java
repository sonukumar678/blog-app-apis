package com.blog.apis.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entities.Comment;
import com.blog.apis.entities.Post;
import com.blog.apis.exceptions.ResourceNotFoundException;
import com.blog.apis.payload.CommentDTO;
import com.blog.apis.repository.CommentRepositoy;
import com.blog.apis.repository.PostRepository;
import com.blog.apis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepositoy commentRepositoy;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDTO createComment(CommentDTO commentDTO, Integer postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		Comment comment = this.modelMapper.map(commentDTO, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepositoy.save(comment);
		return this.modelMapper.map(savedComment, CommentDTO.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment cId = this.commentRepositoy.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "Comment Id", commentId));
		this.commentRepositoy.delete(cId);
	}

}
