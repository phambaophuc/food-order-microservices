package org.pbp.productservice.mapper;

import org.pbp.productservice.dto.request.ProductRequest;
import org.pbp.productservice.dto.response.ProductResponse;
import org.pbp.productservice.entity.Product;

public class ProductMapper {

    public static ProductRequest mapToRequest(Product product) {
        return ProductRequest.builder()
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .categoryRequest(CategoryMapper
                        .mapToRequest(product.getCategory()))
                .build();
    }

    public static ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .categoryResponse(CategoryMapper
                        .mapToResponse(product.getCategory()))
                .build();
    }

    public static Product mapToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .imageUrl(productRequest.getImageUrl())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .category(CategoryMapper
                        .mapToCategory(productRequest.getCategoryRequest()))
                .build();
    }
}
