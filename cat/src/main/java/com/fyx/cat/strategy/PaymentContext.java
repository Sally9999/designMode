package com.fyx.cat.strategy;

import com.fyx.cat.strategy.payment.BasePayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 支付环境
 *
 * @author wushiyi
 * @date 2020/08/06
 */
@Component
@Slf4j
public class PaymentContext {

    @Autowired
    private Map<String, BasePayment> map;

    public BasePayment getPayment(Integer type) {
        for (BasePayment item : map.values()) {
            if (item.getClass().getAnnotationsByType(PaymentType.class)[0].value() ==
                    type.intValue()) {
                return item;
            }
        }
        log.error("payment channel not existed! type:{}", type);
        return null;
    }
}
