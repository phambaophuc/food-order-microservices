package org.pbp.orderservice.document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "OrderItem")
public class OrderItem {
    private Long productId;
    private Integer quantity;
}
