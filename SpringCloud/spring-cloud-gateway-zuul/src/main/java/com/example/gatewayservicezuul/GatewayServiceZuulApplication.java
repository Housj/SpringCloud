package com.example.gatewayservicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
//@EnableEurekaClient
@EnableZuulProxy
@EnableAutoConfiguration
public class GatewayServiceZuulApplication {

	@Bean
	public TokenFilter tokenFilter(){
		return new TokenFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceZuulApplication.class, args);
	}

}

