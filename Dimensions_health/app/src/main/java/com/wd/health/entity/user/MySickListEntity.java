package com.wd.health.entity.user;

import java.util.List;

/*
 *@Auther:王泽洋
 *@Date: 时间
 *@Description:功能
 * */
public class MySickListEntity {

    /**
     * result : {"adoptionSickCircleComment":{"commentId":1221,"commentTime":1566963108000,"commentUserId":63,"content":"你好啊","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_2.jpg","nickName":"RQ_APUYF","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},"otherSickCircleCommentList":[{"commentId":1221,"commentTime":1566963108000,"commentUserId":63,"content":"你好啊","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"杨帅","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":1087,"commentTime":1566483145000,"commentUserId":155,"content":"满纸荒唐言？！","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-08-26/5T8DrI20190826172853.png","nickName":"ob_HWRFZ","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2}]}
     * message : 查询成功
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
        @Override
        public String toString() {
            return "ResultBean{" +
                    "adoptionSickCircleComment=" + adoptionSickCircleComment +
                    ", otherSickCircleCommentList=" + otherSickCircleCommentList +
                    '}';
        }

        /**
         * adoptionSickCircleComment : {"commentId":1221,"commentTime":1566963108000,"commentUserId":63,"content":"你好啊","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_2.jpg","nickName":"RQ_APUYF","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1}
         * otherSickCircleCommentList : [{"commentId":1221,"commentTime":1566963108000,"commentUserId":63,"content":"你好啊","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"杨帅","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":1087,"commentTime":1566483145000,"commentUserId":155,"content":"满纸荒唐言？！","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-08-26/5T8DrI20190826172853.png","nickName":"ob_HWRFZ","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2}]
         */

        private AdoptionSickCircleCommentBean adoptionSickCircleComment;
        private List<OtherSickCircleCommentListBean> otherSickCircleCommentList;

        public AdoptionSickCircleCommentBean getAdoptionSickCircleComment() {
            return adoptionSickCircleComment;
        }

        public void setAdoptionSickCircleComment(AdoptionSickCircleCommentBean adoptionSickCircleComment) {
            this.adoptionSickCircleComment = adoptionSickCircleComment;
        }

        public List<OtherSickCircleCommentListBean> getOtherSickCircleCommentList() {
            return otherSickCircleCommentList;
        }

        public void setOtherSickCircleCommentList(List<OtherSickCircleCommentListBean> otherSickCircleCommentList) {
            this.otherSickCircleCommentList = otherSickCircleCommentList;
        }

        public static class AdoptionSickCircleCommentBean {
            /**
             * commentId : 1221
             * commentTime : 1566963108000
             * commentUserId : 63
             * content : 你好啊
             * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_2.jpg
             * nickName : RQ_APUYF
             * opinion : 0
             * opposeNum : 0
             * supportNum : 0
             * whetherDoctor : 1
             */

            private int commentId;
            private long commentTime;
            private int commentUserId;
            private String content;
            private String headPic;
            private String nickName;
            private int opinion;
            private int opposeNum;
            private int supportNum;
            private int whetherDoctor;
            private boolean aaa;
            private boolean aaa2;

            public boolean isAaa2() {
                return aaa2;
            }

            public void setAaa2(boolean aaa2) {
                this.aaa2 = aaa2;
            }

            public boolean isAaa() {
                return aaa;
            }

            public void setAaa(boolean aaa) {
                this.aaa = aaa;
            }

            @Override
            public String toString() {
                return "AdoptionSickCircleCommentBean{" +
                        "commentId=" + commentId +
                        ", commentTime=" + commentTime +
                        ", commentUserId=" + commentUserId +
                        ", content='" + content + '\'' +
                        ", headPic='" + headPic + '\'' +
                        ", nickName='" + nickName + '\'' +
                        ", opinion=" + opinion +
                        ", opposeNum=" + opposeNum +
                        ", supportNum=" + supportNum +
                        ", whetherDoctor=" + whetherDoctor +
                        '}';
            }

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public long getCommentTime() {
                return commentTime;
            }

            public void setCommentTime(long commentTime) {
                this.commentTime = commentTime;
            }

            public int getCommentUserId() {
                return commentUserId;
            }

            public void setCommentUserId(int commentUserId) {
                this.commentUserId = commentUserId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getOpinion() {
                return opinion;
            }

            public void setOpinion(int opinion) {
                this.opinion = opinion;
            }

            public int getOpposeNum() {
                return opposeNum;
            }

            public void setOpposeNum(int opposeNum) {
                this.opposeNum = opposeNum;
            }

            public int getSupportNum() {
                return supportNum;
            }

            public void setSupportNum(int supportNum) {
                this.supportNum = supportNum;
            }

            public int getWhetherDoctor() {
                return whetherDoctor;
            }

            public void setWhetherDoctor(int whetherDoctor) {
                this.whetherDoctor = whetherDoctor;
            }
        }

        public static class OtherSickCircleCommentListBean {
            @Override
            public String toString() {
                return "OtherSickCircleCommentListBean{" +
                        "commentId=" + commentId +
                        ", commentTime=" + commentTime +
                        ", commentUserId=" + commentUserId +
                        ", content='" + content + '\'' +
                        ", headPic='" + headPic + '\'' +
                        ", nickName='" + nickName + '\'' +
                        ", opinion=" + opinion +
                        ", opposeNum=" + opposeNum +
                        ", supportNum=" + supportNum +
                        ", whetherDoctor=" + whetherDoctor +
                        '}';
            }

            /**
             * commentId : 1221
             * commentTime : 1566963108000
             * commentUserId : 63
             * content : 你好啊
             * headPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
             * nickName : 杨帅
             * opinion : 0
             * opposeNum : 0
             * supportNum : 0
             * whetherDoctor : 1
             */

            private int commentId;
            private long commentTime;
            private int commentUserId;
            private String content;
            private String headPic;
            private String nickName;
            private int opinion;
            private int opposeNum;
            private int supportNum;
            private int whetherDoctor;
            private boolean bbb;
            private boolean bbb2;

            public boolean isBbb2() {
                return bbb2;
            }

            public void setBbb2(boolean bbb2) {
                this.bbb2 = bbb2;
            }

            public boolean isBbb() {
                return bbb;
            }

            public void setBbb(boolean bbb) {
                this.bbb = bbb;
            }

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public long getCommentTime() {
                return commentTime;
            }

            public void setCommentTime(long commentTime) {
                this.commentTime = commentTime;
            }

            public int getCommentUserId() {
                return commentUserId;
            }

            public void setCommentUserId(int commentUserId) {
                this.commentUserId = commentUserId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getOpinion() {
                return opinion;
            }

            public void setOpinion(int opinion) {
                this.opinion = opinion;
            }

            public int getOpposeNum() {
                return opposeNum;
            }

            public void setOpposeNum(int opposeNum) {
                this.opposeNum = opposeNum;
            }

            public int getSupportNum() {
                return supportNum;
            }

            public void setSupportNum(int supportNum) {
                this.supportNum = supportNum;
            }

            public int getWhetherDoctor() {
                return whetherDoctor;
            }

            public void setWhetherDoctor(int whetherDoctor) {
                this.whetherDoctor = whetherDoctor;
            }
        }
    }
}
