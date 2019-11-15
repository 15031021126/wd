package com.wd.health.mvp.login;

import com.wd.base_core.untils.L;
import com.wd.health.api.LoginApi;
import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.login.Login;
import com.wd.health.net.CallBackObj;
import com.wd.health.net.HttpUntils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class LoginModelImpl implements LoginContract.LoginModel {
    @Override
    public void dopostEmail(String email, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(LoginApi.class).email(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MessageEntity>() {
                    @Override
                    public void accept(MessageEntity messageEntity) throws Exception {
                        callBackObj.success(messageEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dopostCheckCode(String email, String code, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(LoginApi.class).checkCode(email,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MessageEntity>() {
                    @Override
                    public void accept(MessageEntity messageEntity) throws Exception {
                        callBackObj.success(messageEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dopostLogin(HashMap<String,String> hashMap, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(LoginApi.class).login(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login>() {
                    @Override
                    public void accept(Login login) throws Exception {
                        callBackObj.success(login);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dopostRegister(String email, String code, String pwd1, String pwd2, String invitationCode, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(LoginApi.class).register(email,code,pwd1,pwd2,invitationCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MessageEntity>() {
                    @Override
                    public void accept(MessageEntity messageEntity) throws Exception {
                        callBackObj.success(messageEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dopostWechat(String wxCode, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(LoginApi.class).wechat(wxCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login>() {
                    @Override
                    public void accept(Login login) throws Exception {
                        callBackObj.success(login);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
