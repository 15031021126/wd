package com.wd.health.mvp.user.sick;

import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.wd.health.net.CallBackObj;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface SickListContract {
    interface SickView extends IBaseView{
        void showList(Object o);
        void adOption(Object o);
        void exOpinion(Object o);
    }
    interface SickModel extends IBaseModel{
        void dogetShow(int sickCircleId, int page, int count, CallBackObj callBackObj);
        void doputOption(int commentId,int sickCirecleId,CallBackObj callBackObj);
        void doputOpinion(int commentId,int opinion,CallBackObj callBackObj);
    }
    abstract class SickPresenter extends BasePresenter<SickModel,SickView>{
        public abstract void show(int sickCircleId,int page,int count);
        public abstract void putOption(int commentId,int sickCirecleId);
        public abstract void exOpinion(int commentId,int opinion);

        @Override
        public SickModel getModel() {
            return new SickListModelImpl();
        }
    }
}
