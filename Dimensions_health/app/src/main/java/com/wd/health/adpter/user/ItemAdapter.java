package com.wd.health.adpter.user;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.wd.health.R;
import com.wd.health.entity.circle.CircleListsBean;
import com.wd.health.untils.NoDoubleClickListener;
import com.wd.health.view.actv.user.sick.PingActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder>{
    private Context context;
    private ArrayList<CircleListsBean.ResultBean> resultBeans;

    public ItemAdapter(Context context, ArrayList<CircleListsBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new ItemHolder(from.inflate(R.layout.ill_item_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        itemHolder.context.setText(resultBeans.get(i).getDetail());
        itemHolder.title.setText(resultBeans.get(i).getTitle());
        String date = TimeUtils.millis2String(resultBeans.get(i).getReleaseTime(),"M");
        String d = TimeUtils.millis2String(resultBeans.get(i).getReleaseTime(), "dd");
        itemHolder.days.setText(d+"");
        itemHolder.month.setText(date+"月");

        itemHolder.go.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent = new Intent(context, PingActivity.class);
                intent.putExtra("sickCircleId",resultBeans.get(i).getSickCircleId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (resultBeans.size()!=0) {
            return resultBeans.size();
        }else {
            return 0;
        }
    }

    static class ItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ill_item_context)
        TextView context;
        @BindView(R.id.ill_item_days)
        TextView days;
        @BindView(R.id.ill_item_go)
        TextView go;
        @BindView(R.id.ill_item_month)
        TextView month;
        @BindView(R.id.ill_item_title)
        TextView title;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}