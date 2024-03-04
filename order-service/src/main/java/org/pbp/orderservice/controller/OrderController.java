package org.pbp.orderservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.orderservice.dto.OrderDto;
import org.pbp.orderservice.dto.response.MessageResponse;
import org.pbp.orderservice.enums.OrderStatus;
import org.pbp.orderservice.feignclient.MessageClient;
import org.pbp.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final MessageClient messageClient;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        log.info("** Order controller: find all orders *");
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findById(@PathVariable String orderId) {
        log.info("** Order controller: find order by id *");
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto) {
        log.info("** Order controller: save order *");
        OrderDto newOrder = orderService.save(orderDto);
        messageClient.sendNewOrder(newOrder);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderDto> updateOrderStatus(@PathVariable String orderId,
                                                      @RequestBody OrderStatus orderStatus) {
        log.info("** Order controller: update order status {} *", orderStatus);
        OrderDto updateOrder = orderService.updateOrderStatus(orderId, orderStatus);
        messageClient.sendUpdateStatus(updateOrder);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable String orderId) {
        log.info("** Order controller: delete order by id *");
        orderService.deleteById(orderId);
        return ResponseEntity.ok(new MessageResponse("Deleted Successfully!"));
    }
}
