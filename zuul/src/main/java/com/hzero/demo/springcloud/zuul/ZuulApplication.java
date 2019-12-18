package com.hzero.demo.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
        System.out.println("http://localhost:8080/ribbon/hi?name=Customer-ribbon&token=aesop");
        System.out.println("http://localhost:8080/feign/hi?name=Customer-feign&token=aesop");
    }

}
