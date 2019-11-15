package com.wd.health.entity.user;

import java.util.List;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class AdopteEntity {
    /**
     * result : [{"adoptTime":1566921600000,"content":"222222222222222222","disease":"高脂蛋白血症","releaseUserHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-08-27/mvXBYP20190827093420.jpg","releaseUserId":117,"releaseUserNickName":"aC_EGUVS","title":"医生来评论"},{"adoptTime":1566921600000,"content":"1111","disease":"虹膜炎","releaseUserHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-08-27/mvXBYP20190827093420.jpg","releaseUserId":117,"releaseUserNickName":"aC_EGUVS","title":"2"},{"adoptTime":1566921600000,"content":"21313123","disease":"痛 风","releaseUserHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-08-27/mvXBYP20190827093420.jpg","releaseUserId":117,"releaseUserNickName":"aC_EGUVS","title":"54520"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * adoptTime : 1566921600000
         * content : 222222222222222222
         * disease : 高脂蛋白血症
         * releaseUserHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-08-27/mvXBYP20190827093420.jpg
         * releaseUserId : 117
         * releaseUserNickName : aC_EGUVS
         * title : 医生来评论
         */

        private long adoptTime;
        private String content;
        private String disease;
        private String releaseUserHeadPic;
        private int releaseUserId;
        private String releaseUserNickName;
        private String title;

        public long getAdoptTime() {
            return adoptTime;
        }

        public void setAdoptTime(long adoptTime) {
            this.adoptTime = adoptTime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public String getReleaseUserHeadPic() {
            return releaseUserHeadPic;
        }

        public void setReleaseUserHeadPic(String releaseUserHeadPic) {
            this.releaseUserHeadPic = releaseUserHeadPic;
        }

        public int getReleaseUserId() {
            return releaseUserId;
        }

        public void setReleaseUserId(int releaseUserId) {
            this.releaseUserId = releaseUserId;
        }

        public String getReleaseUserNickName() {
            return releaseUserNickName;
        }

        public void setReleaseUserNickName(String releaseUserNickName) {
            this.releaseUserNickName = releaseUserNickName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
