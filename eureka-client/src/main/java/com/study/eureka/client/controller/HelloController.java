package com.study.eureka.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("hello")
    public String hello(HttpServletRequest request) {
        ServiceInstance instance = client.getLocalServiceInstance();
        log.error("/hello, host:{}, service_id:{}", instance.getHost(), instance.getServiceId());
        return "hello word!";
    }
}
