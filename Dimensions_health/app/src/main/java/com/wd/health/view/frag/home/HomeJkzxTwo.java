package com.wd.health.view.frag.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.base_core.base.BaseFragment;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.adpter.home.HomeJkzxRecyAdpter;
import com.wd.health.entity.home.HomeHealthConsultationContent;
import com.wd.health.mvp.home.IhomeContract;
import com.wd.health.mvp.home.IhomeModelImpl;
import com.wd.health.mvp.home.IhomePresenterImpl;
import com.wd.health.view.actv.home.ManyconsultationsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:陈浩
 *@Date: 2019/8/5
 *@Time:17:18
 *@Description:${DESCRIPTION}
 * */public class HomeJkzxTwo extends BaseFragment<IhomeModelImpl, IhomePresenterImpl> implements IhomeContract.IhomeView {
    @BindView(R.id.jkzx_two_recy)
    XRecyclerView jkzxTwoRecy;
    private ArrayList<HomeHealthConsultationContent.ResultBean> resultBeans = new ArrayList<>();
    private HomeJkzxRecyAdpter recyAdpter;

    @Override
    protected void iniData() {
        //查询内容
        presenter.requestJkzxContent("2", "1", "5");
        jkzxTwoRecy.setPullRefreshEnabled(false);
        jkzxTwoRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加尾布局
       addFootView();
    }
    //添加尾布局
    private void addFootView() {

        TextView textView = new TextView(getActivity());
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        p.setMargins(0,10,12,12);
        textView.setLayoutParams(p); //设置framelayout宽高（MATCH_PARENT，MATCH_PARENT）
        textView.setGravity(Gravity.RIGHT);
        textView.setTextColor(Color.parseColor("#3087ea"));
        textView.setText("查看更多>>>");
        jkzxTwoRecy.setFootView(textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ManyconsultationsActivity.class);
                intent.putExtra("plateId",2);
                startActivity(intent);
                getActivity().overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
            }
        });
    }

    @Override
    protected int bindlayout() {
        return R.layout.home_jkzx_two;
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

    @Override
    public void showJkzxContent(Object obj) {
        HomeHealthConsultationContent heaithcontent = (HomeHealthConsultationContent) obj;
        if (heaithcontent.getResult().size() != 0) {
            for (int i = 0; i < heaithcontent.getResult().size(); i++) {
                resultBeans.add(heaithcontent.getResult().get(i));
            }
            //设置适配器
            if (resultBeans.size() != 0) {
                recyAdpter = new HomeJkzxRecyAdpter(getActivity(), resultBeans);
                jkzxTwoRecy.setAdapter(recyAdpter);
            }
        } else {
            Toast.makeText(getActivity(), "null", Toast.LENGTH_SHORT).show();
        }
        recyAdpter.notifyDataSetChanged();

    }

}