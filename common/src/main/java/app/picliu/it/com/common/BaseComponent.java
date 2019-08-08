package app.picliu.it.com.common;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.CallSuper;
import android.support.v4.view.KeyEventDispatcher;
/**
 * *  @name:picliu
 * *  @date:2019-08-09
 */
public abstract class BaseComponent implements Component {

    private Context context;

    public Context getContext(){
        return context;
    }

    @CallSuper
    @Override
    public void init(Context context) {
        this.context = context;
    }

    @Override
    public void onApplicationCreate(Context context) {
    }

    @Override
    public void onApplicationAttachBaseContext(Application application, Context base) {

    }

    @Override
    public void onApplicationTerminate() {

    }

    @Override
    public void onAppLowMemory() {

    }

    @Override
    public void onAppConfigurationChanged(Configuration newConfig) {

    }
}
