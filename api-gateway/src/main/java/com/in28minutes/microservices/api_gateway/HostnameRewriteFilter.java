package com.in28minutes.microservices.api_gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class HostnameRewriteFilter extends AbstractGatewayFilterFactory<HostnameRewriteFilter.Config> {

    public static class Config {
        // Configuration properties, if needed
    }

    public HostnameRewriteFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String originalUri = request.getURI().toString();

            // Replace the hostname
            String modifiedUri = originalUri.replace("Explorer_Aadi", "localhost");

            // Build new request with modified URI
            ServerHttpRequest modifiedRequest = request.mutate().uri(URI.create(modifiedUri)).build();
            ServerWebExchange modifiedExchange = exchange.mutate().request(modifiedRequest).build();

            return chain.filter(modifiedExchange);
        };
    }
}

