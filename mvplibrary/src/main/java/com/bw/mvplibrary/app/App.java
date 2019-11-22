package com.bw.mvplibrary.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    //全局上下文
    private static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        Fresco.initialize(this);
    }

    public static App getAppContext() {
        return sContext;
    }
}
