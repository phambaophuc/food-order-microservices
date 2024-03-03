package org.pbp.orderservice.feignclient;

import org.pbp.orderservice.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "send-message-service", url = "http://localhost:8810/")
public interface MessageClient {

    @PostMapping("/new-order")
    void sendNewOrder(@RequestBody OrderDto orderDto);
}
