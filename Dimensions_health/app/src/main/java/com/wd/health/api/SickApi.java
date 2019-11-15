package com.wd.health.api;

import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.circle.CircleListsBean;
import com.wd.health.entity.user.MySickListEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface SickApi {
    @GET(Api.SickCircleList)
    Observable<CircleListsBean> showList(@Query("page") int page, @Query("count") int count);

    @GET(Api.MySickCircle)
    Observable<MySickListEntity> sickList(@Query("sickCircleId") int sickCircleId, @Query("page") int page, @Query("count") int count);

    @PUT(Api.Adoption)
    Observable<MessageEntity> Adoption(@Query("commentId")int commentId,@Query("sickCircleId")int sickCircleId);

    @PUT(Api.Express)
    Observable<MessageEntity> Exopinion(@Query("commentId")int commentId,@Query("opinion")int opinion);

}
