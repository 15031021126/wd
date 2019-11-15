package com.wd.health.mvp.user.adopte;

import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.wd.health.net.CallBackObj;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface AdopteContract {
    interface AdopteView extends IBaseView{
        void showList(Object o);
    }
    interface AdopteModel extends IBaseModel{
        void dogetAdopte(int page, int count, CallBackObj callBackObj);
    }
    abstract class AdoptePresenter extends BasePresenter<AdopteModel,AdopteView>{
        public abstract void aVoid(int page,int count);
        @Override
        public AdopteModel getModel() {
            return new AdopteModelImpl();
        }
    }
}
