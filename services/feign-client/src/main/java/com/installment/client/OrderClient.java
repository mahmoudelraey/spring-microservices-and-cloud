package com.installment.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "order-service")
public interface OrderClient {

}
