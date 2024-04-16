package org.pbp.orderservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.dto.response.MessageResponse;
import org.pbp.orderservice.enums.OrderStatus;
import org.pbp.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> findById(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
        OrderDto newOrder = orderService.save(orderDto);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable String orderId,
                                                      @RequestBody OrderStatus orderStatus) {
        OrderDto updateOrder = orderService.updateOrderStatus(orderId, orderStatus);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable String orderId) {
        orderService.deleteById(orderId);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }
}
