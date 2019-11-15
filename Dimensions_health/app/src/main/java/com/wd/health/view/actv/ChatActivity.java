package com.wd.health.view.actv;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.base_core.base.BaseActivity;
import com.wd.base_core.mvp.BasePresenter;
import com.wd.base_core.untils.L;
import com.wd.health.R;
import com.wd.health.adpter.ChatMsgAdpter;
import com.wd.health.entity.ChatMsg;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.event.OfflineMessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.api.BasicCallback;

/**
 * 聊天会话
 */
public class ChatActivity extends BaseActivity {
    @BindView(R.id.chat_xrecy)
    XRecyclerView chatXrecy;
    @BindView(R.id.chat_xrecy_edt)
    EditText chatXrecyEdt;
    @BindView(R.id.chat_send)
    Button chatSend;
    @BindView(R.id.chat_send_type)
    ImageView chatSendType;
    @BindView(R.id.chat_send_emjo)
    ImageView chatSendEmjo;
    @BindView(R.id.chat_send_pic)
    ImageView chatSendPic;
    @BindView(R.id.chat_back)
    ImageView chatBack;
    @BindView(R.id.doctor_name)
    TextView doctorName;
    @BindView(R.id.chat_video)
    Button chatVideobt;
    private ArrayList<ChatMsg> msgList;
    private ChatMsgAdpter chatMsgAdpter;
    private boolean flag = true;

    @Override
    protected void iniData() {

        /**
         * 软键盘按钮监听
         */
        keybordSend();
        setBar(0);
        //注册
        JMessageClient.registerEventReceiver(this);
        //jkReg();
        /**
         * 登录账号
         */
        jklogin("bbbb", "111111");

        //点击标题栏返回
        chatBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
            }
        });
        //初始化数据
        msgList = new ArrayList<>();
        //初始化信息
        ChatMsg msg1 = new ChatMsg("hello guy", ChatMsg.TYPE_RECEIVED);
        msgList.add(msg1);
        chatXrecy.setLayoutManager(new LinearLayoutManager(this));
        chatMsgAdpter = new ChatMsgAdpter(getApplicationContext(), msgList);
        chatXrecy.setAdapter(chatMsgAdpter);
        //发送
        chatSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送到消息记录
                String trim = chatXrecyEdt.getText().toString();
                ChatMsg msg3 = new ChatMsg(trim, ChatMsg.TYPE_SENT);
                msgList.add(msg3);
                chatMsgAdpter.notifyDataSetChanged();
                chatXrecy.scrollToPosition(msgList.size());
                chatXrecyEdt.setText(null);
                //极光发送
                kjsend("aaaa", trim);
            }
        });

        //点击切换语音或者文字
        chatSendType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                if (flag) {
                    chatSendType.setImageResource(R.mipmap.common_icon_keyboard_n);
                    chatXrecyEdt.setVisibility(View.GONE);
                    chatVideobt.setVisibility(View.VISIBLE);
                } else {
                    chatSendType.setImageResource(R.mipmap.common_icon_voice_n);
                    chatXrecyEdt.setVisibility(View.VISIBLE);
                    chatVideobt.setVisibility(View.GONE);
                }
            }
        });

    }

    /**
     * 软键盘按钮监听
     */
    private void keybordSend() {
        chatXrecyEdt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    //点击GO键
                    case EditorInfo.IME_ACTION_GO:
                        return true;
                    //点击Done
                    case EditorInfo.IME_ACTION_DONE:
                        return true;
                    //点击Next
                    case EditorInfo.IME_ACTION_NEXT:
                        return true;
                    //点击Previous
                    case EditorInfo.IME_ACTION_PREVIOUS:
                        return true;
                    //点击None
                    case EditorInfo.IME_ACTION_NONE:
                        return true;
                    //点击Send
                    case EditorInfo.IME_ACTION_SEND:
                        //发送到消息记录
                        String trim = chatXrecyEdt.getText().toString();
                        ChatMsg msg3 = new ChatMsg(trim, ChatMsg.TYPE_SENT);
                        msgList.add(msg3);
                        chatMsgAdpter.notifyDataSetChanged();
                        chatXrecy.scrollToPosition(msgList.size());
                        chatXrecyEdt.setText(null);
                        //极光发送
                        kjsend("aaaa", trim);
                        return true;
                }
                return false;
            }
        });
    }

    /**
     * 极光注册
     *
     * @param phone
     * @param pwd
     */
    private void jkReg(String phone, String pwd) {
        JMessageClient.register(phone, pwd, new BasicCallback() {
            @Override
            public void gotResult(int i, String s) {
                if (0 == i) {//成功
                    Toast.makeText(ChatActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                } else {//失败
                    Toast.makeText(ChatActivity.this, "注册失败", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    /**
     * 发送给
     *
     * @param phone   //发送内容
     * @param content
     */
    private void kjsend(String phone, String content) {
        Message message = JMessageClient.createSingleTextMessage(phone + "", "", "" + content);
        if (message == null) {
            return;
        } else {


            //设置发送完成回叫
            message.setOnSendCompleteCallback(new BasicCallback() {
                @Override
                public void gotResult(int i, String s) {
                    L.e("123", i + "" + s);
                    if (i == 0) {
                        // Toast.makeText(ChatActivity.this, "发送成共", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            JMessageClient.sendMessage(message);
        }
    }

    /**
     * 登录
     *
     * @param phone
     */
    private void jklogin(String phone, String pwd) {
        JMessageClient.login(phone, pwd, new BasicCallback() {
            @Override
            public void gotResult(int i, String s) {
                System.out.println("i==" + i + " s===" + s);
                if (0 == i) {//成功
                    Toast.makeText(ChatActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                } else {//失败
                    Toast.makeText(ChatActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 找布局
     *
     * @return
     */
    @Override
    protected int bindlayout() {
        return R.layout.activity_chat;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    /**
     * 按返回键动画
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
    }


    //    //用户在线期间，如果群组中发生了成员变化事件，sdk也会通过上抛MessageEvent的方式来通知上层
//    public void onEvent(MessageEvent event ){
//        Message msg = event.getMessage();
//        Toast.makeText(this, "msg:" + msg, Toast.LENGTH_SHORT).show();
//        L.e("123",msg.getContent()+"");
//
//        //获取消息类型，如text voice image eventNotification等。
//        switch (msg.getContentType()) {
//            //处理事件提醒消息，此处message的contentType类型为eventNotification。
//            case eventNotification:
//                //获取事件发生的群的群信息
//                GroupInfo groupInfo = (GroupInfo) msg.getTargetInfo();
//                //获取事件具体的内容对象
//                EventNotificationContent eventNotificationContent = (EventNotificationContent)msg.getContent();
//                Toast.makeText(this, "eventNotificationContent:" + eventNotificationContent, Toast.LENGTH_SHORT).show();
//                //获取事件具体类型
//                switch (eventNotificationContent.getEventNotificationType()){
//                    case group_member_added:
//                        //群成员加群事件
//                        break;
//                    case group_member_removed:
//                        //群成员被踢事件
//                        break;
//                    case group_member_exit:
//                        //群成员退群事件
//                        break;
//                    case group_info_updated://since 2.2.1
//                        //群信息变更事件
//                        break;
//                }
//                break;
//        }
//    }


    /**
     * 接收离线消息。
     * 类似MessageEvent事件的接收，上层在需要的地方增加OfflineMessageEvent事件的接收
     * 即可实现离线消息的接收。
     **/
    public void onEventMainThread(OfflineMessageEvent event) {
        //获取事件发生的会话对象
        Conversation conversation = event.getConversation();
        List<Message> newMessageList = event.getOfflineMessageList();//获取此次离线期间会话收到的新消息列表
        Toast.makeText(this, "" + newMessageList, Toast.LENGTH_SHORT).show();
        //获取事件发生的会话对象
        for (int i = 0; i < newMessageList.size(); i++) {
            String s = newMessageList.get(i).getContent().toJson();
            try {
                JSONObject object = new JSONObject(s);
                String text = object.getString("text");
                L.e(text + "");
                ChatMsg msg1 = new ChatMsg("" + text, ChatMsg.TYPE_RECEIVED);
                msgList.add(msg1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //刷新适配器
            chatMsgAdpter.notifyDataSetChanged();
            chatXrecy.scrollToPosition(msgList.size());
        }

    }

    /**
     * 接收在线消息
     **/
    public void onEventMainThread(MessageEvent event) {
        //获取事件发生的会话对象
        Message newMessage = event.getMessage();//获取此次离线期间会话收到的新消息列表
        String s = newMessage.getContent().toJson();
        L.e("123", s);
        try {
            JSONObject object = new JSONObject(s);
            String text = object.getString("text");
            L.e(text + "");
            ChatMsg msg1 = new ChatMsg("" + text, ChatMsg.TYPE_RECEIVED);
            msgList.add(msg1);//添加到会话
            chatMsgAdpter.notifyDataSetChanged();//刷新
            chatXrecy.scrollToPosition(msgList.size());//滑动到
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解绑
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(this);
    }


}
