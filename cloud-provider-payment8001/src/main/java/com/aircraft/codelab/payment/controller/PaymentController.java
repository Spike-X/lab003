package com.aircraft.codelab.payment.controller;

import com.aircraft.codelab.core.entities.CommonResult;
import com.aircraft.codelab.core.enums.ResultCode;
import com.aircraft.codelab.core.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @GetMapping("/redis")
    public CommonResult<Map<Object, Object>> helloRedis(@RequestParam(defaultValue = "0", name = "id") Long parentId) {
        log.debug("redis test");
        HashMap<String, Object> info = new HashMap<>(8);
        info.put("name", "galaxy");
        info.put("age", "70");
        info.put("id", parentId);
        redisService.hSetAll("test:map:5",info);
        Map<Object, Object> map = redisService.hGetAll("test:map:5");
        return CommonResult.success(ResultCode.SUCCESS.getMessage(), map);
    }
}
