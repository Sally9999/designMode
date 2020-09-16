package com.fyx.cat.strategy.payment;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.strategy.PaymentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 假装支付宝渠道操作
 *
 * @author wushiyi
 * @date 2020/08/06
 */
@Component
@PaymentType(AliPay.TYPE_ALI_PAY)
@Slf4j
public class AliPay extends BasePayment {

    protected static final int TYPE_ALI_PAY = 0;

    @Override
    protected boolean checkAccount(Buyer buyer, BaseCat cat) {
        return buyer.getAliAccount() >= cat.getPrice();
    }

    @Override
    protected boolean pay(Buyer buyer, BaseCat cat) {
        buyer.setAliAccount(buyer.getAliAccount() - cat.getPrice());
        return true;
    }

    @Override
    protected String getPaymentChannel() {
        return "支付宝";
    }

    @Override
    protected Integer getBalance(Buyer buyer) {
        return buyer.getAliAccount();
    }

    @Override
    public boolean fundIn(Buyer buyer, Integer amount) {
        buyer.setAliAccount(buyer.getAliAccount() + amount);
        log.info("{}{}账户入金：{}", buyer.getName(), getPaymentChannel(), amount);
        return true;
    }
}
