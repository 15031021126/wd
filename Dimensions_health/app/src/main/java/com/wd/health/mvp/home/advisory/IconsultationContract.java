package com.wd.health.mvp.home.advisory;

import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.wd.health.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:17:08
 *@Description:${咨询详情}
 * */public interface IconsultationContract {
    interface IconsultationView extends IBaseView {
        //显示咨询
        void showConsultation(Object obj);

        //收藏
        void showCollection(Object obj);

        //取消收藏
        void showDelectCollection(Object obj);

        //收藏列表
        void showFavoritesList(Object obj);
    }

    interface IconsultationModel extends IBaseModel {
        void doGetConsultation(String infoId, CallBackObj callBackObj);

        void doGetshowCollection(String infoId, CallBackObj callBackObj);

        void doGetDelectCollection(String infoId, CallBackObj callBackObj);
        //收藏列表
        void doGetFavoritesList(String page, String count, CallBackObj callBackObj);
    }

    abstract class IconsultationPresenter extends BasePresenter<IconsultationModel, IconsultationView> {
        public abstract void requestConsultation(String infoId);

        public abstract void requestCollection(String infoId);

        //取消收藏
        public abstract void requestDelectCollection(String sickCircleId);
        //收藏列表
        public abstract void requestFavoritesList(String page, String count);

        @Override
        public IconsultationModel getModel() {
            return new ConsultationModelimpl();
        }
    }
}
