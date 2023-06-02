package com.luv2code.demo.rest;

public class StudentErrorResponse {

    private int status;

    private String message;

    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public StudentErrorResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public StudentErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public StudentErrorResponse setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }
}
