package com.my.javabasic.concurrent.disruptor.simplemessage;

public class MessageEvent {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

}
