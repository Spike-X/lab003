package com.aircraft.codelab.order.controller;

import com.aircraft.codelab.core.entities.CommonResult;
import com.aircraft.codelab.core.entities.Payment;
import com.aircraft.codelab.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 2021-09-12
 *
 * @author tao.zhang
 * @since 1.0
 */
@Slf4j
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout", produces = MediaType.APPLICATION_JSON_VALUE)
    public String paymentFeignTimeout() {
        // OpenFeign客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
