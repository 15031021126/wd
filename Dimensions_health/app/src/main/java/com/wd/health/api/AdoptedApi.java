package com.wd.health.api;

import com.wd.health.entity.user.AdopteEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface AdoptedApi {
    @GET(Api.MYADOPTED)
    Observable<AdopteEntity> adopteList(@Query("page")int page,@Query("count")int count);
}
