package com.wd.health.mvp.user.adopte;

import com.wd.health.api.AdoptedApi;
import com.wd.health.entity.user.AdopteEntity;
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
public class AdopteModelImpl implements AdopteContract.AdopteModel {
    @Override
    public void dogetAdopte(int page, int count, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(AdoptedApi.class).adopteList(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AdopteEntity>() {
                    @Override
                    public void accept(AdopteEntity adopteEntity) throws Exception {
                        callBackObj.success(adopteEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
