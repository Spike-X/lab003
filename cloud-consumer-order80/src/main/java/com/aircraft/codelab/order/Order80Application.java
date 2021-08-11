package com.aircraft.codelab.order;

import com.aircraft.codelab.ribbbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 2020-12-30
 *
 * @author tao.zhang
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
public class Order80Application {
    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class, args);
    }
}
