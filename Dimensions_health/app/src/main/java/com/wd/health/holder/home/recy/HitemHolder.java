package com.wd.health.holder.home.recy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wd.health.R;


/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:9:23
 *@Description:${DESCRIPTION}
 * */public class HitemHolder extends RecyclerView.ViewHolder {


    public TextView jkzxTitle;

    public TextView jkzxAuther;

    public TextView jkzxTime;

    public HitemHolder(@NonNull View itemView) {
        super(itemView);
        jkzxTitle = itemView.findViewById(R.id.jkzx_title);
        jkzxAuther = itemView.findViewById(R.id.jkzx_auther);
        jkzxTime = itemView.findViewById(R.id.jkzx_time);


    }
}
