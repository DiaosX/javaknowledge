package com.my.javabasic.thread;


import java.util.ArrayList;
import java.util.List;

public class GatewayRequestHandlerManager {

    private List<GatewayRequestHandler> handlers;
    private GatewayRequestAcceptor acceptor;

    public GatewayRequestHandlerManager(GatewayRequestAcceptor acceptor) {
        this.acceptor = acceptor;
        this.handlers = new ArrayList<>();
        GatewayRequestHandler defaultHandler = new GatewayRequestHandler(acceptor);
        this.add(defaultHandler);
    }

    public boolean add(GatewayRequestHandler handler) {
        return this.handlers.add(handler);
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
