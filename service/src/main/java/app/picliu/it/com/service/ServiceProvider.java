package app.picliu.it.com.service;

import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * *  @name:picliu
 * *  @date:2019-08-08
 */
public abstract class ServiceProvider {

    private static final ServiceProvider aRouterProvider = new ARouterServiceProvider();

    public static ServiceProvider get() {
        return aRouterProvider;
    }

    @NonNull
    public abstract <T> T getService(Class<T> serviceClass) throws ComponentNotFoundException;

    private static class ARouterServiceProvider extends ServiceProvider {

        @NonNull
        @Override
        public <T> T getService(Class<T> serviceClass) throws ComponentNotFoundException {
            T service = ARouter.getInstance().navigation(serviceClass);
            if (service == null) {
                throw new ComponentNotFoundException(serviceClass.getName() + "未发现组件");
            }
            return service;
        }
    }
}
