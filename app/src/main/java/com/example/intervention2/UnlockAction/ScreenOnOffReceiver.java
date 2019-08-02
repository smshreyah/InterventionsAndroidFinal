package com.example.intervention2.UnlockAction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenOnOffReceiver extends BroadcastReceiver {

    private final static String SCREEN_TOGGLE_TAG = "SCREEN_TAG";

    @Override
    public void onReceive(Context context, Intent intent){

        Log.d(SCREEN_TOGGLE_TAG, "onReceive");

        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_OFF.equals(action)){
            Log.d(SCREEN_TOGGLE_TAG, "Screen is turned off");

        } else if (Intent.ACTION_SCREEN_ON.equals(action)){
            Log.d(SCREEN_TOGGLE_TAG, "Screen is turned on");
            Intent screenAction = new Intent(context, ScreenOnOffActivity.class);
            screenAction.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(screenAction);
        }
    }


}
