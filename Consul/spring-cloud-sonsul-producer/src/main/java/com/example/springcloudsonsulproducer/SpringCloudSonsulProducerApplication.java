package com.example.springcloudsonsulproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudSonsulProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSonsulProducerApplication.class, args);
	}

}

