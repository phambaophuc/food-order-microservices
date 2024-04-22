package org.pbp.productservice.service;

import org.pbp.productservice.dto.request.CategoryRequest;
import org.pbp.productservice.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> findAll();
    CategoryResponse findById(Long categoryId);
    CategoryRequest createCategory(CategoryRequest request);
    CategoryRequest updateCategory(CategoryRequest request);
    void deleteById(Long categoryId);
}
