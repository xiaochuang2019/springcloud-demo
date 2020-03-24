package com.xiaochuang.eureka.controller;

import com.xiaochuang.eureka.feign.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/")
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloFeignClient helloFeignClient;
    @RequestMapping("hello")
    public String hello(@RequestParam("name")String name){
        System.out.println("consumer:hello");
        //System.out.println("consumer");
        //return restTemplate.getForObject("http://service-producer/producer/hello?name="+name,String.class);
        return helloFeignClient.hello(name);
    }
}
