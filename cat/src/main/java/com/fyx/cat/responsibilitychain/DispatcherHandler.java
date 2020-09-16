package com.fyx.cat.responsibilitychain;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import lombok.extern.slf4j.Slf4j;

/**
 * 派件员
 *
 * @author wushiyi
 * @date 2020/08/10
 */
@Slf4j
public class DispatcherHandler extends BaseHandler {

    public DispatcherHandler(Integer code, BaseHandler next) {
        super("派件员" + code + "号", next);
    }

    @Override
    public void handleRequest(BaseCat cat, Buyer buyer) {
        log.info("{} 正在派件 {}...", this.name, cat.getCode());
        if (null != getNext()) {
            getNext().handleRequest(cat, buyer);
        } else {
            log.info("{}本次服务已结束 {}。", this.name, cat.getCode());
        }
    }
}
