package app.picliu.it.com.bussniss.component;

import android.content.Context;

import app.picliu.it.com.common.BaseComponent;

/**
 * *  @name:picliu
 * *  @date: 2019/8/9
 */
public class BussnissComponent extends BaseComponent {
    private static BussnissComponent instance;

    public BussnissComponent() {
        instance = this;
    }

    public static BussnissComponent get() {
        return instance;
    }

    @Override
    public void onApplicationCreate(Context context) {
        super.onApplicationCreate(context);
    }
}
