package org.pbp.orderservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.dto.request.OrderRequest;
import org.pbp.orderservice.dto.response.MessageResponse;
import org.pbp.orderservice.dto.response.OrderResponse;
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
    public ResponseEntity<List<OrderResponse>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrderRequest> createOrder(@RequestBody OrderRequest request) {
        return new ResponseEntity<>(orderService.createOrder(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderRequest> updateOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(orderService.updateOrder(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }
}
