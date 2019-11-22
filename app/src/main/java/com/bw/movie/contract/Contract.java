package com.bw.movie.contract;

import com.bw.mvplibrary.base.IBaseView;

/**
 * describe:Contract
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public interface Contract {
    //V层
    interface IView extends IBaseView{
        void onSuccess(Object obj);
        void onSuccessFul(Object object);
        void onNowSuccess(Object now);
        void onAfterSuccess(Object after);
        void onFail(String str);
    }
    //P层
    interface IPresenter{
        //登录
        void doLogin(String email,String pwd);
        //发生验证码
        void doCode(String email);
        //注册
        void doRegister(String nickName,String pwd,String email,String code);
        //banner图
        void doBanner();
        //首页展示
        void doAfter(String page,String count);
        void doNow(String userId,String sessionId,String page,String count);
        void doHot(String page,String count);
        //一级
        void doAddress();
        //二级
        void doPlace(String regionId);
        //推荐影院
        void doRec(String userId,String sessionId,String page,String count);
        //附近影院
        void doNear(String userId,String sessionId,String longitude,String latitude,String page,String count);
        //影院详情
        void doFindCinema(String userId,String sessionId,String cinemaId);
        //电影详情
        void doFindMovies(String userId,String sessionId,String movieId);
        //电影评论
        void doComment(String userId,String sessionId,String movieId,String page,String count);
        //点赞
        void doGreat(String userId,String sessionId,String commentId);
        //关注
        void doGz(String userId,String sessionId,String movieId);
        //取消关注
        void doQgz(String userId,String sessionId,String movieId);
        //电影排期
        void doSchedule(String cinemaId,String page,String count);
        //档期时间
        void doTime();
        //地区查询影院
        void doBy(String regionId);
        //电影档期
        void doFindSc(String movieId,String cinemaId);
        //地区查询
        void doFindCinemasInfoByRegion(String movieId,String regionId,String page,String count);
        //日期查询
        void doFindCinemasInfoByData(String movieId,String date,String page,String count);
}
    //M层
    interface IModel{
        void doLogin(String email,String pwd,IModelCallback iModelCallback);
        void doCode(String email,IModelCallback iModelCallback);
        void doRegister(String nickName,String pwd,String email,String code,IModelCallback iModelCallback);
        void doBanner(IModelCallback iModelCallback);
        void doNow(String userId,String sessionId,String page,String count,IModelCallback iModelCallback);
        void doAfter(String page,String count,IModelCallback iModelCallback);
        void doHot(String page,String count,IModelCallback iModelCallback);
        void doAddress(IModelCallback iModelCallback);
        void doPlace(String regionId,IModelCallback iModelCallback);
        void doRec(String userId,String sessionId,String page,String count,IModelCallback iModelCallback);
        void doNear(String userId,String sessionId,String longitude,String latitude,String page,String count,IModelCallback iModelCallback);
        void doFindCinema(String userId,String sessionId,String cinemaId,IModelCallback iModelCallback);
        void doFindMovies(String userId,String sessionId,String movieId,IModelCallback iModelCallback);
        void doComment(String userId,String sessionId,String movieId,String page,String count,IModelCallback iModelCallback);
        void doGreat(String userId,String sessionId,String commentId,IModelCallback iModelCallback);
        void doGz(String userId,String sessionId,String movieId,IModelCallback iModelCallback);
        void doQgz(String userId,String sessionId,String movieId,IModelCallback iModelCallback);
        void doSchedule(String cinemaId,String page,String count,IModelCallback iModelCallback);
        void doTime(IModelCallback iModelCallback);
        void doBy(String regionId,IModelCallback iModelCallback);
        void doFindSc(String movieId,String cinemaId,IModelCallback iModelCallback);
        void doFindCinemasInfoByRegion(String movieId,String regionId,String page,String count,IModelCallback iModelCallback);
        void doFindCinemasInfoByData(String movieId,String date,String page,String count,IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(Object obj);
            void onSuccessFul(Object object);
            void onNowSuccess(Object now);
            void onAfterSuccess(Object after);
            void onFail(String str);
        }
    }
}
