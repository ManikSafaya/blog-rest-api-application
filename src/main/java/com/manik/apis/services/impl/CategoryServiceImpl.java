package com.manik.apis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manik.apis.entities.Category;
import com.manik.apis.exceptions.ResourceNotFoundException;
import com.manik.apis.payloads.CategoryDto;
import com.manik.apis.repositories.CategoryRepo;
import com.manik.apis.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category newCategory = this.categoryRepo.save(this.modelMapper.map(categoryDto, Category.class));
		return this.modelMapper.map(newCategory, CategoryDto.class);

	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCategory = this.categoryRepo.save(category);

		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
	  Category category = this.categoryRepo.findById(categoryId).
	  orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
	  
	  this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).
		orElseThrow(()->new ResourceNotFoundException("Category", "CategoryId", categoryId));
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		
		return categories.stream().map((category)->this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
		
	}

}
