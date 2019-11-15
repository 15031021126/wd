package com.wd.health.mvp.home;

import com.wd.health.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/8/3
 *@Time:16:59
 *@Description:${DESCRIPTION}
 * */public class IhomePresenterImpl extends IhomeContract.IhomePresenter {

    @Override
    public void requestBanner() {
        model.dogetBanner(new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showBanner(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void requestWzzx() {
        model.dogetWzzx(new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showWzzx(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void requestJkzxTitle() {
        model.dogetJkzxTitle(new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showJkzxTitle(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void requestJkzxContent(String plateId, String page, String count) {
        model.dogetJkzxContent(plateId, page, count, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showJkzxContent(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }
}
