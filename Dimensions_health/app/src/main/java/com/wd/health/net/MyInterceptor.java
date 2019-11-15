package com.wd.health.net;

import com.blankj.utilcode.util.SPUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class MyInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        if (SPUtils.getInstance("login").getBoolean("isLogin")) {
            String sessionId = SPUtils.getInstance("user").getString("sessionId");
            int id = SPUtils.getInstance("user").getInt("id");
            Request build = request.newBuilder().addHeader("sessionId", sessionId)
                    .addHeader("userId", id+"").build();
            Response proceed = chain.proceed(build);
            return proceed;
        }else {
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }
}
