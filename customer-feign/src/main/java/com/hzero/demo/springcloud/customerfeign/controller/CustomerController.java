package com.hzero.demo.springcloud.customerfeign.controller;

import com.hzero.demo.springcloud.customerfeign.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/hi")
    public String feignInfo(@RequestParam String name) {
        return customerService.sayHi(name);
    }
}
