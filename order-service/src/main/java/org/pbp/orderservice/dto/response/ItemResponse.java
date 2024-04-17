package org.pbp.orderservice.dto.response;

import lombok.Builder;
import lombok.Data;
import org.pbp.orderservice.dto.ProductDto;

@Data
@Builder
public class ItemResponse {
    private ProductDto product;
    private Integer quantity;
}
