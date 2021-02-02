package com.blackball.pssmall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.blackball.pssmall.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class PssmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(PssmallProductApplication.class, args);
    }

}
