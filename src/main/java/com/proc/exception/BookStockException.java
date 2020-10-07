package com.proc.exception;

public class BookStockException extends RuntimeException{
    public BookStockException(String msg) {
        super(msg);
    }
}