package com.wd.health.api;

import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.login.Login;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface LoginApi {
    /*发送邮箱*/
    @POST(Api.EMAIL)
    @FormUrlEncoded
    Observable<MessageEntity> email(@Field("email") String email);

    /*邮箱验证*/
    @POST(Api.CHECKCODE)
    @FormUrlEncoded
    Observable<MessageEntity> checkCode(@Field("email")String email,@Field("code")String code);

    /*注册*/
    @POST(Api.REGISTER)
    @FormUrlEncoded
    Observable<MessageEntity> register(@Field("email")String email,@Field("code")String code,@Field("pwd1")String pwd1,@Field("pwd2")String pwd2,@Field("invitationCode")String invitationCode);

    /*登录*/
    @POST(Api.LOGIN)
    @FormUrlEncoded
    Observable<Login> login(@FieldMap HashMap<String,String> hashMap);

    @POST(Api.WECHAT)
    @FormUrlEncoded
    Observable<Login> wechat(@Field("wxCode")String wxCode);
}
