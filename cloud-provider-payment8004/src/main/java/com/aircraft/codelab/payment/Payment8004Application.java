package com.aircraft.codelab.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2021-08-08
 *
 * @author tao.zhang
 * @since 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Payment8004Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004Application.class, args);
    }
}
