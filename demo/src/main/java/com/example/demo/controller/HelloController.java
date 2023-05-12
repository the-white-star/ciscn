package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello SpringBoot";
    }


    @GetMapping("/cs")
    public Map<String, Object> cs() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "helloworld");
        return map;
    }

}
