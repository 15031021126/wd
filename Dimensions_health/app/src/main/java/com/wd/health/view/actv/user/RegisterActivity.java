package com.wd.health.view.actv.user;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.untils.L;
import com.wd.health.R;
import com.wd.health.entity.MessageEntity;
import com.wd.health.mvp.login.LoginContract;
import com.wd.health.mvp.login.LoginModelImpl;
import com.wd.health.mvp.login.LoginPresenterImpl;
import com.wd.health.rsa.RsaCoder;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<LoginModelImpl, LoginPresenterImpl> implements LoginContract.LoginView {


    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.email_bt)
    TextView emailBt;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.eye)
    ImageView eye;
    @BindView(R.id.password2)
    EditText password2;
    @BindView(R.id.eye2)
    ImageView eye2;
    @BindView(R.id.register)
    TextView register;
    private boolean isEye;
    private boolean isEye2;
    private int time=60;

    @Override
    protected void iniData() {
        setBar(0);

        code.getText().toString().trim();
        password.getText().toString().trim();
        password2.getText().toString().trim();

    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_register;
    }

    @Override
    public BasePresenter initPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    public void sendEmail(Object obj) {
        MessageEntity messageEntity= (MessageEntity) obj;
        Toast.makeText(this, messageEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkCode(Object obj) {
        MessageEntity messageEntity= (MessageEntity) obj;
        ToastUtils.showShort(messageEntity.getMessage());
        try {
        if (messageEntity.getStatus().equals("0000")){
            String s = RsaCoder.encryptByPublicKey(password.getText().toString().trim());
            presenter.register(email.getText().toString().trim(),code.getText().toString().trim(), s,s,"");
        }else {

            return;
        }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void login(Object obj) {

    }

    @Override
    public void register(Object obj) {
        MessageEntity messageEntity= (MessageEntity) obj;
        if (messageEntity.getStatus().equals("0000")){
            ToastUtils.showShort(messageEntity.getMessage());
            finish();
        }else {
            ToastUtils.showShort(messageEntity.getMessage());
        }
    }


    @OnClick({R.id.email_bt, R.id.eye, R.id.eye2, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.email_bt:
                emailBt.setClickable(false);
                presenter.sendEmail(email.getText().toString().trim());
                handler.sendEmptyMessageDelayed( 1,1000);
                break;
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
            case R.id.eye2:
                if (isEye2) {
                    password2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isEye2 = false;
                    eye2.setImageResource(R.mipmap.login_icon_hide_password_n);
                } else if (isEye2 == false) {
                    password2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    isEye2 = true;
                    eye2.setImageResource(R.mipmap.login_icon_show_password);
                }
                break;
            case R.id.register:

                if (password2.getText().toString().trim().equals(password.getText().toString().trim())) {
                    String email1 = email.getText().toString().trim();
                    String code1 = code.getText().toString().trim();
                    presenter.checkCode(email1, code1);
                }else {
                    ToastUtils.showShort("密码不一致");
                }
                break;
        }
    }

  private Handler handler=new Handler(){
      @Override
      public void handleMessage(Message msg) {
          switch (msg.what){
              case 1:
                  emailBt.setText(time+"s后重试");
                  emailBt.setBackgroundColor(Color.GRAY);
                  time--;

                  if (time<1){
                      emailBt.setText("获取验证码");
                      emailBt.setClickable(true);
                      emailBt.setBackgroundColor(R.color.myblue);
                      time=60;
                      return;
                  }
          }
            handler.sendEmptyMessageDelayed(1,1000);
      }
  };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
