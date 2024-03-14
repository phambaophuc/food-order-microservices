package org.pbp.orderservice.document;

import lombok.Data;

@Data
public class OrderItem {

    private Long productId;
    private Integer quantity;
}
