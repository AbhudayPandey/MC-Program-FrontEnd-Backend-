package com.cts;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@EnableSwagger2
@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
@EnableHystrix
public class MutualFundServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualFundServiceApplication.class, args);
	}
	

	private ApiInfo apiDeatils() {
		return new ApiInfo(
				"Transaction Control API",
				"Transation Done By User",
				"1.0",
				"Everyone Can Use",
				new springfox.documentation.service.Contact("Abhuday Pandey", "www.cognizant.com", "pandey26@gmail.com"),
				"API License",
				"https://cognizant.com",
				Collections.emptyList()
				);
	}

}
