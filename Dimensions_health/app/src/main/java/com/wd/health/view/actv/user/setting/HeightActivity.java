package com.wd.health.view.actv.user.setting;

import android.view.View;

import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.base.BaseUserTitle;

import butterknife.BindView;

public class HeightActivity extends BaseActivity {


    @BindView(R.id.user_title)
    BaseUserTitle userTitle;

    @Override
    protected void iniData() {
        userTitle.tBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        userTitle.tName.setText("体征");

    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_height;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
