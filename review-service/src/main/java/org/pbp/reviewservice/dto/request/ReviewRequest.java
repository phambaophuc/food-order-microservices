package org.pbp.reviewservice.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequest {
    @Size(min = 2, max = 30, message = "Customer name must be between 2 and 30 characters")
    private String customer;

    @Size(max = 1000, message = "Comment must be at most 1000 characters")
    private String comment;

    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;
    private Long productId;
}
