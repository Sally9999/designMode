package com.fyx.cat.strategy.transport;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import lombok.extern.slf4j.Slf4j;

/**
 * 陆运
 *
 * @author wushiyi
 * @date 2020/08/10
 */
@Slf4j
public class LandStrategy implements BaseStrategy {
    @Override
    public void transport(BaseCat cat, Buyer buyer, String companyName) {
        log.info("{} 陆运在途，{} 正在送往 {}...", cat.getCode(), companyName, buyer.getCity());
    }
}
