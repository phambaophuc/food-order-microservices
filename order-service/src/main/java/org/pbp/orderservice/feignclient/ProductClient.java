package org.pbp.orderservice.feignclient;

import org.pbp.orderservice.config.LoadBalancerConfig;
import org.pbp.orderservice.dto.ProductDto;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE")
@LoadBalancerClient(name = "PRODUCT-SERVICE", configuration = LoadBalancerConfig.class)
public interface ProductClient {

    @GetMapping("/product-service/api/v1/products/{productId}")
    ProductDto getProductById(@PathVariable Long productId);
}
