package com.blackball.pssmall.thirdparty;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PssmallThirdPartyApplicationTests {

    @Value("${spring.cloud.alicloud.access-key}")
    String accessId;

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    String endpoint;

    @Value("${spring.cloud.alicloud.bucket}")
    String bucket;

    @Test
    void contextLoads() {
        System.out.println(accessId);
        System.out.println(endpoint);
        System.out.println(bucket);
    }

}
