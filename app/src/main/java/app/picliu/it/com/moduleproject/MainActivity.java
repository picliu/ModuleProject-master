package app.picliu.it.com.moduleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import app.picliu.it.com.bussniss.BussnissActivity;
import app.picliu.it.com.bussniss2.utils.BussnissTextChangeUtils;

public class MainActivity extends AppCompatActivity {

    private TextView mTvMaster;
    private int changeCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvMaster = findViewById(R.id.tv_master);
        mTvMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, BussnissActivity.class);
//                startActivity(intent);
                ARouter.getInstance().build("/bussniss/activity").navigation(getApplicationContext());
            }
        });

        TextView mTvMasterChange = findViewById(R.id.tv_master_change);
        mTvMasterChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvMaster.setText(BussnissTextChangeUtils.getText() + changeCount);
                changeCount++;
            }
        });
    }
}
