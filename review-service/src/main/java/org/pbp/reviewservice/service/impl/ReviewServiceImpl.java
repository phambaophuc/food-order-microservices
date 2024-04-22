package org.pbp.reviewservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.reviewservice.dto.request.ReviewRequest;
import org.pbp.reviewservice.dto.response.ReviewResponse;
import org.pbp.reviewservice.mapper.ReviewMapper;
import org.pbp.reviewservice.repository.ReviewRepo;
import org.pbp.reviewservice.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    public List<ReviewResponse> findAll() {
        return reviewRepo.findAll()
                .stream()
                .map(ReviewMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponse findById(String reviewId) {
        return reviewRepo.findById(reviewId)
                .map(ReviewMapper::mapToResponse)
                .orElseThrow();
    }

    @Override
    public ReviewRequest createReview(ReviewRequest reviewDto) {
        return ReviewMapper.mapToRequest(reviewRepo.save(ReviewMapper.mapToReview(reviewDto)));
    }

    @Override
    public void deleteById(String reviewId) {
        reviewRepo.deleteById(reviewId);
    }

}
