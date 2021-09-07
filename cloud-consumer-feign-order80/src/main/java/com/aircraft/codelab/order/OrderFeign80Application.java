package com.aircraft.codelab.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 2021-09-07
 *
 * @author tao.zhang
 * @since 1.0
 */
@EnableFeignClients
@SpringBootApplication
public class OrderFeign80Application {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80Application.class, args);
    }
}
