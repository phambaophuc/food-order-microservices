package org.pbp.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private String imageUrl;
    private BigDecimal price;
}
