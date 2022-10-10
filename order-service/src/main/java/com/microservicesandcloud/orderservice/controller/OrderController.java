package com.microservicesandcloud.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Value("${max.value}")
    private String maxValue;

    @GetMapping
    public String getMaxValue() {
        return maxValue;
    }
}
