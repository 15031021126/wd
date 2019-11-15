package com.wd.health.adpter.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wd.health.R;
import com.wd.health.entity.user.AdopteEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class AdopteAdapter extends RecyclerView.Adapter<AdopteAdapter.AdopteHolder> {
    private Context context;
    private ArrayList<AdopteEntity.ResultBean> resultBeans;

    public AdopteAdapter(Context context, ArrayList<AdopteEntity.ResultBean> resultBeans) {
        this.context = context;
        this.resultBeans = resultBeans;
    }

    @NonNull
    @Override
    public AdopteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new AdopteHolder(from.inflate(R.layout.adopte_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdopteHolder adopteHolder, int i) {
        adopteHolder.name.setText(resultBeans.get(i).getTitle());
        long adoptTime = resultBeans.get(i).getAdoptTime();
        String s = TimeUtils.millis2String(adoptTime, "yyyy-MM-dd");
        Glide.with(context).load(resultBeans.get(i).getReleaseUserHeadPic()).apply(new RequestOptions().circleCrop()).into(adopteHolder.img);
        adopteHolder.acf.setText(resultBeans.get(i).getReleaseUserNickName());
        adopteHolder.time.setText("采纳时间："+s);
        adopteHolder.type.setText("病症类型"+resultBeans.get(i).getDisease());
        adopteHolder.title.setText("我的建议");
        adopteHolder.content.setText(resultBeans.get(i).getContent());

    }

    @Override
    public int getItemCount() {
        if (resultBeans.size()!=0){
            return resultBeans.size();
        }else {
            return 0;
        }
    }

    static class AdopteHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.acf)
        TextView acf;
        public AdopteHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
