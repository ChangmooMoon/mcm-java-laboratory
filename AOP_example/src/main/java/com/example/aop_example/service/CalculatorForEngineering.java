package com.example.aop_example.service;

public class CalculatorForEngineering implements Calculator {

    @Override
    public long factorial(long num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
