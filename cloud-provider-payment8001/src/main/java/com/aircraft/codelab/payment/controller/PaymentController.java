package com.aircraft.codelab.payment.controller;

import cn.hutool.core.date.DateUtil;
import com.aircraft.codelab.cache.service.RedisService;
import com.aircraft.codelab.core.entities.CommonResult;
import com.aircraft.codelab.core.entities.Payment;
import com.aircraft.codelab.core.enums.ResultCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020-12-29
 * Payment
 *
 * @author tao.zhang
 * @since 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private RedisService redisService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/redis", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<Map<Object, Object>> helloRedis(@RequestParam(defaultValue = "0", name = "id") Long parentId) {
        log.debug("redis test");
        HashMap<String, Object> info = new HashMap<>(8);
        info.put("name", "galaxy");
        info.put("age", "70");
        info.put("id", parentId);
        // hash方式存储
        redisService.hSetAll("test:map:2", info);
        Map<Object, Object> map = redisService.hGetAll("test:map:2");
        // json方式存储
//        redisService.set("test:map:3",info);
        return CommonResult.success(ResultCode.SUCCESS.getMessage(), map);
    }

    @PostMapping(value = "/payment/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<String> create(@RequestBody Payment payment) {
        log.debug("/payment/create");
        String s1 = DateUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss");
        // 直接存贮
//        redisService.set(s1, payment);
        // 转json存储
        ObjectMapper objectMapper = new ObjectMapper();
        String s = StringUtils.EMPTY;
        try {
            s = objectMapper.writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        redisService.set(s1, s);
        return CommonResult.success("插入数据成功,serverPort: " + serverPort);
    }

    @GetMapping(value = "/payment/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.debug("/payment/get");
        Object o = redisService.get(String.valueOf(id));
        if (o == null) {
            return CommonResult.failed("查找订单失败");
        }
        // 强转(json格式)
//        Payment payment = (Payment) o;
        // json转对象
        ObjectMapper objectMapper = new ObjectMapper();
        Payment payment = null;
        try {
            payment = objectMapper.readValue(o.toString(), Payment.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.debug("payment:{}", payment);
        return CommonResult.success("查询成功,serverPort:  " + serverPort, payment);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("==element==: " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
