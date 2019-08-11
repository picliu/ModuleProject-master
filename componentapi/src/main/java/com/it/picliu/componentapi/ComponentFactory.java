package com.it.picliu.componentapi;

/**
 * *  @name:picliu
 * *  @date: 2019/8/9
 * *  组件工厂类
 */
public abstract class ComponentFactory {

    private Component mComponent;

    public abstract Component onCreate();

    public final Component create() {
        if (mComponent == null) {
            mComponent = onCreate();
        }
        return mComponent;
    }
}
