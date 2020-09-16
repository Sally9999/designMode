package com.fyx.cat.observer;

import java.util.Vector;

/**
 * 抽象被观察者
 *
 * @author wushiyi
 * @date 2020/08/07
 */
public abstract class Observable {
    private boolean changed = false;
    private Vector<Observer> obs;

    public Observable() {
        obs = new Vector<>();
    }

    public synchronized void addObserver(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    public synchronized void deleteObserver(Observer o) {
        obs.removeElement(o);
    }

    public void notifyObservers(Object o) {
        Vector<Observer> arrLocal;

        synchronized (this) {
            if (!changed) {
                return;
            }
            arrLocal = (Vector<Observer>) obs.clone();
            clearChanged();
        }

        arrLocal.stream().parallel().forEach(observer -> {
            observer.response(o);
        });
    }

    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    protected synchronized void setChanged() {
        changed = true;
    }

    protected synchronized void clearChanged() {
        changed = false;
    }

    public synchronized boolean hasChanged() {
        return changed;
    }

    public synchronized int countObservers() {
        return obs.size();
    }

    public abstract void change(Object o);
}
