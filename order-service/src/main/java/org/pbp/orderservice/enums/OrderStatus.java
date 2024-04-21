package org.pbp.orderservice.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED,
    REFUNDED,
    COMPLETED
}
