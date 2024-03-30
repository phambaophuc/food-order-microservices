package org.pbp.reviewservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.reviewservice.client.EmotionPredictionClient;
import org.pbp.reviewservice.dto.ReviewDto;
import org.pbp.reviewservice.mapper.ReviewMapper;
import org.pbp.reviewservice.repository.ReviewRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final EmotionPredictionClient emotionClient;

    @Override
    @Cacheable("reviews")
    public List<ReviewDto> findAll() {
        log.info("** Review service: find all reviews *");
        return reviewRepo.findAll()
                .stream()
                .map(review -> {
                    ReviewDto reviewDto = ReviewMapper.mapToDto(review);
                    reviewDto.setEmotion(emotionClient.predictEmotion(review.getComment()));
                    return reviewDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto findById(String reviewId) {
        log.info("** Review service: find review by id *");
        return reviewRepo.findById(reviewId)
                .map(ReviewMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    @CacheEvict(value = "reviews", allEntries = true)
    public ReviewDto save(ReviewDto reviewDto) {
        log.info("** Review service: save review *");
        return ReviewMapper.mapToDto(reviewRepo.save(ReviewMapper.mapToReview(reviewDto)));
    }

    @Override
    public void deleteById(String reviewId) {
        log.info("** Review service: delete review by id *");
        reviewRepo.deleteById(reviewId);
    }

    @Override
    public List<ReviewDto> findTop6ByOrderByCreatedAtDesc() {
        log.info("** Review service: find top 3 new reviews *");
        return reviewRepo.findTop6ByOrderByCreatedAtDesc()
                .stream()
                .map(ReviewMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
