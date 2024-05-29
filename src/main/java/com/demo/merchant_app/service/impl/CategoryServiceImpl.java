package com.demo.merchant_app.service.impl;

import com.demo.merchant_app.dto.CategoryDTO;
import com.demo.merchant_app.exception.ApiException;
import com.demo.merchant_app.models.Category;
import com.demo.merchant_app.repository.CategoryRepository;
import com.demo.merchant_app.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Category addCategory(CategoryDTO categoryDTO) throws ApiException {
        if (categoryRepository.existsByCategoryName(categoryDTO.getCategoryName())) {
            throw new ApiException("Category already exists");
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }
}
