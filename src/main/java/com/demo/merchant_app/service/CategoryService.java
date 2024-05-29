package com.demo.merchant_app.service;

import com.demo.merchant_app.dto.CategoryDTO;
import com.demo.merchant_app.exception.ApiException;
import com.demo.merchant_app.models.Category;

public interface CategoryService {
    Category addCategory(CategoryDTO categoryDTO) throws ApiException;
}
