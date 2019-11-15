package com.wd.health.api;

/*
 *@Auther:陈浩
 *@Date: 2019/8/3
 *@Time:16:32
 *@Description:${Api}
 * */public class Api {

   public static final String BASEURL = "http://172.17.8.100/";
   // public static final String BASEURL = "http://mobile.bwstudent.com/";

    //首页
    public static final String HOME_BANNER = "health/share/v1/bannersShow";
    public static final String HOME_WZZX_LIST = "health/share/knowledgeBase/v1/findDepartment";
    //健康咨询标题
    public static final String HOME_Health_Consultation_Title = "health/share/information/v1/findInformationPlateList";
    ///健康咨询内容
    public static final String HOME_Health_Consultation_Content = "health/share/information/v1/findInformationList";
    public static final String Home_Consultation_details = "health/share/information/v1/findInformation";

    /*
        用户接口
    */
    public static final String EMAIL="health/user/v1/sendOutEmailCode";//发送邮箱
    public static final String REGISTER="health/user/v1/register";//注册
    public static final String LOGIN="health/user/v1/login";//登录
    public static final String USERINFOBYID="health/user/verify/v1/getUserInfoById";//根据用户ID查询用户信息
    public static final String PERFECTUSERINFO="health/user/verify/v1/perfectUserInfo";//完善用户信息
    //档案类
    public static final String UPDATEARCHIVES="health/user/verify/v1/updateUserArchives";//修改用户档案
    public static final String ARCHIVES="health/user/verify/v1/addUserArchives";//添加用户档案
    public static final String ARCHIVESPICTURE="health/user/verify/v1/uploadArchivesPicture";//上传用户档案图片
    public static final String USERARCHIVES="health/user/verify/v1/findUserArchives";//查看用户档案
    public static final String DELARCHIVES="health/user/verify/v1/deleteUserArchives";//删除档案
    //签到类
    public static final String SIGN="health/user/verify/v1/addSign";//用户签到
    public static final String WHETHERSIGN="health/user/verify/v1/whetherSignToday";//查询用户当天是否签到
    public static final String SIGNDAY="health/user/verify/v1/findUserSign";//查询用户连续签到天数
    //修改
    public static final String HEADPIC="health/user/verify/v1/modifyHeadPic";//上传头像
    public static final String SEX="health/user/verify/v1/updateUserSex";//修改性别
    public static final String NICKNAME="health/user/verify/v1/modifyNickName";//修改名称
    public static final String UPDATEPASSWODE="health/user/verify/v1/updateUserPwd";//修改密码 ( 正常修改 )
    public static final String CHECKCODE="health/user/v1/checkCode";//37.检验验证码
    public static final String RESETPASSWORDE="health/user/v1/resetUserPwd";//38.重置用户密码（忘记密码用）
    //邀请码
    public static final String CODE="health/user/verify/v1/makeInvitationCode";//生成邀请码
    public static final String FINDCODE="health/user/verify/v1/findUserInvitationCode";//查询用户邀请码
    //推送
    public static final String JPUSHTOKEN="health/user/verify/v1/addUserPushToken";//添加用户极光推送信息Token
    //任务
    public static final String TASK="health/user/verify/v1/doTask";//做任务
    public static final String TASKLIST="health/user/verify/v1/findUserTaskList";//任务列表
    public static final String TASKRECEIVE="health/user/verify/v1/receiveReward";//领取任务奖励
    //咨询
    public static final String ADDCOLLECTION="health/user/verify/v1/addInfoCollection";//收藏资讯
    public static final String COLLECTIONLIST="health/user/verify/v1/findUserInfoCollectionList";//查询咨询列表
    public static final String DELCOLLECTION="health/user/verify/v1/cancelInfoCollection";//取消收藏咨询
    //病友圈
    public static final String ADDSICK="health/user/verify/v1/addUserSickCollection";//27.收藏病友圈
    public static final String SICKLIST="health/user/verify/v1/findUserSickCollectionList";//28.病友圈列表
    public static final String DELSICK="health/user/verify/v1/cancelSickCollection";//29.取消病友圈收藏
    //健康课堂视频
    public static final String VIDEOLIST="health/user/verify/v1/findVideoCollectionList";//30.用户收藏健康课堂视频列表
    public static final String DELVIDEO="health/user/verify/v1/cancelVideoCollection";//31.用户取消视频收藏
    public static final String BUYVIDEOLIST="health/user/verify/v1/findUserVideoBuyList";//33.查询用户购买视频列表
    public static final String DELBUYVIDEO="health/user/verify/v1/deleteVideoBuy";//34.删除购买健康课堂视频
    //医生
    public static final String DOCTORLIST="health/user/verify/v1/findUserDoctorFollowList";//32. 查询用户关注医生列表
    //消费记录
    public static final String CONSUMPTIONRECORDLIST="health/user/verify/v1/findUserConsumptionRecordList";//35.查询用户消费记录
    //钱包
    public static final String WALLET="health/user/verify/v1/findUserWallet";//36.我的钱包

}
