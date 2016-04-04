package com.olab.ukrsibmap.view;

import android.app.Application;
import android.content.Context;

/**
 * Created by Oleg on 01/04/2016.
 */
public class MapApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
