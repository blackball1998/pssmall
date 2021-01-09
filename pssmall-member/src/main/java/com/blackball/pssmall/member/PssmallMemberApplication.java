package com.blackball.pssmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.blackball.pssmall.member.service.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class PssmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(PssmallMemberApplication.class, args);
    }

}
