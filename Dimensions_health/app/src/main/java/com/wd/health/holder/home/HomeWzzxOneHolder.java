package com.wd.health.holder.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wd.health.R;


/*
 *@Auther:陈浩
 *@Date: 2019/8/5
 *@Time:14:03
 *@Description:${DESCRIPTION}
 * */public class HomeWzzxOneHolder extends RecyclerView.ViewHolder {

    public RecyclerView wzzxRecy;

    public HomeWzzxOneHolder(@NonNull View itemView) {
        super(itemView);
        wzzxRecy = itemView.findViewById(R.id.wzzx_recy);
    }
}
