package com.proc.exception;

public class UserBalanceException extends RuntimeException {
    public UserBalanceException(String msg) {
        super(msg);
    }
}