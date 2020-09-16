package com.fyx.cat.facede;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.service.CatService;

/**
 * 购买门面类（外观系统）
 *
 * @author wushiyi
 * @date 2020/08/07
 */
public class PurchaseFacede {

    private CatService catService;
    private OrderPaymentSubSystem orderPaymentSubSystem;
    private InventorySubSystem inventorySubSystem;
    private LogisticsSubSystem logisticsSubSystem;

    public PurchaseFacede(CatService catService) {
        this.catService = catService;
        orderPaymentSubSystem = new OrderPaymentSubSystem(catService);
        inventorySubSystem = new InventorySubSystem();
        logisticsSubSystem = new LogisticsSubSystem();
    }

    public void purchase(BaseCat cat, Buyer buyer) {
        boolean flag = orderPaymentSubSystem.purchase(cat, buyer);
        if (flag) {
            inventorySubSystem.handle(cat);
            logisticsSubSystem.delivery(cat, buyer);
        }
    }
}
