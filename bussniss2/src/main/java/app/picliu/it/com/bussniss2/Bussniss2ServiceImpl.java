package app.picliu.it.com.bussniss2;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import app.picliu.it.com.bussniss2.utils.BussnissTextChangeUtils;
import app.picliu.it.com.service.bussniss2.Bussniss2Service;

/**
 * *  @name:picliu
 * *  @date:2019-08-09
 */
@Route(path = "/bussniss2/service")
public class Bussniss2ServiceImpl implements Bussniss2Service {
    @Override
    public String getText() {
        return BussnissTextChangeUtils.getText();
    }

    @Override
    public void init(Context context) {

    }
}
