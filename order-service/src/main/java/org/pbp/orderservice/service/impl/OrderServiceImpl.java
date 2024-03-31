package org.pbp.orderservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.enums.OrderStatus;
import org.pbp.orderservice.exception.OrderNotFoundException;
import org.pbp.orderservice.feignclient.MessageClient;
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
    private final MessageClient messageClient;

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
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        log.info("** Order service: save order *");
        orderDto.setStatus(OrderStatus.PENDING);
        OrderDto newOrder = OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
        messageClient.sendNewOrder(newOrder);
        return newOrder;
    }

    @Override
    @Transactional
    public OrderDto updateOrderStatus(String orderId, OrderStatus status) {
        log.info("** Order service: update order status *");
        OrderDto orderDto = this.findById(orderId);
        orderDto.setStatus(status);

        OrderDto orderUpdate = OrderMapper.mapToDto(orderRepo.save(OrderMapper.mapToOrder(orderDto)));
        messageClient.sendUpdateStatus(orderUpdate);
        return orderUpdate;
    }

    @Override
    public void deleteById(String orderId) {
        log.info("** Order service: delete order by id *");
        orderRepo.deleteById(orderId);
    }
}
