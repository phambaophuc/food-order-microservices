package org.pbp.productservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.productservice.dto.request.CategoryRequest;
import org.pbp.productservice.dto.response.CategoryResponse;
import org.pbp.productservice.exception.CategoryNotFoundException;
import org.pbp.productservice.mapper.CategoryMapper;
import org.pbp.productservice.repository.CategoryRepo;
import org.pbp.productservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepo.findAll()
                .stream()
                .map(CategoryMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse findById(Long categoryId) {
        return categoryRepo.findById(categoryId)
                .map(CategoryMapper::mapToResponse)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryId + " not found."));
    }

    @Override
    public CategoryRequest createCategory(CategoryRequest request) {
        return CategoryMapper.mapToRequest(categoryRepo.save(CategoryMapper.mapToCategory(request)));
    }

    @Override
    public CategoryRequest updateCategory(CategoryRequest request) {
        return CategoryMapper.mapToRequest(categoryRepo.save(CategoryMapper.mapToCategory(request)));
    }

    @Override
    public void deleteById(Long categoryId) {
        categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryId + " not found."));
        categoryRepo.deleteById(categoryId);
    }
}
