package com.bookServer.exception;

public class CustomException extends Exception {
    private int code;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}