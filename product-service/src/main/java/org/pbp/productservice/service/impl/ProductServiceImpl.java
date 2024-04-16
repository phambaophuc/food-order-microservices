package org.pbp.productservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.productservice.dto.ProductDto;
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
    public List<ProductDto> findAll() {
        return productRepo.findAll()
                .stream()
                .map(ProductMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long productId) {
        return productRepo.findById(productId)
                .map(ProductMapper::mapToDto)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found."));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return ProductMapper.mapToDto(productRepo.save(ProductMapper.mapToProduct(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return ProductMapper.mapToDto(productRepo.save(ProductMapper.mapToProduct(productDto)));
    }

    @Override
    public void deleteById(Long productId) {
        productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found."));
        productRepo.deleteById(productId);
    }
}
