package com.wd.health.view.actv.user;

import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.health.R;
import com.wd.health.entity.MessageEntity;
import com.wd.health.entity.user.SignEntity;
import com.wd.health.entity.user.UserEntity;
import com.wd.health.mvp.user.IUserContract;
import com.wd.health.mvp.user.IUserModelImpl;
import com.wd.health.mvp.user.IUserPresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class UserActivity extends BaseActivity<IUserModelImpl, IUserPresenterImpl> implements IUserContract.IUserView {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_message)
    ImageView titleMessage;
    @BindView(R.id.header)
    SimpleDraweeView header;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.sign)
    TextView sign;
    @BindView(R.id.card_l1)
    LinearLayout cardL1;
    @BindView(R.id.card_l2)
    LinearLayout cardL2;


    @Override
    protected void onResume() {
        super.onResume();

        //根据id请求信息
        presenter.UserMessage();
        //判断签到状态
        presenter.UserWhetherSign();
    }

    @Override
    protected void iniData() {
        setBar(0);
    }

    @Override
    protected int bindlayout() {
        return R.layout.activity_user;
    }

    @Override
    public BasePresenter initPresenter() {
        return new IUserPresenterImpl();
    }

    @OnClick({R.id.title_back, R.id.title_message, R.id.header, R.id.name, R.id.sign, R.id.card_l1, R.id.card_l2, R.id.l1, R.id.l2, R.id.l3, R.id.l4, R.id.l5, R.id.l6, R.id.l7, R.id.l8, R.id.l9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.title_message:
                break;
            case R.id.header:
                isLogin();
                break;
            case R.id.name:
                isLogin();
                break;
            //签到
            case R.id.sign:
                isLogin();
                presenter.UserSign();
                break;
            //当前问诊
            case R.id.card_l1:
                isLogin();
                break;
            //历史问诊
            case R.id.card_l2:
                isLogin();
                break;
            //我的档案
            case R.id.l1:
                isLogin();
                break;
            //我的钱包
            case R.id.l2:
                isLogin();
                break;
            //我的收藏
            case R.id.l3:
                isLogin();
                break;
            //被采纳建议
            case R.id.l4:
                isLogin();
                break;
            //我的视频
            case R.id.l5:
                isLogin();
                break;
            //我的病友圈
            case R.id.l6:
                isLogin();
                break;
            //我的关注
            case R.id.l7:
                isLogin();
                break;
            //任务系统
            case R.id.l8:
                isLogin();
                break;
            //设置管理
            case R.id.l9:
                break;
        }
    }

    /*
    * 登录状态
    * */
    public void isLogin() {
        if (!SPUtils.getInstance("login").getBoolean("isLogin")) {
            sA(LoginActivity.class);
        } else {
            return;
        }
    }

    /*
    * 解析数据 设置头像,名称
    * */
    @Override
    public void UserMessage(Object obj) {
        UserEntity userEntity = (UserEntity) obj;
        Uri pic = Uri.parse(userEntity.getResult().getHeadPic());
        header.setImageURI(pic);
        name.setText(userEntity.getResult().getNickName());
    }

    /*
    * 判断签到状态
    * */
    @Override
    public void UserWhetherSign(Object obj) {
        SignEntity signEntity = (SignEntity) obj;
        if (signEntity.getStatus().equals("0000")) {
            if (signEntity.getResult() == 1) {
                sign.setText("已签到");
                sign.setBackgroundColor(Color.GRAY);
                sign.setTextColor(Color.WHITE);
                sign.setClickable(false);
            } else {
                sign.setText("签到");
                sign.setBackgroundColor(Color.WHITE);
                sign.setClickable(true);
            }
        } else {
            ToastUtils.showShort("签到信息获取失败!");
        }
    }

    /*
    * 签到
    * */
    @Override
    public void UserSign(Object obj) {
        MessageEntity messageEntity = (MessageEntity) obj;
        Log.e("sign", "UserSign: "+messageEntity.toString() );
        presenter.UserWhetherSign();
    }
}
