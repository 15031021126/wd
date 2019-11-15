package com.wd.health.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.lxj.xpopup.core.BottomPopupView;
import com.wd.health.R;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class CarePop extends BottomPopupView {
    private int doctorId;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public CarePop(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.care_pop;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        Button bbbbb = findViewById(R.id.bbbbb);
        Button ccccc = findViewById(R.id.ccccc);
        ccccc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
