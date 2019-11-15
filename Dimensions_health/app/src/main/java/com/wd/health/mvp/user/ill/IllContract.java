package com.wd.health.mvp.user.ill;

import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.wd.health.net.CallBackObj;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface IllContract {
    interface IllView extends IBaseView{
        void showList(Object o);
    }
    interface IllModel extends IBaseModel{
        void dogetList(int page, int count, CallBackObj callBackObj);
    }
    abstract class IllPresenter extends BasePresenter<IllModel,IllView>{
        public abstract void show(int page , int count);

        @Override
        public IllModel getModel() {
            return new IllModelImpl();
        }
    }
}
