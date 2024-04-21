package org.pbp.orderservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.entity.Order;
import org.pbp.orderservice.exception.OrderNotFoundException;
import org.pbp.orderservice.mapper.OrderMapper;
import org.pbp.orderservice.repository.OrderRepo;
import org.pbp.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public List<OrderDto> findAll() {
        return orderRepo.findAll()
                .stream()
                .map(OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(Long orderId) {
        return orderRepo.findById(orderId)
                .map(OrderMapper::mapToDto)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " not found"));
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    public void deleteById(Long orderId) {
        orderRepo.findById(orderId)
                .map(OrderMapper::mapToDto)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " not found"));
        orderRepo.deleteById(orderId);
    }
}
