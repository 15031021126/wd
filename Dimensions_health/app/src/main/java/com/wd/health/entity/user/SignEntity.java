package com.wd.health.entity.user;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class SignEntity {
    private int result;
    private String message;
    private String status;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

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
        return "SignEntity{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
