package com.bw.movie.presenter;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.contract.Contract;
import com.bw.movie.model.IModel;
import com.bw.mvplibrary.app.Constant;
import com.bw.mvplibrary.base.BasePresenter;

/**
 * describe:Presenter
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public class Presenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private IModel iModel;

    @Override
    public void doLogin(String email, String pwd) {
        iModel.doLogin(email, pwd, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                if (isViewAttached()) {
                    LoginBean loginBean = (LoginBean) obj;
                    if (loginBean!=null&& Constant.SUCCESS_CODE.equals(loginBean.getStatus())) {
                        getView().onSuccess(loginBean);
                    }else {
                        getView().onFail("服务器异常");
                    }
                }
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                if (isViewAttached()) {
                    getView().onFail(str);
                }
            }
        });
    }

    @Override
    public void doCode(String email) {
        iModel.doCode(email, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doRegister(String nickName, String pwd, String email, String code) {
        iModel.doRegister(nickName, pwd, email, code, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doBanner() {
        iModel.doBanner(new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doNow(String userId, String sessionId,String page,String count) {
        iModel.doNow(userId, sessionId,page,count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {
                getView().onNowSuccess(now);
            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doAfter(String page, String count) {
        iModel.doAfter(page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {
                getView().onAfterSuccess(after);
            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doHot(String page, String count) {
        iModel.doHot(page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doAddress() {
        iModel.doAddress(new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doPlace(String regionId) {
        iModel.doPlace(regionId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doRec(String userId, String sessionId, String page, String count) {
        iModel.doRec(userId, sessionId, page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doNear(String userId, String sessionId, String longitude, String latitude, String page, String count) {
        iModel.doNear(userId, sessionId, longitude, latitude, page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindCinema(String userId, String sessionId, String cinemaId) {
        iModel.doFindCinema(userId, sessionId, cinemaId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindMovies(String userId, String sessionId, String movieId) {
        iModel.doFindMovies(userId, sessionId, movieId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doComment(String userId, String sessionId, String movieId, String page, String count) {
        iModel.doComment(userId, sessionId, movieId, page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doGreat(String userId, String sessionId, String commentId) {
        iModel.doGreat(userId, sessionId, commentId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doGz(String userId, String sessionId, String movieId) {
        iModel.doGz(userId, sessionId, movieId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doQgz(String userId, String sessionId, String movieId) {
        iModel.doQgz(userId, sessionId, movieId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {
                getView().onNowSuccess(now);
            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doSchedule(String cinemaId, String page, String count) {
        iModel.doSchedule(cinemaId, page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doTime() {
        iModel.doTime(new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {
                getView().onNowSuccess(now);
            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doBy(String regionId) {
        iModel.doBy(regionId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindSc(String movieId, String cinemaId) {
        iModel.doFindSc(movieId, cinemaId, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {
                getView().onSuccessFul(object);
            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindCinemasInfoByRegion(String movieId, String regionId, String page, String count) {
        iModel.doFindCinemasInfoByRegion(movieId, regionId, page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doFindCinemasInfoByData(String movieId, String date, String page, String count) {
        iModel.doFindCinemasInfoByData(movieId, date, page, count, new Contract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessFul(Object object) {

            }

            @Override
            public void onNowSuccess(Object now) {

            }

            @Override
            public void onAfterSuccess(Object after) {
                getView().onAfterSuccess(after);
            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    protected void initModel() {
        iModel = new IModel();
    }
}
