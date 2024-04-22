package org.pbp.productservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.productservice.dto.request.ProductRequest;
import org.pbp.productservice.dto.response.ProductResponse;
import org.pbp.productservice.exception.ProductNotFoundException;
import org.pbp.productservice.mapper.ProductMapper;
import org.pbp.productservice.repository.ProductRepo;
import org.pbp.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public List<ProductResponse> findAll() {
        return productRepo.findAll()
                .stream()
                .map(ProductMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(Long productId) {
        return productRepo.findById(productId)
                .map(ProductMapper::mapToResponse)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found."));
    }

    @Override
    public ProductRequest createProduct(ProductRequest request) {
        return ProductMapper.mapToRequest(productRepo.save(ProductMapper.mapToProduct(request)));
    }

    @Override
    public ProductRequest updateProduct(ProductRequest request) {
        return ProductMapper.mapToRequest(productRepo.save(ProductMapper.mapToProduct(request)));
    }

    @Override
    public void deleteById(Long productId) {
        productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found."));
        productRepo.deleteById(productId);
    }
}
