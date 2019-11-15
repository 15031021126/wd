package com.wd.base_core.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:陈浩
 *@Date: 2019/8/2
 *@Time:16:50
 *@Description:${DESCRIPTION}
 * */
public abstract class BaseFragment<M extends IBaseModel, P extends BasePresenter> extends Fragment implements IBaseView {
    public P presenter;
    public M model;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(bindlayout(), container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = (P) initPresenter();
        if (presenter != null) {
            model = (M) presenter.getModel();
            if (model != null) {
                presenter.attach(this);
            }
        }
        //数据处理
        iniData();
    }

    /**
     * 跳转页面
     *
     * @param clz
     */
    public void sA(Class<? extends Activity> clz) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), clz);
        startActivity(intent);
    }

    /**
     * [携带数据的页面跳转]
     */
    public void sA(Class<? extends Activity> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 设置沉浸式
     *
     * @param
     */
    public void setBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f) //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
                .init();
    }

    /**
     * 带参数的颜色值
     *
     * @param b
     */
    public void setBar(int b) {
        BarUtils.setStatusBarLightMode(getActivity(), true);
        BarUtils.setStatusBarColor(getActivity() ,b);
    }

    /**
     * 数据处理
     */
    protected abstract void iniData();

    /**
     * 绑定布局
     *
     * @return
     */
    protected abstract int bindlayout();

    /**
     * 判断网络状态
     *
     * @return
     */
    public Boolean isNet() {
        boolean connected = NetworkUtils.isConnected();
        return connected;
    }

    /**
     * 销毁
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettach();
        }

        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
