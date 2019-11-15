package com.wd.health.api;

import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.user.SignEntity;
import com.wd.health.entity.user.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface UserApi {
    @GET(Api.USERINFOBYID)
    Observable<UserEntity> findUser();
    @GET(Api.WHETHERSIGN)
    Observable<SignEntity> whetherSign();

    @POST(Api.SIGN)
    Observable<MessageEntity> sign();
}
