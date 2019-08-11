package app.picliu.it.com.bussniss.component;

import com.it.picliu.componentapi.Component;
import com.it.picliu.componentapi.ComponentFactory;

/**
 * *  @name:picliu
 * *  @date: 2019/8/9
 */
public class BussnissCompomentFactroy extends ComponentFactory {

    @Override
    public Component onCreate() {
        return new BussnissComponent();
    }
}
