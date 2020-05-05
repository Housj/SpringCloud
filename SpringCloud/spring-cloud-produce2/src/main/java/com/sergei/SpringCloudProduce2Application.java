package com.sergei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudProduce2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProduce2Application.class, args);
    }

}
