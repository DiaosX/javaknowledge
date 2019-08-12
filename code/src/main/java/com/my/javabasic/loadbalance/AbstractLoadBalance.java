package com.my.javabasic.loadbalance;

import org.springframework.util.CollectionUtils;

import java.util.List;

public abstract class AbstractLoadBalance implements ILoadBalance {

    /**
     * 选择地址，如果地址列表只有一个地址可用，则直接返回
     *
     * @param invokers
     * @return
     */
    @Override
    public String select(List<WeightedNode> invokers) {
        if (CollectionUtils.isEmpty(invokers)) {
            return null;
        }
        if (invokers.size() == 1) {
            return invokers.get(0).getIp();
        }
        return doSelect(invokers);
    }

    public abstract String doSelect(List<WeightedNode> invokers);
}
