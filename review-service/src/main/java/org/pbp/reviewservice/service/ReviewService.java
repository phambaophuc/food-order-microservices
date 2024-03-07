package org.pbp.reviewservice.service;

import org.pbp.reviewservice.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAll();
    ReviewDto findById(String reviewId);
    ReviewDto save(ReviewDto reviewDto);
    void deleteById(String reviewId);
    List<ReviewDto> findTop6ByOrderByCreatedAtDesc();
}
