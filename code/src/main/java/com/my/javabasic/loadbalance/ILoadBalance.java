package com.my.javabasic.loadbalance;

import java.util.List;

/**
 * 负载均衡算法
 */
public interface ILoadBalance {
    String select(List<WeightedNode> invokers);
}
