package org.pbp.orderservice.mapper;

import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.entity.Order;

public interface OrderMapper {

    static OrderDto mapToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .items(order.getItems())
                .build();
    }

    static Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .customerId(orderDto.getCustomerId())
                .totalPrice(orderDto.getTotalPrice())
                .status(orderDto.getStatus())
                .items(orderDto.getItems())
                .build();
    }
}
