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
 * */public class HTitemHolder extends RecyclerView.ViewHolder {


    public TextView jkzxThreeTitle;

    public ImageView jkzxThreeImgOne;

    public ImageView jkzxThreeImgTwo;

    public ImageView jkzxThreeImgThree;

    public TextView jkzxThreeAuther;

    public TextView jkzxThreeTime;

    public HTitemHolder(@NonNull View itemView) {
        super(itemView);
        jkzxThreeTitle = itemView.findViewById(R.id.jkzx_three_title);
        jkzxThreeImgOne = itemView.findViewById(R.id.jkzx_three_img_one);
        jkzxThreeImgTwo = itemView.findViewById(R.id.jkzx_three_img_two);
        jkzxThreeImgThree = itemView.findViewById(R.id.jkzx_three_img_three);
        jkzxThreeAuther = itemView.findViewById(R.id.jkzx_three_auther);
        jkzxThreeTime = itemView.findViewById(R.id.jkzx_three_time);


    }
}
