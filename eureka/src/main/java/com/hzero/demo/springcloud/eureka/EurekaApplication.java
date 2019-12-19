package com.hzero.demo.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//添加@EnableEurekaServer，该注解表明标注类是一个Eureka Server，申明此处为服务注册中心。
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
        System.out.println("Eureka已实现集群设置，访问地址如下：");
        System.out.println("http://eureka-server-1:8761/");
        System.out.println("http://eureka-server-2:8762/");
        System.out.println("http://eureka-server-3:8763/");
    }

}
