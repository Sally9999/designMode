package com.fyx.cat.responsibilitychain;

import com.fyx.cat.entity.Buyer;
import com.fyx.cat.entity.cat.BaseCat;

/**
 * 抽象处理者(责任链模式)
 *
 * @author wushiyi
 * @date 2020/08/10
 */
public abstract class BaseHandler {

    protected String name;

    private BaseHandler next;

    public BaseHandler(String name, BaseHandler next) {
        this.name = name;
        this.next = next;
    }

    public BaseHandler getNext() {
        return next;
    }

    /**
     * 处理逻辑
     *
     * @param cat
     * @param buyer
     */
    public abstract void handleRequest(BaseCat cat, Buyer buyer);
}
