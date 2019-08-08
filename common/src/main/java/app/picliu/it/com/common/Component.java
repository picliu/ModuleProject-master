package app.picliu.it.com.common;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * *  @name:picliu
 * *  @date:2019-08-09
 */
public interface Component {

    /**
     * 组件初始化，这个时候不能调用其他组件的服务
     * @param context context
     */
    void init(Context context);

    /**
     * application 初始化
     * @param context context
     */
    void onApplicationCreate(Context context);

    /**
     * application AttachBaseContext
     * @param application
     * @param base context
     */
    void onApplicationAttachBaseContext(Application application, Context base);

    /**
     * application Terminate
     */
    void onApplicationTerminate();

    /**
     * application LowMemory
     */
    void onAppLowMemory();

    /**
     * application ConfigurationChanged
     * @param newConfig
     */
    void onAppConfigurationChanged(Configuration newConfig);
}
