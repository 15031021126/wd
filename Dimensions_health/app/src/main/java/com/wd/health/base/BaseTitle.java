package com.wd.health.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.health.view.actv.user.UserActivity;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class BaseTitle extends LinearLayout {

    public TextView titleTxt;
    public ImageView titleMessage;
    public SimpleDraweeView titleHead;

    public BaseTitle(Context context) {
        this(context,null);
    }

    public BaseTitle(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View inflate = LayoutInflater.from(context).inflate(R.layout.base_title, this, true);
        titleHead = inflate.findViewById(R.id.title_head);
        titleMessage = inflate.findViewById(R.id.title_message);
        titleTxt = inflate.findViewById(R.id.title_txt);
        //如果登录则加载信息
        if (SPUtils.getInstance("login").getBoolean("isLogin")) {
            String head = SPUtils.getInstance("user").getString("headPic");
            Uri parse = Uri.parse(head);
            titleHead.setImageURI(parse);
        }

        titleMessage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "aa", Toast.LENGTH_SHORT).show();
            }
        });
        titleHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,UserActivity.class));
            }
        });
        titleTxt.setText("药品名称\\医生名称\\病名");
        titleTxt.setPadding(18,0,0,0);
        titleTxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("搜索栏");
            }
        });
    }

}
