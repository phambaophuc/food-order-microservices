package org.pbp.orderservice.service;

import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.enums.OrderStatus;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAll();
    OrderDto findById(String orderId);
    OrderDto save(OrderDto orderDto);
    OrderDto updateOrderStatus(String orderId, OrderStatus status);
    void deleteById(String orderId);
}
