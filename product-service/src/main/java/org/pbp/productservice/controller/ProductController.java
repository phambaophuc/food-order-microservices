package org.pbp.productservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.productservice.dto.request.ProductRequest;
import org.pbp.productservice.dto.response.MessageResponse;
import org.pbp.productservice.dto.response.ProductResponse;
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
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductRequest> updateProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(request));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long productId) {
        productService.deleteById(productId);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully."));
    }
}
