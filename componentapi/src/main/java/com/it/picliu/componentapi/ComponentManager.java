package com.it.picliu.componentapi;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * *  @name:picliu
 * *  @date: 2019/8/9
 */
public class ComponentManager {

    private static final List<String> componentFactories = new ArrayList<>();
    private static final List<Component> components = new ArrayList<>();

    private static void installAll(ComponentFactoryLoader factoryLoader) {
        init(factoryLoader);
    }

    private static void init(ComponentFactoryLoader factoryLoader) {
        for (int i = 0; i < componentFactories.size(); i++) {
            try {
                ComponentFactory factory = factoryLoader.loadFactory(componentFactories.get(i));
                components.add(factory.create());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getComponentCount() {
        return components.size();
    }

    public static Component getComponentAt(int index) {
        return components.get(index);
    }

    public static void callOnCreate(Context context) {
        callInit(context);
        for (int i = 0; i < getComponentCount(); i++) {
            getComponentAt(i).onApplicationCreate(context);
        }
    }

    private static void callInit(Context context) {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponentAt(i).init(context);
        }
    }

    public static void attachBaseContext(Application application, Context base) {
        attachBaseContext(new InternalComponentFactoryLoader(), application, base);
    }

    public static void attachBaseContext(ComponentFactoryLoader factoryLoader, Application application, Context base) {
        installAll(factoryLoader);
        for (int i = 0; i < getComponentCount(); i++) {
            getComponentAt(i).onApplicationAttachBaseContext(application, base);
        }
    }

    public static void terminate() {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponentAt(i).onApplicationTerminate();
        }
    }

    public static void onLowMemory() {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponentAt(i).onAppLowMemory();
        }
    }

    public static void onConfigurationChanged(Configuration newConfig) {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponentAt(i).onAppConfigurationChanged(newConfig);
        }
    }

    private static class InternalComponentFactoryLoader implements ComponentFactoryLoader {

        @Override
        public ComponentFactory loadFactory(String className) {
            try {
                return (ComponentFactory) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

