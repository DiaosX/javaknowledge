package com.my.javabasic.thread;


import java.util.ArrayList;
import java.util.List;

public class GatewayRequestHandlerManager {

    private List<GatewayRequestHandler> handlers;
    private GatewayRequestAcceptor acceptor;

    public GatewayRequestHandlerManager(GatewayRequestAcceptor acceptor) {
        this.acceptor = acceptor;
        this.handlers = new ArrayList<>();
    }

    public boolean response(String requestId) {
        try {
            //模拟处理耗时，2s后返回处理结果
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.acceptor.complete(requestId, GatewayResponse.success());
        return true;
    }

    public void start() {
        if (handlers.size() > 0) {
            for (int i = 0; i < this.handlers.size(); i++) {
                Thread handlerWorker = new Thread(this.handlers.get(i));
                handlerWorker.setName("handlerWorker");
                handlerWorker.start();
            }
        }
    }
}
