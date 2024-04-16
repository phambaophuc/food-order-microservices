package org.pbp.reviewservice.service;

import lombok.AllArgsConstructor;
import org.pbp.reviewservice.dto.ReviewDto;
import org.pbp.reviewservice.mapper.ReviewMapper;
import org.pbp.reviewservice.repository.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    public List<ReviewDto> findAll() {
        return reviewRepo.findAll()
                .stream()
                .map(ReviewMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto findById(String reviewId) {
        return reviewRepo.findById(reviewId)
                .map(ReviewMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        return ReviewMapper.mapToDto(reviewRepo.save(ReviewMapper.mapToReview(reviewDto)));
    }

    @Override
    public void deleteById(String reviewId) {
        reviewRepo.deleteById(reviewId);
    }

}
