package org.pbp.apigateway.config;

import org.pbp.apigateway.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiGatewayConfig {

    @Autowired
    private AuthFilter authFilter;

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r
                        .path("/auth-service/**")
                        .filters(f -> f.filter(authFilter.apply(new AuthFilter.Config())))
                        .uri("lb://auth-service")
                )
                .route("product-service", r -> r
                        .path("/product-service/**")
                        .filters(f -> f.filter(authFilter.apply(new AuthFilter.Config())))
                        .uri("lb://product-service")
                )
                .route("order-service", r -> r
                        .path("/order-service/**")
                        .uri("lb://order-service")
                )
                .route("table-service", r -> r
                        .path("/table-service/**")
                        .uri("lb://table-service")
                )
                .route("review-service", r -> r
                        .path("/review-service/**")
                        .uri("lb://review-service")
                )
//                .route("websocket", r -> r
//                        .path("/websocket/**")
//                        .uri("lb://notification-service/websocket")
//                )
                .build();
    }
}
