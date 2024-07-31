package com.blog.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
