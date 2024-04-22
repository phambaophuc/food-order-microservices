package org.pbp.orderservice.service;

import org.pbp.orderservice.dto.request.OrderRequest;
import org.pbp.orderservice.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAll();
    OrderResponse findById(Long orderId);
    OrderRequest createOrder(OrderRequest request);
    OrderRequest updateOrder(OrderRequest request);
    void deleteById(Long orderId);
}
