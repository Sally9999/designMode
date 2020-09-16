package com.fyx.cat.strategy;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.strategy.transport.BaseStrategy;

/**
 * 环境类
 *
 * @author wushiyi
 * @date 2020/08/10
 */
public class TransportationContext {
    private BaseStrategy strategy;

    public TransportationContext(BaseStrategy strategy) {
        this.strategy = strategy;
    }

    public void transport(BaseCat cat, Buyer buyer, String companyName) {
        strategy.transport(cat, buyer, companyName);
    }
}
