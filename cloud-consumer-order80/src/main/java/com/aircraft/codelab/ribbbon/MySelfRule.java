package com.aircraft.codelab.ribbbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2021-08-11
 * 与启动类不在一个包路径
 *
 * @author tao.zhang
 * @since 1.0
 */
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //替换为随机
        return new RandomRule();
    }
}
