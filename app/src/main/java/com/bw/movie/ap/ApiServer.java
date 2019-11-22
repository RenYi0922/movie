package com.bw.movie.ap;

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

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * describe:Apiserver
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public interface ApiServer {
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> doLogin(@Field("email") String email, @Field("pwd") String pwd);
    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<CodeBean> doCode(@Field("email") String email);
    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<RegisterBean> doRegister(@Field("nickName") String nickName,@Field("pwd") String pwd,@Field("email") String email,@Field("code") String code);
    @GET("tool/v2/banner")
    Observable<BannerBean> doBanner();
    @GET("movie/v2/findHotMovieList")
    Observable<HotBean> doHot(@Query("page") String page, @Query("count") String count);
    @GET("movie/v2/findComingSoonMovieList")
    Observable<NowBean> doNow(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("page") String page, @Query("count") String count);
    @GET("movie/v2/findReleaseMovieList")
    Observable<AfterBean> doAfter(@Query("page") String page, @Query("count") String count);
    @GET("tool/v2/findRegionList")
    Observable<AddressBean> doAddress();
    @GET("cinema/v2/findCinemaByRegion")
    Observable<PlaceBean> doPlace(@Query("regionId") String regionId);
    @GET("cinema/v1/findNearbyCinemas")
    Observable<NearBean> doNear(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("longitude") String longitude,@Query("latitude") String latitude,@Query("page") String page, @Query("count") String count);
    @GET("cinema/v1/findRecommendCinemas")
    Observable<RecommendBean> doRec(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("page") String page, @Query("count") String count);
    @GET("cinema/v1/findCinemaInfo")
    Observable<FindCinemaBean> doFindCinema(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("cinemaId") String cinemaId);
    @GET("movie/v2/findMoviesDetail")
    Observable<FindMoviesBean> doFindMovies(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("movieId") String movieId);
    @GET("movie/v2/findAllMovieComment")
    Observable<MovieCommentBean> doComment(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("movieId") String movieId,@Query("page") String page, @Query("count") String count);
    @FormUrlEncoded
    @POST("movie/v1/verify/movieCommentGreat")
    Observable<GreatBean> doGreat(@Header("userId") String userId,@Header("sessionId") String sessionId,@Field("commentId") String commentId);
    @GET("movie/v1/verify/followMovie")
    Observable<GzBean> doGz(@Header("userId") String userId,@Header("sessionId") String sessionId,@Query("movieId") String movieId);
    @GET("movie/v1/verify/cancelFollowMovie")
    Observable<QgzBean> doQgz(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("movieId") String movieId);
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<ScheduleBean> doSchedule(@Query("cinemaId") String cinemaId,@Query("page") String page, @Query("count") String count);
    @GET("tool/v2/findDateList")
    Observable<TimeBean> doTime();
    @GET("cinema/v2/findCinemaByRegion")
    Observable<ByCinemaBean> doBy(@Query("regionId") String regionId);
    @GET("movie/v2/findMovieSchedule")
    Observable<FindScheduleBean> doFindSc(@Query("movieId") String movieId,@Query("cinemaId") String cinemaId);
    @GET("movie/v2/findCinemasInfoByRegion")
    Observable<FindCinemasInfoByRegion> doFindReg(@Query("movieId") String movieId,@Query("regionId") String regionId,@Query("page") String page,@Query("count") String count);
    @GET("movie/v2/findCinemasInfoByDate")
    Observable<FindCinemasInfoByDate> doFindData(@Query("movieId") String movieId, @Query("date") String date, @Query("page") String page, @Query("count") String count);
}
