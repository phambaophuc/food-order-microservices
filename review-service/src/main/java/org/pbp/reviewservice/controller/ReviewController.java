package org.pbp.reviewservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.reviewservice.dto.ReviewDto;
import org.pbp.reviewservice.dto.response.MessageResponse;
import org.pbp.reviewservice.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@AllArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> findAll() {
        log.info("** Review controller: find all reviews *");
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping("/top-6")
    public ResponseEntity<List<ReviewDto>> findTop6ByOrderByCreatedAtDesc() {
        log.info("** Review controller: find top 6 new reviews *");
        return ResponseEntity.ok(reviewService.findTop6ByOrderByCreatedAtDesc());
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> findById(@PathVariable String reviewId) {
        log.info("** Review controller: find review by id *");
        return ResponseEntity.ok(reviewService.findById(reviewId));
    }

    @PostMapping
    public ResponseEntity<ReviewDto> save(@RequestBody ReviewDto reviewDto) {
        log.info("** Review controller: save review *");
        return new ResponseEntity<>(reviewService.save(reviewDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable String reviewId) {
        log.info("** Review controller: delete review by id *");
        reviewService.deleteById(reviewId);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }
}
