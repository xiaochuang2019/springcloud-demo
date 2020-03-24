package com.xiaochuang.eureka.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloFeignCallback implements HelloFeignClient {


    @Override
    public String hello(String name) {
        return "服务调用失败";
    }
}
