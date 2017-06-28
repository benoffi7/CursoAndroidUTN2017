package com.coffeeandcookies.curso2017;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Gonzalo on 28/06/2017.
 */

public class app extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
