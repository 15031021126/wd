package com.wd.health.entity;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class MessageEntity {
    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
