package com.wd.health.mvp.login;

import com.wd.health.net.CallBackObj;

import java.util.HashMap;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class LoginPresenterImpl extends LoginContract.LoginPresenter {
    @Override
    public void sendEmail(String email) {
        model.dopostEmail(email, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.sendEmail(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void checkCode(String email, String code) {
        model.dopostCheckCode(email, code, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.checkCode(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void login(HashMap<String,String> hashMap) {
        model.dopostLogin(hashMap, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.login(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void register(String email, String code, String pwd1, String pwd2, String invitationCode) {
        model.dopostRegister(email, code, pwd1, pwd2, invitationCode, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.register(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }

    @Override
    public void wechat(String wxCode) {
        model.dopostWechat(wxCode, new CallBackObj() {
            @Override
            public void success(Object obj) {
                view.login(obj);
            }

            @Override
            public void err(String msg) {

            }
        });
    }
}
