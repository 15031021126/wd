package com.wd.health.mvp.home;

import android.util.Log;

import com.wd.base_core.untils.L;
import com.wd.health.api.ApiService;
import com.wd.health.entity.home.HomeBanner;
import com.wd.health.entity.home.HomeHealthConsultationContent;
import com.wd.health.entity.home.HomeHealthConsultationTitle;
import com.wd.health.entity.home.HomeWzzxEntity;
import com.wd.health.net.CallBackObj;
import com.wd.health.net.HttpUntils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:陈浩
 *@Date: 2019/8/3
 *@Time:16:53
 *@Description:${DESCRIPTION}
 * */public class IhomeModelImpl implements IhomeContract.IhomeModel {
    @Override
    public void dogetBanner(CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(ApiService.class).getHomeBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeBanner>() {
                    @Override
                    public void accept(HomeBanner homeBanner) throws Exception {
                        callBackObj.success(homeBanner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dogetWzzx(CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(ApiService.class).getHomeWzzx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeWzzxEntity>() {
                    @Override
                    public void accept(HomeWzzxEntity homeBanner) throws Exception {
                        callBackObj.success(homeBanner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dogetJkzxTitle(CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(ApiService.class).getHomeHealth_Consultation_Title()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeHealthConsultationTitle>() {
                    @Override
                    public void accept(HomeHealthConsultationTitle homeBanner) throws Exception {
                        callBackObj.success(homeBanner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }

    @Override
    public void dogetJkzxContent(String plateId, String page, String count, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(ApiService.class).getgetHomeHealth_Consultation_Content(plateId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeHealthConsultationContent>() {
                    @Override
                    public void accept(HomeHealthConsultationContent homeBanner) throws Exception {
                        callBackObj.success(homeBanner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        L.d(throwable.toString());
                    }
                });
    }
}
