package com.hzero.demo.springcloud.customerribbon.controller;

import com.hzero.demo.springcloud.customerribbon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControler {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return customerService.hiService(name);
    }
}
