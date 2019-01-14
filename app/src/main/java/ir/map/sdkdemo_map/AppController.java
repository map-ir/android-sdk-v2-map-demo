package ir.map.sdkdemo_map;

import android.app.Application;

import ir.map.sdk_map.MapSDK;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MapSDK.init(this);
    }
}
