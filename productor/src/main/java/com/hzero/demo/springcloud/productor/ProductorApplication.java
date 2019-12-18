package com.hzero.demo.springcloud.productor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//在application中加入注解@EnableEurekaClient，表明自己属于一个生产者
public class ProductorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductorApplication.class, args);
        System.out.println("服务提供者已实现集群，访问地址：");
        System.out.println("http://localhost:9001/hi?name=Productor");
        System.out.println("http://localhost:9002/hi?name=Productor");
        System.out.println("http://localhost:9003/hi?name=Productor");

    }

}
