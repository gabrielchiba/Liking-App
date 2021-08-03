package com.example.likingapp.utils;
import android.content.Context;

public class AppUtils {
    Context context;

    public AppUtils(Context context) {
        this.context = context;
    }

    public String getTimeStamp() {
        long tsLong = System.currentTimeMillis() / 1000;
        return Long.toString(tsLong);
    }

}
