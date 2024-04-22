package org.pbp.orderservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.dto.request.OrderItemRequest;
import org.pbp.orderservice.dto.request.OrderRequest;
import org.pbp.orderservice.dto.response.OrderResponse;
import org.pbp.orderservice.entity.Order;
import org.pbp.orderservice.entity.OrderItem;
import org.pbp.orderservice.exception.OrderNotFoundException;
import org.pbp.orderservice.mapper.OrderMapper;
import org.pbp.orderservice.repository.OrderRepo;
import org.pbp.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Transactional
    @Override
    public OrderRequest createOrder(OrderRequest request) {
        Order order = new Order();

        List<OrderItem> orderItems = request.getItems().stream()
                .map(item -> OrderItem.builder()
                        .productId(item.getProductId())
                        .price(item.getPrice())
                        .quantity(item.getQuantity())
                        .order(order)
                        .build())
                .collect(Collectors.toList());

        order.setCustomerId(request.getCustomerId());
        order.setStatus(request.getStatus());
        order.setTotalPrice(calculateTotalPrice(orderItems));
        order.setItems(orderItems);

        return OrderMapper.mapToRequest(orderRepo.save(order));
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

    private BigDecimal calculateTotalPrice(List<OrderItem> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
