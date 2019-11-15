package com.wd.health.mvp.user.ill;

import com.wd.health.net.CallBackObj;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class IllPresenterImpl extends IllContract.IllPresenter {
    @Override
    public void show(int page, int count) {
        model.dogetList(page, count, new CallBackObj() {
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
