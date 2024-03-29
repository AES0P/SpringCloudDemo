package com.hzero.demo.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine // 开启turbine监控数据聚合
@EnableHystrixDashboard // 开启hystrix仪表盘
@EnableDiscoveryClient
public class TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
        System.out.println("集群断路器访问：");
        System.out.println("http://localhost:9999/hystrix");
    }

}
