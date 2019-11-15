package com.wd.health.view.actv.home;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.TimeUtils;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.untils.L;
import com.wd.health.R;
import com.wd.health.entity.home.FavoritesList;
import com.wd.health.entity.home.HomeConsultationdetailsEntity;
import com.wd.health.mvp.home.advisory.ConsultationModelimpl;
import com.wd.health.mvp.home.advisory.ConsultationPresenterImpl;
import com.wd.health.mvp.home.advisory.IconsultationContract;
import com.wd.health.view.actv.user.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;

public class ConsultationDetailsActivity extends BaseActivity<ConsultationModelimpl, ConsultationPresenterImpl> implements IconsultationContract.IconsultationView {

    @BindView(R.id.details_title)
    TextView detailsTitle;
    @BindView(R.id.details_anther)
    TextView detailsAnther;
    @BindView(R.id.details_time)
    TextView detailsTime;
    @BindView(R.id.details_web)
    WebView detailsWeb;
    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.details_tab)
    TextView detailsTab;
    @BindView(R.id.details_rbbell)
    ImageView detailsRbbell;
    @BindView(R.id.details_reward)
    RadioButton detailsReward;
    @BindView(R.id.details_collection)
    ImageView detailsCollection;
    @BindView(R.id.details_share)
    RadioButton detailsShare;
    @BindView(R.id.details_scroll)
    NestedScrollView detailsScroll;
    private int time = 0;
    private int id;


    @Override
    protected void iniData() {
        setBar();
        id = getIntent().getIntExtra("id", 1);
        L.e("123",id+"");
        //默认设置收藏状态
        presenter.requestFavoritesList("1", "100");
        //计时
        handler.sendEmptyMessageDelayed(0, 1000);
        int plateId = getIntent().getIntExtra("plateId", 0);
        switch (plateId) {
            case 1:
                detailsTab.setText("健康养生");
                break;
            case 2:
                detailsTab.setText("健康减肥");
                break;
            case 3:
                detailsTab.setText("健康美食");
                break;
            case 4:
                detailsTab.setText("健康美容");
                break;
            case 5:
                detailsTab.setText("慢性疾病");
                break;
        }
        //请去咨询整个详情
        presenter.requestConsultation(id + "");
        //点击返回
        detailsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
            }
        });
        //点击事件消失
        detailsWeb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detailsReward.setVisibility(View.GONE);
                return true;
            }
        });

        //收藏
        detailsCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestFavoritesList("1", "100");
                presenter.requestCollection(id + "");
            }
        });

    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_consultation_details;
    }

    @Override
    public BasePresenter initPresenter() {
        return new ConsultationPresenterImpl();
    }

    /**
     * 展示详情数据
     *
     * @param obj
     */
    @Override
    public void showConsultation(Object obj) {
        HomeConsultationdetailsEntity consultationdetails = (HomeConsultationdetailsEntity) obj;
        HomeConsultationdetailsEntity.ResultBean result = consultationdetails.getResult();
        detailsTitle.setText(result.getTitle());
        detailsAnther.setText(result.getSource());
        detailsTime.setText(TimeUtils.millis2String(result.getReleaseTime()) + "");
        detailsWeb.loadDataWithBaseURL(null, result.getContent(), "text/html", "utf-8", null);

        WebSettings settings = detailsWeb.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        detailsWeb.getSettings().setJavaScriptEnabled(true);
        detailsWeb.loadDataWithBaseURL("", result.getContent(), "text/html", "UTF-8", "");
    }

    /**
     * 收藏
     *
     * @param obj
     */
    @Override
    public void showCollection(Object obj) {
        try {
            JSONObject object = new JSONObject(obj.toString());
            String message = object.getString("message");
            if(message.equals("请先登陆")){
                sA(LoginActivity.class);
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                return;
            }
            if (message.equals("资讯收藏成功")) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                detailsCollection.setImageResource(R.mipmap.common_button_collection_large_s);
            } else {
                presenter.requestDelectCollection(id + "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消收藏
     *
     * @param obj
     */
    @Override
    public void showDelectCollection(Object obj) {
        try {
            JSONObject object = new JSONObject(obj.toString());
            String message = object.getString("message");
            if(message.equals("请先登陆")){
                sA(LoginActivity.class);
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                return;
            }
            if (message.equals("取消成功")) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                detailsCollection.setImageResource(R.mipmap.common_button_collection_large_n);
            } else {
                presenter.requestCollection(id + "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 收藏列表
     *
     * @param obj
     */
    @Override
    public void showFavoritesList(Object obj) {
        FavoritesList list = (FavoritesList) obj;
        if(list==null){
            presenter.requestFavoritesList("1", "100");
        }else{
            for (int i = 0; i < list.getResult().size(); i++) {
                int infoId = list.getResult().get(i).getInfoId();
                if (infoId == id) {
                    L.e("123",infoId+"");
                    //有的收藏
                    //   presenter.requestCollection(id + "");
                    detailsCollection.setImageResource(R.mipmap.common_button_collection_large_s);
                    return;
                } else if (infoId != id) {
                    //取消
                    // presenter.requestDelectCollection(id + "");
                    detailsCollection.setImageResource(R.mipmap.common_button_collection_large_n);
                }
            }
        }

    }


    /***
     * 按返回键动画
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    time++;
                    if (time == 10) {
                        time = 0;
                        detailsReward.setVisibility(View.VISIBLE);
                        handler.removeMessages(0);
                        return;
                    } else {
                        handler.sendEmptyMessageDelayed(0, 1000);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        time = 0;
        handler.removeMessages(0);
        handler = null;
    }


}
