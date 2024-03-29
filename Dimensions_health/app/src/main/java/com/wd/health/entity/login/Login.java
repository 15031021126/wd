package com.wd.health.entity.login;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class Login {
    /**
     * result : {"age":0,"email":"527400988@qq.com","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_4.jpg","height":0,"id":117,"jiGuangPwd":"Z6kLUzBufSTa3MrhXQ0icHPkA+mfZYfUd5/IJw2Y+ggeh9Phu4iJ6hR2VXYNwOULJUY6ryoFH+y0pX1AzOG2FJKa0jBCv6Ega1JqlM5gmiNIEfWXKAJ1ub4Ku2AaJZlEa910HmMrrmRvbXl/FxsevATsnOb+noKngNG5kQo3M7I=","nickName":"aC_EGUVS","sessionId":"1565059785249117","sex":1,"userName":"rawQiq527400988","weight":0,"whetherBingWeChat":2}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        /**
         * age : 0
         * email : 527400988@qq.com
         * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_4.jpg
         * height : 0
         * id : 117
         * jiGuangPwd : Z6kLUzBufSTa3MrhXQ0icHPkA+mfZYfUd5/IJw2Y+ggeh9Phu4iJ6hR2VXYNwOULJUY6ryoFH+y0pX1AzOG2FJKa0jBCv6Ega1JqlM5gmiNIEfWXKAJ1ub4Ku2AaJZlEa910HmMrrmRvbXl/FxsevATsnOb+noKngNG5kQo3M7I=
         * nickName : aC_EGUVS
         * sessionId : 1565059785249117
         * sex : 1
         * userName : rawQiq527400988
         * weight : 0
         * whetherBingWeChat : 2
         */

        private int age;
        private String email;
        private String headPic;
        private int height;
        private int id;
        private String invitationCode;
        private String jiGuangPwd;
        private String nickName;
        private String sessionId;
        private int sex;
        private String userName;
        private int weight;
        private int whetherBingWeChat;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }


        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getWhetherBingWeChat() {
            return whetherBingWeChat;
        }

        public void setWhetherBingWeChat(int whetherBingWeChat) {
            this.whetherBingWeChat = whetherBingWeChat;
        }
    }
}
