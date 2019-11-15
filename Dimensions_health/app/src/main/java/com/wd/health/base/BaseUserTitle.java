package com.wd.health.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wd.health.R;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class BaseUserTitle extends RelativeLayout {

    public TextView tName;
    public ImageView tBack;

    public BaseUserTitle(Context context) {
        this(context,null);
    }

    public BaseUserTitle(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseUserTitle(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View inflate = LayoutInflater.from(context).inflate(R.layout.base_title2, this, true);
        tBack = inflate.findViewById(R.id.t_back);
        tName = inflate.findViewById(R.id.t_name);
    }
}
