package org.pbp.productservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.productservice.dto.request.CategoryRequest;
import org.pbp.productservice.dto.response.CategoryResponse;
import org.pbp.productservice.dto.response.MessageResponse;
import org.pbp.productservice.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryRequest> createCategory(@RequestBody CategoryRequest request) {
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryRequest> updateCategory(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(request));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long categoryId) {
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }

}
