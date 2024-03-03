package org.pbp.sendmessageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/new-order")
    public void sendNewOrder(@RequestBody Object orderDto) {
        messagingTemplate.convertAndSend("/order/newOrder", orderDto);
    }
}
