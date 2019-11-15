package com.wd.health.adpter.home;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.wd.base_core.untils.L;
import com.wd.health.R;
import com.wd.health.entity.home.HomeHealthConsultationContent;
import com.wd.health.holder.home.recy.HOItemHolder;
import com.wd.health.holder.home.recy.HTitemHolder;
import com.wd.health.holder.home.recy.HitemHolder;
import com.wd.health.holder.home.recy.HoitemFootHolder;
import com.wd.health.untils.GetTimeAgo;
import com.wd.health.view.actv.home.ConsultationDetailsActivity;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/8/6
 *@Time:8:48
 *@Description:${DESCRIPTION}
 * */public class HomeJkzxRecyAdpter extends RecyclerView.Adapter {
    private Activity context;
    private ArrayList<HomeHealthConsultationContent.ResultBean> resultBeans;
    private boolean flag = false;

    public HomeJkzxRecyAdpter(Activity context, ArrayList<HomeHealthConsultationContent.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        switch (i) {
            case 0:
                return new HitemHolder(from.inflate(R.layout.home_jkzx_tem, viewGroup, false));
            case 1:
                return new HOItemHolder(from.inflate(R.layout.home_jkzx_one_item, viewGroup, false));
            case 3:
                return new HTitemHolder(from.inflate(R.layout.home_jkzx_three_item, viewGroup, false));

            case 4:
                return new HoitemFootHolder(from.inflate(R.layout.moreconsultationfoot, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HomeHealthConsultationContent.ResultBean bean = resultBeans.get(i);
        switch (getItemViewType(i)) {
            case 0:
                String timeAgo = GetTimeAgo.getTimeAgo(bean.getReleaseTime());
                ((HitemHolder) viewHolder).jkzxAuther.setText(bean.getSource());
                ((HitemHolder) viewHolder).jkzxTime.setText(timeAgo + "");
                ((HitemHolder) viewHolder).jkzxTitle.setText(bean.getTitle() + "");
                ((HitemHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ConsultationDetailsActivity.class);
                        intent.putExtra("id", bean.getId());
                        intent.putExtra("plateId", resultBeans.get(i).getPlateId());
                        context.startActivity(intent);
                        context.overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                    }
                });
                break;
            case 1:
                ((HOItemHolder) viewHolder).jkzxOneAuther.setText(resultBeans.get(i).getSource());
                ((HOItemHolder) viewHolder).jkzxOneTime.setText(GetTimeAgo.getTimeAgo(resultBeans.get(i).getReleaseTime()) + "");
                ((HOItemHolder) viewHolder).jkzxOneTitle.setText(resultBeans.get(i).getTitle() + "");
                Glide.with(context).load(resultBeans.get(i).getThumbnail()).into(((HOItemHolder) viewHolder).jkzxOneImg);
                ((HOItemHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ConsultationDetailsActivity.class);
                        intent.putExtra("id", bean.getId());
                        intent.putExtra("plateId", resultBeans.get(i).getPlateId());
                        context.startActivity(intent);
                        context.overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                    }
                });
                break;
            case 3:
                ((HTitemHolder) viewHolder).jkzxThreeAuther.setText(bean.getSource());
                ((HTitemHolder) viewHolder).jkzxThreeTime.setText(GetTimeAgo.getTimeAgo(bean.getReleaseTime()));
                ((HTitemHolder) viewHolder).jkzxThreeTitle.setText(bean.getTitle() + "");
                String[] split = resultBeans.get(i).getThumbnail().split(";");
                Glide.with(context).load(split[0]).into(((HTitemHolder) viewHolder).jkzxThreeImgOne);
                Glide.with(context).load(split[1]).into(((HTitemHolder) viewHolder).jkzxThreeImgTwo);
                Glide.with(context).load(split[2]).into(((HTitemHolder) viewHolder).jkzxThreeImgThree);
                ((HTitemHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, ConsultationDetailsActivity.class);
                        intent.putExtra("id", bean.getId());
                        intent.putExtra("plateId", resultBeans.get(i).getPlateId());
                        context.startActivity(intent);
                        context.overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
                    }
                });
                break;
            case 4:
                ((HoitemFootHolder) viewHolder).itemView.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return resultBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        String[] split = resultBeans.get(position).getThumbnail().split(";");
        // L.e(""+split.length);
        L.e("123", position + "\n"+resultBeans.size());
        if(flag){
            if (position +1>= resultBeans.size()) {
                return 4;
            }
        }

        switch (split.length) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 3:
                return 3;
        }
        return 4;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
