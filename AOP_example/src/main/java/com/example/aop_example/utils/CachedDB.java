package com.example.aop_example.utils;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class CachedDB {

    private Map<Long, Object> cache = new HashMap<>();

    @Pointcut("execution(public * com.example.aop_example.service..*(long))")
    public void publicTarget() {
    }

    @Around("publicTarget()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num = (Long) joinPoint.getArgs()[0]; // 0번 argument가 long인 모든 메서드
        if (cache.containsKey(num)) {
            System.out.printf("cache에서 찾음[%d]\n", num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();
        cache.put(num, result);
        System.out.printf("cache에 추가함[%d]\n", num);
        return result;
    }
}
