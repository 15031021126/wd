package com.wd.health;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.wd.health.service.Myservice;

import cn.jpush.im.android.api.JMessageClient;

/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:8:22
 *@Description:${DESCRIPTION}
 * */public class App extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);//初始化
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //frsco
        ImagePipelineConfig pipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(Environment.getDownloadCacheDirectory())//设置外部SD卡缓存目录文件
                        .setBaseDirectoryName("wdhealth/")//设置缓存名称
                        .setMaxCacheSize(10 * 1024 * 1024)//设置缓存大小
                        .build())
                .build();
        //初始化
        Fresco.initialize(this, pipelineConfig);
        if (BuildConfig.DEBUG) {
            JMessageClient.setDebugMode(true);
        }
        //允许漫游
        JMessageClient.init(this, true);
    }
}
