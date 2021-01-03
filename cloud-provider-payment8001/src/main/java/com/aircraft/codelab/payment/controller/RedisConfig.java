package com.aircraft.codelab.payment.controller;

import com.aircraft.codelab.core.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 2021-01-03
 *
 * @author tao.zhang
 * @since 1.0
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
