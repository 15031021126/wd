package com.wd.health.view.actv.user;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.entity.login.Login;
import com.wd.health.mvp.login.LoginContract;
import com.wd.health.mvp.login.LoginModelImpl;
import com.wd.health.mvp.login.LoginPresenterImpl;
import com.wd.health.rsa.RsaCoder;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginModelImpl, LoginPresenterImpl> implements LoginContract.LoginView {


    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.eye)
    ImageView eye;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.reset_password)
    TextView resetPassword;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.weixin)
    ImageView weixin;
    private boolean isEye;
    private HashMap<String, String> hashMap;

    @Override
    protected void iniData() {
        setBar(0);
        try {
            if (SPUtils.getInstance("login") != null) {
                String e = SPUtils.getInstance("login").getString("email");
                String p = SPUtils.getInstance("login").getString("pwd");
                email.setText(e);
                password.setText(RsaCoder.decryptByPublicKey(p));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_login;
    }

    @Override
    public BasePresenter initPresenter() {
        return new LoginPresenterImpl();
    }

    @OnClick({R.id.eye, R.id.login, R.id.reset_password, R.id.register, R.id.weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.eye:
                if (isEye) {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isEye = false;
                    eye.setImageResource(R.mipmap.login_icon_hide_password_n);
                } else if (isEye == false) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    isEye = true;
                    eye.setImageResource(R.mipmap.login_icon_show_password);
                }
                break;
            case R.id.login:
                try {
                    String em = email.getText().toString().trim();
                    String pass = password.getText().toString().trim();
                    hashMap = new HashMap<>();
                    hashMap.put("email", em);
                    hashMap.put("pwd", RsaCoder.encryptByPublicKey(pass));
                    presenter.login(hashMap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.reset_password:
                break;
            case R.id.register:
                sA(RegisterActivity.class);
                break;
            case R.id.weixin:
                break;
        }
    }

    @Override
    public void sendEmail(Object obj) {

    }

    @Override
    public void checkCode(Object obj) {

    }

    @Override
    public void login(Object obj) {
        Login login = (Login) obj;
        if (login.getStatus().equals("0000")) {
            ToastUtils.showShort(login.getMessage());
            SPUtils.getInstance("login").put("email", hashMap.get("email"));
            SPUtils.getInstance("login").put("pwd", hashMap.get("pwd"));
            SPUtils.getInstance("login").put("isLogin", true);
            SPUtils.getInstance("user").put("age",login.getResult().getAge());
            SPUtils.getInstance("user").put("headPic",login.getResult().getHeadPic());
            SPUtils.getInstance("user").put("height",login.getResult().getHeight());
            SPUtils.getInstance("user").put("id",login.getResult().getId());
            SPUtils.getInstance("user").put("jiGuangPwd",login.getResult().getJiGuangPwd());
            SPUtils.getInstance("user").put("nickName",login.getResult().getNickName());
            SPUtils.getInstance("user").put("sessionId",login.getResult().getSessionId());
            SPUtils.getInstance("user").put("sex",login.getResult().getSex());
            SPUtils.getInstance("user").put("userName",login.getResult().getUserName());
            SPUtils.getInstance("user").put("weight",login.getResult().getWeight());
            SPUtils.getInstance("user").put("whetherBingWeChat",login.getResult().getWhetherBingWeChat());
            SPUtils.getInstance("user").put("invitationCode",login.getResult().getInvitationCode());
            finish();
        } else {
            ToastUtils.showShort(login.getMessage());
            SPUtils.getInstance("login").put("pwd", hashMap.get(""));
            SPUtils.getInstance("login").put("isLogin", false);
            SPUtils.getInstance("user").clear();
        }
    }

    @Override
    public void register(Object obj) {

    }
}
