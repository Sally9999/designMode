package com.fyx.cat.entity.accessories;

import com.fyx.cat.entity.cat.BaseCat;
import lombok.Data;

/**
 * 配件（装饰器模式）
 *
 * @author wushiyi
 * @date 2020/08/05
 */
@Data
public class BaseAccessory extends BaseCat {

    private BaseCat cat;

    public BaseAccessory(BaseCat cat) {
        this.cat = cat;
    }

    @Override
    public String getType() {
        return String.format("%s+%s", cat.getType(), super.getType());
    }

    @Override
    public String getCode() {
        return cat.getCode();
    }

    @Override
    public String getDescription() {
        return String.format("%s\n%s", cat.getDescription(), super.getDescription());
    }

    @Override
    public Integer getPrice() {
        return cat.getPrice() + super.getPrice();
    }

    @Override
    public boolean isSold() {
        return cat.isSold();
    }

    @Override
    public void setSold(boolean sold) {
        cat.setSold(sold);
    }
}
