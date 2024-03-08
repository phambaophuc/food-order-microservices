package org.pbp.apigateway.config;

import org.pbp.apigateway.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Value("${server.port}")
    private String SERVER_PORT;

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r
                        .path("/product-service/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://product-service")
                )
                .route("order-service", r -> r
                        .path("/order-service/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://order-service")
                )
                .route("table-service", r -> r
                        .path("/table-service/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://table-service")
                )
                .route("review-service", r -> r
                        .path("/review-service/**")
                        .filters(f -> f.filter(CorsFilter::filter))
                        .uri("lb://review-service")
                )
                .route(r -> r
                        .path("/websocket/**")
                        .uri("lb:ws://notification-service/websocket")
                )
                .route(r -> r
                        .path("/sockjs-websocket/**")
                        .uri("lb://notification-service/sockjs-websocket")
                )
                .route("openapi", r -> r
                        .path("/v3/api-docs/**")
                        .filters(f -> f.rewritePath("/v3/api-docs/(?<path>.*)", "/${path}/v3/api-docs"))
                        .uri("http://localhost:" + SERVER_PORT)
                )
                .build();
    }
}
