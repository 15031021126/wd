package com.wd.health.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.wd.health.view.actv.ChatActivity;

/*
 *@Auther:陈浩
 *@Date: 2019/9/10
 *@Time:19:24
 *@Description:${通知}
 * */public class PushService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //todo 跳转之前要处理的逻辑
        Toast.makeText(context, "diadiaji", Toast.LENGTH_SHORT).show();
        Intent newIntent = new Intent(context, ChatActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);
//
//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        //前提：知道要跳转应用的包名、类名
//        ComponentName componentName = new ComponentName("com.wd.health", "com.wd.health.view.actv.ChatActivity");
//        intent.setComponent(componentName);
//        startActivity(intent);
    }
}
