package com.blackball.pssmall.member.service.feign;

import com.blackball.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "pssmall-coupon")
public interface MemberCouponService {

    @RequestMapping("coupon/coupon/test")
    R test();
}
