package com.aircraft.codelab.payment.controller;

import cn.hutool.core.date.DateUtil;
import com.aircraft.codelab.core.entities.CommonResult;
import com.aircraft.codelab.core.entities.Payment;
import com.aircraft.codelab.core.enums.ResultCode;
import com.aircraft.codelab.core.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
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

    @Resource
    private ObjectMapper objectMapper;

    @GetMapping("/redis")
    public CommonResult<Map<Object, Object>> helloRedis(@RequestParam(defaultValue = "0", name = "id") Long parentId) {
        log.debug("redis test");
        HashMap<String, Object> info = new HashMap<>(8);
        info.put("name", "galaxy");
        info.put("age", "70");
        info.put("id", parentId);
        redisService.hSetAll("test:map:5", info);
        Map<Object, Object> map = redisService.hGetAll("test:map:5");
        return CommonResult.success(ResultCode.SUCCESS.getMessage(), map);
    }

    @PostMapping(value = "/payment/create")
    public CommonResult<String> create(@RequestBody Payment payment) throws JsonProcessingException {
        log.debug("/payment/create");
        String valueAsString = objectMapper.writeValueAsString(payment);
        String s1 = DateUtil.format(LocalDateTime.now(), "yyyyMMddHHmmss");
        redisService.set(s1, valueAsString);
        return CommonResult.success(ResultCode.SUCCESS.getMessage());
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Object> getPaymentById(@PathVariable("id") Long id) {
        log.debug("/payment/get");
        Object o = redisService.get(String.valueOf(id));

        if (o != null) {
            return CommonResult.success(ResultCode.SUCCESS.getMessage(), o);
        } else {
            return CommonResult.failed("查找订单失败");
        }
    }
}
