package com.my.javabasic.thread;


public class GatewayRequestHandler implements Runnable {

    private GatewayRequestAcceptor acceptor;

    public GatewayRequestHandler(GatewayRequestAcceptor acceptor) {
        this.acceptor = acceptor;
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

    @Override
    public void run() {
        while (true) {
            for (String requestId : this.acceptor.getAllRequestIds()) {
                this.response(requestId);
            }
            try {
                //Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
