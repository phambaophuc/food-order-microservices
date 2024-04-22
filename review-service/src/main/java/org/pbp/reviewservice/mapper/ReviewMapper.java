package org.pbp.reviewservice.mapper;

import org.pbp.reviewservice.document.Review;
import org.pbp.reviewservice.dto.request.ReviewRequest;
import org.pbp.reviewservice.dto.response.ReviewResponse;

public class ReviewMapper {

    public static ReviewRequest mapToRequest(Review review) {
        return ReviewRequest.builder()
                .customer(review.getCustomer())
                .comment(review.getComment())
                .rating(review.getRating())
                .productId(review.getProductId())
                .build();
    }

    public static ReviewResponse mapToResponse(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .customer(review.getCustomer())
                .comment(review.getComment())
                .rating(review.getRating())
                .productId(review.getProductId())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    public static Review mapToReview(ReviewRequest reviewRequest) {
        return Review.builder()
                .customer(reviewRequest.getCustomer())
                .comment(reviewRequest.getComment())
                .rating(reviewRequest.getRating())
                .productId(reviewRequest.getProductId())
                .build();
    }
}
