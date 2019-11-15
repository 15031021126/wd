package com.wd.health.view.frag.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.wd.base_core.base.BaseFragment;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.adpter.home.HomeJkzxVpAdpter;
import com.wd.health.adpter.home.HomeWzzxAdpter;
import com.wd.health.base.BaseTitle;
import com.wd.health.entity.home.HomeBanner;
import com.wd.health.entity.home.HomeHealthConsultationTitle;
import com.wd.health.entity.home.HomeWzzxEntity;
import com.wd.health.mvp.home.IhomeContract;
import com.wd.health.mvp.home.IhomeModelImpl;
import com.wd.health.mvp.home.IhomePresenterImpl;
import com.wd.health.view.actv.ChatActivity;
import com.wd.health.view.actv.user.UserActivity;
import com.wd.health.view.frag.home.HomeJkzxFive;
import com.wd.health.view.frag.home.HomeJkzxFour;
import com.wd.health.view.frag.home.HomeJkzxOne;
import com.wd.health.view.frag.home.HomeJkzxThree;
import com.wd.health.view.frag.home.HomeJkzxTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/*
 *@Auther:陈浩
 *@Date: 2019/8/3
 *@Time:15:55
 *@Description:${首页}
 * */public class HomeFrag extends BaseFragment<IhomeModelImpl, IhomePresenterImpl> implements IhomeContract.IhomeView {
    @BindView(R.id.home_banner)
    XBanner homeBanners;
    @BindView(R.id.zsbd_common_disease)
    LinearLayout zsbdCommonDisease;
    @BindView(R.id.zsbd_common_drugs)
    LinearLayout zsbdCommonDrugs;
    @BindView(R.id.wzzx_recy)
    RecyclerView wzzxRecy;
    @BindView(R.id.home_health_assessment)
    ImageView homeHealthAssessment;
    @BindView(R.id.home_jkzx_tab)
    TabLayout homeJkzxTab;
    @BindView(R.id.home_jkzx_viewpager)
    ViewPager homeJkzxViewpager;
    @BindView(R.id.homescroview)
    NestedScrollView homescroview;
    @BindView(R.id.basetitle)
    BaseTitle basetitle;
    @BindView(R.id.home_jkzx_name)
    TextView jkzxname;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void iniData() {
        jkzxname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getActivity(), ChatActivity.class));
            }
        });
        setBar(0);

        //请求xbanner数据
        presenter.requestBanner();
        //请求问诊咨询列表
        presenter.requestWzzx();
        //健康咨询标题
        presenter.requestJkzxTitle();
        //健康咨询内容
        presenter.requestJkzxContent("1", "1", "5");
        //知识宝典
        iniZsbd();
        //健康评测
        iniJkpc();

        //请求xbanner数据
        presenter.requestBanner();

        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.home_jkzx_one, null, true);
        inflate.setVisibility(View.GONE);
        View viewById = inflate.findViewById(R.id.jkzx_one_recy);
        viewById.setBackgroundColor(Color.RED);
        //吸顶
        homescroview.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d("HomeFrag", "homeJkzxTab.getScaleY():" + scrollY + "\n");
                if (scrollY > 1370) {
                    // Toast.makeText(getActivity(), "s", Toast.LENGTH_SHORT).show();
                } else {
//                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()) {
//                        @Override
//                        public boolean canScrollVertically() {
//                            return false;
//                        }
//                    };

                }
            }
        });

        //惯性
        homescroview.fling(4);

    }

    //健康评测
    private void iniJkpc() {
        homeHealthAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "去评测", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //知识宝典
    private void iniZsbd() {
        zsbdCommonDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "常见病", Toast.LENGTH_SHORT).show();
            }
        });
        zsbdCommonDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "常见药品", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected int bindlayout() {
        return R.layout.homefrag;
    }

    @Override
    public BasePresenter initPresenter() {
        return new IhomePresenterImpl();
    }

    /**
     * 首页轮播数据
     *
     * @param obj
     */
    @Override
    public void showBanner(Object obj) {
        HomeBanner banners = (HomeBanner) obj;
        //轮播
        homeBanners.setBannerData(banners.getResult());
        homeBanners.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(banners.getResult().get(position).getImageUrl()).into((ImageView) view);
            }
        });
        homeBanners.setPageTransformer(Transformer.Accordion);
    }

    /**
     * 问诊咨询
     *
     * @param obj
     */
    @Override
    public void showWzzx(Object obj) {
        HomeWzzxEntity wzzxEntity = (HomeWzzxEntity) obj;
        wzzxRecy.setLayoutManager(new GridLayoutManager(getActivity(), 4, LinearLayoutManager.VERTICAL, false));
        //适配器
        HomeWzzxAdpter homeWzzxAdpter = new HomeWzzxAdpter(getActivity(), wzzxEntity);
        wzzxRecy.setAdapter(homeWzzxAdpter);
    }

    /**
     * 健康咨询标题
     *
     * @param obj
     */
    @Override
    public void showJkzxTitle(Object obj) {
        HomeHealthConsultationTitle tabtitle = (HomeHealthConsultationTitle) obj;
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < tabtitle.getResult().size(); i++) {
            strings.add(tabtitle.getResult().get(i).getName());
        }
        fragments.add(new HomeJkzxOne());
        fragments.add(new HomeJkzxTwo());
        fragments.add(new HomeJkzxThree());
        fragments.add(new HomeJkzxFour());
        fragments.add(new HomeJkzxFive());
        HomeJkzxVpAdpter vpAdpter = new HomeJkzxVpAdpter(getActivity().getSupportFragmentManager(), getActivity(), strings, fragments);
        homeJkzxViewpager.setAdapter(vpAdpter);
        homeJkzxTab.setupWithViewPager(homeJkzxViewpager);
        homeJkzxViewpager.setOffscreenPageLimit(fragments.size() - 1);
    }

    /**
     * 健康咨询内容
     *
     * @param obj
     */
    @Override
    public void showJkzxContent(Object obj) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettach();
            presenter = null;
        }
    }
}
