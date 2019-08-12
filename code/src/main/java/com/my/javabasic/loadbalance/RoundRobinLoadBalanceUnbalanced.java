package com.my.javabasic.loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 轮训非均衡模式
 */
public class RoundRobinLoadBalanceUnbalanced extends AbstractLoadBalance {


    private List<String> ips = new ArrayList<>();

    private static AtomicInteger lockCurr = new AtomicInteger();

    /**
     * 实现思路：将地址按照权重重复，然后选择
     *
     * @param invokers
     * @return
     */
    @Override
    public String doSelect(List<WeightedNode> invokers) {
        ips.clear();
        for (int i = 0; i < invokers.size(); i++) {
            for (int j = 0; j < invokers.get(i).getWeight(); j++) {
                ips.add(invokers.get(i).getIp());
            }
        }
        int index = lockCurr.incrementAndGet();
        if (index >= ips.size()) {
            lockCurr.getAndSet(0);
        }
        return ips.get(index & ips.size());
    }
}
