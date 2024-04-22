package org.pbp.productservice.mapper;

import org.pbp.productservice.dto.request.CategoryRequest;
import org.pbp.productservice.dto.response.CategoryResponse;
import org.pbp.productservice.entity.Category;

public class CategoryMapper {

    public static CategoryRequest mapToRequest(Category category) {
        return CategoryRequest.builder()
                .name(category.getName())
                .build();
    }

    public static CategoryResponse mapToResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category mapToCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .build();
    }
}
