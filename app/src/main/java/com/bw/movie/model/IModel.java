package com.bw.movie.model;

import android.telecom.Call;

import com.bw.movie.bean.AddressBean;
import com.bw.movie.bean.AfterBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.ByCinemaBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.FindCinemaBean;
import com.bw.movie.bean.FindCinemasInfoByDate;
import com.bw.movie.bean.FindCinemasInfoByRegion;
import com.bw.movie.bean.FindMoviesBean;
import com.bw.movie.bean.FindScheduleBean;
import com.bw.movie.bean.GreatBean;
import com.bw.movie.bean.GzBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieCommentBean;
import com.bw.movie.bean.NearBean;
import com.bw.movie.bean.NowBean;
import com.bw.movie.bean.PlaceBean;
import com.bw.movie.bean.QgzBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ScheduleBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.util.HttpUtil;
import com.bw.mvplibrary.utils.CommonObserver;
import com.bw.mvplibrary.utils.CommonSchedulers;

/**
 * describe:IModel
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public class IModel implements Contract.IModel {
    @Override
    public void doLogin(String email, String pwd, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doLogin(email,pwd)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        iModelCallback.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doCode(String email, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doCode(email)
                .compose(CommonSchedulers.<CodeBean>io2main())
                .subscribe(new CommonObserver<CodeBean>() {
                    @Override
                    public void onNext(CodeBean codeBean) {
                        iModelCallback.onSuccessFul(codeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doRegister(String nickName, String pwd, String email, String code, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doRegister(nickName,pwd,email,code)
                .compose(CommonSchedulers.<RegisterBean>io2main())
                .subscribe(new CommonObserver<RegisterBean>() {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        iModelCallback.onSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doBanner(final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doBanner()
                .compose(CommonSchedulers.<BannerBean>io2main())
                .subscribe(new CommonObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        iModelCallback.onSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doNow(String userId, String sessionId, String page,String count,final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doNow(userId,sessionId,page,count)
                .compose(CommonSchedulers.<NowBean>io2main())
                .subscribe(new CommonObserver<NowBean>() {
                    @Override
                    public void onNext(NowBean nowBean) {
                        iModelCallback.onNowSuccess(nowBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doAfter(String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doAfter(page,count)
                .compose(CommonSchedulers.<AfterBean>io2main())
                .subscribe(new CommonObserver<AfterBean>() {
                    @Override
                    public void onNext(AfterBean afterBean) {
                        iModelCallback.onAfterSuccess(afterBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doHot(String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doHot(page,count)
                .compose(CommonSchedulers.<HotBean>io2main())
                .subscribe(new CommonObserver<HotBean>() {
                    @Override
                    public void onNext(HotBean hotBean) {
                        iModelCallback.onSuccessFul(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doAddress(final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doAddress()
                .compose(CommonSchedulers.<AddressBean>io2main())
                .subscribe(new CommonObserver<AddressBean>() {
                    @Override
                    public void onNext(AddressBean addressBean) {
                        iModelCallback.onSuccessFul(addressBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doPlace(String regionId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doPlace(regionId)
                .compose(CommonSchedulers.<PlaceBean>io2main())
                .subscribe(new CommonObserver<PlaceBean>() {
                    @Override
                    public void onNext(PlaceBean placeBean) {
                        iModelCallback.onSuccessFul(placeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doRec(String userId, String sessionId, String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doRec(userId,sessionId,page,count)
                .compose(CommonSchedulers.<RecommendBean>io2main())
                .subscribe(new CommonObserver<RecommendBean>() {
                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        iModelCallback.onSuccess(recommendBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doNear(String userId, String sessionId, String longitude, String latitude, String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doNear(userId,sessionId,longitude,latitude,page,count)
                .compose(CommonSchedulers.<NearBean>io2main())
                .subscribe(new CommonObserver<NearBean>() {
                    @Override
                    public void onNext(NearBean nearBean) {
                        iModelCallback.onSuccess(nearBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindCinema(String userId, String sessionId, String cinemaId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindCinema(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.<FindCinemaBean>io2main())
                .subscribe(new CommonObserver<FindCinemaBean>() {
                    @Override
                    public void onNext(FindCinemaBean findCinemaBean) {
                        iModelCallback.onSuccess(findCinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindMovies(String userId, String sessionId, String movieId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindMovies(userId,sessionId,movieId)
                .compose(CommonSchedulers.<FindMoviesBean>io2main())
                .subscribe(new CommonObserver<FindMoviesBean>() {
                    @Override
                    public void onNext(FindMoviesBean findMoviesBean) {
                        iModelCallback.onSuccess(findMoviesBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doComment(String userId, String sessionId, String movieId, String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doComment(userId,sessionId,movieId,page,count)
                .compose(CommonSchedulers.<MovieCommentBean>io2main())
                .subscribe(new CommonObserver<MovieCommentBean>() {
                    @Override
                    public void onNext(MovieCommentBean movieCommentBean) {
                        iModelCallback.onSuccess(movieCommentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doGreat(String userId, String sessionId, String commentId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doGreat(userId,sessionId,commentId)
                .compose(CommonSchedulers.<GreatBean>io2main())
                .subscribe(new CommonObserver<GreatBean>() {
                    @Override
                    public void onNext(GreatBean greatBean) {
                        iModelCallback.onSuccessFul(greatBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doGz(String userId, String sessionId, String movieId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doGz(userId,sessionId,movieId)
                .compose(CommonSchedulers.<GzBean>io2main())
                .subscribe(new CommonObserver<GzBean>() {
                    @Override
                    public void onNext(GzBean gzBean) {
                        iModelCallback.onSuccessFul(gzBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doQgz(String userId, String sessionId, String movieId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doQgz(userId,sessionId,movieId)
                .compose(CommonSchedulers.<QgzBean>io2main())
                .subscribe(new CommonObserver<QgzBean>() {
                    @Override
                    public void onNext(QgzBean qgzBean) {
                        iModelCallback.onNowSuccess(qgzBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doSchedule(String cinemaId, String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doSchedule(cinemaId, page, count)
                .compose(CommonSchedulers.<ScheduleBean>io2main())
                .subscribe(new CommonObserver<ScheduleBean>() {
                    @Override
                    public void onNext(ScheduleBean scheduleBean) {
                        iModelCallback.onSuccess(scheduleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doTime(final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doTime()
                .compose(CommonSchedulers.<TimeBean>io2main())
                .subscribe(new CommonObserver<TimeBean>() {
                    @Override
                    public void onNext(TimeBean timeBean) {
                        iModelCallback.onNowSuccess(timeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doBy(String regionId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doBy(regionId)
                .compose(CommonSchedulers.<ByCinemaBean>io2main())
                .subscribe(new CommonObserver<ByCinemaBean>() {
                    @Override
                    public void onNext(ByCinemaBean byCinemaBean) {
                        iModelCallback.onSuccessFul(byCinemaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindSc(String movieId, String cinemaId, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindSc(movieId,cinemaId)
                .compose(CommonSchedulers.<FindScheduleBean>io2main())
                .subscribe(new CommonObserver<FindScheduleBean>() {
                    @Override
                    public void onNext(FindScheduleBean findScheduleBean) {
                        iModelCallback.onSuccessFul(findScheduleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindCinemasInfoByRegion(String movieId, String regionId, String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindReg(movieId,regionId,page,count)
                .compose(CommonSchedulers.<FindCinemasInfoByRegion>io2main())
                .subscribe(new CommonObserver<FindCinemasInfoByRegion>() {
                    @Override
                    public void onNext(FindCinemasInfoByRegion findCinemasInfoByRegion) {
                        iModelCallback.onSuccess(findCinemasInfoByRegion);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindCinemasInfoByData(String movieId, String date, String page, String count, final IModelCallback iModelCallback) {
        HttpUtil.getInstance().getApiServer().doFindData(movieId,date,page,count)
                .compose(CommonSchedulers.<FindCinemasInfoByDate>io2main())
                .subscribe(new CommonObserver<FindCinemasInfoByDate>() {
                    @Override
                    public void onNext(FindCinemasInfoByDate findCinemasInfoByDate) {
                        iModelCallback.onAfterSuccess(findCinemasInfoByDate);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }
}
