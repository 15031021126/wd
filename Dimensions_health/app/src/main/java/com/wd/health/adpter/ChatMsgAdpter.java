package com.wd.health.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wd.health.R;
import com.wd.health.entity.ChatMsg;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/8/7
 *@Time:16:08
 *@Description:${DESCRIPTION}
 * */public class ChatMsgAdpter extends RecyclerView.Adapter<ChatMsgAdpter.ChatViewHolder> {

    private Context context;
    private ArrayList<ChatMsg> msgList;

    public ChatMsgAdpter(Context context, ArrayList<ChatMsg> msgList) {
        this.context = context;
        this.msgList = msgList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(context);
        return new ChatViewHolder(from.inflate(R.layout.chat_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder chatViewHolder, int i) {
        String pichead = SPUtils.getInstance("user").getString("headPic");
        //设置头像
        Glide.with(context).load(pichead)
                .apply(new RequestOptions().circleCrop())
                .into(chatViewHolder.myhead);

        ChatMsg msg = msgList.get(i);//获取当前的Msg实例
        //对消息的类型进行判断，显示对应的布局，隐藏另一个布局。
        if (msg.getType() == ChatMsg.TYPE_RECEIVED) {
            chatViewHolder.leftLayout.setVisibility(View.VISIBLE);
            chatViewHolder.rightLayout.setVisibility(View.GONE);
            chatViewHolder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() == ChatMsg.TYPE_SENT) {
            chatViewHolder.leftLayout.setVisibility(View.GONE);
            chatViewHolder.rightLayout.setVisibility(View.VISIBLE);
            chatViewHolder.rightMsg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        RelativeLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView myhead;

        //传入view参数，获取布局中的控件
        public ChatViewHolder(View view) {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            rightLayout = (RelativeLayout) view.findViewById(R.id.right_layout);
            leftMsg = (TextView) view.findViewById(R.id.chat_left_msg);
            rightMsg = (TextView) view.findViewById(R.id.chat_right_msg);
            myhead = (ImageView) view.findViewById(R.id.chat_myhead);
        }
    }

}
