package com.wd.health.view.actv.user.sick;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.adpter.user.IllAdapter;
import com.wd.health.base.BaseUserTitle;
import com.wd.health.base.NoMessage;
import com.wd.health.entity.circle.CircleListsBean;
import com.wd.health.mvp.user.ill.IllContract;
import com.wd.health.mvp.user.ill.IllModelImpl;
import com.wd.health.mvp.user.ill.IllPresenterImpl;

import java.util.ArrayList;

import butterknife.BindView;

public class IllActivity extends BaseActivity<IllModelImpl,IllPresenterImpl> implements IllContract.IllView {

    private static final String TAG = "ills";
    @BindView(R.id.user_title)
    BaseUserTitle userTitle;
    @BindView(R.id.ill_rec)
    RecyclerView illRec;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.no_message)
    NoMessage noMessage;
    private ArrayList<CircleListsBean.ResultBean> resultBeans;
    private int page=1;
    private int count =5;
    private IllAdapter illAdapter;

    @Override
    protected void iniData() {
        resultBeans=new ArrayList<>();
        userTitle.tName.setText("我的病友圈");
        userTitle.tBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        presenter.show(page,count);
        illRec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        refreshLayout.setRefreshHeader(new BezierCircleHeader(this));
        refreshLayout.setRefreshFooter(new BallPulseFooter(this));
        illRec.setNestedScrollingEnabled(false);
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                presenter.show(page,count);
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                resultBeans.clear();
                presenter.show(page,count);
                refreshLayout.finishRefresh();
            }
        });

    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_ill;
    }

    @Override
    public BasePresenter initPresenter() {
        return new IllPresenterImpl();
    }

    @Override
    public void showList(Object o) {
        CircleListsBean circleListsBean= (CircleListsBean) o;

        if (circleListsBean.getStatus().equals("0000")){
            if (circleListsBean.getResult().size()!=0) {
                for (int i = 0; i < circleListsBean.getResult().size(); i++) {
                    if (!resultBeans.contains(circleListsBean.getResult().get(i))) {
                        resultBeans.add(circleListsBean.getResult().get(i));
                    }
                }
                if (resultBeans.size()==0){
                    noMessage.setVisibility(View.VISIBLE);
                    refreshLayout.setVisibility(View.GONE);
                }else {
                    noMessage.setVisibility(View.GONE);
                    refreshLayout.setVisibility(View.VISIBLE);
                }
                if (illAdapter==null){
                    illAdapter = new IllAdapter(this,resultBeans);
                }
                illRec.setAdapter(illAdapter);
            }else {
                refreshLayout.finishLoadMoreWithNoMoreData();
                ToastUtils.showShort("没了呀!!!");
            }
        }else {
        }
    }
}
