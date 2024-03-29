package com.bw.movie.util;

import com.bw.movie.ap.ApiServer;
import com.bw.mvplibrary.app.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * describe:HttpUtil
 * date:2019/11/11
 * author:任(Lenovo)
 * function:
 */
public class HttpUtil {
    private static HttpUtil httpUtil = new HttpUtil();
    private final ApiServer apiServer;

    public static HttpUtil getInstance(){
        return httpUtil;
    }
    public HttpUtil (){
        //拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        //OKHttp
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        //retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiServer = retrofit.create(ApiServer.class);
    }
    public ApiServer getApiServer(){
        return apiServer;
    }
}
