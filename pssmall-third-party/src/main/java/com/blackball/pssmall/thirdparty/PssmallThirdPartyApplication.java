package com.blackball.pssmall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PssmallThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PssmallThirdPartyApplication.class, args);
    }

}
