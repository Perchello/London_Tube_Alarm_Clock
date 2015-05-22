package perchello.londontubealarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<ScanResult> mScanResultList;
    public TextView mWifiTextView;
    public WifiManager mWifiManager;

    public WifiScanReceiver mWifiReceiver;
    public Button mGetNewWifiButton;
    private PendingIntent pendingIntent;
    public Button mStopAlarmButton;
    public String mFincheleyCentral;
    public String mEastFinchley;
    public String mHighgate;
    public String mArchway;
    public String mTufnellPark;
    public String mCamdenTown;
    public String mEuston;
    public String mKentishTown;
    public String mKingsCross;
    public String mAngel;
    public String mOldStreet;
    public String mMoorgate;
    public String mBank;
    public String mLondonBridge;
    public String mBermondsey;
    public String mCanadaWater;
    public String mCanaryWharf;
    public String mNorthGreenwich;
    public String mCanningTown;
    public String mAndrewOffice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        //pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        //AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 5, pendingIntent);

        setStationNames();
        mStopAlarmButton = (Button) findViewById(R.id.stopAlarmButton);
        mWifiTextView = (TextView) findViewById(R.id.wifiTextView);

       mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
       mWifiReceiver = new WifiScanReceiver();
       registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        mGetNewWifiButton = (Button) findViewById(R.id.getWifiButton);
        mGetNewWifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetWifiActivity.class);
                startActivity(intent);
            }
        });
        /*mStopAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentstop = new Intent(MainActivity.this, AlarmReceiver.class);
                PendingIntent senderstop = PendingIntent.getBroadcast(MainActivity.this,
                        0, intentstop, 0);
                AlarmManager alarmManagerStop = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManagerStop.cancel(senderstop);
            }
        });*/

       mWifiManager.startScan();

    }

    @Override
    public void onPause() {
        super.onPause();

        unregisterReceiver(mWifiReceiver);

    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

    }

    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mScanResultList = mWifiManager.getScanResults();

            for (int i =0; i < mScanResultList.size(); i++) {
                Log.d("Network name is :" + mScanResultList.get (i).SSID.toString().toLowerCase()+" :", mScanResultList.get (i).BSSID.toString().toLowerCase());

                if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("00:62:2c:72:9c:f4")){
                    mWifiTextView.setText("George Home");
                    i = mScanResultList.size();
                }
                else if (mAndrewOffice.contains(mScanResultList.get(i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Rudenko Office");
                    /*Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();*/
                    i = mScanResultList.size();
                }
                else if (mFincheleyCentral.contains(mScanResultList.get(i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Archway");
                    i = mScanResultList.size();
                }
                else if (mEastFinchley.contains(mScanResultList.get(i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("East Finchley");
                    i = mScanResultList.size();
                }
                else if (mHighgate.contains(mScanResultList.get(i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Highgate");
                    i = mScanResultList.size();
                }
                else if (mArchway.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Archway");
                    i = mScanResultList.size();
                }
                else if (mTufnellPark.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Tufnell Park");
                    i = mScanResultList.size();
                }
                else if (mKentishTown.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Kentish Town");
                    i = mScanResultList.size();
                }
                else if (mCamdenTown.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Camden Town");
                    i = mScanResultList.size();
                }
                else if (mEuston.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Euston");
                    i = mScanResultList.size();
                }
                else if (mKingsCross.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Kings Cross");
                    i = mScanResultList.size();
                }
                else if (mAngel.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Angel");
                    i = mScanResultList.size();
                }
                else if (mOldStreet.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Old Street");
                    i = mScanResultList.size();
                }
                else if (mMoorgate.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Moorgate");
                    i = mScanResultList.size();
                }
                else if (mBank.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Bank");
                    i = mScanResultList.size();
                }
                else if (mLondonBridge.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("London Bridge");
                    i = mScanResultList.size();
                }
                else if (mBermondsey.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Bermondsey");
                    i = mScanResultList.size();
                }
                else if (mCanadaWater.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Canada Water");
                    i = mScanResultList.size();
                }
                else if (mCanaryWharf.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Canary Wharf");
                    i = mScanResultList.size();
                }
                else if (mNorthGreenwich.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Highgate");
                    i = mScanResultList.size();
                }
                else if (mCanningTown.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Highgate");
                    i = mScanResultList.size();
                }


            }
            mWifiManager.startScan();

        }


    }

    private void setStationNames(){
        mAndrewOffice = "c8:bc:c8:fd:9d:95";
        mFincheleyCentral = "c8:f9:f9:4d:f0:d3 c8:f9:f9:4d:f0:d1 2c:36:f8:0f:3a:c3 2c:36:f8:0f:3a:ce 2c:36:f8:0f:3a:c0 2c:36:f8:0f:3a:c1 2c:36:f8:0f:3a:cf 2c:36:f8:0f:3a:cc 2c:36:f8:0f:3a:c9 2c:36:f8:0f:3a:cb 2c:36:f8:0f:3a:c8 2c:36:f8:0f:3a:ca 2c:36:f8:0f:3a:c7 c8:f9:f9:4d:f0:d0 c8:f9:f9:4d:f0:d8 c8:f9:f9:4d:f0:da c8:f9:f9:4d:f0:df c8:f9:f9:4d:f0:de c8:f9:f9:4d:f0:d7 c8:f9:f9:4d:f0:d9 c8:f9:f9:4d:f0:dc 2c:36:f8:0f:3a:c2 c8:f9:f9:4d:f0:d2 2c:36:f8:0f:3a:cd c8:f9:f9:4d:f0:dd c8:f9:f9:4d:f0:d5 2c:36:f8:0f:3a:c8 2c:36:f8:0f:3a:c5 2c:36:f8:0f:51:3f 2c:36:f8:0f:51:30 2c:36:f8:0f:51:33 2c:36:f8:0f:51:38 2c:36:f8:0f:51:39 2c:36:f8:0f:51:3a 2c:36:f8:0f:51:3c 2c:36:f8:0f:51:31 2c:36:f8:0f:51:37 2c:36:f8:0f:51:3b 2c:36:f8:0f:45:a1 2c:36:f8:0f:51:34 2c:36:f8:0f:3f:0f 2c:36:f8:0f:51:3e c8:f9:f9:29:04:b6 2c:36:f8:0f:3f:0b 2c:36:f8:0f:3f:0d c8:f9:f9:29:04:b3 2c:36:f8:0f:51:38 2c:36:f8:0f:45:a0 2c:36:f8:0f:45:a6 2c:36:f8:0f:3f:00 2c:36:f8:0f:3f:09 2c:36:f8:0f:3f:0a 2c:36:f8:0f:3f:0c 2c:36:f8:0f:45:a8 2c:36:f8:0f:3f:05 c8:f9:f9:29:04:b1 2c:36:f8:0f:45:a3 2c:36:f8:0f:2a:f9 2c:36:f8:0f:2a:fc 2c:36:f8:0f:2a:f8 2c:36:f8:0f:2a:fa 2c:36:f8:0f:22:60 2c:36:f8:0f:22:65 2c:36:f8:0f:45:a4 2c:36:f8:0f:2a:f0 2c:36:f8:0f:2a:f8 c8:f9:f9:29:04:ba 3c:ce:73:f8:30:00 c8:f9:f9:29:04:b7 c8:f9:f9:29:04:be 2c:36:f8:0f:2a:fe 3c:ce:73:f8:30:01 3c:ce:73:f8:30:03 2c:36:f8:0f:2a:ff c8:f9:f9:29:04:bf c8:f9:f9:29:04:bc 3c:ce:73:f8:30:06 2c:36:f8:0f:2a:f5 c8:f9:f9:29:04:b8 c8:f9:f9:29:04:bb 2c:36:f8:0f:34:24 2c:b0:5d:d6:e5:bd 2c:36:f8:0f:51:3d 2c:36:f8:0f:51:32 c8:f9:f9:29:04:b2 2c:36:f8:0f:45:a2 2c:36:f8:0f:3f:0e 2c:36:f8:0f:3f:01 2c:36:f8:0f:2a:fd 3c:ce:73:f8:30:02 2c:36:f8:0f:22:61 2c:36:f8:0f:34:22 c8:f9:f9:29:04:bd 02:33:bb:88:39:d6 12:33:bb:88:39:d6 c8:f9:f9:4d:f0:db c8:f9:f9:4d:f0:dd c8:f9:f9:4d:f0:d1 c8:f9:f9:4d:f0:d3 c8:f9:f9:4d:f0:d0 c8:f9:f9:4d:f0:d2 c8:f9:f9:4d:f0:d5 c8:f9:f9:4d:f0:d7 ";
        mEastFinchley = "64:e9:50:96:23:93 64:e9:50:05:e0:9c b0:e0:3c:62:2f:b4 64:e9:50:05:e0:91 64:e9:50:05:e0:93 64:e9:50:96:0b:31 64:e9:50:96:0b:30 64:e9:50:05:e0:90 64:e9:50:96:05:4e 64:e9:50:96:05:4d 64:e9:50:05:fa:ca 64:e9:50:05:fa:cd 64:e9:50:05:fa:c3 64:e9:50:96:05:4b 64:e9:50:05:fa:cc 64:e9:50:96:05:4c 64:e9:50:96:05:4a 64:e9:50:05:fa:ce 6c:99:89:92:d4:e3 2c:3e:cf:f1:1a:63 2c:3e:cf:f0:05:d3 64:e9:50:05:fa:cf 64:e9:50:96:05:4f 64:e9:50:96:23:91 64:e9:50:96:23:92 2c:3e:cf:f0:05:d1 6c:99:89:92:d4:e2 6c:99:89:92:d4:e4 6c:99:89:92:d4:e0 64:e9:50:96:05:43 64:e9:50:96:05:42 64:e9:50:96:05:41 64:e9:50:96:05:4b 64:e9:50:96:05:4e 64:e9:50:96:05:4d 64:e9:50:96:05:40 64:e9:50:96:05:4f 64:e9:50:05:fa:cd 64:e9:50:05:fa:cb 64:e9:50:05:fa:ca 64:e9:50:05:fa:cc 64:e9:50:05:fa:ce 64:e9:50:05:fa:cf 64:e9:50:05:fa:c2 64:e9:50:05:e0:9d 64:e9:50:05:e0:9e 64:e9:50:96:25:41 64:e9:50:05:e0:9a 64:e9:50:05:e0:9c 64:e9:50:05:fa:c4 64:e9:50:96:05:44 64:e9:50:96:25:42 64:e9:50:96:0b:31 6c:99:89:93:25:94 6c:99:89:93:25:92 6c:99:89:93:25:90 ";
        mHighgate = "3c:ce:73:f6:c7:2e 3c:ce:73:f6:c7:2a 3c:ce:73:f6:c7:2c 3c:ce:73:f6:c7:28 3c:ce:73:f6:c7:2b 3c:ce:73:f6:c7:2f 3c:ce:73:f6:c7:20 3c:ce:73:f6:c7:21 3c:ce:73:f6:c7:23 c8:f9:f9:72:31:0f c8:f9:f9:72:31:0c c8:f9:f9:72:31:0e c8:f9:f9:72:31:03 c8:f9:f9:72:31:01 c8:f9:f9:72:31:00 3c:ce:73:f6:c7:2d 3c:ce:73:f6:c7:22 c8:f9:f9:72:31:0d c8:f9:f9:72:31:02 c8:f9:f9:72:31:0a c8:f9:f9:72:31:0b 3c:ce:73:f6:c7:27 c8:f9:f9:72:31:08 c8:f9:f9:72:31:07 3c:ce:73:f8:80:ef 3c:ce:73:f8:80:eb 3c:ce:73:f8:80:ec 3c:ce:73:f8:80:e7 3c:ce:73:f8:80:e3 3c:ce:73:f8:80:e1 3c:ce:73:f8:80:e8 c8:f9:f9:72:31:07 3c:ce:73:f8:80:ee 3c:ce:73:f8:80:e0 3c:ce:73:f8:80:ed 3c:ce:73:f8:80:e2 ";
        mArchway = "c8:f9:f9:4c:94:79 c8:f9:f9:4c:94:71 c8:f9:f9:4c:94:7b c8:f9:f9:4c:94:7c c8:f9:f9:4c:94:74 c8:f9:f9:4c:94:7f c8:f9:f9:4c:94:78 c8:f9:f9:4c:94:7e c8:f9:f9:4c:94:73 c8:f9:f9:4c:94:7a c8:f9:f9:4c:74:d4 c8:f9:f9:4c:74:de c8:f9:f9:4c:74:dc c8:f9:f9:4c:74:da c8:f9:f9:4c:74:d9 c8:f9:f9:4c:74:df c8:f9:f9:4c:74:db c8:f9:f9:4c:94:72 c8:f9:f9:4c:94:7d c8:f9:f9:4c:74:dd c8:f9:f9:4c:74:d1 c8:f9:f9:4c:74:d3 c8:f9:f9:4c:74:d2 c8:f9:f9:2b:ee:8c c8:f9:f9:2b:ee:8e c8:f9:f9:2b:ee:8f c8:f9:f9:2b:ee:89 c8:f9:f9:2b:ee:8b c8:f9:f9:2b:ee:88 c8:f9:f9:2b:ee:8a c8:f9:f9:2b:ee:83 c8:f9:f9:2b:ee:81 c8:f9:f9:2b:ee:8d c8:f9:f9:2b:ee:82 c8:f9:f9:4c:94:76 c8:f9:f9:4c:94:77 c8:f9:f9:4c:74:d6 c8:f9:f9:2b:ee:87 c8:f9:f9:2b:ee:86 c8:f9:f9:4c:74:d8 ";
        mTufnellPark = "2c:cc:15:25:f8:c6 3c:ce:73:70:4b:f4 3c:ce:73:70:4b:f1 3c:ce:73:70:4b:f3 3c:ce:73:70:4b:f6 3c:ce:73:70:4b:f2 3c:ce:73:6c:6c:ad 3c:ce:73:6c:6c:ab 3c:ce:73:6c:6c:a9 3c:ce:73:6c:6c:ae 3c:ce:73:6c:6c:a8 3c:ce:73:6c:6c:ac 3c:ce:73:6c:6c:af 3c:ce:73:6c:6c:aa 3c:ce:73:6c:6c:a1 3c:ce:73:6c:6c:a3 3c:ce:73:6c:6c:a4 3c:ce:73:6c:6c:a6 3c:ce:73:6c:6c:a7 3c:ce:73:6c:6c:a2 3c:ce:73:70:4b:ff 3c:ce:73:70:4b:fe 3c:ce:73:70:4b:fc 3c:ce:73:70:4b:f9 3c:ce:73:70:4b:f8 3c:ce:73:70:4b:fb 3c:ce:73:70:4b:fa 3c:ce:73:f8:3e:91 3c:ce:73:f8:3e:94 3c:ce:73:f8:3e:93 3c:ce:73:f8:3e:96 3c:ce:73:70:4b:fd 3c:ce:73:f8:3e:92  3c:ce:73:6c:80:bb 3c:ce:73:6c:80:bc 3c:ce:73:6c:80:be 3c:ce:73:6c:80:bd 3c:ce:73:6c:80:b1 3c:ce:73:6c:80:b3 3c:ce:73:6c:80:b4 3c:ce:73:6c:80:b0 3c:ce:73:6c:80:b8 3c:ce:73:6c:80:ba 3c:ce:73:6c:80:bf 3c:ce:73:6c:80:b9 c8:f9:f9:28:f1:c3 c8:f9:f9:28:f1:c1 3c:ce:73:6c:6b:64 c8:f9:f9:28:f1:ce c8:f9:f9:28:f1:cb c8:f9:f9:28:f1:c4 c8:f9:f9:28:f1:cc 3c:ce:73:6c:80:b2 c8:f9:f9:28:f1:c2 c8:f9:f9:28:f1:cd c8:f9:f9:28:f1:c9 c8:f9:f9:28:f1:cf c8:f9:f9:28:f1:ca";
        mKentishTown = "2c:36:f8:0f:43:79 2c:36:f8:0f:43:7e 2c:36:f8:0f:43:78 2c:36:f8:0f:43:7b 2c:36:f8:0f:43:7a 2c:36:f8:0f:43:7c 2c:36:f8:0f:43:73 2c:36:f8:0f:43:71 2c:36:f8:0f:43:70 2c:36:f8:0f:2b:60 2c:36:f8:0f:43:7f 2c:36:f8:0f:2b:61 2c:36:f8:0f:2b:63 2c:36:f8:0f:2b:6f 2c:36:f8:0f:2b:62 2c:36:f8:0f:43:7d 2c:36:f8:0f:43:72 2c:36:f8:0f:46:63 2c:36:f8:0f:43:76 2c:36:f8:0f:2b:64 2c:36:f8:0f:2b:66 2c:36:f8:0f:2b:6a 2c:36:f8:0f:46:60 2c:36:f8:0f:2b:68 2c:36:f8:0f:46:61 2c:36:f8:0f:46:66 2c:36:f8:0f:46:67 e8:cd:2d:4e:91:b3 2c:36:f8:0f:46:62 c8:f9:f9:4d:ff:ca c8:f9:f9:4d:ff:c3 c8:f9:f9:2a:f7:fb c8:f9:f9:2a:f7:fe c8:f9:f9:2a:f7:f0 c8:f9:f9:2a:f7:f1 c8:f9:f9:2a:f7:fc c8:f9:f9:2a:f7:f3 c8:f9:f9:2a:f7:ff c8:f9:f9:4d:ff:cd c8:f9:f9:2a:f7:f2 c8:f9:f9:2a:f7:fd c8:f9:f9:2a:f7:f8 c8:f9:f9:2a:f7:f9 c8:f9:f9:2a:f7:f5 c8:f9:f9:2a:f7:f7 c8:f9:f9:2a:f7:fa c8:f9:f9:4d:ff:cf c8:f9:f9:4d:ff:ce c8:f9:f9:4d:ff:c8 c8:f9:f9:4d:ff:cc c8:f9:f9:4d:ff:c9 c8:f9:f9:4d:ff:c0 c8:f9:f9:4d:ff:c1 c8:f9:f9:4d:ff:c2 ";
        mCamdenTown = "3c:ce:73:f6:9e:1f 3c:ce:73:f6:9e:1c 3c:ce:73:f6:9e:19 3c:ce:73:f6:9e:1b 3c:ce:73:f6:9e:1e 3c:ce:73:f6:9e:1d 3c:ce:73:f6:9e:18 3c:ce:73:f6:9e:1a 3c:ce:73:f6:9e:13 3c:ce:73:f6:9e:11 3c:ce:73:f6:9e:10 3c:ce:73:f6:9e:12 c8:f9:f9:2a:3e:e2 c8:f9:f9:2a:3e:e0 c8:f9:f9:2a:3e:e3 c8:f9:f9:2a:3e:e1 3c:ce:73:f8:3d:71 c8:f9:f9:2a:92:5f c8:f9:f9:2a:92:5d c8:f9:f9:2a:92:5e c8:f9:f9:2a:92:51 3c:ce:73:f6:9e:14 c8:f9:f9:2a:79:2b c8:f9:f9:2a:79:2f c8:f9:f9:2a:79:28 c8:f9:f9:2a:92:5c c8:f9:f9:2a:79:2e c8:f9:f9:2a:79:2c c8:f9:f9:2a:79:29 c8:f9:f9:2a:92:5a c8:f9:f9:2a:92:50 c8:f9:f9:2a:92:5b c8:f9:f9:2a:79:2a c8:f9:f9:2a:3e:e5 c8:f9:f9:2a:92:52 c8:f9:f9:2a:79:27 c8:f9:f9:2a:79:26 c8:f9:f9:2a:80:fb 3c:ce:73:f8:3d:77 3c:ce:73:f8:3d:75 c8:f9:f9:2a:79:23 c8:f9:f9:2a:79:20 c8:f9:f9:2a:79:2d c8:f9:f9:2a:80:fd c8:f9:f9:2a:79:22 3c:ce:73:6c:6c:59 3c:ce:73:6c:6c:5f 3c:ce:73:6c:6c:5a 3c:ce:73:6c:6c:5c 3c:ce:73:6c:6c:5b 3c:ce:73:6c:6c:58 3c:ce:73:6c:6c:5e 3c:ce:73:6c:6c:5d 3c:ce:73:6c:6c:50 3c:ce:73:6c:6c:53 3c:ce:73:6c:6c:51 3c:ce:73:6c:6c:52 3c:ce:73:6c:6c:54 c8:f9:f9:2a:85:43 c8:f9:f9:2a:85:44 3c:ce:73:6c:6c:55 c8:f9:f9:2a:85:40 c8:f9:f9:2a:85:41 c8:f9:f9:2a:85:42 3c:ce:73:f6:e0:c0 3c:ce:73:f6:e0:ce 3c:ce:73:f6:e0:c5 3c:ce:73:f6:9d:63 2c:cc:15:25:f8:c6 3c:ce:73:f6:9d:62 3c:ce:73:f6:e0:c3 3c:ce:73:f6:e0:c1 3c:ce:73:f6:9d:61 3c:ce:73:f6:9d:60 3c:ce:73:f6:9d:6c 3c:ce:73:f6:9d:69 3c:ce:73:f6:9d:6f 3c:ce:73:f6:9d:6a 3c:ce:73:f6:e0:c2 3c:ce:73:f6:9d:6d 3c:ce:73:f6:9d:64 3c:ce:73:f6:9d:6e 3c:ce:73:f6:9d:68 3c:ce:73:f6:9d:6b 3c:ce:73:f6:e0:c7 ";
        mEuston = "3c:ce:73:f8:7f:2f 3c:ce:73:f8:7f:2b 3c:ce:73:f8:7f:2e 3c:ce:73:f8:7f:2d 3c:ce:73:f8:7f:22 3c:ce:73:f8:7f:21 3c:ce:73:f8:7f:24 3c:ce:73:f8:7f:2c 3c:ce:73:f8:7f:23 c8:f9:f9:2a:95:9b c8:f9:f9:2a:95:9d c8:f9:f9:2a:95:92 c8:f9:f9:2a:95:91 c8:f9:f9:2a:95:9e c8:f9:f9:2a:95:99 c8:f9:f9:2a:95:94 c8:f9:f9:2a:95:97 c8:f9:f9:2a:95:9f c8:f9:f9:2a:95:9a c8:f9:f9:2a:95:93 c8:f9:f9:2a:95:9c 2c:cc:15:25:f8:c6 c8:f9:f9:72:2b:ad c8:f9:f9:2a:95:96 3c:ce:73:f8:7f:25 c8:f9:f9:72:2b:ae 3c:ce:73:f8:7f:2a c8:f9:f9:72:2b:a4 c8:f9:f9:72:2b:a2 c8:f9:f9:72:2b:a1 c8:f9:f9:72:2b:a3 c8:f9:f9:2a:83:9d c8:f9:f9:2a:83:9e c8:f9:f9:2a:83:99 c8:f9:f9:2a:83:9a c8:f9:f9:2a:83:9f c8:f9:f9:2a:83:9b c8:f9:f9:2a:83:97 c8:f9:f9:2a:83:92 c8:f9:f9:2a:83:91 c8:f9:f9:2a:83:94 c8:f9:f9:2a:83:9c c8:f9:f9:2a:83:93 c8:f9:f9:29:00:3a c8:f9:f9:29:00:37 c8:f9:f9:29:00:3b c8:f9:f9:29:00:3d c8:f9:f9:29:00:34 c8:f9:f9:29:00:3e c8:f9:f9:29:00:39 c8:f9:f9:29:00:31 c8:f9:f9:29:00:32 c8:f9:f9:29:00:3f c8:f9:f9:29:00:3c c8:f9:f9:29:00:33 c8:f9:f9:2a:83:96 c8:f9:f9:29:00:36 ";
        mKingsCross = "2c:3f:38:30:13:9b 2c:3f:38:30:13:9a 2c:3f:38:30:13:9d 2c:3f:38:30:13:99 2c:3f:38:30:13:9c 2c:3f:38:30:13:94 2c:3f:38:30:13:91 2c:3f:38:30:13:97 2c:3f:38:30:13:9e 2c:3f:38:30:13:92 2c:3f:38:2a:ab:1e 2c:3f:38:2a:ab:1b 2c:3f:38:30:13:90 2c:3f:38:30:13:9f 2c:3f:38:2a:ab:1f 2c:3f:38:30:13:98 2c:3f:38:2a:ab:1d 64:a0:e7:fe:ac:12 64:a0:e7:fe:ac:11 64:a0:e7:fe:ac:10 64:a0:e7:fe:ac:1c 64:a0:e7:fe:ac:19 64:a0:e7:fe:ac:1a 64:a0:e7:fe:ac:14 64:a0:e7:f8:6b:74 64:a0:e7:f8:6b:71 64:a0:e7:f8:6b:72 64:a0:e7:fe:ac:1f 64:a0:e7:f8:6b:70 64:a0:e7:f8:6b:79 64:a0:e7:f8:6b:7e 64:a0:e7:f8:6b:77 64:a0:e7:f8:6b:7b 64:a0:e7:f8:6b:7d 64:a0:e7:f8:6b:7c 64:a0:e7:f8:6b:7a 2c:3f:38:30:13:91 2c:3f:38:30:13:94 2c:3f:38:30:13:92 64:a0:e7:f8:6b:7f 2c:3f:38:30:13:90 64:a0:e7:f8:6b:76 64:a0:e7:fe:ac:15 64:a0:e7:fe:ac:18 64:a0:e7:fe:ac:17 2c:3f:38:30:13:9d 2c:3f:38:30:13:9b 2c:3f:38:30:13:99 2c:3f:38:30:13:96 2c:3f:38:30:13:9c 64:a0:e7:fe:ac:1b 2c:3f:38:30:13:9a 2c:3f:38:30:13:9e ";
        mAngel = "64:a0:e7:29:7d:a1 64:a0:e7:29:7d:a3 64:a0:e7:29:7d:ae 64:a0:e7:29:7d:a9 64:a0:e7:29:7d:a4 64:a0:e7:29:7d:a0 64:a0:e7:29:7d:af 64:a0:e7:29:7d:aa c4:0a:cb:64:b9:9b 64:a0:e7:29:7d:a8 64:a0:e7:29:7d:ab 64:a0:e7:29:7d:ac c4:0a:cb:64:b9:9e 64:a0:e7:29:7d:a7 c4:0a:cb:64:b9:91 c4:0a:cb:64:b9:94 c4:0a:cb:64:b9:93 c4:0a:cb:64:b9:98 c4:0a:cb:64:da:94 64:a0:e7:29:7d:a2 64:a0:e7:29:7d:ad c4:0a:cb:64:b9:9d c4:0a:cb:64:b9:92 c4:0a:cb:64:da:91 c4:0a:cb:64:da:93 c4:0a:cb:64:da:92 c4:0a:cb:64:b9:90 c4:0a:cb:64:b9:9c c4:0a:cb:2d:b1:3e c4:0a:cb:2d:b1:3f c4:0a:cb:2d:b1:3a c4:0a:cb:eb:b3:73 c4:0a:cb:eb:b3:74 c4:0a:cb:eb:b3:71 c4:0a:cb:2d:b1:3c c4:0a:cb:2d:b1:3b c4:0a:cb:2d:b1:39 c4:0a:cb:2d:b1:34 c4:0a:cb:2d:b1:31 c4:0a:cb:2d:b1:33 c4:0a:cb:64:da:97 c4:0a:cb:64:da:9b 2c:cc:15:25:f8:c6 c4:0a:cb:64:da:9e 48:28:2f:c6:c2:ec c4:0a:cb:64:da:93 c4:0a:cb:64:da:91 c4:0a:cb:eb:b3:72 c4:0a:cb:2d:b1:3d c4:0a:cb:2d:b1:32 c4:0a:cb:64:da:9d c4:0a:cb:64:da:92 c4:0a:cb:64:da:9f c4:0a:cb:64:da:99 c4:0a:cb:64:da:9c c4:0a:cb:64:da:94 c4:0a:cb:64:da:9a c4:0a:cb:64:da:90 64:a0:e7:29:7d:a3 64:a0:e7:29:7d:a6 64:a0:e7:29:7d:a2 c4:0a:cb:64:da:95 c4:0a:cb:2d:b1:30 c4:0a:cb:2d:b1:38 c4:0a:cb:2d:b1:37 c4:0a:cb:eb:b3:77 64:a0:e7:29:7d:a0 64:a0:e7:29:7d:a8 64:a0:e7:29:7d:a4 c4:0a:cb:eb:b3:70 c4:0a:cb:eb:b3:78 c4:0a:cb:eb:b3:7a c4:0a:cb:eb:b3:7d ";
        mOldStreet = "48:28:2f:c6:c2:ec 64:a0:e7:fe:bc:e8 64:a0:e7:fe:bc:eb 64:a0:e7:fe:bc:ee 64:a0:e7:fe:bc:ed 64:a0:e7:fe:bc:e0 64:a0:e7:fe:bc:ea 64:a0:e7:fe:bc:e4 64:a0:e7:fe:bc:e1 64:a0:e7:fe:bc:e2 64:a0:e7:fe:ad:8a 64:a0:e7:fe:ad:88 64:a0:e7:fe:ad:8e 64:a0:e7:fe:ad:87 64:a0:e7:fe:ad:82 64:a0:e7:fe:ad:81 64:a0:e7:fe:ad:8b 64:a0:e7:fe:bc:ec 64:a0:e7:fe:bc:e3 64:a0:e7:fe:ad:83 64:a0:e7:fe:ad:8d 64:a0:e7:fe:ad:8f 64:a0:e7:fe:ad:89 64:a0:e7:fe:ad:84 64:a0:e7:fe:ad:8c 64:a0:e7:fe:bc:e5 64:a0:e7:fe:bc:ef 64:a0:e7:fe:c2:72 64:a0:e7:fe:c2:74 64:a0:e7:fe:c2:71 64:a0:e7:fe:c2:73 64:a0:e7:f8:64:3a 64:a0:e7:f8:64:3f 64:a0:e7:f8:64:39 64:a0:e7:f8:64:3d 64:a0:e7:f8:64:38 64:a0:e7:f8:64:3e 64:a0:e7:f8:64:31 64:a0:e7:f8:64:3b 64:a0:e7:f8:64:32 64:a0:e7:f8:64:34 2c:3f:38:30:20:b4 2c:3f:38:30:20:b2 2c:3f:38:30:20:bf 2c:3f:38:30:20:bd 2c:3f:38:30:20:b8 2c:3f:38:30:20:bb 2c:3f:38:30:20:b9 2c:3f:38:30:20:ba 2c:3f:38:30:20:be 64:a0:e7:f8:64:3c 64:a0:e7:f8:64:33 2c:3f:38:30:20:bc 64:a0:e7:f8:64:36 2c:3f:38:30:20:b0 64:a0:e7:f8:64:37 ";
        mMoorgate = "00:0e:8e:23:79:68 ";
        mBank = "3c:ce:73:f8:8c:51 3c:ce:73:f8:8c:5b 3c:ce:73:f8:8c:5d 3c:ce:73:f8:8c:59 3c:ce:73:f8:8c:5f 3c:ce:73:f8:8c:5e 3c:ce:73:f8:8c:5c 3c:ce:73:f8:8c:57 3c:ce:73:f8:8c:5a 3c:ce:73:f8:8c:56 3c:ce:73:f8:8f:2f 3c:ce:73:f8:8f:25 3c:ce:73:f8:40:0b 3c:ce:73:f8:40:09 3c:ce:73:f8:40:0f 3c:ce:73:f8:40:07 3c:ce:73:f8:40:0d 3c:ce:73:f8:40:0a 3c:ce:73:f8:40:0e 3c:ce:73:f8:40:0c 3c:ce:73:f8:40:02 3c:ce:73:f8:40:01 3c:ce:73:f8:40:04 3c:ce:73:f8:3d:1e 3c:ce:73:f8:3d:14 3c:ce:73:f8:3d:1d 3c:ce:73:f8:3d:1b 3c:ce:73:f8:40:03 3c:ce:73:f8:3d:1c 3c:ce:73:f8:3d:13 3c:ce:73:f8:3d:1a 3c:ce:73:f8:3d:1f 3c:ce:73:f8:3d:17 3c:ce:73:f8:3d:19 3c:ce:73:f8:3d:11 3c:ce:73:f6:a0:64 3c:ce:73:f8:8c:5d 3c:ce:73:f8:8c:5b 3c:ce:73:f8:8c:5e 3c:ce:73:f8:3d:12 3c:ce:73:f8:8c:5c 3c:ce:73:f8:40:05 3c:ce:73:f8:40:08 3c:ce:73:f8:40:00 3c:ce:73:f8:3d:16 3c:ce:73:f6:a0:6d 3c:ce:73:f6:a0:6e 3c:ce:73:f6:a0:6b 3c:ce:73:f6:a0:69 3c:ce:73:f6:a0:6a 3c:ce:73:f6:a0:6c 2c:36:f8:0f:2d:72 ";
        mLondonBridge = "64:a0:e7:ff:0f:fc 64:a0:e7:ff:0f:fd 64:a0:e7:ff:0f:f0 64:a0:e7:ff:0f:f2 64:a0:e7:ff:0f:f1 64:a0:e7:ff:17:7f 64:a0:e7:ff:17:7d 64:a0:e7:ff:17:7b 64:a0:e7:ff:17:7e 64:a0:e7:ff:17:78 64:a0:e7:ff:17:7c 64:a0:e7:ff:17:73 64:a0:e7:ff:17:70 64:a0:e7:ff:17:71 64:a0:e7:ff:17:72 64:a0:e7:ff:12:ce 64:a0:e7:ff:12:cc 64:a0:e7:ff:12:cf 64:a0:e7:ff:12:cd 64:a0:e7:ff:12:cb 64:a0:e7:ff:12:ca 64:a0:e7:ff:12:c1 64:a0:e7:ff:12:c0 64:a0:e7:ff:12:c3 64:a0:e7:ff:12:c8 64:a0:e7:ff:12:c2 64:a0:e7:ff:17:7a 64:a0:e7:ff:17:74 64:a0:e7:ff:0f:ff 64:a0:e7:ff:0f:fb 64:a0:e7:ff:0f:fe 48:c8:62:00:47:41 64:a0:e7:ff:0f:f8 64:a0:e7:ff:0f:f7 64:a0:e7:ff:0f:f3 64:a0:e7:f8:c3:1b 64:a0:e7:f8:c3:10 64:a0:e7:f8:c3:13 64:a0:e7:f8:c3:1e 64:a0:e7:f8:c3:1f 64:a0:e7:f8:c3:18 64:a0:e7:f8:c3:1a 3c:ce:73:6c:6c:63 3c:ce:73:6c:6c:61 64:a0:e7:f8:c3:12 64:a0:e7:f8:c3:1d 3c:ce:73:6c:6c:62 64:a0:e7:f8:c3:17 64:a0:e7:f8:c3:15 64:a0:e7:f8:c3:11 64:a0:e7:f8:c3:1c 3c:ce:73:6c:6c:60 3c:ce:73:6c:6c:6c 3c:ce:73:6c:6c:6e 3c:ce:73:6c:6c:6a 3c:ce:73:6c:6c:68 3c:ce:73:6c:6c:6b 3c:ce:73:6c:6c:6d 3c:ce:73:6c:6c:64 2c:3f:38:30:36:3b 2c:3f:38:30:36:3a 2c:3f:38:30:36:38 2c:3f:38:30:36:3e 2c:3f:38:30:36:3f 2c:3f:38:30:36:3c 2c:3f:38:30:36:37 2c:3f:38:30:36:31 2c:3f:38:30:36:30 2c:3f:38:30:36:33 2c:3f:38:2a:ae:00 2c:3f:38:30:36:3d 2c:3f:38:30:36:32 2c:3f:38:2a:ae:01 64:a0:e7:ff:17:df 64:a0:e7:ff:17:db 64:a0:e7:ff:17:dc 64:a0:e7:ff:17:de 64:a0:e7:ff:17:d1 64:a0:e7:ff:17:d7 64:a0:e7:ff:17:d3 64:a0:e7:ff:17:d0 64:a0:e7:ff:17:dd 64:a0:e7:ff:17:d2 64:a0:e7:dc:e3:cc 64:a0:e7:dc:e3:cf 64:a0:e7:dc:e3:c0 64:a0:e7:dc:e3:ca 64:a0:e7:dc:e3:ce 64:a0:e7:dc:e3:cb 64:a0:e7:dc:e3:c8 64:a0:e7:dc:e3:c3 64:a0:e7:dc:e3:c4 64:a0:e7:dc:e3:c1 64:a0:e7:dc:e3:cd 64:a0:e7:dc:e3:c2 ";
        mBermondsey = "2c:3f:38:30:0e:02 2c:3f:38:30:0e:04 2c:3f:38:30:0e:01 2c:3f:38:30:0e:03 2c:3f:38:30:0e:0f 2c:3f:38:30:10:99 2c:3f:38:30:10:9a 2c:3f:38:30:10:9f 2c:3f:38:30:10:94 2c:3f:38:30:10:92 2c:3f:38:30:10:91 2c:3f:38:30:10:93 c8:f9:f9:5b:76:41 c8:f9:f9:5b:76:48 c8:f9:f9:5b:76:49 c8:f9:f9:5b:76:4d c8:f9:f9:5b:76:47 c8:f9:f9:5b:76:44 c8:f9:f9:5b:76:42 c8:f9:f9:5b:76:4a c8:f9:f9:5b:76:4f c8:f9:f9:5b:76:4b c8:f9:f9:5b:76:4e 2c:3f:38:30:10:90 2c:3f:38:30:10:9e 2c:3f:38:30:10:9d 2c:3f:38:30:10:98 2c:3f:38:30:10:95 2c:3f:38:30:10:9b c8:f9:f9:5b:76:4c c8:f9:f9:5b:76:43 2c:3f:38:30:10:9c ";
        mCanadaWater = "2c:3f:38:2a:e7:a7 2c:3f:38:2a:e7:af 2c:3f:38:2a:e7:ac 2c:3f:38:2a:e7:a3 2c:3f:38:2a:e7:a8 2c:3f:38:2a:e7:ab 2c:3f:38:2a:e7:a0 2c:3f:38:2a:e7:a1 2c:3f:38:2a:e7:ae 2c:3f:38:2a:e7:aa 64:a0:e7:ff:13:ae 64:a0:e7:ff:13:a3 64:a0:e7:ff:13:af 64:a0:e7:ff:13:a0 64:a0:e7:ff:13:ac 64:a0:e7:ff:13:a1 2c:3f:38:2a:e7:a2 2c:3f:38:2a:e7:ad 64:a0:e7:ff:13:a2 2c:3f:38:2a:e7:a8 2c:3f:38:2a:e7:a4 64:a0:e7:ff:13:a7 2c:3f:38:2a:b6:db 2c:3f:38:2a:b6:df 2c:3f:38:2a:b6:d8 2c:3f:38:2a:b6:d7 2c:3f:38:2a:b6:de 2c:3f:38:2a:b6:dc 2c:3f:38:2a:b6:da 2c:3f:38:2a:b6:d1 2c:3f:38:2a:b6:d0 2c:3f:38:2a:b6:d3 2c:3f:38:2a:b6:d4 2c:3f:38:2a:b6:dd 2c:3f:38:2a:b6:d2 ";
        mCanaryWharf = "2c:3f:38:30:60:d1 2c:3f:38:30:60:d3 2c:3f:38:30:60:da 2c:3f:38:30:60:d4 2c:3f:38:30:60:de 2c:3f:38:30:60:dc 2c:3f:38:30:60:db 2c:3f:38:30:60:df 2c:3f:38:2a:a9:bb 2c:3f:38:2a:a9:b1 2c:3f:38:2a:a9:b3 2c:3f:38:2a:a9:be 2c:3f:38:30:60:d2 2c:3f:38:30:60:dd 2c:3f:38:30:60:d5 2c:3f:38:30:60:d8 2c:3f:38:30:60:d7 2c:3f:38:2a:a9:bc 2c:3f:38:2a:a9:b9 2c:3f:38:2a:a9:bf 2c:3f:38:2a:a9:bd 64:a0:e7:af:d1:a1 64:a0:e7:af:d1:a3 64:a0:e7:af:d1:a2 64:a0:e7:af:d1:a6 64:a0:e7:af:d1:a4 2c:3f:38:2a:e3:33 2c:3f:38:2a:e3:31 2c:3f:38:2a:e3:34 2c:3f:38:2a:e3:3e 2c:3f:38:2a:e3:3b 2c:3f:38:2a:e3:39 2c:3f:38:2a:e3:3c 2c:3f:38:2a:e3:3f 64:a0:e7:af:d1:a1 64:a0:e7:af:d1:a3 2c:3f:38:2a:e3:38 2c:3f:38:2a:e3:3a 2c:3f:38:2a:e3:3d 2c:3f:38:2a:e3:32 64:a0:e7:af:d1:a2 2c:3f:38:2a:e3:30 2c:3f:38:2a:e3:35 00:26:b7:07:85:4a ";
        mNorthGreenwich = "64:a0:e7:fe:7e:1f 64:a0:e7:fe:7e:1e 64:a0:e7:fe:7e:1b 64:a0:e7:fe:7e:19 64:a0:e7:fe:7e:11 64:a0:e7:fe:7e:13 64:a0:e7:fe:7e:14 64:a0:e7:fe:7e:1d 64:a0:e7:fe:7e:12 64:a0:e7:fe:7e:16 64:a0:e7:fe:7e:1a 64:a0:e7:fe:7e:1c 64:a0:e7:fe:7e:18 0c:37:dc:e8:dc:78 64:a0:e7:fe:7c:04 2c:3f:38:2a:ab:8b 2c:3f:38:2a:ab:8c 2c:3f:38:2a:ab:81 2c:3f:38:2a:ab:89 2c:3f:38:2a:ab:83 2c:3f:38:2a:ab:8d 2c:3f:38:2a:ab:82 2c:3f:38:2a:ab:84 2c:3f:38:2a:ab:8a 2c:3f:38:2a:ab:8e 2c:3f:38:2a:ab:80 2c:3f:38:2a:ab:8f 64:a0:e7:fe:7c:00 ";
        mCanningTown = "c8:f9:f9:5b:87:42 00:24:a8:c1:a8:30 00:24:a8:c1:08:40 c8:f9:f9:4d:f3:a1 c8:f9:f9:5b:87:43 3c:ce:73:f6:a0:ab 3c:ce:73:f6:a0:a7 3c:ce:73:f6:a0:ad 3c:ce:73:f6:a0:aa 3c:ce:73:f6:a0:ae 3c:ce:73:f6:a0:af 3c:ce:73:f6:a0:a8 3c:ce:73:f6:a0:a4 3c:ce:73:f6:a0:ac 3c:ce:73:f6:a0:a3 c8:f9:f9:4d:f3:a2 c8:f9:f9:4d:f3:a3 3c:ce:73:f6:a0:a2 3c:ce:73:f6:a0:a1 c8:f9:f9:5b:87:44 c8:f9:f9:5b:87:45 02:13:60:7c:66:40 00:24:a8:c1:a8:30 c8:f9:f9:72:0d:44 c8:f9:f9:72:0d:47 c8:f9:f9:72:0d:42 c8:f9:f9:72:0d:41 c8:f9:f9:72:0d:4e c8:f9:f9:72:0d:4b c8:f9:f9:72:0d:48 c8:f9:f9:72:0d:4f c8:f9:f9:72:0d:4d c8:f9:f9:72:0d:4a c8:f9:f9:72:0d:47 c8:f9:f9:5b:87:44 c8:f9:f9:5b:87:48 c8:f9:f9:5b:87:42 c8:f9:f9:5b:87:40 08:bd:43:52:90:12 c8:f9:f9:72:0d:43 c8:f9:f9:72:0d:4c ";

    }
}


