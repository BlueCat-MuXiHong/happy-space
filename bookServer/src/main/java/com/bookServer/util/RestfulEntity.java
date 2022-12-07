package com.bookServer.util;

public class RestfulEntity {

    private boolean status;
    private int code;
    private Object result;

    public RestfulEntity(boolean status, int code, Object result) {
        this.status = status;
        this.code = code;
        this.result = result;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}