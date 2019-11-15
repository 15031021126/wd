package com.wd.health.holder.home.recy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.health.R;


/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:9:23
 *@Description:${DESCRIPTION}
 * */public class HOItemHolder extends RecyclerView.ViewHolder {

    public ImageView jkzxOneImg;

    public TextView jkzxOneTitle;

    public TextView jkzxOneAuther;

    public TextView jkzxOneTime;

    public HOItemHolder(@NonNull View itemView) {
        super(itemView);
        jkzxOneImg = itemView.findViewById(R.id.jkzx_one_img);
        jkzxOneTitle = itemView.findViewById(R.id.jkzx_one_title);
        jkzxOneAuther = itemView.findViewById(R.id.jkzx_one_auther);
        jkzxOneTime = itemView.findViewById(R.id.jkzx_one_time);

    }
}
