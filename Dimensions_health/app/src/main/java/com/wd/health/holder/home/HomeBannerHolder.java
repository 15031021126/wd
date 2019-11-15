package com.wd.health.holder.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.stx.xhb.xbanner.XBanner;
import com.wd.health.R;

import butterknife.BindView;

/*
 *@Auther:陈浩
 *@Date: 2019/8/3
 *@Time:17:28
 *@Description:${首页轮播}
 * */public class HomeBannerHolder extends RecyclerView.ViewHolder {


    public XBanner banner;

    public HomeBannerHolder(@NonNull View itemView) {
        super(itemView);
        banner = itemView.findViewById(R.id.home_banner);
    }
}
