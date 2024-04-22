package org.pbp.orderservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.dto.request.OrderRequest;
import org.pbp.orderservice.dto.response.OrderResponse;
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
    public List<OrderResponse> findAll() {
        return orderRepo.findAll()
                .stream()
                .map(OrderMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(Long orderId) {
        return orderRepo.findById(orderId)
                .map(OrderMapper::mapToResponse)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " not found"));
    }

    @Override
    public OrderRequest createOrder(OrderRequest request) {
        return OrderMapper.mapToRequest(orderRepo.save(OrderMapper.mapToOrder(request)));
    }

    @Override
    public OrderRequest updateOrder(OrderRequest request) {
        return OrderMapper.mapToRequest(orderRepo.save(OrderMapper.mapToOrder(request)));
    }

    @Override
    public void deleteById(Long orderId) {
        orderRepo.findById(orderId)
                .map(OrderMapper::mapToRequest)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " not found"));
        orderRepo.deleteById(orderId);
    }
}
