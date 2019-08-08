package app.picliu.it.com.moduleproject;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * *  @name:picliu
 * *  @date:2019-08-08
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
