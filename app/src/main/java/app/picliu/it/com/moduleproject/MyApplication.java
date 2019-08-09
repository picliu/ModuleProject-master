package app.picliu.it.com.moduleproject;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.launcher.RouteClassLoader;

/**
 * *  @name:picliu
 * *  @date:2019-08-08
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            if (BuildConfig.DEBUG) {
                ARouter.openDebug();
                ARouter.openLog();
            }
            ARouter.init(this, new RouteClassLoader() {
                @Override
                public Class<?> loadClass(String className) throws ClassNotFoundException {
                    return Class.forName(className);
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
