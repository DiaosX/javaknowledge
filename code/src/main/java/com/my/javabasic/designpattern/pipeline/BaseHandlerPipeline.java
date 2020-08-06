package com.my.javabasic.designpattern.pipeline;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseHandlerPipeline<H> {
    private List<H> valves;

    public BaseHandlerPipeline(int initSize) {
        valves = new ArrayList<>(initSize);
    }

    public BaseHandlerPipeline() {
        this(2);
    }

    /**
     * 增加阀门
     *
     * @param valve 阀门
     */
    public void addValve(H valve) {
        valves.add(valve);
    }

    /**
     * 删除任务阀门
     *
     * @param valve 任务阀门
     */
    public void removeValve(H valve) {
        valves.remove(valve);
    }

    /**
     * 返回所有阀门
     *
     * @return 管道中的阀门
     */
    public List<H> getValves() {
        return valves;
    }

    public void setValves(List<H> valves) {
        this.valves = valves;
    }
}


