package com.blog.apis.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entities.Category;
import com.blog.apis.exceptions.ResourceNotFoundException;
import com.blog.apis.payload.CategoryDTO;
import com.blog.apis.repository.CategoryRepository;
import com.blog.apis.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category cat = this.modelMapper.map(categoryDTO, Category.class);
		Category addCat = this.categoryRepository.save(cat);
		return this.modelMapper.map(addCat, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		cat.setCategoryTitle(categoryDTO.getCategoryTitle());
		cat.setCategoryDescription(categoryDTO.getCategoryDescription());
		Category UpdatedCat = this.categoryRepository.save(cat);
		return this.modelMapper.map(UpdatedCat, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		this.categoryRepository.delete(cat);
	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		return this.modelMapper.map(cat, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getCategories() {
		List<Category> allCat = this.categoryRepository.findAll();
		List<CategoryDTO> categoriesDTO = allCat.stream().map(cat ->this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return categoriesDTO;
	}

}
