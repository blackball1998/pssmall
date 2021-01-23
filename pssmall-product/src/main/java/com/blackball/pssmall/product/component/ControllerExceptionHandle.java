package com.blackball.pssmall.product.component;

import com.blackball.common.exception.BizCodeEnum;
import com.blackball.common.utils.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@Log4j2
@RestControllerAdvice(basePackages = "com.blackball.pssmall.product.controller")
public class ControllerExceptionHandle {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出错{},异常类型{}", e.getMessage(), e.getClass());
        HashMap<String, String> map = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(item -> {
            map.put(item.getField(), item.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data", map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {
        return R.error();
    }
}
