package com.example.di_without_spring.config.exception;

public class DuplicateMemberException extends RuntimeException {

    public DuplicateMemberException(String msg) {
        super(msg);
    }
}
