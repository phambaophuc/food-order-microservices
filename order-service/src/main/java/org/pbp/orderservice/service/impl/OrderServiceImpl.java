package org.pbp.orderservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.enums.OrderStatus;
import org.pbp.orderservice.exception.OrderNotFoundException;
import org.pbp.orderservice.mapper.OrderMapper;
import org.pbp.orderservice.repository.OrderRepo;
import org.pbp.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public List<OrderDto> findAll() {
        return orderRepo.findByOrderByStatusDesc()
                .stream()
                .map(OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(String orderId) {
        return orderRepo.findById(orderId)
                .map(OrderMapper::mapToDto)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        orderDto.setStatus(OrderStatus.PENDING);
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    @Transactional
    public OrderDto updateOrderStatus(String orderId, OrderStatus status) {
        OrderDto orderDto = this.findById(orderId);
        orderDto.setStatus(status);
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    public void deleteById(String orderId) {
        orderRepo.deleteById(orderId);
    }
}
