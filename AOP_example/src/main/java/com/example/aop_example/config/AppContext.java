package com.example.aop_example.config;

import com.example.aop_example.service.Calculator;
import com.example.aop_example.service.CalculatorForEngineering;
import com.example.aop_example.utils.CachedDB;
import com.example.aop_example.utils.ExecuteTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class AppContext {

    @Bean
    public CachedDB cachedDB() {
        return new CachedDB();
    }

    @Bean
    public ExecuteTime executeTime() {
        return new ExecuteTime();
    }

    @Bean
    public Calculator calculator() {
        return new CalculatorForEngineering();
    }
}
