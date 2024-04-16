package org.pbp.productservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.productservice.dto.ProductDto;
import org.pbp.productservice.dto.response.MessageResponse;
import org.pbp.productservice.exception.ProductNotFoundException;
import org.pbp.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.update(productDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long productId) {
        try {
            productService.deleteById(productId);
            return ResponseEntity.ok(new MessageResponse("Deleted Successfully."));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.ok(new MessageResponse("Product not found with id " + productId));
        }
    }
}
