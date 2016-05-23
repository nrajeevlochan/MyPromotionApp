package com.mypromotionapp;

import android.app.Application;
import android.util.Log;

import com.android.volley.toolbox.ImageLoader;

import java.util.PriorityQueue;

/**
 * Created by ${} on 5/22/16.
 */
public class MyPromotionCardApplication extends Application {

    private static final String TAG = MyPromotionCardApplication.class.getName();
    private static MyPromotionCardApplication mInstance = new MyPromotionCardApplication();
    private static ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        imageLoader = MyVolleyRequest.getInstance(getApplicationContext()).getImageLoader();
        Log.d(TAG, "imageLoader" + imageLoader);
    }

    public static MyPromotionCardApplication getInstance() {
        return mInstance;
    }

    public ImageLoader getImageLoader()
    {
        return imageLoader;
    }
}
