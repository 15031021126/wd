package com.wd.health.mvp.home.advisory;

import com.wd.base_core.untils.L;
import com.wd.health.api.ApiService;
import com.wd.health.entity.home.FavoritesList;
import com.wd.health.entity.home.HomeConsultationdetailsEntity;
import com.wd.health.net.CallBackObj;
import com.wd.health.net.HttpUntils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:17:36
 *@Description:${DESCRIPTION}
 * */public class ConsultationModelimpl implements IconsultationContract.IconsultationModel {
    @Override
    public void doGetConsultation(String infoId, CallBackObj callBackObj) {
        HttpUntils.getInstance().getcreate(ApiService.class).getHomeConsultationdetails(infoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HomeConsultationdetailsEntity>() {
            @Override
            public void accept(HomeConsultationdetailsEntity homeConsultationdetailsEntity) throws Exception {
                callBackObj.success(homeConsultationdetailsEntity);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                L.d(throwable.toString());
            }
        });
    }

    @Override
    public void doGetshowCollection(String infoId, CallBackObj callBackObj) {

        HttpUntils.getInstance().getcreate(ApiService.class).getHomeConsultationCollection(infoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                callBackObj.success(responseBody.string());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                L.d(throwable.toString());
            }
        })
        ;
    }

    /**
     * 取消收藏
     * @param infoId
     * @param callBackObj
     */
    @Override
    public void doGetDelectCollection(String infoId, CallBackObj callBackObj) {

        HttpUntils.getInstance().getcreate(ApiService.class).delectCollectionList(infoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                callBackObj.success(responseBody.string());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                L.d(throwable.toString());
            }
        })
        ;
    }

    /**
     * 收藏列表
     * @param page
     * @param count
     * @param callBackObj
     */
    @Override
    public void doGetFavoritesList(String page, String count, CallBackObj callBackObj) {

        HttpUntils.getInstance().getcreate(ApiService.class).getHomeConsultationCollectionList(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<FavoritesList>() {
            @Override
            public void accept(FavoritesList favoritesList) throws Exception {
                callBackObj.success(favoritesList);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                L.d(throwable.toString());
            }
        })
        ;
    }
}
