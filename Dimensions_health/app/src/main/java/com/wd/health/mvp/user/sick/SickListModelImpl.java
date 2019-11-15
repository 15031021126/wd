package com.wd.health.mvp.user.sick;

import com.wd.health.api.SickApi;
import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.user.MySickListEntity;
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
public class SickListModelImpl implements SickListContract.SickModel {
    @Override
    public void dogetShow(int sickCircleId, int page, int count, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(SickApi.class).sickList(sickCircleId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MySickListEntity>() {
                    @Override
                    public void accept(MySickListEntity mySickListEntity) throws Exception {
                        callBackObj.success(mySickListEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void doputOption(int commentId, int sickCirecleId, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(SickApi.class).Adoption(commentId,sickCirecleId)
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

                    }
                });
    }

    @Override
    public void doputOpinion(int commentId, int opinion, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(SickApi.class).Exopinion(commentId,opinion)
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

                    }
                });
    }
}
