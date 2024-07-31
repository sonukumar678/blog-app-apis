package com.blog.apis.services;

import java.util.List;

import com.blog.apis.payload.CategoryDTO;

public interface CategoryService {
	
	 CategoryDTO createCategory(CategoryDTO categoryDTO);
	
	 CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
	
	 void deleteCategory(Integer categoryId);
	
	 CategoryDTO getCategory(Integer categoryId);
	
	 List<CategoryDTO> getCategories();

}
