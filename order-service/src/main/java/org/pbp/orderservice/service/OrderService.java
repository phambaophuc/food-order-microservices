package org.pbp.orderservice.service;

import org.pbp.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAll();
    OrderDto findById(Long orderId);
    OrderDto save(OrderDto orderDto);
    OrderDto update(OrderDto orderDto);
    void deleteById(Long orderId);
}
