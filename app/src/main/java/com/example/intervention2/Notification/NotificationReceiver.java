package com.example.intervention2.Notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.intervention2.AppConstant;

public class NotificationReceiver extends BroadcastReceiver {
    //Like/Dislike Notification

    @Override
    public void onReceive(Context context, Intent intent){
        String action = intent.getAction();
        if (AppConstant.YES_ACTION.equals(action)){
            Toast.makeText(context, "LIKED", Toast.LENGTH_SHORT).show();
            NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancelAll();
        }
        else if(AppConstant.NO_ACTION.equals(action)){
            Toast.makeText(context, "DISLIKED", Toast.LENGTH_SHORT).show();
            NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancelAll();
        }
    }
}
