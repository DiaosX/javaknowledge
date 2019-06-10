package com.my.javabasic.fastjson.basic;

public class ResponseT<T> {
    private boolean success;
    private T data;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage;

    public static <T> ResponseT<T> success(T data) {
        ResponseT<T> result = new ResponseT();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> ResponseT<T> fail(String errorMessage) {
        ResponseT<T> result = new ResponseT();
        result.setSuccess(false);
        result.setErrorMessage(errorMessage);
        return result;
    }
}
