package com.wd.health.mvp.user.sick;

import com.wd.health.net.CallBackObj;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class SickListPresenterImpl extends SickListContract.SickPresenter {
    @Override
    public void show(int sickCircleId, int page, int count) {
        model.dogetShow(sickCircleId, page, count, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showList(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void putOption(int commentId, int sickCirecleId) {
        model.doputOption(commentId, sickCirecleId, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.adOption(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    /**
     * 发表观点   支持反对
     * @param commentId
     * @param opinion
     */
    @Override
    public void exOpinion(int commentId, int opinion) {
        model.doputOpinion(commentId, opinion, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.exOpinion(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }
}
