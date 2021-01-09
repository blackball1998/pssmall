package com.blackball.pssmall.member;

import com.blackball.common.utils.R;
import com.blackball.pssmall.member.service.feign.MemberCouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PssmallMemberApplicationTests {

    @Autowired
    private MemberCouponService memberCouponService;

    @Value("${test.username}")
    private String name;

    @Value("${test.age}")
    private String age;

    @Test
    void contextLoads() {
        R couponResponse = memberCouponService.test();
        System.out.println(couponResponse.get("coupon"));
    }

    @Test
    void remoteConfig() {
        System.out.println(name + "," + age);
    }

}
