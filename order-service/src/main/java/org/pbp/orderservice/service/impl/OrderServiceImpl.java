package org.pbp.orderservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.enums.OrderStatus;
import org.pbp.orderservice.mapper.OrderMapper;
import org.pbp.orderservice.repository.OrderRepo;
import org.pbp.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public List<OrderDto> findAll() {
        log.info("** Order service: find all orders *");
        return orderRepo.findByOrderByStatusDesc()
                .stream()
                .map(OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findById(String orderId) {
        log.info("** Order service: find order by id *");
        return orderRepo.findById(orderId)
                .map(OrderMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        log.info("** Order service: save order *");
        orderDto.setStatus(OrderStatus.PENDING);
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        log.info("** Order service: update order *");
        return OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
    }

    @Override
    @Transactional
    public OrderDto updateOrderStatus(String orderId, OrderStatus status) {
        log.info("** Order service: update order status *");
        OrderDto orderUpdate = this.findById(orderId);
        orderUpdate.setStatus(status);
        return this.update(orderUpdate);
    }

    @Override
    public void deleteById(String orderId) {
        log.info("** Order service: delete order by id *");
        orderRepo.deleteById(orderId);
    }
}
