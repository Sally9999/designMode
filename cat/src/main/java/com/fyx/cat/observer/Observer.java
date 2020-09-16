package com.fyx.cat.observer;

/**
 * 抽象观察者
 *
 * @author wushiyi
 * @date 2020/08/07
 */
public interface Observer {

    /**
     * 响应
     *
     * @param o
     */
    void response(Object o);
}
