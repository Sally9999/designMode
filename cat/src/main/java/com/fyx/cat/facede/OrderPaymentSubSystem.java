package com.fyx.cat.facede;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.service.CatService;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单支付子系统
 *
 * @author wushiyi
 * @date 2020/08/07
 */
@Slf4j
public class OrderPaymentSubSystem {

    private CatService catService;

    public OrderPaymentSubSystem(CatService catService) {
        this.catService = catService;
    }

    public boolean purchase(BaseCat cat, Buyer buyer) {
        log.info("{}尝试购买{}【{}】...", buyer.getName(), cat.getType(), cat.getCode());
        return catService.buyACat(cat, buyer);
    }
}
