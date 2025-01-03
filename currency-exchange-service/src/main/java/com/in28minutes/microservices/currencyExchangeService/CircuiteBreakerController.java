package com.in28minutes.microservices.currencyExchangeService;

import io.github.resilience4j.retry.annotation.Retry;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuiteBreakerController {
    Logger logger = LoggerFactory.getLogger(CircuiteBreakerController.class);
    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedMethod")
    public String sampleApi() {
        logger.info("sample api call");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:800/dummy-data-url", String.class);
        return forEntity.getBody();
    }

    public String hardcodedMethod(Exception ex)
    {
        return "fallback-method";
    }
}