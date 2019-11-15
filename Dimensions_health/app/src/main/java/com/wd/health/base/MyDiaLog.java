package com.wd.health.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:21:20
 *@Description:${DESCRIPTION}
 * */public class MyDiaLog extends AlertDialog{


    protected MyDiaLog(@NonNull Context context) {
        super(context);
    }

    protected MyDiaLog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MyDiaLog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
