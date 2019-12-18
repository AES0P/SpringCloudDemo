package com.hzero.demo.springcloud.customerribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    // 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-client-productor/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hey " +
                name + ", there is some problem with hi page";
    }
}
