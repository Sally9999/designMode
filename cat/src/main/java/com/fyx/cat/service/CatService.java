package com.fyx.cat.service;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;

/**
 * @author wushiyi
 * @date 2020/08/05
 */
public interface CatService {
    /**
     * 初始化
     *
     * @throws CloneNotSupportedException
     */
    void init() throws CloneNotSupportedException;

    /**
     * 买只猫
     *
     * @param cat
     * @param buyer
     * @return
     */
    boolean buyACat(BaseCat cat, Buyer buyer);
}
