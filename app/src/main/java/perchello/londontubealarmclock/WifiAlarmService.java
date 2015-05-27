package perchello.londontubealarmclock;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Perchello on 25/05/2015.
 */
public class WifiAlarmService extends Service {
    private List<ScanResult> mScanResultList;
    public WifiManager mWifiManager;
    public WifiScanReceiver mWifiReceiver;
    public String mCurrentStation;
    public Boolean mRepeatAlarm;
    public String mDestinationStation;
    public String mDestinationMac;




    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        if (intent == null) {
            Log.d ("WifiAlarmService: ", "Intent is null, terminating");
        } else {
            mDestinationStation = intent.getStringExtra("stationName");
            mDestinationMac = intent.getStringExtra("mac");

            mWifiReceiver = new WifiScanReceiver();

            Log.d("Status is ", Stations.mStatus);


            Log.d("WifiAlarmService :", "Station name is " + mDestinationStation + " and mac is " + mDestinationMac);
            mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            mCurrentStation = "";
            mRepeatAlarm = true;
            registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
            mWifiManager.startScan();
        }


    }


    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mScanResultList = mWifiManager.getScanResults();
            for (int i =0; i < mScanResultList.size(); i++) {
                Log.d("I am in onReceive Loop", "");

                if (mDestinationMac.contains (mScanResultList.get (i).BSSID.toString().toLowerCase())){
                    mCurrentStation=mDestinationStation;

                    createNotification();
                    mRepeatAlarm = false;
                    unregisterReceiver(mWifiReceiver);
                    i = mScanResultList.size();
                }

            }
            if (mRepeatAlarm ) {
                unregisterReceiver(mWifiReceiver);
                if (Stations.mStatus.equals("true")) {
                    startAlarmManager();
                }
            }

        }

        private void createNotification() {
            Intent intent1 = new Intent(WifiAlarmService.this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(WifiAlarmService.this, 0, intent1, 0);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification n = new Notification.Builder(WifiAlarmService.this)
                    .setContentTitle("You arrived to " + mDestinationStation)
                    .setContentText(mCurrentStation)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
                    .getNotification();

            notificationManager.notify(0, n);
        }


        public void startAlarmManager() {

            Intent myIntent = new Intent(WifiAlarmService.this, WifiReceiver.class);
            myIntent.putExtra("stationName", mDestinationStation);
            myIntent.putExtra("mac", mDestinationMac);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(WifiAlarmService.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(), pendingIntent);
        }


    }


}
