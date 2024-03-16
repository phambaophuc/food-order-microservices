package org.pbp.orderservice.feignclient;

import org.pbp.orderservice.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "${service.url.notification}")
public interface MessageClient {

    @PostMapping("/order/new-order")
    void sendNewOrder(@RequestBody OrderDto orderDto);

    @PostMapping("/order/update-status")
    void sendUpdateStatus(@RequestBody OrderDto orderDto);
}
