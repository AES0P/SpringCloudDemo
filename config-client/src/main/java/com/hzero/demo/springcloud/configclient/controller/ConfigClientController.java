package com.hzero.demo.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//这个controller主要是为了演示是否成功读取到了【配置服务端】的配置文件。
@RestController
public class ConfigClientController {

    @Value("${info}")
    private String info;

    /**
     * 提供的一个restful服务
     *
     * @return 返回  配置中的info信息
     */
    @RequestMapping("/info")
    public String info() {
        return info;
    }
}
