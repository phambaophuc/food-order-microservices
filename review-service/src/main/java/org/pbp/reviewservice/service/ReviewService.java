package org.pbp.reviewservice.service;

import org.pbp.reviewservice.dto.request.ReviewRequest;
import org.pbp.reviewservice.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewService {

    List<ReviewResponse> findAll();
    ReviewResponse findById(String reviewId);
    ReviewRequest createReview(ReviewRequest request);
    void deleteById(String reviewId);
}
