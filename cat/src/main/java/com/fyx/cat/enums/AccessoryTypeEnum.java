package com.fyx.cat.enums;

import com.fyx.cat.entity.accessories.CatFood;
import com.fyx.cat.entity.accessories.CatLitter;
import com.fyx.cat.entity.accessories.Cattery;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wushiyi
 * @date 2020/08/05
 */
@AllArgsConstructor
@Getter
public enum AccessoryTypeEnum {

    CATTERY("CA", "猫窝", Cattery.class),
    CAT_FOOD("CF", "猫粮", CatFood.class),
    CAT_LITTER("CL", "猫砂", CatLitter.class);

    private String code;
    private String name;
    private Class clazz;

    public static AccessoryTypeEnum getEnum(String code) {
        if (code != null) {
            for (AccessoryTypeEnum e : AccessoryTypeEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }
}
