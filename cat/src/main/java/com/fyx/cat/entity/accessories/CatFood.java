package com.fyx.cat.entity.accessories;

import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.enums.AccessoryTypeEnum;

/**
 * @author wushiyi
 * @date 2020/08/06
 */
public class CatFood extends BaseAccessory {

    public CatFood(BaseCat cat) {
        super(cat);
        setType(AccessoryTypeEnum.CAT_FOOD.getName());
        this.setDescription(AccessoryTypeEnum.CAT_FOOD.getName());
        this.setPrice(100);
    }
}
