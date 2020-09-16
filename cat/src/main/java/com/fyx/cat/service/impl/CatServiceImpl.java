package com.fyx.cat.service.impl;

import com.fyx.cat.command.BaseCommand;
import com.fyx.cat.command.PurchaseCommand;
import com.fyx.cat.dto.PaymentDTO;
import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.MailContent;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.enums.AccessoryTypeEnum;
import com.fyx.cat.enums.CatTypeEnum;
import com.fyx.cat.factory.CatFactory;
import com.fyx.cat.observer.BuyerObserver;
import com.fyx.cat.observer.CatObservable;
import com.fyx.cat.service.CatService;
import com.fyx.cat.strategy.PaymentContext;
import com.fyx.cat.strategy.payment.BasePayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author wushiyi
 * @date 2020/08/05
 */
@Service("catService")
@Slf4j
public class CatServiceImpl implements CatService {

    @Autowired
    private CatFactory catFactory;
    @Autowired
    private PaymentContext paymentContext;

    @Override
    public void init() {
        try {
            int count = 3;
            List<BaseCat> cats = new ArrayList<>();
            while (count-- > 0) {
                for (CatTypeEnum e : CatTypeEnum.values()) {
                    cats.add(catFactory.getCat(e.getCode()));
                }
            }
            List<Buyer> buyers = getBuyers();
            notifyBuyers(cats, buyers);
            CatObservable catObservable = new CatObservable();
            for (Buyer buyer : buyers) {
                catObservable.addObserver(new BuyerObserver(buyer, this));
            }
            log.info("observer count:{}", catObservable.countObservers());
            catObservable.sale(cats);
            Thread.sleep(5000);
            cats.stream().filter(cat -> !cat.isSold()).forEach(cat -> log.info("{}【{}】:喵喵好可怜，没人喜欢我T_T", cat.getType(), cat.getCode()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void notifyBuyers(List<BaseCat> cats, List<Buyer> buyers) {
        try {
            List<String> types = cats.stream().map(BaseCat::getType).distinct().collect(Collectors.toList());
            MailContent mailContent = new MailContent();
            mailContent.setSubject("店铺上新啦");
            mailContent.setContent(String.format("%s开售了", String.join("、", types)));
            for (Buyer buyer : buyers) {
                MailContent m = mailContent.clone();
                m.setReceiver(buyer.getMail());
                // 假装发了邮件
                log.info("sent mail:{}", m.toString());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private List<Buyer> getBuyers() {
        Buyer buyer1 = new Buyer("张三", "北京", 10000, 0, "zhangsan@sina.com");
        Buyer buyer2 = new Buyer("李四", "上海", 5000, 4000, "lisi@qq.com");
        Buyer buyer3 = new Buyer("王五", "深圳", 3000, 500, "wangwu@163.com");
        List<Buyer> buyers = new ArrayList<>();
        buyers.add(buyer1);
        buyers.add(buyer2);
        buyers.add(buyer3);
        return buyers;
    }

    @Override
    public boolean buyACat(BaseCat cat, Buyer buyer) {
        try {
            BaseCat target;
            int random = new Random().nextInt(3);
            switch (random) {
                case 0:
                    target = cat;
                    break;
                case 1:
                    target = createAccessoryByRandom(cat);
                    break;
                default:
                    target = createAccessoryByRandom(createAccessoryByRandom(cat));

            }
            BasePayment payment = paymentContext.getPayment(new Random().nextInt(2));
            BaseCommand command = new PurchaseCommand(payment);
            return command.execute(new PaymentDTO(buyer, target, null));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    private BaseCat createAccessoryByRandom(BaseCat cat) throws NoSuchMethodException, InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {

        AccessoryTypeEnum[] types = AccessoryTypeEnum.values();
        Class clazz = types[new Random().nextInt(types.length)].getClazz();
        while (clazz.equals(cat.getClass())) {
            clazz = types[new Random().nextInt(types.length)].getClazz();
        }
        Constructor constructor = clazz.getDeclaredConstructor(new Class[]{
                BaseCat.class
        });
        constructor.setAccessible(true);
        return (BaseCat) constructor.newInstance(cat);
    }
}
