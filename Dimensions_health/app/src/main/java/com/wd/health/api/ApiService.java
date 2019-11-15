package com.wd.health.api;

import com.wd.health.entity.home.FavoritesList;
import com.wd.health.entity.home.HomeBanner;
import com.wd.health.entity.home.HomeConsultationdetailsEntity;
import com.wd.health.entity.home.HomeHealthConsultationContent;
import com.wd.health.entity.home.HomeHealthConsultationTitle;
import com.wd.health.entity.home.HomeWzzxEntity;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 *@Auther:陈浩
 *@Date: 2019/8/3
 *@Time:16:54
 *@Description:${首页}
 * */public interface ApiService {
    /**
     * 首页伦比
     *
     * @return
     */
    @GET(Api.HOME_BANNER)
    Observable<HomeBanner> getHomeBanner();

    /**
     * 问诊咨询
     *
     * @return
     */
    @GET(Api.HOME_WZZX_LIST)
    Observable<HomeWzzxEntity> getHomeWzzx();

    /**
     * 获得健康咨询标题
     *
     * @return
     */
    @GET(Api.HOME_Health_Consultation_Title)
    Observable<HomeHealthConsultationTitle> getHomeHealth_Consultation_Title();

    /**
     * 获取健康咨询内荣
     *
     * @param plateId
     * @param page
     * @param count
     * @return
     */
    @GET(Api.HOME_Health_Consultation_Content)
    Observable<HomeHealthConsultationContent> getgetHomeHealth_Consultation_Content(@Query("plateId") String plateId,
                                                                                    @Query("page") String page,
                                                                                    @Query("count") String count);

    /**
     * 查询咨询详情
     *
     * @param infoId
     * @return
     */
    @GET(Api.Home_Consultation_details)
    Observable<HomeConsultationdetailsEntity> getHomeConsultationdetails(@Query("infoId") String infoId);

    /**
     * 收藏
     *
     * @param infoId
     * @return
     */
    @POST(Api.ADDCOLLECTION)
    @FormUrlEncoded
    Observable<ResponseBody> getHomeConsultationCollection(@Field("infoId") String infoId);

    /***
     * 收藏列表
     * @param page
     * @param count
     * @return
     */
    @GET(Api.COLLECTIONLIST)
    Observable<FavoritesList> getHomeConsultationCollectionList(@Query("page") String page, @Query("count") String count);

    /**
     * 取消收藏咨询
     *
     * @param sickCircleId
     * @return
     */
    @DELETE(Api.DELCOLLECTION)
    Observable<ResponseBody> delectCollectionList(@Query("infoId") String sickCircleId);
}
