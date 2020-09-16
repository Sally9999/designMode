package com.fyx.cat.observer;


import com.fyx.cat.entity.cat.BaseCat;

import java.util.List;

/**
 * 具体被观察者（观察者模式）
 *
 * @author wushiyi
 * @date 2020/08/07
 */
public class CatObservable extends Observable {

    public void sale(List<BaseCat> cats) {
        for (BaseCat cat : cats) {
            this.change(cat);
        }
    }

    @Override
    public void change(Object o) {
        this.setChanged();
        this.notifyObservers(o);
    }
}
