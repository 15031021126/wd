package com.wd.health.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class MyProgress extends View {
    public MyProgress(Context context) {
        this(context,null);
    }

    public MyProgress(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyProgress(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initA();
    }

    private void initA() {

    }
}
