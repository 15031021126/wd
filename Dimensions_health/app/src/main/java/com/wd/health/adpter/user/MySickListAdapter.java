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
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.entity.user.MySickListEntity;
import com.wd.health.untils.NoDoubleClickListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class MySickListAdapter extends RecyclerView.Adapter<MySickListAdapter.MySickListHolder> {
    private Context context;
    private ArrayList<MySickListEntity.ResultBean.OtherSickCircleCommentListBean> arrayList;

    public MySickListAdapter(Context context, ArrayList<MySickListEntity.ResultBean.OtherSickCircleCommentListBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MySickListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new MySickListHolder(from.inflate(R.layout.ping_item2,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MySickListHolder mySickListHolder, int i) {
        Glide.with(context).load(arrayList.get(i).getHeadPic()).into(mySickListHolder.pic);
        long commentTime = arrayList.get(i).getCommentTime();
        String string = TimeUtils.millis2String(commentTime, "yyyy/MM/dd");
        mySickListHolder.time.setText(string);
        mySickListHolder.ping.setText(arrayList.get(i).getContent());
        mySickListHolder.name.setText(arrayList.get(i).getNickName());
        mySickListHolder.agreeNum.setText(arrayList.get(i).getSupportNum()+"");
        mySickListHolder.disagreeNum.setText(arrayList.get(i).getOpposeNum()+"");

        int opinion = arrayList.get(i).getOpinion();
            if (opinion == 1) {
                arrayList.get(i).setBbb(true);
                mySickListHolder.agree.setImageResource(R.mipmap.common_icon_agree_s);
                mySickListHolder.disAgree.setImageResource(R.mipmap.common_icon_disagree_n);
                mySickListHolder.agree.setOnClickListener(new NoDoubleClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {
                        ToastUtils.showShort("已经点过赞了");
                    }
                });
                mySickListHolder.disAgree.setOnClickListener(new NoDoubleClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {
                        ToastUtils.showShort("已经点过赞了");
                    }
                });
            } else if (opinion == 2) {
                arrayList.get(i).setBbb(true);
                mySickListHolder.disAgree.setImageResource(R.mipmap.common_icon_disagree_s);
                mySickListHolder.agree.setImageResource(R.mipmap.common_icon_agree_n);
                mySickListHolder.agree.setOnClickListener(new NoDoubleClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {
                        ToastUtils.showShort("已经点过踩了");
                    }
                });
                mySickListHolder.disAgree.setOnClickListener(new NoDoubleClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {
                        ToastUtils.showShort("已经点过踩了");
                    }
                });
            } else if (opinion == 0) {
                mySickListHolder.agree.setOnClickListener(new NoDoubleClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {
                        callinBackSick2.getCommitId(arrayList.get(i).getCommentId(), 1,i);
                        mySickListHolder.agree.setImageResource(R.mipmap.common_icon_agree_s);
                    }
                });
                mySickListHolder.disAgree.setOnClickListener(new NoDoubleClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {
                        callinBackSick2.getCommitId(arrayList.get(i).getCommentId(), 2,i);
                        mySickListHolder.disAgree.setImageResource(R.mipmap.common_icon_disagree_s);

                    }
                });
            }
    }

    private CallinBackSick2 callinBackSick2;
    public void setCallinBackSick2(CallinBackSick2 callinBackSick2){
        this.callinBackSick2=callinBackSick2;
    }
    public interface  CallinBackSick2{
        void getCommitId(int commentId,int opinion,int i);
    }

    @Override
    public int getItemCount() {
        if (arrayList.size()!=0){
            return arrayList.size();
        }
        return 0;
    }

    static class MySickListHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ping_pic)
        ImageView pic;
        @BindView(R.id.ping_name)
        TextView name;
        @BindView(R.id.ping)
        TextView ping;
        @BindView(R.id.ping_time)
        TextView time;
        @BindView(R.id.agree)
        ImageView agree;
        @BindView(R.id.agree_num)
        TextView agreeNum;
        @BindView(R.id.disagree)
        ImageView disAgree;
        @BindView(R.id.disagree_num)
        TextView disagreeNum;
        public MySickListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
