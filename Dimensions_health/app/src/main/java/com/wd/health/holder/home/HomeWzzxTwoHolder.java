package com.wd.health.holder.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.health.R;


/*
 *@Auther:陈浩
 *@Date: 2019/8/5
 *@Time:14:03
 *@Description:${问诊咨询}
 * */public class HomeWzzxTwoHolder extends RecyclerView.ViewHolder {


    public ImageView wzzxItemImg;

    public TextView wzzxItemTv;

    public HomeWzzxTwoHolder(@NonNull View itemView) {
        super(itemView);
        wzzxItemImg = itemView.findViewById(R.id.wzzx_item_img);
        wzzxItemTv = itemView.findViewById(R.id.wzzx_item_tv);
    }
}
