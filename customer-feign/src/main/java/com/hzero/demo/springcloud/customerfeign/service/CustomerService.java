package com.hzero.demo.springcloud.customerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "eureka-client-productor", fallback = CustomerServiceFailure.class) // value调用的服务的名称,fallback熔断器
public interface CustomerService {

    //这里使用productor中定义的方法的路径名进行匹配
    @RequestMapping("/hi")
    String sayHi(@RequestParam String name);

}
