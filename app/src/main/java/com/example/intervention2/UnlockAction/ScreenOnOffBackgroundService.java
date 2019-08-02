package com.example.intervention2.UnlockAction;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class ScreenOnOffBackgroundService extends Service {
    //Needed for ScreenOnOff activity

    private ScreenOnOffReceiver screenOnOffReceiver = null;
    private final static String SCREEN_TOGGLE_TAG = "ScreenOnOffActivity";

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        return super.onStartCommand(intent,flags, startId);
    }


    @Override
    public void onCreate(){
        super.onCreate();

        Log.d(SCREEN_TOGGLE_TAG, "onCreate");

        //Creating IntentFilter instance
        IntentFilter intentFilter = new IntentFilter();

        //Add network connectivity change action
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");

        //Set broadcast receiver priority
        intentFilter.setPriority(100);

        //Create a network change broadcast receiver
        screenOnOffReceiver = new ScreenOnOffReceiver();

        //Register broadcast receiver with the intent filter object
        registerReceiver(screenOnOffReceiver, intentFilter);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        //unregister screenOnOffReceiver when destroy
//        if (screenOnOffReceiver != null){
//            unregisterReceiver(screenOnOffReceiver);
//        }
    }

}
