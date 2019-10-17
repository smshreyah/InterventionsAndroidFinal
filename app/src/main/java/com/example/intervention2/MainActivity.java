package com.example.intervention2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

import com.aware.Aware;
import com.aware.Aware_Preferences;
import com.aware.ESM;
import com.example.intervention2.Notification.AlarmReceiver;
import com.example.intervention2.UnlockAction.ScreenOnOffReceiver;
import com.example.intervention2.UnlockAction.ScreenReceiver;


public class MainActivity extends AppCompatActivity {

    private final static String SCREEN_TOGGLE_TAG = "MainActivity";

    private ScreenOnOffReceiver screenOnOffReceiver = null;
    private AlarmReceiver alarmReceiver = null;
    public ESM ESM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_feeling_survey);

        //Initializing AWARE
        Intent aware = new Intent(getApplicationContext(), Aware.class);
        startService(aware);

        //initializing ESM queue
        ESM = new ESM();
        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_ESM, true);

        //AWARE: (testing accelerometer only first) in onCreate methods in activities/services
        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_ACCELEROMETER, true);
        Aware.setSetting(getApplicationContext(), Aware_Preferences.FREQUENCY_ACCELEROMETER, 200000);
        Aware.startAccelerometer(getApplicationContext());

        //Joining AWARE study
        Aware.joinStudy(getApplicationContext(), "https://compwell.ece.rice.edu/AWARE/index.php/webservice/index/2/Yc0ElAuSrvwv");

        //Screen Activity (AWARE)
        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_SCREEN, true);
        ScreenReceiver unlockingAction = new ScreenReceiver();
        registerReceiver(unlockingAction, new IntentFilter());

        //Sending data between client and server
        Intent remoteDataOffloading = new Intent(MainActivity.this, RemoteDataOffloading.class);
        startService(remoteDataOffloading); //background service for sending data

        //notifications
        Intent alarm = new Intent(this, AlarmReceiver.class);
        alarmReceiver = new AlarmReceiver();
        registerReceiver(alarmReceiver, new IntentFilter());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarm, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 60000, pendingIntent);

        //The following are some capabilities I originally used through Android, but I now implemented them above with AWARE
        //Services
//        Intent backgroundService = new Intent(this, ScreenOnOffBackgroundService.class);
//        startService(backgroundService); //background service for unlock action

        //Receiver
//        IntentFilter intentFilter = new IntentFilter(); //Create an IntentFilter Instance
//        intentFilter.addAction("android.intent.action.SCREEN_ON"); ////Add network connectivity change action
//        intentFilter.addAction("android.intent.action.SCREEN_OFF");
//        intentFilter.setPriority(100); //Setting broadcast receiver priority

//        screenOnOffReceiver = new ScreenOnOffReceiver(); //create a network change broadcast receiver
//        registerReceiver(screenOnOffReceiver, intentFilter); //register the broadcast receiver with the intent filter object

    }

    @Override
    public void onStart(){
        super.onStart();
        //Every time the app starts
        Log.d(SCREEN_TOGGLE_TAG, "onStart()");
        Intent intentGeneral = new Intent(MainActivity.this, GeneralFeelingSurvey.class);
        startActivity(intentGeneral);
    }

    @Override
    public void onResume(){
        super.onResume();
        //App resumes
        Log.d(SCREEN_TOGGLE_TAG, "onResume");
        Intent intentGeneral = new Intent(MainActivity.this, GeneralFeelingSurvey.class);
        startActivity(intentGeneral);

    }

    @Override
    public void onRestart(){
        super.onRestart();
        //After app restarts
        Log.d(SCREEN_TOGGLE_TAG, "onResume");
        Intent intentGeneral = new Intent(MainActivity.this, GeneralFeelingSurvey.class);
        startActivity(intentGeneral);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }

    public static String getInterventionString(int rand) {
        //For notifications - easy interventions that don't require a link (check notification folder for classes)
        if (rand == 0) {
            return "Close your eyes and take a couple of deep breaths...";
        } else if (rand == 1) {
            return "Grab a coffee or take a short walk with someone";
        } else if (rand == 2) {
            return "Change your posture and sit up straight";
        } else if (rand == 3) {
            return "Stand up and take a quick stretch";
        } else if (rand == 4) {
            return "Walk to a friends office and have a quick chat";
        } else if (rand == 5) {
            return "Smile!";
        } else if (rand == 6) {
            return "Ask a friend to make a funny face…";
        } else if (rand == 7) {
            return "Make the familiar new again. Pick one picture of an object and observe it mindfully for a couple of minutes.";
        } else if (rand == 8) {
            return "Relax and listen to a song you really like.";
        } else if (rand == 9){
            return "Remember a beautiful moment in your recent past";
        } else if (rand == 10){
            return "Give somebody a pat on the back for any good reason";
        } else if (rand == 11){
            return "Write down a small step towards a goal";
        } else if (rand == 12){
            return "Take a moment to reflect upon a hard situation a friend/family is going through";
        } else {
            return "Write down a very simple goal you want to accomplish this week";
        }
    }

}
