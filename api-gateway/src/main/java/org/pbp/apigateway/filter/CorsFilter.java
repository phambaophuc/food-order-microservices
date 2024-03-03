package org.pbp.apigateway.filter;

import com.google.common.net.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class CorsFilter {

    public static Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getResponse()
                .getHeaders()
                .add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:4200");
        exchange.getResponse()
                .getHeaders()
                .add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE");
        exchange.getResponse()
                .getHeaders()
                .add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
        return chain.filter(exchange);
    }
}
