package com.wd.health.adpter.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.wd.health.R;
import com.wd.health.entity.circle.CircleListsBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class IllAdapter extends RecyclerView.Adapter<IllAdapter.IllHolder1> {
    private Context context;
    private ArrayList<CircleListsBean.ResultBean> resultBeans;

    public IllAdapter(Context context, ArrayList<CircleListsBean.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public IllHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new IllHolder1(from.inflate(R.layout.ill_item1, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IllHolder1 viewHolder, int i) {
        long releaseTime = resultBeans.get(i).getReleaseTime();
        String date = TimeUtils.millis2String(releaseTime,"yyyy");
        viewHolder.year.setText(date+"年");
        ItemAdapter itemAdapter = new ItemAdapter(context, resultBeans);
        viewHolder.rec.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        viewHolder.rec.setAdapter(itemAdapter);

    }

    @Override
    public int getItemCount() {
        if (resultBeans.size() != 0) {
         return 1;
        } else {
            return 0;
        }
    }

    static class IllHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.ill_item1_year)
        TextView year;
        @BindView(R.id.ill_item1_rec)
        RecyclerView rec;

        public IllHolder1(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
