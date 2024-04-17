package org.pbp.orderservice.service.impl;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.document.Order;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.dto.response.ItemResponse;
import org.pbp.orderservice.dto.response.OrderResponse;
import org.pbp.orderservice.enums.OrderStatus;
import org.pbp.orderservice.exception.OrderNotFoundException;
import org.pbp.orderservice.feignclient.ProductClient;
import org.pbp.orderservice.mapper.OrderMapper;
import org.pbp.orderservice.repository.OrderRepo;
import org.pbp.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ProductClient productClient;

    @Override
    public List<OrderDto> findAll() {
        return orderRepo.findByOrderByStatusDesc()
                .stream()
                .map(OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public OrderDto findById(String orderId) {
//        return orderRepo.findById(orderId)
//                .map(OrderMapper::mapToDto)
//                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
//    }

    @Override
    public OrderResponse findById(String orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));

        List<ItemResponse> itemResponses = new ArrayList<>();
        order.getItems().forEach(item -> {
            ItemResponse itemResponse = ItemResponse.builder()
                    .quantity(item.getQuantity())
                    .product(productClient.getProductById(item.getProductId()))
                    .build();
            itemResponses.add(itemResponse);
        });

        return OrderResponse.builder()
                .id(order.getId())
                .status(order.getStatus())
                .items(itemResponses)
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        orderDto.setStatus(OrderStatus.PENDING);
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    @Transactional
    public OrderDto updateOrderStatus(String orderId, OrderStatus status) {
        OrderDto orderDto = orderRepo.findById(orderId)
                .map(OrderMapper::mapToDto)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));

        orderDto.setStatus(status);
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    public void deleteById(String orderId) {
        orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        orderRepo.deleteById(orderId);
    }
}
