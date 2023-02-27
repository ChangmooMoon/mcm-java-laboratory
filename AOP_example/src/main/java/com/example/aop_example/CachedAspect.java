package com.example.aop_example;

import com.example.aop_example.config.AppContext;
import com.example.aop_example.service.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CachedAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppContext.class);

        Calculator cal = ac.getBean("calculator", Calculator.class);
        cal.factorial(7);
        cal.factorial(7);
        cal.factorial(5);
        cal.factorial(5);
        ac.close();
    }
}
