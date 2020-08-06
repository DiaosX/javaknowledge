package com.my.javabasic.designpattern.pipeline2;

public class HandlerPipeline {
    private HandlerContext head;

    public void addFirst(Handler handler) {//这里仅仅实现了一个简单的插入操作，即在链表的头部出入一个handler。
        HandlerContext ctx = new HandlerContext(handler);
        HandlerContext tmp = head;
        head = ctx;
        head.setNext(tmp);
    }

    public HandlerPipeline() {
        head = new HeadContext(new HeadHandler());
    }

    public void invoke(Object msg) {//封装了外部调用接口
        head.invokeNext(msg);
    }

    final class HeadContext extends HandlerContext {
        public HeadContext(Handler handler) {
            super(handler);
        }
    }

    final class HeadHandler implements Handler {
        @Override
        public String getName() {
            return "first";
        }

        @Override
        public void handle(HandlerContext ctx, Object msg) {
            System.out.println("处理管道开始,当前处理器名称：" + ctx.getHandler().getName());
            String result = (String) msg + "end";
            System.out.println(result);
        }
    }
}
