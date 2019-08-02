package com.example.intervention2.Notification;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.intervention2.AppConstant;
import com.example.intervention2.MainActivity;
import com.example.intervention2.R;

import java.util.Random;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

public class AlarmService extends Service {
    //Creates notification

    private boolean isRunning;
    private Context context;
    private Thread backgroundThread;
    private static final String CHANNEL_ID = "alarm_channel";
    private final static String SCREEN_TOGGLE_TAG = "AlarmService";
    private String interventionNotification;
    boolean liked;
    boolean disliked;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        this.context = this;
        this.isRunning = false;
        this.backgroundThread = new Thread(myTask);
        Log.d(SCREEN_TOGGLE_TAG, "AlarmService: onCreate");
        liked = false;
        disliked = false;

    }

    private Runnable myTask = new Runnable() {
        public void run() {
           // Log.d(SCREEN_TOGGLE_TAG, "AlarmService: run");
            // Do something here
            Random random = new Random();
            int rand_int= random.nextInt(13);
            interventionNotification = MainActivity.getInterventionString(rand_int);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setContentTitle("Take a small break:")
                    .setContentText(interventionNotification)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(interventionNotification))
                    .setTicker("Take a small break")
                    .setSmallIcon(R.drawable.lotus)
                    .setAutoCancel(true);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            Intent likedReceive = new Intent();
            likedReceive.setAction(AppConstant.YES_ACTION);
            PendingIntent pendingIntentYes = PendingIntent.getBroadcast(context, 123, likedReceive, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.addAction(R.mipmap.ic_launcher, "Like", pendingIntentYes);

            Intent dislikedReceive = new Intent();
            dislikedReceive.setAction(AppConstant.NO_ACTION);
            PendingIntent pendingIntentNo = PendingIntent.getBroadcast(context, 123, dislikedReceive, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.addAction(R.mipmap.ic_launcher_round, "Dislike", pendingIntentNo);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                builder.setChannelId(CHANNEL_ID);
            }



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "NotificationDemo", IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }
            notificationManager.notify(0, builder.build());
            stopSelf();
        }
    };

    @Override
    public void onDestroy() {
        this.isRunning = false;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!this.isRunning) {
            this.isRunning = true;
            this.backgroundThread.start();
        }
        return START_STICKY;
    }
}