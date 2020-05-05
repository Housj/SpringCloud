package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.atomic.AtomicStampedReference;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    AtomicStampedReference<Integer> a = new AtomicStampedReference<>(new Integer(0),1);


    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class);
    }
}
