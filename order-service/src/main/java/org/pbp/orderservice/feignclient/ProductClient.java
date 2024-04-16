package org.pbp.orderservice.feignclient;

import org.pbp.orderservice.constant.AppConstant;
import org.pbp.orderservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE", url = AppConstant.PRODUCT_SERVICE_URL)
public interface ProductClient {

    @GetMapping("/api/v1/products/{productId}")
    ProductDto getProductById(@PathVariable Long productId);
}
