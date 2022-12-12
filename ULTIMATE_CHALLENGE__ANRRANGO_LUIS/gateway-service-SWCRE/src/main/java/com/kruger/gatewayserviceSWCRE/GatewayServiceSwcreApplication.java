package com.kruger.gatewayserviceSWCRE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceSwcreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceSwcreApplication.class, args);
	}

}
