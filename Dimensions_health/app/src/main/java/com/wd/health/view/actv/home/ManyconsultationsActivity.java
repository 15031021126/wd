package com.wd.health.view.actv.home;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.untils.L;
import com.wd.health.R;
import com.wd.health.adpter.home.HomeJkzxRecyAdpter;
import com.wd.health.entity.home.HomeHealthConsultationContent;
import com.wd.health.mvp.home.IhomeContract;
import com.wd.health.mvp.home.IhomeModelImpl;
import com.wd.health.mvp.home.IhomePresenterImpl;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 更多咨询
 */
public class ManyconsultationsActivity extends BaseActivity<IhomeModelImpl, IhomePresenterImpl> implements IhomeContract.IhomeView {

    @BindView(R.id.advisory_more_heah)
    ImageView advisoryMoreHeah;
    @BindView(R.id.advisory_more_tab)
    TextView advisoryMoreTab;
    @BindView(R.id.advisory_more_rbbell)
    ImageView advisoryMoreRbbell;
    @BindView(R.id.advisory_more_xrecyc)
    XRecyclerView advisoryMoreXrecyc;
    private ArrayList<HomeHealthConsultationContent.ResultBean> resultBeans = new ArrayList<>();
    private HomeJkzxRecyAdpter recyAdpter;
    private int plateId;
    private int page = 1;

    @Override
    protected void iniData() {
        setBar();
        ///初始化
        inithis();
        //处理设置适配器
        //设置适配器
        if (resultBeans != null) {
            recyAdpter = new HomeJkzxRecyAdpter(this, resultBeans);
            advisoryMoreXrecyc.setAdapter(recyAdpter);
        }
        //刷新加载
        advisoryMoreXrecyc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                resultBeans.clear();
                presenter.requestJkzxContent("" + plateId, "1", "7");
                recyAdpter.notifyDataSetChanged();
                advisoryMoreXrecyc.refreshComplete();
                View view = LayoutInflater.from(ManyconsultationsActivity.this).inflate(R.layout.moreconsultationfoot, null, false);
                //advisoryMoreXrecyc.addHeaderView(view);
                //  advisoryMoreXrecyc.setFootView(view);
                recyAdpter.setFlag(false);
            }

            @Override
            public void onLoadMore() {
                page++;
                presenter.requestJkzxContent("" + plateId, "" + page, "5");
                recyAdpter.notifyDataSetChanged();
                advisoryMoreXrecyc.loadMoreComplete();
            }
        });

    }

    //初始化
    private void inithis() {
        plateId = getIntent().getIntExtra("plateId", 0);
        //查询内容默认
        presenter.requestJkzxContent("" + plateId, "1", "7");
        advisoryMoreXrecyc.setLayoutManager(new LinearLayoutManager(this));
        advisoryMoreXrecyc.setLoadingMoreEnabled(true);
        Glide.with(this).load(SPUtils.getInstance("user").getString("headPic")).apply(new RequestOptions().circleCrop()).into(advisoryMoreHeah);

        //设置标题bar
        switch (plateId) {
            case 1:
                advisoryMoreTab.setText("健康养生");
                break;
            case 2:
                advisoryMoreTab.setText("健康减肥");
                break;
            case 3:
                advisoryMoreTab.setText("健康美食");
                break;
            case 4:
                advisoryMoreTab.setText("健康美容");
                break;
            case 5:
                advisoryMoreTab.setText("慢性疾病");
                break;
        }
        /**
         * 跳转会话
         */
        advisoryMoreRbbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /***
     * 按返回键动画
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_manyconsultations;
    }

    @Override
    public BasePresenter initPresenter() {
        return new IhomePresenterImpl();
    }


    @Override
    public void showBanner(Object obj) {

    }

    @Override
    public void showWzzx(Object obj) {

    }

    @Override
    public void showJkzxTitle(Object obj) {

    }

    /**
     * 处理数据
     *
     * @param obj
     */
    @Override
    public void showJkzxContent(Object obj) {
        HomeHealthConsultationContent heaithcontent = (HomeHealthConsultationContent) obj;
        if (heaithcontent.getResult().size() != 0) {
            recyAdpter.setFlag(false);
            for (int i = 0; i < heaithcontent.getResult().size(); i++) {
                if (!resultBeans.contains(heaithcontent.getResult().get(i))) {
                    resultBeans.add(heaithcontent.getResult().get(i));
                }else{
                    L.e("123","包含");
                }
            }
        } else {
           // Toast.makeText(this, "nul00l", Toast.LENGTH_SHORT).show();
            recyAdpter.setFlag(true);
            return;
        }
        recyAdpter.notifyDataSetChanged();
    }
}
