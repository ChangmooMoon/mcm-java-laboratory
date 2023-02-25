package com.example.aop_example.utils;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExecuteTime {

    @Pointcut("execution(public * com.example.aop_example.service..*(..))")
    private void publicTarget() {
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.nanoTime();
            Signature sig = joinPoint.getSignature();

            System.out.printf(
                "%s.%s(%s) 실행시간: %d ns%n",
                joinPoint.getTarget().getClass().getSimpleName(),
                sig.getName(),
                Arrays.toString(joinPoint.getArgs()),
                finish - start
            );
        }

    }
}
