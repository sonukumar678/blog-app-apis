package com.blog.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
