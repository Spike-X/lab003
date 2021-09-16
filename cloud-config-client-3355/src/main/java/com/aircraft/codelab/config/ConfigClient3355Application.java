package com.aircraft.codelab.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 2021-09-14
 *
 * @author tao.zhang
 * @since 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClient3355Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Application.class, args);
    }
}
