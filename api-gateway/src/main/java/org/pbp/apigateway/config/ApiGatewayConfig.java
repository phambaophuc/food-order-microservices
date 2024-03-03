package org.pbp.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/api/products/**")
                        .uri("lb://product-service"))
                .route(p -> p.path("/api/categories/**")
                        .uri("lb://category-service"))
                .route(p -> p.path("/api/orders/**")
                        .uri("lb://order-service"))
                .route(p -> p.path("/api/tables/**")
                        .uri("lb://table-service"))
                .build();
    }
}
