package com.my.javabasic.loadbalance;

import java.util.List;

/**
 * 一致性哈希负载均衡
 */
public class ConsistentHashLoadBalance extends AbstractLoadBalance {

    @Override
    public String doSelect(List<String> invokers, String url) {
        return null;
    }
}
