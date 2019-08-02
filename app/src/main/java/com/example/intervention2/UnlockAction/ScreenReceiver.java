package com.example.intervention2.UnlockAction;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.aware.Aware;
import com.aware.ESM;
import com.aware.Screen;
import com.aware.providers.Accelerometer_Provider;
import com.aware.ui.ESM_Queue;
import com.aware.ui.esms.ESMFactory;
import com.aware.ui.esms.ESM_QuickAnswer;
import com.aware.utils.DatabaseHelper;
import com.aware.utils.Https;

import org.json.JSONException;

import java.util.Hashtable;

public class ScreenReceiver extends BroadcastReceiver {
    //AWARE version of screen on off. Implemented so we can keep track of this data through aware

    private Thread screenActivityThread;
    private static Context context;

    private static final String TAG = "ScreenReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        final PendingResult pendingResult = goAsync();
        Task asyncTask = new Task(pendingResult, intent);
        this.context = context;
        asyncTask.execute();
    }

    private static class Task extends AsyncTask<String, Integer, String> {

        private final PendingResult pendingResult;
        private final Intent intent;

        private Task(PendingResult pendingResult, Intent intent) {
            this.pendingResult = pendingResult;
            this.intent = intent;
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder sb = new StringBuilder();
            sb.append("Action: " + intent.getAction() + "\n");
            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
            String log = sb.toString();
            Log.d(TAG, log);
            if (Screen.ACTION_AWARE_SCREEN_UNLOCKED.equals(log)) {
                onPostExecute(log);
            }
            return log;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                ESMFactory factory = new ESMFactory();

                //define ESM question
                ESM_QuickAnswer esmQuickAnswer = new ESM_QuickAnswer();
                esmQuickAnswer.addQuickAnswer("Yes")
                        .addQuickAnswer("No")
                        .setInstructions("Quick Answers ESM");

                //add them to the factory
                factory.addESM(esmQuickAnswer);

                //Queue them
                ESM.queueESM(context, factory.build());

                // Must call finish() so the BroadcastReceiver can be recycled.
                pendingResult.finish();
            }
            catch(JSONException e) {
                e.printStackTrace();
            }
        }

    }

}
