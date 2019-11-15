package com.wd.health.mvp.home;

import com.wd.base_core.base.BaseFragment;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.wd.health.net.CallBackObj;

/*
 *@Auther:陈浩
 *@Date: 2019/8/3
 *@Time:16:51
 *@Description:${DESCRIPTION}
 * */public interface IhomeContract {
    interface IhomeView extends IBaseView {
        //轮播数据
        void showBanner(Object obj);

        //问诊咨询
        void showWzzx(Object obj);

        //健康咨询标题
        void showJkzxTitle(Object obj);
        //健康咨询内容

        void showJkzxContent(Object obj);
    }

    interface IhomeModel extends IBaseModel {
        //轮播数据
        void dogetBanner(CallBackObj callBackObj);

        //问诊咨询
        void dogetWzzx(CallBackObj callBackObj);

        //健康咨询标题
        void dogetJkzxTitle(CallBackObj callBackObj);
        //健康咨询内容

        void dogetJkzxContent(String plateId, String page, String count, CallBackObj callBackObj);
    }

    abstract class IhomePresenter extends BasePresenter<IhomeModel, IhomeView> {
        //轮播数据
        public abstract void requestBanner();

        //问诊咨询
        public abstract void requestWzzx();

        //健康咨询标题
        public abstract void requestJkzxTitle();

        //健康咨询内容
        public abstract void requestJkzxContent(String plateId, String page, String count);

        @Override
        public IhomeModel getModel() {
            return new IhomeModelImpl();
        }
    }
}
