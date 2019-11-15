package com.wd.health.mvp.user.adopte;

import com.wd.health.net.CallBackObj;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class AdoptePresenterImpl extends AdopteContract.AdoptePresenter {
    @Override
    public void aVoid(int page, int count) {
        model.dogetAdopte(page, count, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.showList(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }
}
