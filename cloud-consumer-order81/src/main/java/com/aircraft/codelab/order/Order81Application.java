package com.aircraft.codelab.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2021-08-09
 *
 * @author tao.zhang
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Order81Application {
    public static void main(String[] args) {
        SpringApplication.run(Order81Application.class, args);
    }
}
