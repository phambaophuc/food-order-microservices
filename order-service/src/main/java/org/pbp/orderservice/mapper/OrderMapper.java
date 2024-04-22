package org.pbp.orderservice.mapper;

import org.pbp.orderservice.dto.request.OrderRequest;
import org.pbp.orderservice.dto.response.OrderResponse;
import org.pbp.orderservice.entity.Order;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderRequest mapToRequest(Order order) {
        return OrderRequest.builder()
                .customerId(order.getCustomerId())
                .status(order.getStatus())
                .items(order.getItems()
                        .stream()
                        .map(OrderItemMapper::mapToRequest)
                        .collect(Collectors.toList()))
                .build();
    }

    public static OrderResponse mapToResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .items(order.getItems()
                        .stream()
                        .map(OrderItemMapper::mapToResponse)
                        .collect(Collectors.toList()))
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    public static Order mapToOrder(OrderRequest orderRequest) {
        return Order.builder()
                .customerId(orderRequest.getCustomerId())
                .status(orderRequest.getStatus())
                .items(orderRequest.getItems()
                        .stream()
                        .map(OrderItemMapper::mapToOrderItem)
                        .collect(Collectors.toList()))
                .build();
    }
}
