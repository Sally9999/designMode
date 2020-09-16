package com.fyx.cat.entity.accessories;

import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.enums.AccessoryTypeEnum;

/**
 * @author wushiyi
 * @date 2020/08/06
 */
public class Cattery extends BaseAccessory {

    public Cattery(BaseCat cat) {
        super(cat);
        setType(AccessoryTypeEnum.CATTERY.getName());
        this.setDescription(AccessoryTypeEnum.CATTERY.getName());
        this.setPrice(70);
    }
}
