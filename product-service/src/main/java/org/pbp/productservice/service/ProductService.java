package org.pbp.productservice.service;

import org.pbp.productservice.dto.request.ProductRequest;
import org.pbp.productservice.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAll();
    ProductResponse findById(Long productId);
    ProductRequest createProduct(ProductRequest request);
    ProductRequest updateProduct(ProductRequest request);
    void deleteById(Long productId);
}
