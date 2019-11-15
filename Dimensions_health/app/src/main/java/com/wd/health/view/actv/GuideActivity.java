package com.wd.health.view.actv;


import android.view.View;

import com.blankj.utilcode.util.SPUtils;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 引导页
 */
public class GuideActivity extends BaseActivity {

    @Override
    protected void iniData() {
        setBar(0);
        SPUtils.getInstance().put("one",true);
        //设置引导页布局资源
        BGABanner bgaBanner = findViewById(R.id.bgabannerview);
        List<View> views = new ArrayList<>();
        views.add(View.inflate(this, R.layout.guideone, null));
        views.add(View.inflate(this, R.layout.guidetwo, null));
        views.add(View.inflate(this, R.layout.guidethree, null));
        views.add(View.inflate(this, R.layout.guidefour, null));
        View inflate = View.inflate(this, R.layout.guidefive, null);
        views.add(inflate);
        //点击事件跳转
        inflate.findViewById(R.id.five_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sA(HomeActivity.class);
                finish();
            }
        });
        bgaBanner.setData(views);
    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_guide;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }


}
