package com.yunplus.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaServer
@SpringBootApplication
@ComponentScan("com.ctrip")
public class YunplusEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunplusEurekaApplication.class, args);
    }

}
