package org.pbp.reviewservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.reviewservice.dto.request.ReviewRequest;
import org.pbp.reviewservice.dto.response.MessageResponse;
import org.pbp.reviewservice.dto.response.ReviewResponse;
import org.pbp.reviewservice.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewResponse>> findAll() {
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> findById(@PathVariable String reviewId) {
        return ResponseEntity.ok(reviewService.findById(reviewId));
    }

    @PostMapping
    public ResponseEntity<ReviewRequest> createReview(@RequestBody ReviewRequest request) {
        return new ResponseEntity<>(reviewService.createReview(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable String reviewId) {
        reviewService.deleteById(reviewId);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }
}
