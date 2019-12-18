package com.hzero.demo.springcloud.customerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient//@EnableDiscoveryClient表明标注类是消费者，加入restTemplate以消费相关的服务
@EnableHystrix//开启断路器
@EnableHystrixDashboard//开启断路器指标看板
public class CustomerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerRibbonApplication.class, args);
        System.out.println("http://localhost:8888/hi?name=Customer-ribbon");
        System.out.println("断路器指示板： http://localhost:8888/hystrix");
    }


}
