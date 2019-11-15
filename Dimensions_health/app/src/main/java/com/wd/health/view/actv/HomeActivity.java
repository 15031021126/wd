package com.wd.health.view.actv;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.SPUtils;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.view.frag.VideoFrag;
import com.wd.health.view.frag.home.HomeFrag;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 首页
 */
public class HomeActivity extends BaseActivity implements OnClickListener {


    @BindView(R.id.home_pager)
    ViewPager homePager;
    @BindView(R.id.rb1)
    RadioButton home;
    @BindView(R.id.rb3)
    RadioButton video;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.advisory)
    ImageView advisory;

    @Override
    protected void iniData() {
        setBar();
        //引导页
        isOne();
        home.setOnClickListener(this);
        video.setOnClickListener(this);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFrag());
        fragments.add(new VideoFrag());
        //设置适配器
        homePager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        homePager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        //跳转到咨询
        advisory.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    //第一次引导页
    private void isOne() {
        boolean one = SPUtils.getInstance().getBoolean("one");
        if (one) {
            return;
        } else {
            sA(GuideActivity.class);
            finish();
        }
    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_home;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    /**
     * 点击事件回调
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb1:
                homePager.setCurrentItem(0);
                break;
            case R.id.rb3:
                homePager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
