package org.pbp.orderservice.mapper;

import org.pbp.orderservice.dto.request.OrderItemRequest;
import org.pbp.orderservice.dto.response.OrderItemResponse;
import org.pbp.orderservice.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItemRequest mapToRequest(OrderItem orderItem) {
        return OrderItemRequest.builder()
                .productId(orderItem.getProductId())
                .price(orderItem.getPrice())
                .quantity(orderItem.getQuantity())
                .build();
    }

    public static OrderItemResponse mapToResponse(OrderItem orderItem) {
        return OrderItemResponse.builder()
                .id(orderItem.getId())
                .productId(orderItem.getProductId())
                .price(orderItem.getPrice())
                .quantity(orderItem.getQuantity())
                .order(orderItem.getOrder())
                .build();
    }

    public static OrderItem mapToOrderItem(OrderItemRequest orderItemRequest) {
        return OrderItem.builder()
                .productId(orderItemRequest.getProductId())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .build();
    }
}
