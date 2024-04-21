package org.pbp.orderservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.dto.response.MessageResponse;
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

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.save(orderDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderDto> update(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.update(orderDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }
}
