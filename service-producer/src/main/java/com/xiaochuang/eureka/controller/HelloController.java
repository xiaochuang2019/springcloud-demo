package com.xiaochuang.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer/")
public class HelloController {
    @RequestMapping("hello")
    public String hello(@RequestParam("name") String name){
        System.out.println("producer:hello");
        return "hello,"+name + ",from producer";
    }
}
