package perchello.londontubealarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<ScanResult> mScanResultList;
    PendingIntent mPendingIntent;
    public TextView mWifiTextView;
    public Button mSetAlarmButton;
    public Button mCancelAlarmButton;
    public WifiManager mWifiManager;
    public WifiScanReceiver mWifiReceiver;
    public Button mGetNewWifiButton;
    public String mCurrentStation;
    public Boolean mIsWifiReceiverRegistered = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentStation = "N/A";
        mWifiTextView = (TextView) findViewById(R.id.wifiTextView);
        mWifiTextView.setText(mCurrentStation);
        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        mWifiReceiver = new WifiScanReceiver();
        registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mIsWifiReceiverRegistered = true;
        mSetAlarmButton = (Button) findViewById(R.id.setAlarmButton);
        mSetAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsWifiReceiverRegistered){
                    registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
                    mIsWifiReceiverRegistered = true;
                }
                Intent myIntent = new Intent(MainActivity.this, WifiReceiver.class);
                Stations stations = new Stations();
                Stations.mStatus = "true";

                myIntent.putExtra("stationName", "Canning Town");
                myIntent.putExtra("mac", stations.getMac(0));
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mPendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(), mPendingIntent);
            }
        });


        mCancelAlarmButton = (Button) findViewById(R.id.cancelAlarmButton);
        mCancelAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stations.mStatus = "false";

                if (mIsWifiReceiverRegistered){
                    unregisterReceiver(mWifiReceiver);
                    mIsWifiReceiverRegistered = false;
                }
                Intent intent = new Intent(MainActivity.this, WifiReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);

            }
        });
        mGetNewWifiButton = (Button) findViewById(R.id.getWifiButton);
        mGetNewWifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetWifiActivity.class);
                startActivity(intent);
            }
        });

        mWifiManager.startScan();

    }


        @Override
    public void onPause() {
        super.onPause();
        if (mIsWifiReceiverRegistered) {
            unregisterReceiver(mWifiReceiver);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mIsWifiReceiverRegistered = true;
        mWifiManager.startScan();

    }
    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Stations stations = new Stations();
                        mScanResultList = mWifiManager.getScanResults();
            for (int i = 0; i<mScanResultList.size(); i++){
                Log.d ("MainActivity",mScanResultList.get(i).BSSID);
                if (!mCurrentStation.equals (stations.compareMacs(mScanResultList.get(i).BSSID)) && stations.compareMacs(mScanResultList.get(i).BSSID)!=null) {
                    mCurrentStation = stations.compareMacs(mScanResultList.get(i).BSSID);
                    mWifiTextView.setText(mCurrentStation);
                }
            }
            mWifiManager.startScan();

        }
    }


}



