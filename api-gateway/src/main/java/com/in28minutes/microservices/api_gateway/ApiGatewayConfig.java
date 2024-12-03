package com.in28minutes.microservices.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfig {

    @Bean
  public RouteLocator routeGateway(RouteLocatorBuilder builder)
  {

      return builder.routes().route(p -> p.path("/get")
              .filters(f-> f.addRequestHeader("MyHeader","MyUri")
                      .addRequestParameter("param","MyParam"))
              .uri("http://httpbin.org:80"))
              .route(p->p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
              .route(p->p.path("/currency-conversion/**").uri("lb://currency-conversion"))
              .build();
  }
}
