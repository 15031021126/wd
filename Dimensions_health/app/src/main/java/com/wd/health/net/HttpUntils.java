package com.wd.health.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.wd.health.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@Auther:陈浩
 *@Date: 2019/6/29
 *@Time:8:52
 *@Description:${网络请求类}
 * */public class HttpUntils {

    private static HttpUntils untils;
    private final Retrofit retrofit;

    private HttpUntils() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MyInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder().baseUrl(Api.BASEURL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static HttpUntils getInstance() {
        if (untils == null) {
            synchronized (HttpUntils.class) {
                if (untils == null) {
                    untils = new HttpUntils();
                }
            }
        }
        return untils;
    }

    public <T> T getcreate(final Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * 判断网络
     * @param context
     * @return
     */
    public boolean isnet(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if(activeNetworkInfo!=null){
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }
}
