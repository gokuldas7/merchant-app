package com.demo.merchant_app.controller;

import com.demo.merchant_app.dto.CategoryDTO;
import com.demo.merchant_app.exception.ApiException;
import com.demo.merchant_app.models.Category;
import com.demo.merchant_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) throws ApiException {
        return ResponseEntity.ok(categoryService.addCategory(categoryDTO));
    }
}
