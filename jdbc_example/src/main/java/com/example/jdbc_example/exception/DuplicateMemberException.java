package com.example.jdbc_example.exception;

public class DuplicateMemberException extends RuntimeException {

    public DuplicateMemberException(String msg) {
        super(msg);
    }
}
