package com.example.intervention2.Notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class AlarmReceiver extends BroadcastReceiver{
    //Needed for creating notification

    private final static String SCREEN_TOGGLE_TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent background = new Intent(context, AlarmService.class);
        context.startService(background);
        //Log.d(SCREEN_TOGGLE_TAG, "AlarmReceiver");

    }
}