package org.pbp.orderservice.mapper;

import org.pbp.orderservice.document.Order;
import org.pbp.orderservice.dto.OrderDto;

public interface OrderMapper {

    static OrderDto mapToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .status(order.getStatus())
                .tableNumber(order.getTableNumber())
                .items(order.getItems())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    static Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .status(orderDto.getStatus())
                .tableNumber(orderDto.getTableNumber())
                .items(orderDto.getItems())
                .createdAt(orderDto.getCreatedAt())
                .updatedAt(orderDto.getUpdatedAt())
                .build();
    }
}
