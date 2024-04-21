package org.pbp.productservice.mapper;

import org.pbp.productservice.dto.CategoryDto;
import org.pbp.productservice.dto.ProductDto;
import org.pbp.productservice.entity.Category;
import org.pbp.productservice.entity.Product;

public interface ProductMapper {

    static ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .categoryDto(
                        CategoryDto.builder()
                                .id(product.getCategory().getId())
                                .name(product.getCategory().getName())
                                .build()
                )
                .build();
    }

    static Product mapToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .imageUrl(productDto.getImageUrl())
                .price(productDto.getPrice())
                .category(
                        Category.builder()
                                .id(productDto.getCategoryDto().getId())
                                .name(productDto.getCategoryDto().getName())
                                .build()
                )
                .build();
    }
}
