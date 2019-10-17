package com.example.intervention2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.util.Log;

import com.aware.providers.Accelerometer_Provider;
import com.aware.utils.DatabaseHelper;
import com.aware.utils.Https;
import com.aware.utils.SSLManager;

import java.security.cert.Certificate;
import java.util.Hashtable;

public class RemoteDataOffloading extends Service {

    private boolean isRunning;
    private Context context;
    private Thread dataOffloadingThread;
    private final String TAG = "REMOTEDATA: ";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        this.context = this;
        this.isRunning = false;
        this.dataOffloadingThread = new Thread(myTask);
    }

    private Runnable myTask = new Runnable() {
        public void run() {
            //Get the last 1000 records from accelerometer
            Cursor accelerometer_data = getContentResolver().query(Accelerometer_Provider.Accelerometer_Data.CONTENT_URI, null, null, null, Accelerometer_Provider.Accelerometer_Data.TIMESTAMP + "DESC LIMIT 1000");
            if (accelerometer_data != null && accelerometer_data.getCount() > 0) {
                Https https = new Https(getResources().openRawResource(R.raw.compwell)); //put your certificate in /res/raw/your_certificate.crt
                Hashtable<String, String> postData = new Hashtable<>();
                postData.put("accelerometer_data", DatabaseHelper.cursorToString(accelerometer_data));
                https.dataPOST("https://compwell.ece.rice.edu", postData, false); //set to true if your server supports gzip compression
            }
            if (accelerometer_data != null && !accelerometer_data.isClosed())
                accelerometer_data.close();
        }

    };
}
