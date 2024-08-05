package com.springcloud.kleycloak.mscartoes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@OpenAPIDefinition(info = @Info(title = "mscartoes", version = "1.0", description = "API`s mscartoes"))
public class MscartoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscartoesApplication.class, args);
	}

}
