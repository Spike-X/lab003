package com.aircraft.codelab.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021-09-14
 *
 * @author tao.zhang
 * @since 1.0
 */
@RefreshScope //post请求手动刷新 curl -X POST localhost:3355/actuator/refresh
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getConfigInfo() {
        return configInfo;
    }
}
