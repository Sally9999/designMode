package com.fyx.cat.strategy.transport;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;

/**
 * 抽象策略类（策略模式）
 *
 * @author wushiyi
 * @date 2020/08/10
 */
public interface BaseStrategy {

    /**
     * 运输
     *
     * @param cat
     * @param buyer
     * @param companyName
     */
    void transport(BaseCat cat, Buyer buyer, String companyName);
}
