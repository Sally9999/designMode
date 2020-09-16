package com.fyx.cat.observer;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.facede.PurchaseFacede;
import com.fyx.cat.service.CatService;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;


/**
 * 具体观察者 （观察者模式）
 *
 * @author wushiyi
 * @date 2020/08/07
 */
@Slf4j
public class BuyerObserver implements Observer {

    private CatService catService;

    private Buyer buyer;

    public BuyerObserver(Buyer buyer, CatService catService) {
        this.buyer = buyer;
        this.catService = catService;
    }

    @Override
    public void response(Object o) {
        boolean flag = new Random().nextBoolean();
        BaseCat cat = (BaseCat) o;
        if (flag) {
            PurchaseFacede facede = new PurchaseFacede(catService);
            facede.purchase(cat, buyer);
        } else {
            log.info("{}放弃购买{}【{}】", buyer.getName(), cat.getType(), cat.getCode());
        }
    }
}
