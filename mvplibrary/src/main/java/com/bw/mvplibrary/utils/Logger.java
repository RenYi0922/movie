package com.bw.mvplibrary.utils;

import android.util.Log;

/**
 * describe:Logger
 * date:2019/11/6
 * author:任(Lenovo)
 * function:
 */
public class Logger {
    public static boolean logOn = true;//正式上线时改为false

    public static void i(String tag, String msg) {
        if (logOn) {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable e) {
        if (logOn) {
            Log.i(tag, msg, e);
        }
    }

    public static void d(String tag, String msg) {
        if (logOn) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable e) {
        if (logOn) {
            Log.d(tag, msg, e);
        }

    }

    public static void e(String tag, String msg) {
        if (logOn) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        if (logOn) {
            Log.e(tag, msg, e);
        }
    }

    public static void v(String tag, String msg) {
        if (logOn) {
            Log.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, Throwable e) {
        if (logOn) {
            Log.v(tag, msg, e);
        }
    }
}
