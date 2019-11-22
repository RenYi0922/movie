package com.bw.movie.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * describe:MyCustomViewPager
 * date:2019/11/14
 * author:任(Lenovo)
 * function:
 */
public class MyCustomViewPager extends ViewPager {

    private boolean noScroll = true;

    public MyCustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (noScroll){
            return false;
        }else{
            return super.onTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (noScroll){
            return false;
        }else{
            return super.onInterceptTouchEvent(ev);
        }
    }
}
