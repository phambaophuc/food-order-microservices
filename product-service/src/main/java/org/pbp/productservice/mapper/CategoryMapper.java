package org.pbp.productservice.mapper;

import org.pbp.productservice.dto.CategoryDto;
import org.pbp.productservice.entity.Category;

public interface CategoryMapper {

    static CategoryDto mapToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    static Category mapToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
    }
}
