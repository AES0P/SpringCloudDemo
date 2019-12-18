package com.hzero.demo.springcloud.productor.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Productor {

    @Value("${server.port}")
    String port;

    //    http://localhost:9001/hi?name=aesop
    @RequestMapping("/hi")
    public String sayHi(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

}
