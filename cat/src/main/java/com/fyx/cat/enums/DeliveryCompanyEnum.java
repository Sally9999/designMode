package com.fyx.cat.enums;

import com.fyx.cat.strategy.transport.AirStrategy;
import com.fyx.cat.strategy.transport.BaseStrategy;
import com.fyx.cat.strategy.transport.LandStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 快递公司
 *
 * @author wushiyi
 * @date 2020/08/10
 */
@Getter
@AllArgsConstructor
public enum DeliveryCompanyEnum {

    SF("sf", "顺丰快递", new AirStrategy()),
    ZT("zt", "中通快递", new LandStrategy());

    private String code;
    private String name;
    private BaseStrategy strategy;

    public static DeliveryCompanyEnum getEnum(String code) {
        if (code != null) {
            for (DeliveryCompanyEnum e : DeliveryCompanyEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }
}
