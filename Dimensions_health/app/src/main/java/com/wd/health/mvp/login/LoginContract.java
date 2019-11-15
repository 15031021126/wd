package com.wd.health.mvp.login;

import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.mvp.IBaseModel;
import com.wd.base_core.mvp.IBaseView;
import com.wd.health.net.CallBackObj;

import java.util.HashMap;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public interface LoginContract {
    interface LoginView extends IBaseView{
        void sendEmail(Object obj);
        void checkCode(Object obj);
        void login(Object obj);
        void register(Object obj);
    }
    interface LoginModel extends IBaseModel{
        void dopostEmail(String email,CallBackObj callBackObj);
        void dopostCheckCode(String email,String code,CallBackObj callBackObj);
        void dopostLogin(HashMap<String,String> hashMap, CallBackObj callBackObj);
        void dopostRegister(String email,String code,String pwd1,String pwd2,String invitationCode,CallBackObj callBackObj);
        //wechat
        void dopostWechat(String wxCode,CallBackObj callBackObj);
    }
    abstract class  LoginPresenter extends BasePresenter<LoginModel,LoginView>{
        public abstract void sendEmail(String email);
        public abstract void checkCode(String email,String code);
        public abstract void login(HashMap<String,String> hashMap);
        public abstract void register(String email,String code,String pwd1,String pwd2,String invitationCode);
        public abstract void wechat(String wxCode);
        @Override
        public LoginModel getModel() {
            return new LoginModelImpl();
        }
    }
}
