package com.my.javabasic.thread;

public class GatewayResponse {

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private Object data;
    private boolean success;

    public static GatewayResponse success() {
        GatewayResponse response = new GatewayResponse();
        response.data = "请求成功.";
        response.success = true;
        return response;
    }
}
