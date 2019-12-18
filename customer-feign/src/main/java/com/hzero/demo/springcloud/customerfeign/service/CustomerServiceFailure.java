package com.hzero.demo.springcloud.customerfeign.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceFailure implements CustomerService{

    @Override
    public String sayHi(String name) {
        return "hey " +
                name + ", there is some problem with hi page";
    }
}
