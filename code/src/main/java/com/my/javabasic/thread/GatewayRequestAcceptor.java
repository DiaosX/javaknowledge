package com.my.javabasic.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 接收请求类
 */
public class GatewayRequestAcceptor {
    private static int MAX_REQUESTOR_COUNT = 500;
    private Map<String, CompletableFuture<GatewayResponse>> requestorQueue;

    public GatewayRequestAcceptor(int maxRequestorCount) {
        MAX_REQUESTOR_COUNT = maxRequestorCount;
        this.requestorQueue = new HashMap<>();
    }

    public GatewayRequestAcceptor() {
        this.requestorQueue = new ConcurrentHashMap<>();
    }

    public Set<String> getAllRequestIds() {
        return this.requestorQueue.keySet();
    }

    public int getCurrentRequestorCount() {
        return this.requestorQueue.size();
    }

    public boolean accept(String requestId, CompletableFuture<GatewayResponse> task) {
        if (this.requestorQueue.size() >= MAX_REQUESTOR_COUNT) {
            reject(requestId, "已经达到了最大请求个数");
            return false;
            //这个地方等待一定时间再尝试加入请求队列
        }
        this.requestorQueue.put(requestId, task);
        try {
            GatewayResponse response = task.get();
            printRequestorCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void reject(String requestId, String message) {
        System.out.println("拒绝请求:" + requestId + "，原因:" + message);
    }

    public boolean complete(String requestId, GatewayResponse response) {
        if (this.requestorQueue.containsKey(requestId)) {
            this.requestorQueue.get(requestId).complete(response);
            this.requestorQueue.remove(requestId);
            printRequestorCount();
            return false;
        }
        return true;
    }

    private void printRequestorCount() {
        System.out.println("当前请求等待者个数:" + this.getCurrentRequestorCount());
    }
}
