package com.blog.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entities.Comment;

public interface CommentRepositoy extends JpaRepository<Comment, Integer>{

}
