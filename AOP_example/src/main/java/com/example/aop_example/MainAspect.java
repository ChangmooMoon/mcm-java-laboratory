package com.example.aop_example;

import com.example.aop_example.config.AppContext;
import com.example.aop_example.service.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppContext.class);

        Calculator calculator = ac.getBean(Calculator.class);
        long result = calculator.factorial(11);

        System.out.println("calculator.factorial(11) = " + result);
        System.out.println(calculator.getClass().getName()); // calculator 는 com.sun.proxy.$Proxy18 타입(스프링이 생성한 프록시타입)

        ac.close();
    }
}
