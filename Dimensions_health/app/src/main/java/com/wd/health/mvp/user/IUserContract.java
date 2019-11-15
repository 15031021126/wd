package com.wd.health.mvp.user;

import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.wd.health.net.CallBackObj;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface IUserContract {
    interface IUserView extends IBaseView{
        void UserMessage(Object obj);
        void UserWhetherSign(Object obj);
        void UserSign(Object obj);
    }
    interface IUserModel extends IBaseModel{
        void dogetUser(CallBackObj callBackObj);
        void dogetWhetherSign(CallBackObj callBackObj);
        void dopostSign(CallBackObj callBackObj);
    }
    abstract class IUserPresenter extends BasePresenter<IUserModel,IUserView>{
        public abstract void UserMessage();
        public abstract void UserWhetherSign();
        public abstract void UserSign();

        @Override
        public IUserModel getModel() {
            return new IUserModelImpl();
        }
    }

}
