package org.pbp.reviewservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponse {
    private String id;
    private String customer;
    private String comment;
    private Integer rating;
    private Long productId;
    private Date createdAt;
    private Date updatedAt;
}
