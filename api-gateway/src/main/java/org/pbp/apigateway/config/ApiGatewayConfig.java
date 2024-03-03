package org.pbp.apigateway.config;

import org.pbp.apigateway.filter.CorsFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/api/products/**", "/api/categories/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://product-service")
                )
                .route(p -> p.path("/api/categories/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://category-service")
                )
                .route(p -> p.path("/api/orders/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://order-service")
                )
                .route(p -> p.path("/api/tables/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://table-service")
                )
                .route(p -> p
                        .path("/websocket/**")
                        .uri("lb:ws://notification-service/websocket")
                )
                .route(p -> p
                        .path("/sockjs-websocket/**")
                        .uri("lb://notification-service/sockjs-websocket")
                )
                .build();
    }
}
