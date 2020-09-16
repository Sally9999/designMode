package com.fyx.cat.responsibilitychain;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.enums.DeliveryCompanyEnum;
import com.fyx.cat.strategy.TransportationContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 运输系统
 *
 * @author wushiyi
 * @date 2020/08/10
 */
@Slf4j
public class DeliveryCompanyHandler extends BaseHandler {

    public DeliveryCompanyHandler(String name, BaseHandler next) {
        super(name, next);
    }

    @Override
    public void handleRequest(BaseCat cat, Buyer buyer) {
        DeliveryCompanyEnum company = DeliveryCompanyEnum.getEnum(this.name);
        if (null == company) {
            log.error("未找到快递公司{}", this.name);
        } else {
            TransportationContext ctx = new TransportationContext(company.getStrategy());
            ctx.transport(cat, buyer, company.getName());
            if (null != getNext()) {
                getNext().handleRequest(cat, buyer);
            } else {
                log.info("{}本次服务已结束 {}。", company.getName(), cat.getCode());
            }
        }
    }
}
