package com.hatthabank.payment.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

import com.hatthabank.sdk.configuration.annoatation.EnableHTBScan;

@SpringBootApplication
@EnableHTBScan
@EnableAutoConfiguration
@EnableFeignClients(basePackages = "com.hatthabank.payment.gateway.config.feign")
@EnableAsync
@EnableCaching
@EnableZuulProxy
public class PaymentGatewayApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayApplication.class, args);
	}

}
