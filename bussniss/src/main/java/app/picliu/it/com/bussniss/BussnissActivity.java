package app.picliu.it.com.bussniss;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import app.picliu.it.com.service.bussniss2.Bussniss2Service;
import app.picliu.it.com.service.ServiceProvider;

/**
 * *  @name:picliu
 * *  @date:2019-08-08
 */
public class BussnissActivity extends AppCompatActivity {

    private TextView mTvBussniss;
    private int changeCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussiniss);
        initView();
    }

    private void initView() {
        mTvBussniss = findViewById(R.id.tv_bussniss);
        mTvBussniss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvBussniss.setText(ServiceProvider.get().getService(Bussniss2Service.class).getText() + changeCount);
                changeCount++;
            }
        });
    }
}
