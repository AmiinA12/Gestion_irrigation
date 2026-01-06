package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RefreshScope
@EnableKafka
public class MicroserviceIrrigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceIrrigationApplication.class, args);
	}

}
