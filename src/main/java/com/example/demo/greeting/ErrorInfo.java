package com.example.demo.greeting;

public class ErrorInfo {
    private String errorCode;
    private String message;
    private String fallback;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFallback() {
        return fallback;
    }

    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    public ErrorInfo(String errorCode, String message, String fallback) {
        this.errorCode = errorCode;
        this.message = message;
        this.fallback = fallback;
    }

}