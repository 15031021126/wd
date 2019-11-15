package com.wd.health.entity.user;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class UserEntity {
    /**
     * result : {"age":20,"email":"1510621690@qq.com","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-04-02/20190402112521.jpg","height":180,"id":1,"invitationCode":"RTTNASJBQI","jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","nickName":"天气不错","sex":2,"userName":"hIB3Qt1510621690","weight":140,"whetherBingWeChat":2}
     * message : 用户信息查询成功
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
         * age : 20
         * email : 1510621690@qq.com
         * headPic : http://172.17.8.100/images/health/user/head_pic/2019-04-02/20190402112521.jpg
         * height : 180
         * id : 1
         * invitationCode : RTTNASJBQI
         * jiGuangPwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * nickName : 天气不错
         * sex : 2
         * userName : hIB3Qt1510621690
         * weight : 140
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

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
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

        @Override
        public String toString() {
            return "ResultBean{" +
                    "age=" + age +
                    ", email='" + email + '\'' +
                    ", headPic='" + headPic + '\'' +
                    ", height=" + height +
                    ", id=" + id +
                    ", invitationCode='" + invitationCode + '\'' +
                    ", jiGuangPwd='" + jiGuangPwd + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", sex=" + sex +
                    ", userName='" + userName + '\'' +
                    ", weight=" + weight +
                    ", whetherBingWeChat=" + whetherBingWeChat +
                    '}';
        }
    }
}
