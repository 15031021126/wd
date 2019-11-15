package com.wd.health.mvp.user.ill;

import com.wd.health.api.SickApi;
import com.wd.health.entity.circle.CircleListsBean;
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
public class IllModelImpl implements IllContract.IllModel {
    @Override
    public void dogetList(int page, int count, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(SickApi.class).showList(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CircleListsBean>() {
                    @Override
                    public void accept(CircleListsBean circleListsBean) throws Exception {
                        callBackObj.success(circleListsBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
