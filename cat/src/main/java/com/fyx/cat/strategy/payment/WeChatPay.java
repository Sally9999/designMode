package com.fyx.cat.strategy.payment;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.strategy.PaymentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 假装微信渠道操作
 *
 * @author wushiyi
 * @date 2020/08/06
 */
@Component
@PaymentType(WeChatPay.TYPE_WE_CHAT_PAY)
@Slf4j
public class WeChatPay extends BasePayment {

    protected static final int TYPE_WE_CHAT_PAY = 1;

    @Override
    protected boolean checkAccount(Buyer buyer, BaseCat cat) {
        return buyer.getWxAccount() >= cat.getPrice();
    }

    @Override
    protected boolean pay(Buyer buyer, BaseCat cat) {
        buyer.setWxAccount(buyer.getWxAccount() - cat.getPrice());
        return true;
    }

    @Override
    protected String getPaymentChannel() {
        return "微信";
    }

    @Override
    protected Integer getBalance(Buyer buyer) {
        return buyer.getWxAccount();
    }

    @Override
    public boolean fundIn(Buyer buyer, Integer amount) {
        buyer.setWxAccount(buyer.getWxAccount() + amount);
        log.info("{}{}账户入金：{}", buyer.getName(), getPaymentChannel(), amount);
        return true;
    }
}
