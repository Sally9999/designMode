package com.fyx.cat.facede;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.enums.DeliveryCompanyEnum;
import com.fyx.cat.responsibilitychain.BaseHandler;
import com.fyx.cat.responsibilitychain.DeliveryCompanyHandler;
import com.fyx.cat.responsibilitychain.DispatcherHandler;
import com.fyx.cat.responsibilitychain.RecipientHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 物流子系统
 *
 * @author wushiyi
 * @date 2020/08/07
 */
@Slf4j
public class LogisticsSubSystem {

    public void delivery(BaseCat cat, Buyer buyer) {
        BaseHandler dispatcher = new DispatcherHandler(new Random().nextInt(), null);
        DeliveryCompanyEnum[] companies = DeliveryCompanyEnum.values();
        String companyCode = companies[new Random().nextInt(companies.length)].getCode();
        BaseHandler company = new DeliveryCompanyHandler(companyCode, dispatcher);
        BaseHandler recipient = new RecipientHandler(new Random().nextInt(), company);
        recipient.handleRequest(cat, buyer);
    }
}
