package com.aircraft.codelab.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 2021-09-17
 *
 * @author tao.zhang
 * @since 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class GateWay9527Application {
    public static void main(String[] args) {
        SpringApplication.run(GateWay9527Application.class, args);
    }
}
