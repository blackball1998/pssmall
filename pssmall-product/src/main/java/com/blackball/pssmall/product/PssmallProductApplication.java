package com.blackball.pssmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com/blackball/pssmall/product/dao")
@SpringBootApplication
public class PssmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(PssmallProductApplication.class, args);
    }

}
