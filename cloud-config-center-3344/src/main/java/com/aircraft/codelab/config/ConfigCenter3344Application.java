package com.aircraft.codelab.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 2021-09-14
 *
 * @author tao.zhang
 * @since 1.0
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigCenter3344Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344Application.class, args);
    }
}
