package com.my.javabasic.loadbalance;

import java.util.List;


/**
 * 轮训负载均衡
 */
public class RoundRobinLoadBalance extends AbstractLoadBalance {
    @Override
    public String doSelect(List<WeightedNode> invokers) {
        return null;
    }
}
