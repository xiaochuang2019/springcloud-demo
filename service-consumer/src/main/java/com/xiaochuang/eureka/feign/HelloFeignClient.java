package com.xiaochuang.eureka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-producer"/*,fallback = HelloFeignCallback.class*/)
public interface HelloFeignClient {
    @RequestMapping("/producer/hello")
    public String hello(@RequestParam("name")String name);
}
