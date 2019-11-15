package com.wd.health.mvp.user;

import com.wd.base_core.untils.L;
import com.wd.health.api.UserApi;
import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.user.SignEntity;
import com.wd.health.entity.user.UserEntity;
import com.wd.health.net.CallBackObj;
import com.wd.health.net.HttpUntils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class IUserModelImpl implements IUserContract.IUserModel {
    @Override
    public void dogetUser(CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(UserApi.class)
                .findUser().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserEntity>() {
                    @Override
                    public void accept(UserEntity userEntity) throws Exception {
                        callBackObj.success(userEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dogetWhetherSign(CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(UserApi.class).whetherSign()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SignEntity>() {
                    @Override
                    public void accept(SignEntity signEntity) throws Exception {
                        callBackObj.success(signEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dopostSign(CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(UserApi.class).sign()
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
}
