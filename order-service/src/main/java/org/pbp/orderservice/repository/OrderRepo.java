package org.pbp.orderservice.repository;

import org.pbp.orderservice.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends MongoRepository<Order, String> {
    List<Order> findByOrderByStatusDesc();
}
