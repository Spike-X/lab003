package com.aircraft.codelab.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 2021-07-25
 *
 * @author tao.zhang
 * @since 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class Eureka7002Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002Application.class, args);
    }
}
