package com.hzero.demo.springcloud.customerfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix//开启断路器
@EnableHystrixDashboard//开启断路器指标看板
public class CustomerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFeignApplication.class, args);
        System.out.println("http://localhost:8899/hi?name=Customer-feign");
        System.out.println("断路器指示板： http://localhost:8899/hystrix");
    }

}
