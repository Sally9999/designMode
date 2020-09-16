package com.fyx.cat.strategy;

import java.lang.annotation.*;

/**
 * 支付类型注解
 *
 * @author wushiyi
 * @date 2020/09/16
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PaymentType {
    int value();
}
