package com.it.picliu.componentapi;

/**
 * *  @name:picliu
 * *  @date: 2019/8/9
 */
public interface ComponentFactoryLoader {
    ComponentFactory loadFactory(String className) throws ClassNotFoundException;
}
