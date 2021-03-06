package com.my.javabasic.loadbalance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机负载均衡
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    public String doSelect(List<WeightedNode> invokers) {
        int length = invokers.size();
        return invokers.get(ThreadLocalRandom.current().nextInt(length)).getIp();
    }
}
