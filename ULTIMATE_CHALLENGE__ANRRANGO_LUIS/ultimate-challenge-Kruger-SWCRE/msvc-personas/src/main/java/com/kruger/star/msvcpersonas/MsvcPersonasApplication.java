package com.kruger.star.msvcpersonas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsvcPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcPersonasApplication.class, args);
	}

}
