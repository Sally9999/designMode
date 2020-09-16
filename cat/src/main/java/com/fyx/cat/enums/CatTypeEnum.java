package com.fyx.cat.enums;

import com.fyx.cat.entity.cat.Ragdoll;
import com.fyx.cat.entity.cat.ScottishFold;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wushiyi
 * @date 2020/08/05
 */
@AllArgsConstructor
@Getter
public enum CatTypeEnum {

    RAGDOLL("RD", "布偶猫", Ragdoll.class),
    SCOTTISH_FOLD("SF", "折耳猫", ScottishFold.class);

    private String code;
    private String name;
    private Class clazz;

    public static CatTypeEnum getEnum(String code) {
        if (code != null) {
            for (CatTypeEnum e : CatTypeEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }
}
