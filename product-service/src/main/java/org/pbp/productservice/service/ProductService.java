package org.pbp.productservice.service;

import org.pbp.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Long categoryId);
    ProductDto save(ProductDto categoryDto);
    ProductDto update(ProductDto categoryDto);
    void deleteById(Long categoryId);
}
