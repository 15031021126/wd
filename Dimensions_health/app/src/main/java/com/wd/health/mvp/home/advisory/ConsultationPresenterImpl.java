package com.wd.health.mvp.home.advisory;

import com.wd.health.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:17:38
 *@Description:${DESCRIPTION}
 * */public class ConsultationPresenterImpl extends IconsultationContract.IconsultationPresenter {
    @Override
    public void requestConsultation(String infoId) {
        model.doGetConsultation(infoId, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showConsultation(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    /**
     * 收藏
     *
     * @param infoId
     */
    @Override
    public void requestCollection(String infoId) {
        model.doGetshowCollection(infoId, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showCollection(obj);
            }

            @Override
            public void err(String msg) {
                view.showCollection(msg);
            }
        });
    }

    @Override
    public void requestDelectCollection(String sickCircleId) {
        model.doGetDelectCollection(sickCircleId, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showDelectCollection(obj);
            }

            @Override
            public void err(String msg) {
                view.showDelectCollection(msg);
            }
        });
    }

    /**
     * 列表
     * @param page
     * @param count
     */
    @Override
    public void requestFavoritesList(String page, String count) {
        model.doGetFavoritesList(page,count, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showFavoritesList(obj);
            }

            @Override
            public void err(String msg) {
                view.showFavoritesList(msg);
            }
        });
    }
}
