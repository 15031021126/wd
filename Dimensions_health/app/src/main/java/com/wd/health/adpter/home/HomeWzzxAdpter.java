package com.wd.health.adpter.home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wd.health.R;
import com.wd.health.entity.home.HomeWzzxEntity;
import com.wd.health.holder.home.HomeWzzxTwoHolder;
import com.wd.health.view.actv.ChatActivity;

/*
 *@Auther:陈浩
 *@Date: 2019/8/5
 *@Time:14:07
 *@Description:${DESCRIPTION}
 * */public class HomeWzzxAdpter extends RecyclerView.Adapter<HomeWzzxTwoHolder> {
    private Context context;
    private HomeWzzxEntity wzzxEntity;

    public HomeWzzxAdpter(Context context, HomeWzzxEntity wzzxEntity) {
        this.context = context;
        this.wzzxEntity = wzzxEntity;
    }

    @NonNull
    @Override
    public HomeWzzxTwoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new HomeWzzxTwoHolder(from.inflate(R.layout.home_wzzx_two, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeWzzxTwoHolder homeWzzxTwoHolder, int i) {
        HomeWzzxEntity.ResultBean bean = wzzxEntity.getResult().get(i);
        homeWzzxTwoHolder.wzzxItemTv.setText(bean.getDepartmentName());
        //圆的图
        Glide.with(context).load(bean.getPic()).apply(new RequestOptions().circleCrop()).into(homeWzzxTwoHolder.wzzxItemImg);
        //点击事件
        homeWzzxTwoHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(context, "bean.getId():" + bean.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return wzzxEntity.getResult().size();
    }

}
