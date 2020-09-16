package com.fyx.cat.entity.accessories;

import com.fyx.cat.entity.cat.BaseCat;
import com.fyx.cat.enums.AccessoryTypeEnum;

/**
 * @author wushiyi
 * @date 2020/08/06
 */
public class CatLitter extends BaseAccessory {

    public CatLitter(BaseCat cat) {
        super(cat);
        setType(AccessoryTypeEnum.CAT_LITTER.getName());
        this.setDescription(AccessoryTypeEnum.CAT_LITTER.getName());
        this.setPrice(30);
    }
}
