package com.hzero.demo.springcloud.customerribbon.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {


    @Bean
    @LoadBalanced//开启Ribbon的负载模式，开启后Ribbon将拦截RestTemplate发起的请求，并实现负载均衡，默认的负载均衡策略是轮询
    public RestTemplate restTemplate() {
        return new RestTemplate();//RestTemplate 是由 Spring Web 模块提供的工具类，与 SpringCloud 无关，是独立存在的
    }

    //Ribbon提供多种负载策略由IRule进行管理
    //修改RIbbon的负载均衡策略
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();//该策略实现了从服务实例清单中随机选择一个服务实例，作为请求服务对象。
//        return new RetryRule();//该策略具备重试机制的实例选择功能，在给定时间内能够得到选择到具体的服务实例就返回，当超过时间还有没选到就返回null，参数maxRetryMillis控制这个超时时间
//        return new RoundRobinRule();//该策略实现了按照线性轮询的方式一次轮询服务清单上的每个服务实例
//        return new WeightedResponseTimeRule();//该策略是对RoundRobinRule的扩展，增加了根据实例的响应时间来计算权重，并从权重中选择对应的实例。该策略实现主要有三个核心内容：定时任务、权重计算、实例选择
//        return new BestAvailableRule();//BestAvailableRule策略继承ClientConfigEnableRoundRobinRule，通过遍历负载均衡中维护的所有服务实例，会过滤掉故障实例，并找出并发数请求数最小的实例，所以该策略的特性就是选出最空闲的实例
//        return new AvailabilityFilteringRule();//AvailabilityFilteringRule策略继承PredicateBasedRule策略的“先过滤，在轮询”特性

    }

    @Bean
    @SuppressWarnings({"unchecked","rawtypes"})
    public ServletRegistrationBean getServlet() {

        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

        registrationBean.setLoadOnStartup(1);

        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");

        return registrationBean;
    }


}
