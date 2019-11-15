package com.wd.health.entity.home;

import java.util.List;

/*
 *@Auther:陈浩
 *@Date: 2019/8/8
 *@Time:19:20
 *@Description:${DESCRIPTION}
 * */public class FavoritesList {

    /**
     * result : [{"createTime":1565261879000,"id":176,"infoId":3,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1hYEOB__T1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1ezYSBCDT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1JzASBXdT1RCvBVdK","title":"这4个错误的姿势，最容易引起脊柱侧弯！多数人都中枪了"}]
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
         * createTime : 1565261879000
         * id : 176
         * infoId : 3
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1hYEOB__T1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1ezYSBCDT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1JzASBXdT1RCvBVdK
         * title : 这4个错误的姿势，最容易引起脊柱侧弯！多数人都中枪了
         */

        private long createTime;
        private int id;
        private int infoId;
        private String thumbnail;
        private String title;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
