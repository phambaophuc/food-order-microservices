package org.pbp.orderservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.dto.response.MessageResponse;
import org.pbp.orderservice.enums.OrderStatus;
import org.pbp.orderservice.exception.OrderNotFoundException;
import org.pbp.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        log.info("** Order controller: find all orders *");
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findById(@PathVariable String orderId) {
        try {
            log.info("** Order controller: find order by id *");
            return ResponseEntity.ok(orderService.findById(orderId));
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(new MessageResponse("Order not found!"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
        log.info("** Order controller: save order *");
        OrderDto newOrder = orderService.save(orderDto);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable String orderId,
                                                      @RequestBody OrderStatus orderStatus) {
        log.info("** Order controller: update order status {} *", orderStatus);
        OrderDto updateOrder = orderService.updateOrderStatus(orderId, orderStatus);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable String orderId) {
        log.info("** Order controller: delete order by id *");
        orderService.deleteById(orderId);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }
}
