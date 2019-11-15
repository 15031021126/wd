package com.wd.health.view.actv.user;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ColorUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.adpter.user.AdopteAdapter;
import com.wd.health.base.BaseUserTitle;
import com.wd.health.base.NoMessage;
import com.wd.health.entity.user.AdopteEntity;
import com.wd.health.mvp.user.adopte.AdopteContract;
import com.wd.health.mvp.user.adopte.AdopteModelImpl;
import com.wd.health.mvp.user.adopte.AdoptePresenterImpl;
import com.yanzhenjie.recyclerview.widget.DefaultItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;

public class AdopteActivity extends BaseActivity<AdopteModelImpl, AdoptePresenterImpl> implements AdopteContract.AdopteView {


    @BindView(R.id.user_title)
    BaseUserTitle userTitle;
    @BindView(R.id.adopte_rec)
    RecyclerView adopteRec;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.no_message)
    NoMessage noMessage;
    private int page = 1;
    private ArrayList<AdopteEntity.ResultBean> resultBeans = new ArrayList<>();
    private AdopteAdapter adopteAdapter;

    @Override
    protected void iniData() {

        userTitle.tName.setText("被采纳建议");
        userTitle.tBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        presenter.aVoid(page, 5);

        adopteRec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adopteRec.setNestedScrollingEnabled(false);
        adopteRec.addItemDecoration(new DefaultItemDecoration(ColorUtils.getColor(R.color.mylightgray)));


        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                presenter.aVoid(page, 5);
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                resultBeans.clear();
                presenter.aVoid(page, 5);
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_cn;
    }

    @Override
    public BasePresenter initPresenter() {
        return new AdoptePresenterImpl();
    }

    @Override
    public void showList(Object o) {
        AdopteEntity adopteEntity = (AdopteEntity) o;
        if (adopteEntity.getStatus().equals("0000")) {
            if (adopteEntity.getResult().size() != 0) {
                for (int i = 0; i < adopteEntity.getResult().size(); i++) {
                    if (!resultBeans.contains(adopteEntity.getResult().get(i))) {
                        resultBeans.add(adopteEntity.getResult().get(i));
                    }
                }
            } else {
                ToastUtils.showShort("没了");
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
            if (resultBeans.size() == 0) {
                noMessage.setVisibility(View.VISIBLE);
                refreshLayout.setVisibility(View.GONE);
            } else {
                noMessage.setVisibility(View.GONE);
                refreshLayout.setVisibility(View.VISIBLE);
            }
            if (adopteAdapter == null) {
                adopteAdapter = new AdopteAdapter(this, resultBeans);
            }
            adopteRec.setAdapter(adopteAdapter);
        } else {
            ToastUtils.showShort(adopteEntity.getMessage());
        }
    }
}
