package com.wd.health.view.actv.user.sick;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.untils.L;
import com.wd.health.R;
import com.wd.health.adpter.user.MySickListAdapter;
import com.wd.health.adpter.user.MySickListAdapter2;
import com.wd.health.base.BaseUserTitle;
import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.user.MySickListEntity;
import com.wd.health.mvp.user.sick.SickListContract;
import com.wd.health.mvp.user.sick.SickListModelImpl;
import com.wd.health.mvp.user.sick.SickListPresenterImpl;
import com.wd.health.untils.NoDoubleClickListener;

import java.util.ArrayList;

import butterknife.BindView;

public class PingActivity extends BaseActivity<SickListModelImpl, SickListPresenterImpl> implements SickListContract.SickView {
    @BindView(R.id.user_title)
    BaseUserTitle userTitle;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    public TextView ping;
    public TextView time;
    public RecyclerView rec;
    public ImageView pic;
    public TextView name;
    public ImageView agree;
    public TextView agreeNum;
    public ImageView disagree;
    public TextView disAgreeNum;
    private int page = 1;
    private int count = 5;
    private ArrayList<MySickListEntity.ResultBean.OtherSickCircleCommentListBean> arrayList = new ArrayList<>();
    private LinearLayout linnn;
    private MySickListAdapter2 mySickListAdapter2;
    private MySickListAdapter mySickListAdapter;
    private int sickCircleId;

    @Override
    protected void iniData() {
        name = findViewById(R.id.ping_name);
        pic = findViewById(R.id.ping_pic);
        rec = findViewById(R.id.ping_out_rec);
        time = findViewById(R.id.ping_time);
        ping = findViewById(R.id.ping);
        agree = findViewById(R.id.agree);
        agreeNum = findViewById(R.id.agree_num);
        disagree = findViewById(R.id.disagree);
        disAgreeNum = findViewById(R.id.disagree_num);
        linnn = findViewById(R.id.linnn);

        userTitle.tBack.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                finish();
            }
        });
        userTitle.tName.setText("我的评论列表");
        Intent intent = getIntent();
        sickCircleId = intent.getIntExtra("sickCircleId", 0);
        presenter.show(sickCircleId, page, count);



        rec.setNestedScrollingEnabled(false);
        rec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        refreshLayout.setEnableLoadMore(true);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                presenter.show(sickCircleId,page,count);
                refreshLayout.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                arrayList.clear();
                presenter.show(sickCircleId,page,count);
                refreshLayout.finishRefresh();
            }
        });

    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_ping;
    }

    @Override
    public BasePresenter initPresenter() {
        return new SickListPresenterImpl();
    }

    /**
     * 查找
     * @param o
     */
    @Override
    public void showList(Object o) {
        MySickListEntity mySickListEntity = (MySickListEntity) o;
        if (mySickListEntity.getStatus().equals("0000")) {
            if (mySickListEntity.getResult().getOtherSickCircleCommentList().size()!=0) {
                MySickListEntity.ResultBean.AdoptionSickCircleCommentBean agreeBean = mySickListEntity.getResult().getAdoptionSickCircleComment();
                //================点赞===================
                if (agreeBean != null) {
                    linnn.setVisibility(View.VISIBLE);
                    agreeBean = mySickListEntity.getResult().getAdoptionSickCircleComment();
                    int opinion = agreeBean.getOpinion();
                    if (opinion==1){
                        agreeBean.setAaa(true);
                        agreeBean.setAaa2(false);
                    }else if (opinion==2){
                        agreeBean.setAaa2(true);
                        agreeBean.setAaa(false);
                    }else if (opinion==0){
                        agreeBean.setAaa(false);
                        agreeBean.setAaa2(false);
                    }

                    if (agreeBean.isAaa()){
                        agree.setImageResource(R.mipmap.common_icon_agree_s);
                    }else {
                        agree.setImageResource(R.mipmap.common_icon_agree_n);
                    }
                    if (agreeBean.isAaa2()){
                        disagree.setImageResource(R.mipmap.common_icon_disagree_s);
                    }else {
                        disagree.setImageResource(R.mipmap.common_icon_disagree_n);
                    }
                    //===============基本信息====================
                    name.setText(agreeBean.getNickName());
                    Glide.with(this).load(agreeBean.getHeadPic()).into(pic);
                    ping.setText(agreeBean.getContent());
                    agreeNum.setText(agreeBean.getSupportNum() + "");
                    disAgreeNum.setText(agreeBean.getOpposeNum() + "");
                    long commentTime = agreeBean.getCommentTime();
                    String string = TimeUtils.millis2String(commentTime, "yyyy/MM/dd");
                    time.setText(string);
                    mySickListAdapter = new MySickListAdapter(this, arrayList);
                    rec.setAdapter(mySickListAdapter);

                    //================adapter点击====================
                    mySickListAdapter.setCallinBackSick2(new MySickListAdapter.CallinBackSick2() {
                        @Override
                        public void getCommitId(int commentId, int opinion,int i) {
                            Log.e("888", "getCommitId: "+commentId+"-"+opinion );
                            presenter.exOpinion(commentId,opinion);
                        }
                    });
                } else {
                    //==================没有 采纳==============================
                    linnn.setVisibility(View.GONE);
                    mySickListAdapter2 = new MySickListAdapter2(this, arrayList);
                    rec.setAdapter(mySickListAdapter2);
                    mySickListAdapter2.setCallinBackSick(new MySickListAdapter2.CallinBackSick() {
                        @Override
                        public void getId(int commentId) {
                            presenter.putOption(commentId, sickCircleId);
                        }
                    });
                    mySickListAdapter2.setCallinBackSick2(new MySickListAdapter2.CallinBackSick2() {
                        @Override
                        public void getCommitId(int commentId, int opinion,int i) {
                            Log.e("888", "getCommitId: "+commentId+"-"+opinion );
                            presenter.exOpinion(commentId,opinion);
                        }
                    });
                }

                //============================数据===========================
                for (int i = 0; i < mySickListEntity.getResult().getOtherSickCircleCommentList().size(); i++) {
                    if (!arrayList.contains(mySickListEntity.getResult().getOtherSickCircleCommentList().get(i))) {
                        arrayList.add(mySickListEntity.getResult().getOtherSickCircleCommentList().get(i));
                    } else {
                        L.e("TTT", "已有");
                    }
                }
            }else {
                ToastUtils.showShort("没有评论!!!");
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        } else {
            ToastUtils.showShort(mySickListEntity.getMessage());
        }
    }

    /**
     * 优秀评论
     * @param o
     */
    @Override
    public void adOption(Object o) {
        MessageEntity messageEntity= (MessageEntity) o;
        ToastUtils.showShort(messageEntity.getMessage());
        if (messageEntity.getStatus().equals("0000")){
            arrayList.clear();
            presenter.show(sickCircleId,page,count);
        }
    }

    /**
     * 观点
     * @param o
     */
    @Override
    public void exOpinion(Object o) {
        MessageEntity messageEntity= (MessageEntity) o;
            ToastUtils.showShort(messageEntity.getMessage());
            if (messageEntity.getStatus().equals("0000")){
                    mySickListAdapter.notifyDataSetChanged();
                    mySickListAdapter2.notifyDataSetChanged();
            }else {
                ToastUtils.showShort(messageEntity.getMessage());
            }
    }
}
