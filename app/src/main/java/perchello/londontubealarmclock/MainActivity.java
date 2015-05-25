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

import java.util.Calendar;
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

    public String mCharringCross;
    public String mEmbankment;
    public String mGoodgeStreet;
    public String mLeicesterSquare;
    public String mMorningtonCrescent;
    public String mSouthwarkStation;
    public String mWarrenStreet;
    public String mWaterloo;

    public String mAldgateEast;
    public String mBlackFriars;
    public String mWestminster;
    public String mWestKensigton;
    public String mWestBrompton;
    public String mVictoria;
    public String mTowerHill;
    public String mTemple;
    public String mStJamesPark;
    public String mSouthKensington;
    public String mSloaneSquare;
    public String mMonument;
    public String mMansionHouse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setStationNames();
        mWifiTextView = (TextView) findViewById(R.id.wifiTextView);
        //mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        //mWifiReceiver = new WifiScanReceiver();
        //registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mSetAlarmButton = (Button) findViewById(R.id.setAlarmButton);
        mSetAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, WifiReceiver.class);
                myIntent.putExtra("1", "test");
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mPendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(), 1000, mPendingIntent);
            }
        });


        mCancelAlarmButton = (Button) findViewById(R.id.cancelAlarmButton);
        mCancelAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WifiReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
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

        //mWifiManager.startScan();

    }

    @Override
    public void onPause() {
        super.onPause();

        //unregisterReceiver(mWifiReceiver);

    }

    @Override
    public void onResume() {
        super.onResume();
        //registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

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
                            mWifiTextView.setText("Finchley Central");
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
                                mWifiTextView.setText("North Greenwich");
                                i = mScanResultList.size();
                            }
                    else if (mCanningTown.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                                mWifiTextView.setText("Canning Town");
                                i = mScanResultList.size();
                            }
                else if (mCharringCross.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Charring Cross");
                    i = mScanResultList.size();
                }
                else if (mEmbankment.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Embankment");
                    i = mScanResultList.size();
                }
                else if (mGoodgeStreet.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Goodge Street");
                    i = mScanResultList.size();
                }
                else if (mLeicesterSquare.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Leicester Square");
                    i = mScanResultList.size();
                }
                else if (mMorningtonCrescent.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Mornington Crescent");
                    i = mScanResultList.size();
                }
                else if (mSouthwarkStation.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Southwark Station");
                    i = mScanResultList.size();
                }
                else if (mWarrenStreet.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Warren Street");
                    i = mScanResultList.size();
                }
                else if (mWaterloo.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Waterloo");
                    i = mScanResultList.size();
                }
                else if (mAldgateEast.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Aldgate East");
                    i = mScanResultList.size();
                }
                else if (mBlackFriars.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Black Friars");
                    i = mScanResultList.size();
                }
                else if (mWestminster.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Westminster");
                    i = mScanResultList.size();
                }
                else if (mWestKensigton.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("West Kensington");
                    i = mScanResultList.size();
                }
                else if (mWestBrompton.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("West Brompton");
                    i = mScanResultList.size();
                }
                else if (mVictoria.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Victoria");
                    i = mScanResultList.size();
                }
                else if (mTowerHill.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Tower Hill");
                    i = mScanResultList.size();
                }
                else if (mTemple.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Temple");
                    i = mScanResultList.size();
                }
                else if (mStJamesPark.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("St James's Park");
                    i = mScanResultList.size();
                }
                else if (mSouthKensington.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("South Kensington");
                    i = mScanResultList.size();
                }
                else if (mSloaneSquare.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Sloane Square");
                    i = mScanResultList.size();
                }
                else if (mMonument.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Monument");
                    i = mScanResultList.size();
                }
                else if (mMansionHouse.contains(mScanResultList.get (i).BSSID.toString().toLowerCase())) {
                    mWifiTextView.setText("Mansion House");
                    i = mScanResultList.size();
                }


            }
            mWifiManager.startScan();

        }
    }

    private void setStationNames(){
        mAndrewOffice = "c8:bc:c8:fd:9d:95";
        mFincheleyCentral = "";
        mEastFinchley = "BBConnect 64:e9:50:96:25:41;BBConnect 64:e9:50:05:e0:91;BBConnect 64:e9:50:05:fa:c1;BBConnect 64:e9:50:96:05:41;BBConnect 64:e9:50:05:fa:ce;BBConnect 2c:3e:cf:f0:05:d1;BBConnect 6c:99:89:92:d4:e1;1234 6c:99:89:92:d4:e3;BBConnect \n" +
                "64:e9:50:96:0b:31;BBConnect 2c:3e:cf:f1:1a:61;";
        mHighgate = "BBConnect 3c:ce:73:f8:90:91; BBConnect a4:56:30:cc:97:f1;Virgin Media WiFi a4:56:30:cc:97:f2;Virgin Media WiFi 3c:ce:73:f8:90:92;Virgin Media WiFi 2c:36:f8:b6:6e:92;BBConnect 2c:36:f8:b6:6e:9e;VodafoneWiFi 2c:36:f8:b6:6e:97;Virgin Media \n" +
                "WiFi 2c:36:f8:b6:6e:9d;EE WiFi_Auto 2c:36:f8:b6:6e:98;BBConnect 2c:36:f8:b6:6e:91;VodafoneWiFi 3c:ce:73:f8:90:98;EE WiFi_Auto a4:56:30:cc:97:f7;";
        mArchway = "BBConnect 3c:ce:73:f8:88:4e;VodafoneWiFi 3c:ce:73:f8:88:48;BBConnect 3c:ce:73:f8:88:41;BBConnect c8:f9:f9:2b:ee:8e;Virgin Media WiFi 3c:ce:73:f8:88:4d;Virgin Media WiFi 3c:ce:73:f8:88:42;EE WiFi_Auto c8:f9:f9:2b:ee:89;BBConnect c8:f9:f9:2b:ee:81;VodafoneWiFi c8:f9:f9:2b:ee:88;2288 c8:f9:f9:2b:ee:80;Virgin Media WiFi c8:f9:f9:2b:ee:82;Virgin Media WiFi c8:f9:f9:2b:ee:8d;BBConnect c8:f9:f9:4c:94:71;EE WiFi_Auto c8:f9:f9:4c:94:76;Virgin Media WiFi c8:f9:f9:4c:94:72;VodafoneWiFi c8:f9:f9:4c:94:77;2288 3c:ce:73:f8:88:40;";
        mTufnellPark = "BBConnect 3c:ce:73:70:4b:f1;Virgin Media WiFi 3c:ce:73:70:4b:f2;EE WiFi_Auto 3c:ce:73:6c:6c:a9;VodafoneWiFi 3c:ce:73:6c:6c:a8;BBConnect 3c:ce:73:6c:6c:ae;BBConnect 3c:ce:73:6c:6c:a1;Virgin Media WiFi 3c:ce:73:6c:6c:ad;Virgin Media WiFi \n" +
                "3c:ce:73:6c:6c:a2;VodafoneWiFi 3c:ce:73:6c:6c:a7;EE WiFi_Auto 3c:ce:73:70:4b:f6;BBConnect 3c:ce:73:70:4b:fe;";
        mKentishTown = "BBConnect c8:f9:f9:4d:ff:ce;BBConnect c8:f9:f9:29:68:61;EE WiFi_Auto c8:f9:f9:4d:ff:c8;VodafoneWiFi c8:f9:f9:4d:ff:c9;BBConnect c8:f9:f9:4d:ff:c1;BBConnect c8:f9:f9:2a:f7:f1;BBConnect c8:f9:f9:2a:f7:fe;VodafoneWiFi c8:f9:f9:2a:f7:f9;EE \n" +
                "WiFi_Auto c8:f9:f9:2a:f7:f8;Virgin Media WiFi c8:f9:f9:29:68:62;Virgin Media WiFi c8:f9:f9:4d:ff:cd;Virgin Media WiFi c8:f9:f9:2a:f7:f2;Virgin Media WiFi c8:f9:f9:2a:f7:fd;VodafoneWiFi c8:f9:f9:29:68:66;EE WiFi_Auto \n" +
                "c8:f9:f9:29:68:67;BBConnect 2c:36:f8:0f:3f:11;Virgin Media WiFi 2c:36:f8:0f:3f:12;";
        mCamdenTown = "BBConnect 3c:ce:73:f6:e0:ce;Virgin Media WiFi 3c:ce:73:f6:e0:cd;EE WiFi_Auto 3c:ce:73:f6:e0:c8;BBConnect 3c:ce:73:f6:e0:c1;VodafoneWiFi 3c:ce:73:f6:9d:66;Virgin Media WiFi 3c:ce:73:f6:e0:c2;BBConnect 3c:ce:73:f6:9d:61;EE WiFi_Auto \n" +
                "3c:ce:73:f6:9d:68;BBConnect 3c:ce:73:f6:9d:6e;VodafoneWiFi 3c:ce:73:f6:9d:69;VodafoneWiFi 3c:ce:73:f6:e0:c9;EE WiFi_Auto 3c:ce:73:f6:e0:c7;Virgin Media WiFi 3c:ce:73:f6:9d:62;Virgin Media WiFi 3c:ce:73:f6:9d:6d;2288 \n" +
                "3c:ce:73:f6:9d:64;VodafoneWiFi 3c:ce:73:f6:e0:c6;";
        mEuston = "c8:f9:f9:2a:83:9d c8:f9:f9:2a:83:9e c8:f9:f9:2a:83:99 c8:f9:f9:2a:83:9a c8:f9:f9:2a:83:9f c8:f9:f9:2a:83:9b c8:f9:f9:2a:83:97 c8:f9:f9:2a:83:92 c8:f9:f9:2a:83:91 c8:f9:f9:2a:83:94 c8:f9:f9:2a:83:9c c8:f9:f9:2a:83:93 c8:f9:f9:29:00:3a c8:f9:f9:29:00:37 c8:f9:f9:29:00:3b c8:f9:f9:29:00:3d c8:f9:f9:29:00:34 c8:f9:f9:29:00:3e c8:f9:f9:29:00:39 c8:f9:f9:29:00:31 c8:f9:f9:29:00:32 c8:f9:f9:29:00:3f c8:f9:f9:29:00:3c c8:f9:f9:29:00:33 c8:f9:f9:2a:83:96 c8:f9:f9:29:00:36 3c:ce:73:f8:7f:2f 3c:ce:73:f8:7f:2b 3c:ce:73:f8:7f:2e 3c:ce:73:f8:7f:2d 3c:ce:73:f8:7f:22 3c:ce:73:f8:7f:21 3c:ce:73:f8:7f:24 3c:ce:73:f8:7f:2c 3c:ce:73:f8:7f:23 c8:f9:f9:2a:95:9b c8:f9:f9:2a:95:9d c8:f9:f9:2a:95:92 c8:f9:f9:2a:95:91 c8:f9:f9:2a:95:9e c8:f9:f9:2a:95:99 c8:f9:f9:2a:95:94 c8:f9:f9:2a:95:97 c8:f9:f9:2a:95:9f c8:f9:f9:2a:95:9a c8:f9:f9:2a:95:93 c8:f9:f9:2a:95:9c 2c:cc:15:25:f8:c6 c8:f9:f9:72:2b:ad c8:f9:f9:2a:95:96 3c:ce:73:f8:7f:25 c8:f9:f9:72:2b:ae 3c:ce:73:f8:7f:2a c8:f9:f9:72:2b:a4 c8:f9:f9:72:2b:a2 c8:f9:f9:72:2b:a1 c8:f9:f9:72:2b:a3 ";
        mKingsCross = "2c:3f:38:30:13:9b 2c:3f:38:30:13:9a 2c:3f:38:30:13:9d 2c:3f:38:30:13:99 2c:3f:38:30:13:9c 2c:3f:38:30:13:94 2c:3f:38:30:13:91 2c:3f:38:30:13:97 2c:3f:38:30:13:9e 2c:3f:38:30:13:92 2c:3f:38:2a:ab:1e 2c:3f:38:2a:ab:1b 2c:3f:38:30:13:90 2c:3f:38:30:13:9f 2c:3f:38:2a:ab:1f 2c:3f:38:30:13:98 2c:3f:38:2a:ab:1d 64:a0:e7:fe:ac:12 64:a0:e7:fe:ac:11 64:a0:e7:fe:ac:10 64:a0:e7:fe:ac:1c 64:a0:e7:fe:ac:19 64:a0:e7:fe:ac:1a 64:a0:e7:fe:ac:14 64:a0:e7:f8:6b:74 64:a0:e7:f8:6b:71 64:a0:e7:f8:6b:72 64:a0:e7:fe:ac:1f 64:a0:e7:f8:6b:70 64:a0:e7:f8:6b:79 64:a0:e7:f8:6b:7e 64:a0:e7:f8:6b:77 64:a0:e7:f8:6b:7b 64:a0:e7:f8:6b:7d 64:a0:e7:f8:6b:7c 64:a0:e7:f8:6b:7a 2c:3f:38:30:13:91 2c:3f:38:30:13:94 2c:3f:38:30:13:92 64:a0:e7:f8:6b:7f 2c:3f:38:30:13:90 64:a0:e7:f8:6b:76 64:a0:e7:fe:ac:15 64:a0:e7:fe:ac:18 64:a0:e7:fe:ac:17 2c:3f:38:30:13:9d 2c:3f:38:30:13:9b 2c:3f:38:30:13:99 2c:3f:38:30:13:96 2c:3f:38:30:13:9c 64:a0:e7:fe:ac:1b 2c:3f:38:30:13:9a 2c:3f:38:30:13:9e ";
        mAngel = "c4:0a:cb:2d:b1:3e c4:0a:cb:2d:b1:3f c4:0a:cb:2d:b1:3a c4:0a:cb:eb:b3:73 c4:0a:cb:eb:b3:74 c4:0a:cb:eb:b3:71 c4:0a:cb:2d:b1:3c c4:0a:cb:2d:b1:3b c4:0a:cb:2d:b1:39 c4:0a:cb:2d:b1:34 c4:0a:cb:2d:b1:31 c4:0a:cb:2d:b1:33 c4:0a:cb:64:da:97 c4:0a:cb:64:da:9b 2c:cc:15:25:f8:c6 c4:0a:cb:64:da:9e 48:28:2f:c6:c2:ec c4:0a:cb:64:da:93 c4:0a:cb:64:da:91 c4:0a:cb:eb:b3:72 c4:0a:cb:2d:b1:3d c4:0a:cb:2d:b1:32 c4:0a:cb:64:da:9d c4:0a:cb:64:da:92 c4:0a:cb:64:da:9f c4:0a:cb:64:da:99 c4:0a:cb:64:da:9c c4:0a:cb:64:da:94 c4:0a:cb:64:da:9a c4:0a:cb:64:da:90 64:a0:e7:29:7d:a3 64:a0:e7:29:7d:a6 64:a0:e7:29:7d:a2 c4:0a:cb:64:da:95 c4:0a:cb:2d:b1:30 c4:0a:cb:2d:b1:38 c4:0a:cb:2d:b1:37 c4:0a:cb:eb:b3:77 64:a0:e7:29:7d:a0 64:a0:e7:29:7d:a8 64:a0:e7:29:7d:a4 c4:0a:cb:eb:b3:70 c4:0a:cb:eb:b3:78 c4:0a:cb:eb:b3:7a c4:0a:cb:eb:b3:7d 64:a0:e7:29:7d:a1 64:a0:e7:29:7d:a3 64:a0:e7:29:7d:ae 64:a0:e7:29:7d:a9 64:a0:e7:29:7d:a4 64:a0:e7:29:7d:a0 64:a0:e7:29:7d:af 64:a0:e7:29:7d:aa c4:0a:cb:64:b9:9b 64:a0:e7:29:7d:a8 64:a0:e7:29:7d:ab 64:a0:e7:29:7d:ac c4:0a:cb:64:b9:9e 64:a0:e7:29:7d:a7 c4:0a:cb:64:b9:91 c4:0a:cb:64:b9:94 c4:0a:cb:64:b9:93 c4:0a:cb:64:b9:98 c4:0a:cb:64:da:94 64:a0:e7:29:7d:a2 64:a0:e7:29:7d:ad c4:0a:cb:64:b9:9d c4:0a:cb:64:b9:92 c4:0a:cb:64:da:91 c4:0a:cb:64:da:93 c4:0a:cb:64:da:92 c4:0a:cb:64:b9:90 c4:0a:cb:64:b9:9c ";
        mOldStreet = "48:28:2f:c6:c2:ec 64:a0:e7:fe:bc:e8 64:a0:e7:fe:bc:eb 64:a0:e7:fe:bc:ee 64:a0:e7:fe:bc:ed 64:a0:e7:fe:bc:e0 64:a0:e7:fe:bc:ea 64:a0:e7:fe:bc:e4 64:a0:e7:fe:bc:e1 64:a0:e7:fe:bc:e2 64:a0:e7:fe:ad:8a 64:a0:e7:fe:ad:88 64:a0:e7:fe:ad:8e 64:a0:e7:fe:ad:87 64:a0:e7:fe:ad:82 64:a0:e7:fe:ad:81 64:a0:e7:fe:ad:8b 64:a0:e7:fe:bc:ec 64:a0:e7:fe:bc:e3 64:a0:e7:fe:ad:83 64:a0:e7:fe:ad:8d 64:a0:e7:fe:ad:8f 64:a0:e7:fe:ad:89 64:a0:e7:fe:ad:84 64:a0:e7:fe:ad:8c 64:a0:e7:fe:bc:e5 64:a0:e7:fe:bc:ef 64:a0:e7:fe:c2:72 64:a0:e7:fe:c2:74 64:a0:e7:fe:c2:71 64:a0:e7:fe:c2:73 64:a0:e7:f8:64:3a 64:a0:e7:f8:64:3f 64:a0:e7:f8:64:39 64:a0:e7:f8:64:3d 64:a0:e7:f8:64:38 64:a0:e7:f8:64:3e 64:a0:e7:f8:64:31 64:a0:e7:f8:64:3b 64:a0:e7:f8:64:32 64:a0:e7:f8:64:34 2c:3f:38:30:20:b4 2c:3f:38:30:20:b2 2c:3f:38:30:20:bf 2c:3f:38:30:20:bd 2c:3f:38:30:20:b8 2c:3f:38:30:20:bb 2c:3f:38:30:20:b9 2c:3f:38:30:20:ba 2c:3f:38:30:20:be 64:a0:e7:f8:64:3c 64:a0:e7:f8:64:33 2c:3f:38:30:20:bc 64:a0:e7:f8:64:36 2c:3f:38:30:20:b0 64:a0:e7:f8:64:37 48:28:2f:c6:c2:ec 64:a0:e7:fe:bc:e8 64:a0:e7:fe:bc:eb 64:a0:e7:fe:bc:ee 64:a0:e7:fe:bc:ed 64:a0:e7:fe:bc:e0 64:a0:e7:fe:bc:ea 64:a0:e7:fe:bc:e4 64:a0:e7:fe:bc:e1 64:a0:e7:fe:bc:e2 64:a0:e7:fe:ad:8a 64:a0:e7:fe:ad:88 64:a0:e7:fe:ad:8e 64:a0:e7:fe:ad:87 64:a0:e7:fe:ad:82 64:a0:e7:fe:ad:81 64:a0:e7:fe:ad:8b 64:a0:e7:fe:bc:ec 64:a0:e7:fe:bc:e3 64:a0:e7:fe:ad:83 64:a0:e7:fe:ad:8d 64:a0:e7:fe:ad:8f 64:a0:e7:fe:ad:89 64:a0:e7:fe:ad:84 64:a0:e7:fe:ad:8c 64:a0:e7:fe:bc:e5 64:a0:e7:fe:bc:ef 64:a0:e7:fe:c2:72 64:a0:e7:fe:c2:74 64:a0:e7:fe:c2:71 64:a0:e7:fe:c2:73 ";
        mMoorgate = "00:0e:8e:23:79:68 ";
        mBank = "3c:ce:73:f8:8c:51 3c:ce:73:f8:8c:5b 3c:ce:73:f8:8c:5d 3c:ce:73:f8:8c:59 3c:ce:73:f8:8c:5f 3c:ce:73:f8:8c:5e 3c:ce:73:f8:8c:5c 3c:ce:73:f8:8c:57 3c:ce:73:f8:8c:5a 3c:ce:73:f8:8c:56 3c:ce:73:f8:8f:2f 3c:ce:73:f8:8f:25 3c:ce:73:f8:40:0b 3c:ce:73:f8:40:09 3c:ce:73:f8:40:0f 3c:ce:73:f8:40:07 3c:ce:73:f8:40:0d 3c:ce:73:f8:40:0a 3c:ce:73:f8:40:0e 3c:ce:73:f8:40:0c 3c:ce:73:f8:40:02 3c:ce:73:f8:40:01 3c:ce:73:f8:40:04 3c:ce:73:f8:3d:1e 3c:ce:73:f8:3d:14 3c:ce:73:f8:3d:1d 3c:ce:73:f8:3d:1b 3c:ce:73:f8:40:03 3c:ce:73:f8:3d:1c 3c:ce:73:f8:3d:13 3c:ce:73:f8:3d:1a 3c:ce:73:f8:3d:1f 3c:ce:73:f8:3d:17 3c:ce:73:f8:3d:19 3c:ce:73:f8:3d:11 3c:ce:73:f6:a0:64 3c:ce:73:f8:8c:5d 3c:ce:73:f8:8c:5b 3c:ce:73:f8:8c:5e 3c:ce:73:f8:3d:12 3c:ce:73:f8:8c:5c 3c:ce:73:f8:40:05 3c:ce:73:f8:40:08 3c:ce:73:f8:40:00 3c:ce:73:f8:3d:16 3c:ce:73:f6:a0:6d 3c:ce:73:f6:a0:6e 3c:ce:73:f6:a0:6b 3c:ce:73:f6:a0:69 3c:ce:73:f6:a0:6a 3c:ce:73:f6:a0:6c 2c:36:f8:0f:2d:72 ";
        mLondonBridge = "BBConnect 2c:3f:38:30:10:4f;2288 2c:3f:38:30:10:4d;5150-5725 64:a0:e7:ff:0f:ff;Virgin Media WiFi 64:a0:e7:ff:0f:fd;BBConnect 64:a0:e7:ff:0f:fe;1234 64:a0:e7:ff:0f:fc;5150-5725 2c:3f:38:2a:fb:0f;2288 2c:3f:38:2a:fb:0b;1234 2c:3f:38:2a:fb:0c;VodafoneWiFi 2c:3f:38:2a:fb:08;1234 2c:3f:38:2a:fb:03;BBConnect 2c:3f:38:2a:fb:01;5150-5725 2c:3f:38:2a:fb:00;2288 64:a0:e7:ff:0f:fb;222666328 64:a0:e7:ff:0f:fa;VodafoneWiFi 64:a0:e7:ff:0f:f8;5150-5725 64:a0:e7:ff:0f:f0;BBConnect 64:a0:e7:ff:0f:f1;1234 64:a0:e7:ff:0f:f3;Virgin Media WiFi 64:a0:e7:ff:0f:f2;222666328 2c:3f:38:30:10:4c;BBConnect 64:a0:e7:ff:1d:ce;1234 64:a0:e7:ff:1d:cc;5150-5725 64:a0:e7:ff:1d:cf;1234 64:a0:e7:ff:1d:c3;BBConnect 64:a0:e7:ff:1d:c1;Virgin Media WiFi 64:a0:e7:ff:1d:cd;VodafoneWiFi 2c:3f:38:30:10:49;Virgin Media WiFi 2c:3f:38:30:10:4e;BBConnect 2c:3f:38:30:10:40;Virgin Media WiFi 2c:3f:38:30:10:41;2288 64:a0:e7:ff:17:7b;5150-5725 64:a0:e7:ff:17:7f;BBConnect 64:a0:e7:ff:17:7e;1234 64:a0:e7:ff:17:7c;VodafoneWiFi 64:a0:e7:ff:17:78;Virgin Media WiFi 64:a0:e7:ff:17:7d;2288 64:a0:e7:ff:1d:cb;BBConnect 64:a0:e7:ff:17:71;5150-5725 64:a0:e7:ff:17:70;1234 64:a0:e7:ff:17:73;BBConnect 2c:3f:38:2a:fb:0e;222666328 2c:3f:38:2a:fb:0a;Virgin Media WiFi 2c:3f:38:2a:fb:0d;VodafoneWiFi 64:a0:e7:ff:1d:c8;222666328 64:a0:e7:ff:1d:ca;VodafoneWiFi 64:a0:e7:ff:0f:f7;222666328 64:a0:e7:ff:0f:f5;2288 64:a0:e7:ff:17:74;222666328 64:a0:e7:ff:17:75;VodafoneWiFi 64:a0:e7:ff:1d:c7;BBConnect 2c:3f:38:2a:ae:00;222666328 64:a0:e7:ff:1d:c5;Virgin Media WiFi 64:a0:e7:ff:17:72;Virgin Media WiFi 2c:3f:38:2a:fb:02;BBConnect 2c:3f:38:2a:fb:0e;Virgin Media WiFi 2c:3f:38:2a:fb:0d;VodafoneWiFi 2c:3f:38:2a:fb:08;BBConnect 2c:3f:38:2a:ae:0f;BBConnect 2c:3f:38:2a:ae:00;Virgin Media WiFi 2c:3f:38:2a:ae:0e;1234 2c:3f:38:2a:fb:03;VodafoneWiFi \n" +
                "2c:3f:38:2a:fb:07;BBConnect 64:a0:e7:ff:12:ce;1234 64:a0:e7:ff:12:cc;2288 64:a0:e7:ff:12:cb;5150-5725 64:a0:e7:ff:12:cf;VodafoneWiFi 64:a0:e7:ff:12:c8;222666328 64:a0:e7:ff:12:ca;BBConnect 64:a0:e7:ff:12:c1;5150-5725 64:a0:e7:ff:12:c0;1234 64:a0:e7:ff:12:c3;1234 64:a0:e7:ff:1d:c3;5150-5725 64:a0:e7:ff:1d:c0;Virgin Media WiFi 64:a0:e7:ff:12:c2;Virgin Media WiFi 64:a0:e7:ff:12:cd;222666328 64:a0:e7:ff:12:c5;BBConnect 64:a0:e7:ff:1d:c1;BBConnect 2c:3f:38:2a:fb:01;VodafoneWiFi 2c:3f:38:2a:ae:09;BBConnect 2c:3f:38:30:36:31;VodafoneWiFi 2c:3f:38:30:36:37;BBConnect 2c:3f:38:30:36:3e;VodafoneWiFi 2c:3f:38:30:36:38;Virgin Media WiFi 2c:3f:38:2a:fb:02;Virgin \n" +
                "Media WiFi 2c:3f:38:2a:ae:01;Virgin Media WiFi 2c:3f:38:30:36:32;Virgin Media WiFi 2c:3f:38:30:36:3d;5150-5725 2c:3f:38:2a:ea:bf;VodafoneWiFi 2c:3f:38:2a:ea:b8;2288 2c:3f:38:2a:ea:bb;222666328 2c:3f:38:2a:ea:ba;1234 2c:3f:38:2a:ea:bc;BBConnect 2c:3f:38:2a:ea:be;5150-5725 64:a0:e7:ff:17:d0;1234 2c:3f:38:2a:ea:b3;VodafoneWiFi 64:a0:e7:ff:17:d8;BBConnect 64:a0:e7:ff:17:d1;2288 64:a0:e7:ff:17:db;222666328 64:a0:e7:ff:17:da;Virgin Media WiFi 2c:3f:38:2a:ea:bd;Virgin Media WiFi 64:a0:e7:ff:17:d2;1234 64:a0:e7:ff:17:dc;1234 64:a0:e7:ff:17:d3;5150-5725 64:a0:e7:ff:17:df;BBConnect 64:a0:e7:ff:17:de;Virgin Media WiFi 64:a0:e7:ff:17:dd;1234 64:a0:e7:dc:e3:cc;BBConnect 64:a0:e7:dc:e3:ce;5150-5725 64:a0:e7:dc:e3:cf;222666328 64:a0:e7:dc:e3:ca;2288 64:a0:e7:dc:e3:cb;Virgin Media WiFi 64:a0:e7:dc:e3:cd;5150-5725 3c:ce:73:6c:6c:60;222666328 3c:ce:73:6c:6c:6a;VodafoneWiFi 64:a0:e7:dc:e3:c8;5150-5725 3c:ce:73:6c:6c:6f;1234 3c:ce:73:6c:6c:6c;BBConnect 3c:ce:73:6c:6c:6e;5150-5725 64:a0:e7:dc:e3:c0;2288 3c:ce:73:6c:6c:6b;5150-5725 2c:3f:38:2a:e5:30;Virgin Media WiFi 3c:ce:73:6c:6c:6d;2288 64:a0:e7:ff:17:d4;222666328 64:a0:e7:dc:e3:c5;2288 3c:ce:73:6c:6c:64;222666328 3c:ce:73:6c:6c:65;VodafoneWiFi 3c:ce:73:6c:6c:68;2288 2c:3f:38:2a:e5:34;5150-5725 2c:3f:38:2a:ea:b0;2288 64:a0:e7:dc:e3:c4;1234 3c:ce:73:6c:6c:63;222666328 2c:3f:38:2a:e5:3a;Virgin Media WiFi 2c:3f:38:2a:ea:b2;Virgin Media WiFi 3c:ce:73:6c:6c:62;";
        mBermondsey = "EE WiFi_Auto 2c:3f:38:30:0d:b9;1234 2c:3f:38:30:0d:bb;BBConnect 2c:3f:38:30:0d:bd;VodafoneWiFi 2c:3f:38:30:0d:b8;BBConnect 2c:3f:38:30:0d:b2;BBConnect 2c:3f:38:2a:fb:2d;Virgin Media WiFi 2c:3f:38:30:0d:bc;Virgin Media WiFi \n" +
                "2c:3f:38:30:0d:b3;Virgin Media WiFi 2c:3f:38:2a:fb:2c;EE WiFi_Auto 2c:3f:38:2a:fb:29;BBConnect 2c:3f:38:2a:fb:22;VodafoneWiFi 2c:3f:38:2a:fb:28;Virgin Media WiFi 2c:3f:38:2a:fb:23;VodafoneWiFi 2c:3f:38:30:0d:b7;EE WiFi_Auto \n" +
                "2c:3f:38:30:0d:b6;BBConnect 2c:3f:38:30:20:62;BBConnect 2c:3f:38:30:20:6d;5150-5725 2c:3f:38:30:20:61;222666328 2c:3f:38:30:20:6a;2288 2c:3f:38:30:20:6f;1234 2c:3f:38:30:20:64;VodafoneWiFi 2c:3f:38:30:20:68;1234 2c:3f:38:30:20:6b;EE WiFi_Auto 2c:3f:38:30:20:69;EE WiFi_Auto 2c:3f:38:30:20:66;Virgin Media WiFi 2c:3f:38:30:20:6c;Virgin Media WiFi 2c:3f:38:30:20:63;5150-5725 2c:3f:38:30:20:6e;";
        mCanadaWater = "VodafoneWiFi 2c:3f:38:2a:e7:a7;BBConnect 2c:3f:38:2a:e7:ae;EE WiFi_Auto 2c:3f:38:2a:e7:a8;BBConnect 2c:3f:38:2a:e7:a1;Virgin Media WiFi 2c:3f:38:2a:e7:ad;Virgin Media WiFi 2c:3f:38:2a:e7:a2;VodafoneWiFi 64:a0:e7:ff:13:a7;EE WiFi_Auto \n" +
                "64:a0:e7:ff:13:a8;BBConnect 64:a0:e7:ff:13:ae;BBConnect 64:a0:e7:ff:13:a1;Virgin Media WiFi 64:a0:e7:ff:13:ad;Virgin Media WiFi 64:a0:e7:ff:13:a2;VodafoneWiFi 2c:3f:38:2a:e7:a8;EE WiFi_Auto 64:a0:e7:ff:13:a7;";
        mCanaryWharf = "BBConnect 64:a0:e7:af:d1:ae;Virgin Media WiFi 64:a0:e7:af:d1:ad;Virgin Media WiFi 64:a0:e7:af:d1:a2;BBConnect 64:a0:e7:af:d1:a1;EE WiFi_Auto 2c:3f:38:2a:e3:39;VodafoneWiFi 2c:3f:38:2a:e3:38;BBConnect 2c:3f:38:2a:e3:3e;Virgin Media WiFi 2c:3f:38:2a:e3:3d;EE WiFi_Auto 64:a0:e7:af:d1:a9;VodafoneWiFi 64:a0:e7:af:d1:a8;BBConnect 2c:3f:38:2a:e3:31;BBConnect 2c:3f:38:2a:ac:51;Virgin Media WiFi 2c:3f:38:2a:e3:32;Virgin Media WiFi 2c:3f:38:2a:ac:52;";
        mNorthGreenwich = "Virgin Media WiFi 64:a0:e7:fe:7e:12;BBConnect 64:a0:e7:f8:4e:21;Virgin Media WiFi 64:a0:e7:f8:4e:22;VodafoneWiFi 2c:3f:38:2a:c8:d8;BBConnect 2c:3f:38:2a:c8:de;EE WiFi_Auto 2c:3f:38:2a:c8:d9;EE WiFi_Auto 64:a0:e7:f8:4e:26;EE WiFi_Auto \n" +
                "2c:3f:38:2a:c8:d6;BBConnect 2c:3f:38:2a:c8:d1;Virgin Media WiFi 2c:3f:38:2a:c8:dd;Virgin Media WiFi 2c:3f:38:2a:c8:d2;Virgin Media WiFi 64:a0:e7:fe:7c:02;1234 2c:3f:38:2a:ab:8c;5150-5725 2c:3f:38:2a:ab:8b;BBConnect 2c:3f:38:2a:ab:8e;222666328 2c:3f:38:2a:ab:8a;EE WiFi_Auto 2c:3f:38:2a:ab:89;VodafoneWiFi 2c:3f:38:2a:ab:88;2288 2c:3f:38:2a:ab:8f;Virgin Media WiFi 2c:3f:38:2a:ab:8d;5150-5725 2c:3f:38:2a:ab:84;BBConnect 2c:3f:38:2a:ab:81;1234 2c:3f:38:2a:ab:83;Virgin Media WiFi 2c:3f:38:2a:ab:82;BBConnect 64:a0:e7:fe:7c:01;5150-5725 64:a0:e7:fe:7c:04;1234 64:a0:e7:fe:7c:03;5150-5725 2c:3f:38:2a:c8:d4;Virgin Media WiFi 64:a0:e7:fe:7c:02;EE WiFi_Auto 64:a0:e7:fe:7c:09;222666328 64:a0:e7:fe:7c:0a;5150-5725 64:a0:e7:fe:7c:0b;1234 64:a0:e7:fe:7c:0c;VodafoneWiFi 64:a0:e7:fe:7c:08;BBConnect 64:a0:e7:fe:77:90;BBConnect 64:a0:e7:fe:7c:0e;2288 64:a0:e7:fe:7c:0f;1234 2c:3f:38:2a:c8:d3;1234 2c:3f:38:2a:c8:dc;VodafoneWiFi 2c:3f:38:2a:c8:d8;BBConnect 2c:3f:38:2a:c8:d1;5150-5725 2c:3f:38:2a:c8:db;EE WiFi_Auto 2c:3f:38:2a:c8:d9;222666328 2c:3f:38:2a:c8:da;Virgin Media WiFi 64:a0:e7:fe:7c:0d;Virgin Media WiFi 64:a0:e7:fe:77:91;EE WiFi_Auto 2c:3f:38:2a:ab:86;EE WiFi_Auto 64:a0:e7:fe:7c:06;BBConnect 2c:3f:38:2a:c8:de;2288 2c:3f:38:2a:c8:d0;VodafoneWiFi 64:a0:e7:fe:77:95;2288 2c:3f:38:2a:c8:df;222666328 64:a0:e7:fe:77:93;Virgin Media WiFi 2c:3f:38:2a:c8:d2;Virgin Media WiFi 2c:3f:38:2a:c8:dd;";
        mCanningTown = "EE WiFi_Auto 3c:ce:73:f6:a0:a8;VodafoneWiFi 3c:ce:73:f6:a0:a7;BBConnect 3c:ce:73:f6:a0:ad;BBConnect 3c:ce:73:f6:a0:a2;Virgin Media WiFi 3c:ce:73:f6:a0:ac;Virgin Media WiFi 3c:ce:73:f6:a0:a3;EE WiFi_Auto 3c:ce:73:f6:a0:a7;BBConnect \n" +
                "c8:f9:f9:4d:f3:a2;EE WiFi_Auto c8:f9:f9:4d:f3:a7;Virgin Media WiFi c8:f9:f9:4d:f3:a3;";
        mCharringCross = "BBConnect c8:f9:f9:2b:ed:22;VodafoneWiFi a4:56:30:a3:6b:68;BBConnect a4:56:30:a3:6b:62;Virgin Media WiFi c8:f9:f9:2b:ed:23;Virgin Media WiFi a4:56:30:a3:6b:63;EE WiFi_Auto a4:56:30:a3:6b:68;BBConnect a4:56:30:a3:6b:6d;VodafoneWiFi \n" +
                "a4:56:30:a3:6b:67;BBConnect 3c:ce:73:f6:ee:9d;EE WiFi_Auto 3c:ce:73:f6:ee:98;BBConnect 3c:ce:73:f6:ee:92;Virgin Media WiFi a4:56:30:a3:6b:6c;Virgin Media WiFi 3c:ce:73:f6:ee:9c;Virgin Media WiFi 3c:ce:73:f6:ee:93;VodafoneWiFi \n" +
                "3c:ce:73:f6:ee:97;VodafoneWiFi 3c:ce:73:f6:ee:98;BBConnect a4:56:30:e9:41:9e;Virgin Media WiFi a4:56:30:e9:41:9d;";
        mEmbankment  = "BBConnect c8:f9:f9:2a:94:ee;VodafoneWiFi c8:f9:f9:2a:94:e7;BBConnect c8:f9:f9:2a:94:e1;Virgin Media WiFi c8:f9:f9:2a:94:ed;Virgin Media WiFi c8:f9:f9:2a:94:e2;BBConnect c8:f9:f9:2a:f2:71;Virgin Media WiFi c8:f9:f9:2a:f2:72;EE WiFi_Auto \n" +
                "c8:f9:f9:2a:f2:77;VodafoneWiFi c8:f9:f9:2a:f2:77;BBConnect c8:f9:f9:2a:f2:7e;EE WiFi_Auto c8:f9:f9:2a:f2:78;EE WiFi_Auto c8:f9:f9:2a:94:e7;Virgin Media WiFi c8:f9:f9:2a:f2:7d;";
        mGoodgeStreet = "BBConnect 2c:36:f8:e9:db:d1;Virgin Media WiFi 2c:36:f8:e9:db:d2;Virgin Media WiFi 3c:ce:73:70:64:02;BBConnect 2c:36:f8:e9:db:de;VodafoneWiFi 2c:36:f8:e9:db:d7;EE WiFi_Auto 2c:36:f8:e9:db:d9;VodafoneWiFi 3c:ce:73:09:86:17;EE WiFi_Auto \n" +
                "3c:ce:73:09:86:19;BBConnect 3c:ce:73:09:86:1e;Virgin Media WiFi 2c:36:f8:e9:db:dd;Virgin Media WiFi 3c:ce:73:09:86:1d;Virgin Media WiFi 3c:ce:73:09:86:12;BBConnect 3c:ce:73:09:86:11;";
        mLeicesterSquare = "Virgin Media WiFi 2c:3f:38:2a:aa:72;BBConnect 2c:3f:38:2b:26:d1;EE WiFi_Auto 2c:3f:38:2b:26:d9;BBConnect 2c:3f:38:2b:26:de;VodafoneWiFi 2c:3f:38:2b:26:d7;Virgin Media WiFi 2c:3f:38:2b:26:d2;Virgin Media WiFi 2c:3f:38:2b:26:dd;";
        mMorningtonCrescent = "BBConnect c8:f9:f9:72:27:0e;BBConnect c8:f9:f9:72:27:01;EE WiFi_Auto 3c:ce:73:70:68:48;BBConnect 3c:ce:73:70:68:41;Virgin Media WiFi c8:f9:f9:72:27:0d;Virgin Media WiFi c8:f9:f9:72:27:02;Virgin Media WiFi 3c:ce:73:70:68:4d;Virgin Media \n" +
                "WiFi 3c:ce:73:70:68:42;VodafoneWiFi 3c:ce:73:70:68:47;BBConnect 3c:ce:73:70:68:4e;VodafoneWiFi 3c:ce:73:70:68:48;VodafoneWiFi c8:f9:f9:72:27:08;BBConnect c8:f9:f9:72:31:be;VodafoneWiFi c8:f9:f9:72:31:b7;EE WiFi_Auto \n" +
                "c8:f9:f9:72:31:b8;Virgin Media WiFi c8:f9:f9:72:31:bd;";
        mSouthwarkStation = "VodafoneWiFi 64:a0:e7:f8:bd:09;BBConnect 64:a0:e7:f8:bd:0d;BBConnect 64:a0:e7:f8:bd:02;Virgin Media WiFi 64:a0:e7:f8:bd:0c;Virgin Media WiFi 64:a0:e7:f8:bd:03;EE WiFi_Auto 64:a0:e7:f8:bd:07;EE WiFi_Auto 64:a0:e7:f8:bd:08;VodafoneWiFi \n" +
                "64:a0:e7:f8:bd:06;1234 64:a0:e7:f8:62:cb;222666328 64:a0:e7:f8:62:ca;2288 64:a0:e7:f8:62:cf;VodafoneWiFi 64:a0:e7:f8:62:c9;BBConnect 64:a0:e7:f8:62:cd;5150-5725 64:a0:e7:f8:62:ce;EE WiFi_Auto 64:a0:e7:f8:62:c7;5150-5725 64:a0:e7:f8:62:c1;1234 64:a0:e7:f8:62:c4;EE WiFi_Auto 64:a0:e7:f8:62:c8;BBConnect 64:a0:e7:f8:62:c2;2288 64:a0:e7:f8:62:c0;Virgin Media WiFi 64:a0:e7:f8:62:cc;Virgin Media WiFi 64:a0:e7:f8:62:c3;BBConnect 2c:3f:38:2a:aa:42;1234 2c:3f:38:2a:aa:44;5150-5725 2c:3f:38:2a:aa:41;Virgin Media WiFi 2c:3f:38:2a:aa:43;VodafoneWiFi 64:a0:e7:f8:62:c6;1234 2c:3f:38:2a:aa:4b;222666328 2c:3f:38:2a:aa:4a;BBConnect 2c:3f:38:2a:aa:4d;5150-5725 2c:3f:38:2a:aa:4e;222666328 2c:3f:38:2a:aa:45;Virgin Media WiFi 2c:3f:38:2a:aa:4c;";
        mWarrenStreet = "BBConnect 00:08:30:8e:a6:32;EE WiFi_Auto 00:08:30:8e:a6:37;BBConnect 00:08:30:8e:a6:3d;VodafoneWiFi 00:08:30:8e:a6:39;EE WiFi_Auto 00:08:30:a7:d2:c7;BBConnect 00:08:30:a7:d2:cd;VodafoneWiFi 00:08:30:a7:d2:c9;BBConnect \n" +
                "00:08:30:a7:d2:c2;Virgin Media WiFi 00:08:30:8e:a6:30;Virgin Media WiFi 00:08:30:8e:a6:3f;Virgin Media WiFi 00:08:30:a7:d2:cf;Virgin Media WiFi 00:08:30:a7:d2:c0;VodafoneWiFi 00:08:30:a7:d2:c6;";
        mWaterloo = "BBConnect 44:e4:d9:3e:38:de;Virgin Media WiFi 44:e4:d9:3e:38:d2;Virgin Media WiFi 44:e4:d9:3e:38:dd;BBConnect 04:c5:a4:08:ca:01;VodafoneWiFi 04:c5:a4:08:ca:09;EE WiFi_Auto 04:c5:a4:08:ca:08;BBConnect 04:c5:a4:08:ca:0e;VodafoneWiFi \n" +
                "44:e4:d9:ab:11:29;BBConnect 44:e4:d9:ab:11:2e;BBConnect 44:e4:d9:ab:11:21;EE WiFi_Auto 44:e4:d9:ab:11:28;BBConnect 44:e4:d9:01:a1:e1;Virgin Media WiFi 04:c5:a4:08:ca:0d;Virgin Media WiFi 04:c5:a4:08:ca:02;Virgin Media WiFi \n" +
                "44:e4:d9:ab:11:22;Virgin Media WiFi 44:e4:d9:ab:11:2d;EE WiFi_Auto 44:e4:d9:ab:11:27;VodafoneWiFi 04:c5:a4:08:ca:06;VodafoneWiFi 44:e4:d9:ab:11:26;EE WiFi_Auto 44:e4:d9:01:a1:e7;VodafoneWiFi 44:e4:d9:3e:8e:19;BBConnect 44:e4:d9:3e:8e:1e; EE WiFi_Auto 44:e4:d9:3e:8e:18; VodafoneWiFi 04:c5:a4:08:33:46; BBConnect 04:c5:a4:08:33:41;EE WiFi_Auto 04:c5:a4:08:33:47;EE WiFi_Auto 04:c5:a4:08:7a:37;Virgin Media WiFi 44:e4:d9:3e:8e:12;Virgin Media WiFi 44:e4:d9:3e:8e:1d;Virgin Media WiFi 04:c5:a4:08:33:42;Virgin Media WiFi 04:c5:a4:08:7a:32;222666328 c0:62:6b:66:c1:3a;1234 c0:62:6b:66:c1:3c;EE WiFi_Auto c0:62:6b:66:c1:38;VodafoneWiFi c0:62:6b:66:c1:39;5150-5725 c0:62:6b:66:c1:3f;BBConnect c0:62:6b:66:c1:3e;2288 c0:62:6b:66:c1:3b;BBConnect c0:62:6b:66:c1:31;1234 c0:62:6b:66:c1:33;5150-5725 c0:62:6b:66:c1:30;Virgin Media WiFi c0:62:6b:66:c1:3d;Virgin Media WiFi c0:62:6b:66:c1:32;VodafoneWiFi c0:62:6b:66:c1:36;1234 44:e4:d9:3e:38:d3;5150-5725 44:e4:d9:3e:38:d0;BBConnect 44:e4:d9:3e:38:d1;BBConnect 44:e4:d9:01:a1:e1;1234 44:e4:d9:01:a1:e3;EE WiFi_Auto c0:62:6b:66:c1:37;EE WiFi_Auto 44:e4:d9:3e:38:d7;222666328 44:e4:d9:3e:38:da;1234 44:e4:d9:3e:38:dc;BBConnect 44:e4:d9:3e:38:de;5150-5725 44:e4:d9:3e:38:df;EE WiFi_Auto 44:e4:d9:3e:38:d8;VodafoneWiFi 44:e4:d9:3e:38:d9;2288 44:e4:d9:3e:38:db;Virgin Media WiFi 44:e4:d9:3e:38:dd;";
        mAldgateEast = "BBConnect c4:0a:cb:2d:b1:00;BBConnect c4:0a:cb:65:01:7e;VodafoneWiFi c4:0a:cb:65:01:77;EE WiFi_Auto c4:0a:cb:65:01:78;BBConnect c4:0a:cb:65:01:71;BBConnect c4:0a:cb:64:cf:f1;Virgin Media WiFi c4:0a:cb:65:01:7d;Virgin Media WiFi c4:0a:cb:65:01:72;BBConnect c4:0a:cb:64:cf:fe;Virgin Media WiFi c4:0a:cb:64:cf:fd;Virgin Media WiFi c4:0a:cb:64:cf:f2;Virgin Media WiFi c4:0a:cb:2d:b1:01;VodafoneWiFi c4:0a:cb:64:cf:f7;EE WiFi_Auto c4:0a:cb:2d:b1:06;BBConnect c4:0a:cb:5d:8d:e1;Virgin Media WiFi c4:0a:cb:5d:8d:e2;BBConnect c4:0a:cb:2d:b1:0f;BBConnect c4:0a:cb:65:01:7e;BBConnect c4:0a:cb:65:01:71;Virgin Media WiFi c4:0a:cb:65:01:7d;BBConnect c4:0a:cb:64:cf:fe;Virgin Media WiFi c4:0a:cb:64:cf:fd;BBConnect c4:0a:cb:64:cf:f1;VodafoneWiFi c4:0a:cb:64:cf:f7;Virgin Media WiFi c4:0a:cb:64:cf:f2;EE WiFi_Auto c4:0a:cb:64:cf:f8;VodafoneWiFi c4:0a:cb:65:01:77;BBConnect c4:0a:cb:2d:b1:00;Virgin Media WiFi c4:0a:cb:65:01:72;Virgin Media WiFi c4:0a:cb:2d:b1:01;EE WiFi_Auto c4:0a:cb:2d:b1:06;BBConnect c4:0a:cb:5d:8d:e1;Virgin Media WiFi c4:0a:cb:5d:8d:e2;";
        mBlackFriars = "1234 3c:ce:73:f8:41:f4;BBConnect 3c:ce:73:f8:41:f2;";
        mWestminster = "5150-5725 64:a0:e7:fe:aa:0e;1234 64:a0:e7:fe:aa:0b;VodafoneWiFi 64:a0:e7:fe:aa:09;222666328 64:a0:e7:fe:aa:0a;BBConnect 64:a0:e7:fe:aa:0d;2288 64:a0:e7:fe:aa:0f;BBConnect 64:a0:e7:fe:aa:02;1234 64:a0:e7:fe:aa:04;EE WiFi_Auto 64:a0:e7:fe:aa:07;5150-5725 64:a0:e7:fe:aa:01;5150-5725 64:a0:e7:f8:20:41;BBConnect 64:a0:e7:f8:20:42;Virgin Media WiFi 64:a0:e7:fe:aa:03;Virgin Media WiFi 64:a0:e7:f8:20:43;BBConnect 64:a0:e7:f8:57:b2;5150-5725 64:a0:e7:f8:57:b1;1234 64:a0:e7:f8:57:b4;BBConnect 64:a0:e7:f8:57:bd;Virgin Media WiFi 64:a0:e7:f8:57:b3;VodafoneWiFi 64:a0:e7:f8:57:b9;222666328 64:a0:e7:f8:57:ba;5150-5725 64:a0:e7:f8:57:be;EE WiFi_Auto 64:a0:e7:f8:57:b7;2288 64:a0:e7:f8:57:bf;1234 64:a0:e7:f8:57:bb;Virgin Media WiFi 64:a0:e7:f8:57:bc;1234 64:a0:e7:f8:66:c4;BBConnect 64:a0:e7:f8:66:c2;5150-5725 64:a0:e7:f8:66:c1;1234 64:a0:e7:f8:66:cb;1234 64:a0:e7:f8:66:f4;EE WiFi_Auto 64:a0:e7:f8:66:f8;5150-5725 64:a0:e7:f8:66:f1;BBConnect 64:a0:e7:f8:66:cd;5150-5725 64:a0:e7:f8:66:ce;Virgin Media WiFi 64:a0:e7:f8:66:c3;Virgin Media WiFi 64:a0:e7:f8:66:cc;VodafoneWiFi 64:a0:e7:f8:57:b6;222666328 64:a0:e7:f8:66:fa;EE WiFi_Auto 64:a0:e7:f8:66:f7;EE WiFi_Auto 64:a0:e7:f8:66:c7;2288 64:a0:e7:f8:66:cf;1234 64:a0:e7:fe:78:0b;EE WiFi_Auto 64:a0:e7:f8:66:c8;VodafoneWiFi 64:a0:e7:f8:66:c9;222666328 64:a0:e7:f8:66:ca;2288 64:a0:e7:f8:66:c0;5150-5725 64:a0:e7:fe:78:0e;BBConnect 64:a0:e7:fe:78:0d;2288 64:a0:e7:f8:66:ff;1234 64:a0:e7:f8:66:fb;5150-5725 64:a0:e7:f8:66:fe;222666328 64:a0:e7:fe:78:0a;222666328 64:a0:e7:f8:20:45;BBConnect 64:a0:e7:f8:66:f2;2288 64:a0:e7:fe:78:0f;VodafoneWiFi 64:a0:e7:f8:66:f6;BBConnect 64:a0:e7:fe:78:02;Virgin Media WiFi 64:a0:e7:fe:78:0c;5150-5725 64:a0:e7:af:c8:c1;BBConnect 64:a0:e7:af:c8:cd;BBConnect 64:a0:e7:af:c8:c2;Virgin Media WiFi 64:a0:e7:af:c8:c3;1234 64:a0:e7:af:c8:c4;5150-5725 3c:ce:73:f8:84:d2;1234 3c:ce:73:f8:84:d4;BBConnect 3c:ce:73:f8:84:d1;2412-2484 3c:ce:73:f8:84:d0;Virgin Media WiFi 64:a0:e7:af:c8:cc;5150-5725 64:a0:e7:f8:3e:b1;VodafoneWiFi 64:a0:e7:f8:3e:b9;222666328 64:a0:e7:f8:3e:ba;5150-5725 64:a0:e7:f8:3e:be;Virgin Media WiFi 64:a0:e7:f8:3e:bc;2288 64:a0:e7:f8:3e:bf;BBConnect 64:a0:e7:f8:3e:bd;1234 64:a0:e7:f8:3e:bb;EE WiFi_Auto 64:a0:e7:f8:3e:b7;Virgin Media WiFi 64:a0:e7:fe:9a:03;BBConnect 64:a0:e7:f8:3e:b2;VodafoneWiFi 64:a0:e7:f8:3e:b6;222666328 64:a0:e7:af:c8:c5;222666328 64:a0:e7:fe:9a:05;1234 64:a0:e7:f8:3e:b4;BBConnect 64:a0:e7:fe:9a:02;5150-5725 64:a0:e7:fe:9a:01;1234 64:a0:e7:fe:9a:04;Virgin Media WiFi 64:a0:e7:f8:3e:b3;5150-5725 64:a0:e7:af:c8:c1;BBConnect 64:a0:e7:af:c8:cd;BBConnect 64:a0:e7:af:c8:c2;Virgin Media WiFi 64:a0:e7:af:c8:c3;1234 64:a0:e7:af:c8:c4;5150-5725 3c:ce:73:f8:84:d2;1234 3c:ce:73:f8:84:d4;BBConnect 3c:ce:73:f8:84:d1;2412-2484 3c:ce:73:f8:84:d0;Virgin Media WiFi 64:a0:e7:af:c8:cc;5150-5725 64:a0:e7:f8:3e:b1;VodafoneWiFi 64:a0:e7:f8:3e:b9;222666328 64:a0:e7:f8:3e:ba;5150-5725 64:a0:e7:f8:3e:be;Virgin Media WiFi 64:a0:e7:f8:3e:bc;2288 64:a0:e7:f8:3e:bf;BBConnect 64:a0:e7:f8:3e:bd;1234 64:a0:e7:f8:3e:bb;EE WiFi_Auto 64:a0:e7:f8:3e:b7;Virgin Media WiFi 64:a0:e7:fe:9a:03;BBConnect 64:a0:e7:f8:3e:b2;VodafoneWiFi 64:a0:e7:f8:3e:b6;222666328 64:a0:e7:af:c8:c5;222666328 64:a0:e7:fe:9a:05;1234 64:a0:e7:f8:3e:b4;BBConnect 64:a0:e7:fe:9a:02;5150-5725 64:a0:e7:fe:9a:01;1234 64:a0:e7:fe:9a:04;Virgin Media WiFi 64:a0:e7:f8:3e:b3;BBConnect 64:a0:e7:fe:9a:02;5150-5725 64:a0:e7:fe:9a:01;1234 64:a0:e7:fe:9a:04;5150-5725 64:a0:e7:fe:9a:0e;VodafoneWiFi \n" +
                "64:a0:e7:fe:9a:09;Virgin Media WiFi 64:a0:e7:fe:9a:03;Virgin Media WiFi 64:a0:e7:fe:9a:0c;1234 64:a0:e7:fe:9a:0b;EE WiFi_Auto \n" +
                "64:a0:e7:fe:9a:07;2288 64:a0:e7:fe:9a:0f;BBConnect 64:a0:e7:fe:9a:0d;BBConnect 3c:ce:73:f8:84:de;5150-5725 \n" +
                "3c:ce:73:f8:84:dd;5150-5725 3c:ce:73:f8:84:d2;2378 3c:ce:73:f8:84:da;1234 3c:ce:73:f8:84:d4;BBConnect 3c:ce:73:f8:84:d1;1234 \n" +
                "3c:ce:73:f8:84:db;2412-2484 3c:ce:73:f8:84:d0;2412-2484 3c:ce:73:f8:84:df;222666328 64:a0:e7:fe:9a:0a;EE WiFi_Auto \n" +
                "64:a0:e7:fe:9a:08;2288 64:a0:e7:fe:9a:00;";
        mWestKensigton = "Virgin Media WiFi 64:e9:50:05:cc:01;BBConnect 64:e9:50:05:cc:00;1234 64:e9:50:96:24:e3;5150-5725 64:e9:50:05:f7:20;Virgin Media WiFi 64:e9:50:96:24:e2;2288 64:e9:50:05:f7:2b;EE WiFi_Auto 64:e9:50:05:f7:28;BBConnect 64:e9:50:05:f7:2e;4321 64:e9:50:05:f7:29;222666328 64:e9:50:05:f7:2a;5150-5725 64:e9:50:05:f7:2f;1234 64:e9:50:05:f7:2c;VodafoneWiFi 64:e9:50:05:f7:27;BBConnect 64:e9:50:05:f7:21;1234 64:e9:50:05:f7:23;BBConnect 64:e9:50:96:24:ee;1234 64:e9:50:96:24:ec;5150-5725 64:e9:50:96:24:ef;Virgin Media WiFi 64:e9:50:05:f7:2d;Virgin Media WiFi 64:e9:50:05:f7:22;Virgin Media WiFi 64:e9:50:96:24:ed;BBConnect 64:e9:50:05:f2:61;5150-5725 64:e9:50:05:f2:62;2288 64:e9:50:96:24:eb;VodafoneWiFi 64:e9:50:96:24:e7;1234 64:e9:50:05:f2:63;2412-2484 64:e9:50:05:f2:60;VodafoneWiFi 64:e9:50:05:f7:28;222666328 64:e9:50:96:24:ea;EE WiFi_Auto 64:e9:50:96:24:e7;222666328 64:e9:50:05:f7:25;4321 64:e9:50:96:24:e9;EE WiFi_Auto 64:e9:50:96:24:e8;2288 64:e9:50:05:f7:24;222666328 64:e9:50:96:24:e5;";
        mWestBrompton = "2288 64:e9:50:05:f0:ef;1234 64:e9:50:05:f0:eb;EE WiFi_Auto 64:e9:50:05:f0:e9;5150-5725 64:e9:50:05:f0:ee;VodafoneWiFi \n" +
                "64:e9:50:05:f0:e7;BBConnect 64:e9:50:05:f0:ed;Virgin Media WiFi 64:e9:50:05:f0:ec;222666328 64:e9:50:05:f0:ea;5150-5725 \n" +
                "64:e9:50:05:fa:4e;222666328 64:e9:50:05:fa:4a;1234 64:e9:50:05:fa:4b;5150-5725 64:e9:50:05:f0:e1;1234 64:e9:50:05:f0:e4;2288 \n" +
                "64:e9:50:05:fa:4f;EE WiFi_Auto 64:e9:50:05:fa:49;VodafoneWiFi 64:e9:50:05:fa:47;BBConnect 64:e9:50:05:fa:4d;1234 \n" +
                "64:e9:50:05:fa:44;Virgin Media WiFi 64:e9:50:05:f0:e3;Virgin Media WiFi 64:e9:50:05:fa:4c;VodafoneWiFi 64:e9:50:05:fa:48;2288 \n" +
                "64:e9:50:05:fa:40;BBConnect 64:e9:50:05:f0:e2;BBConnect 64:e9:50:96:09:0d;2288 64:e9:50:96:09:0f;EE WiFi_Auto \n" +
                "64:e9:50:96:09:09;5150-5725 64:e9:50:96:09:0e;222666328 64:e9:50:96:09:0a;1234 64:e9:50:96:09:0b;VodafoneWiFi \n" +
                "64:e9:50:96:09:07;Virgin Media WiFi 64:e9:50:96:09:0c;";
        mVictoria = "2288 44:e4:d9:3e:27:2b;5150-5725 44:e4:d9:3e:27:2c;EE WiFi_Auto 44:e4:d9:3e:27:29;222666328 44:e4:d9:3e:27:2a;VodafoneWiFi 44:e4:d9:3e:27:28;1234 44:e4:d9:3e:27:2e;5150-5725 44:e4:d9:3e:27:23;1234 44:e4:d9:3e:27:21;Virgin Media WiFi 44:e4:d9:3e:27:2f;BBConnect 44:e4:d9:3e:27:22;BBConnect b4:14:89:5b:6e:bd;1234 b4:14:89:5b:6e:b1;BBConnect b4:14:89:5b:6e:b2;5150-5725 b4:14:89:5b:6e:b3;5150-5725 b4:14:89:5b:6e:bc;1234 b4:14:89:5b:6e:be;Virgin Media WiFi 44:e4:d9:3e:27:20;Virgin Media WiFi b4:14:89:5b:6e:b0;Virgin Media WiFi b4:14:89:5b:6e:bf;EE WiFi_Auto b4:14:89:5b:6e:b9;2288 b4:14:89:5b:6e:bb;222666328 b4:14:89:5b:6e:ba;BBConnect 44:e4:d9:3e:27:2d;VodafoneWiFi 44:e4:d9:3e:27:27;1234 c0:62:6b:66:ba:e1;222666328 b4:14:89:5b:6e:b5;2288 c0:62:6b:66:ba:e4;5150-5725 c0:62:6b:66:ba:e3;EE WiFi_Auto c0:62:6b:66:ba:e6;BBConnect c0:62:6b:66:ba:e2;Virgin Media WiFi c0:62:6b:66:ba:e0;BBConnect 2c:36:f8:0f:2a:1d;5150-5725 2c:36:f8:0f:2a:1c;VodafoneWiFi 2c:36:f8:0f:2a:18;1234 2c:36:f8:0f:2a:11;5150-5725 2c:36:f8:0f:2a:13;BBConnect 2c:36:f8:0f:2a:12;Virgin Media WiFi 2c:36:f8:0f:2a:1f;Virgin Media WiFi 2c:36:f8:0f:2a:10;5150-5725 c0:62:6b:66:ba:e3;1234 c0:62:6b:66:ba:e1;VodafoneWiFi 2c:36:f8:0f:2a:17;1234 2c:36:f8:0f:2a:1e;EE WiFi_Auto 2c:36:f8:0f:2a:19;222666328 2c:36:f8:0f:2a:1a;222666328 2c:36:f8:0f:2a:15;BBConnect c0:62:6b:66:ba:e2;222666328 c0:62:6b:66:ba:e5;VodafoneWiFi c0:62:6b:66:ba:e7;Virgin Media WiFi c0:62:6b:66:ba:e0;";
        mTowerHill = "5150-5725 04:c5:a4:08:6e:71;BBConnect 04:c5:a4:08:6e:72;1234 04:c5:a4:08:6e:74;5150-5725 04:c5:a4:08:6e:7e;EE WiFi_Auto 04:c5:a4:08:6e:78;2288 04:c5:a4:08:6e:7f;1234 04:c5:a4:08:6e:7b;Virgin Media WiFi 04:c5:a4:08:6e:73;Virgin Media WiFi 04:c5:a4:08:6e:7c;BBConnect 04:c5:a4:08:6e:7d;VodafoneWiFi 04:c5:a4:08:6e:77;222666328 04:c5:a4:08:6e:7a;";
        mTemple = "EE WiFi_Auto c8:f9:f9:2a:84:69;Virgin Media WiFi c8:f9:f9:2a:84:6c;1234 c8:f9:f9:2a:84:64;BBConnect \n" +
                "c8:f9:f9:2a:84:62;BBConnect c8:f9:f9:2a:84:6d;5150-5725 c8:f9:f9:2a:84:61;2288 c8:f9:f9:2a:84:6f;1234 c8:f9:f9:2a:84:6b;5150\n" +
                "-5725 c8:f9:f9:2a:84:6e;VodafoneWiFi c8:f9:f9:2a:84:68;Virgin Media WiFi c8:f9:f9:2a:84:63;222666328 c8:f9:f9:2a:84:65;2288 \n" +
                "c8:f9:f9:2a:84:60;EE WiFi_Auto c8:f9:f9:29:5c:a6;";
        mStJamesPark = "222666328 44:e4:d9:01:f6:ea;5150-5725 44:e4:d9:01:f6:ee;2288 44:e4:d9:01:f6:ef;BBConnect 44:e4:d9:01:f6:ed;VodafoneWiFi 44:e4:d9:01:f6:e8;EE WiFi_Auto 44:e4:d9:01:f6:e9;BBConnect 44:e4:d9:3e:3d:b2;BBConnect 44:e4:d9:01:f6:e2;1234 44:e4:d9:01:f6:e4;5150-5725 44:e4:d9:3e:3d:b1;5150-5725 44:e4:d9:3e:3d:be;BBConnect 3c:ce:73:70:65:fe;Virgin Media WiFi 44:e4:d9:01:f6:ec;Virgin Media WiFi 3c:ce:73:70:65:fd;Virgin Media WiFi 44:e4:d9:01:f6:e3;Virgin Media WiFi 44:e4:d9:3e:3d:b3;5150-5725 44:e4:d9:01:f6:e1;1234 44:e4:d9:3e:3d:b4;BBConnect 3c:ce:73:70:65:f1;2288 3c:ce:73:70:65:ff;EE WiFi_Auto 3c:ce:73:70:65:f9;222666328 44:e4:d9:3e:3d:ba;VodafoneWiFi 3c:ce:73:70:65:fa;VodafoneWiFi 44:e4:d9:3e:3d:b8;222666328 3c:ce:73:70:65:fc;5150-5725 c0:62:6b:e5:20:01;1234 c0:62:6b:e5:20:0b;EE WiFi_Auto 44:e4:d9:3e:3d:b9;BBConnect 44:e4:d9:3e:3d:bd;VodafoneWiFi c0:62:6b:e5:20:08;2288 44:e4:d9:3e:3d:bf;BBConnect c0:62:6b:e5:20:0d;1234 44:e4:d9:3e:3d:bb;5150-5725 c0:62:6b:e5:20:0e;tep_1165 48:c8:62:00:56:8b;Virgin Media WiFi 3c:ce:73:70:65:f2;Virgin Media WiFi 44:e4:d9:3e:3d:bc;Virgin Media WiFi c0:62:6b:e5:20:0c;Virgin Media WiFi c0:62:6b:e5:20:03;EE WiFi_Auto 44:e4:d9:01:f6:e6;2288 3c:ce:73:70:65:f0;222666328 3c:ce:73:70:65:f3;VodafoneWiFi 3c:ce:73:70:65:f5;1234 c0:62:6b:e5:20:04;VodafoneWiFi 44:e4:d9:3e:3d:b7;222666328 c0:62:6b:e5:20:0a;EE WiFi_Auto 44:e4:d9:3e:3d:b6;2288 c0:62:6b:e5:20:0f;BBConnect c0:62:6b:e5:20:02;222666328 c0:62:6b:e5:20:05;BBConnect 44:e4:d9:01:8d:92;5150-5725 44:e4:d9:01:8d:91;1234 44:e4:d9:01:8d:94;VodafoneWiFi 44:e4:d9:01:8d:97;Virgin Media WiFi 44:e4:d9:01:8d:93;VodafoneWiFi 44:e4:d9:01:f6:e7;222666328 44:e4:d9:01:f6:e5;1234 44:e4:d9:01:f6:eb;2288 44:e4:d9:01:f6:e0;2288 c0:62:6b:e5:20:00; 00:0f:61:f0:d9:31; 00:0f:61:f0:d9:32; 00:0f:61:f0:d9:30;2288 44:e4:d9:01:8d:9f;5150-5725 44:e4:d9:01:8d:9e;222666328 44:e4:d9:01:8d:9a;EE WiFi_Auto 44:e4:d9:01:8d:99;BBConnect \n" +
                "44:e4:d9:01:8d:9d;1234 44:e4:d9:01:8d:9b;Virgin Media WiFi 44:e4:d9:01:8d:9c;BBConnect 44:e4:d9:01:8d:92;1234 \n" +
                "44:e4:d9:01:8d:94;5150-5725 44:e4:d9:01:8d:91;BBConnect 2c:3e:cf:f0:2b:31;Virgin Media WiFi 44:e4:d9:01:8d:93;Virgin Media \n" +
                "WiFi 2c:3e:cf:f0:2b:32;VodafoneWiFi 44:e4:d9:01:8d:98;BTWiFi 02:f2:01:45:69:e6;EE WiFi_Auto 44:e4:d9:01:8d:96;222666328 \n" +
                "2c:3e:cf:f0:2b:33;VodafoneWiFi 2c:3e:cf:f0:2b:35;5150-5725 c0:62:6b:e5:20:0e;222666328 c0:62:6b:e5:20:0a;1234 \n" +
                "c0:62:6b:e5:20:0b;BBConnect c0:62:6b:e5:20:0d;VodafoneWiFi c0:62:6b:e5:20:08;2288 c0:62:6b:e5:20:0f;Virgin Media WiFi \n" +
                "c0:62:6b:e5:20:0c;BTOpenzone-B 12:f2:01:45:69:e6;";
        mSouthKensington = "5150-5725 c8:f9:f9:29:73:8b;BBConnect c8:f9:f9:29:73:81;5150-5725 c8:f9:f9:29:73:84;222666328 c8:f9:f9:29:73:8a;BBConnect \n" +
                "c8:f9:f9:29:73:8e;1234 c8:f9:f9:29:73:8c;VodafoneWiFi c8:f9:f9:29:73:88;Virgin Media WiFi c8:f9:f9:29:73:8d;Virgin Media WiFi \n" +
                "c8:f9:f9:29:73:82;EE WiFi_Auto c8:f9:f9:29:73:89;2288 c8:f9:f9:29:73:8f;BBConnect 2c:36:f8:0f:2c:91;1234 \n" +
                "2c:36:f8:0f:2c:93;1234 c8:f9:f9:29:73:83;222666328 c8:f9:f9:29:73:85;2288 c8:f9:f9:29:73:80;BBConnect 2c:36:f8:0f:3e:2e;5150-5725 2c:36:f8:0f:3e:2b;1234 2c:36:f8:0f:3e:2c;2288 2c:36:f8:0f:3e:20;VodafoneWiFi \n" +
                "2c:36:f8:0f:3e:28;Virgin Media WiFi 2c:36:f8:0f:3e:22;";
        mSloaneSquare = "1234 c8:f9:f9:72:1c:f4;5150-5725 c8:f9:f9:72:1c:f1;BBConnect c8:f9:f9:72:1c:f2;Virgin Media WiFi c8:f9:f9:72:1c:f3;1234 \n" +
                "c8:f9:f9:5b:ab:d4;222666328 3c:ce:73:f8:93:2a;5150-5725 3c:ce:73:f8:93:2e;1234 c8:f9:f9:72:1c:fb;BBConnect \n" +
                "3c:ce:73:f8:93:22;5150-5725 3c:ce:73:f8:93:21;1234 3c:ce:73:f8:93:2b;BBConnect 3c:ce:73:f8:93:2d;1234 3c:ce:73:f8:93:24;5150\n" +
                "-5725 c8:f9:f9:72:1c:fe;2288 3c:ce:73:f8:93:2f;BBConnect c8:f9:f9:72:1c:fd;Virgin Media WiFi c8:f9:f9:72:1c:fc;Virgin Media \n" +
                "WiFi 3c:ce:73:f8:93:2c;Virgin Media WiFi 3c:ce:73:f8:93:23;EE WiFi_Auto c8:f9:f9:5b:a3:08;222666328 c8:f9:f9:5b:a3:0a;1234 \n" +
                "c8:f9:f9:5b:a3:0b;5150-5725 c8:f9:f9:5b:a3:0e;VodafoneWiFi c8:f9:f9:5b:a3:07;2288 c8:f9:f9:5b:a3:0f;BBConnect \n" +
                "c8:f9:f9:5b:a3:0d;1234 c8:f9:f9:5b:a3:04;5150-5725 c8:f9:f9:5b:a3:01;BBConnect c8:f9:f9:5b:a3:02;VodafoneWiFi \n" +
                "c8:f9:f9:5b:a3:08;222666328 3c:ce:73:f8:93:25;EE WiFi_Auto 3c:ce:73:f8:93:27;BBConnect 34:a8:4e:96:cf:22;EE WiFi_Auto \n" +
                "c8:f9:f9:72:1c:f7;2288 34:a8:4e:96:cf:20;VodafoneWiFi 34:a8:4e:96:cf:28;EE WiFi_Auto 3c:ce:73:f8:93:28;VodafoneWiFi \n" +
                "3c:ce:73:f8:93:27;Virgin Media WiFi c8:f9:f9:5b:a3:0c;Virgin Media WiFi c8:f9:f9:5b:a3:03;Virgin Media WiFi \n" +
                "34:a8:4e:96:cf:23;EE WiFi_Auto c8:f9:f9:5b:a3:08;1234 c8:f9:f9:5b:a3:0b;5150-5725 c8:f9:f9:5b:a3:0e;5150-5725 c8:f9:f9:5b:a3:01;Virgin Media WiFi c8:f9:f9:5b:a3:0c;BBConnect c8:f9:f9:5b:a3:0d;VodafoneWiFi c8:f9:f9:5b:a3:07;BBConnect c8:f9:f9:5b:a3:02;1234 c8:f9:f9:5b:a3:04;Virgin Media WiFi c8:f9:f9:5b:a3:03;VodafoneWiFi c8:f9:f9:5b:a3:08;2288 c8:f9:f9:5b:a3:00;2288 c8:f9:f9:5b:a3:0f;";
        mMonument = "BBConnect 3c:ce:73:f8:40:02;BBConnect 3c:ce:73:f8:8c:52;5150-5725 3c:ce:73:f8:8c:51;5150-5725 3c:ce:73:f8:8c:5e;1234 3c:ce:73:f8:8c:54;222666328 3c:ce:73:f8:8c:5a;1234 3c:ce:73:f8:40:04;EE WiFi_Auto 3c:ce:73:f8:8c:57;1234 3c:ce:73:f8:8c:5b;BBConnect 3c:ce:73:f8:8c:5d;2288 3c:ce:73:f8:8c:5f;VodafoneWiFi 3c:ce:73:f8:8c:59;5150-5725 3c:ce:73:6c:5e:fe;EE WiFi_Auto 3c:ce:73:f8:8f:27;1234 3c:ce:73:f8:8f:2b;5150-5725 3c:ce:73:f8:8f:2e;222666328 3c:ce:73:6c:5e:fa;2288 3c:ce:73:6c:5e:ff;BBConnect 3c:ce:73:f8:8f:2d;BBConnect 3c:ce:73:f8:8f:22;5150-5725 3c:ce:73:f8:8f:21;Virgin Media WiFi 3c:ce:73:f8:8c:53;Virgin Media WiFi 3c:ce:73:f8:8c:5c;Virgin Media WiFi 3c:ce:73:f8:40:03;Virgin Media WiFi 3c:ce:73:6c:5e:fc;Virgin Media WiFi 3c:ce:73:f8:8f:2c;Virgin Media WiFi 3c:ce:73:f8:8f:23;BBConnect 3c:ce:73:6c:5e:f2;5150-5725 3c:ce:73:6c:5e:f1;1234 3c:ce:73:6c:5e:f4;EE WiFi_Auto 3c:ce:73:6c:5e:f7;222666328 3c:ce:73:f8:8f:2a;VodafoneWiFi 3c:ce:73:f8:8f:29;1234 3c:ce:73:6c:5e:fb;BBConnect 3c:ce:73:6c:5e:fd;Virgin Media WiFi 3c:ce:73:6c:5e:f3;VodafoneWiFi 3c:ce:73:f8:8c:56;VodafoneWiFi 3c:ce:73:6c:5e:f9;VodafoneWiFi 3c:ce:73:6c:5e:f6;VodafoneWiFi 3c:ce:73:f8:40:06;5150-5725 3c:ce:73:f8:40:01;222666328 3c:ce:73:f8:8f:25;5150-5725 3c:ce:73:f8:40:0e;1234 3c:ce:73:f8:40:0b;VodafoneWiFi 3c:ce:73:f8:40:09;BBConnect 3c:ce:73:f8:40:0d;222666328 3c:ce:73:f8:40:0a;BBConnect 2c:36:f8:0f:2d:71;VodafoneWiFi 2c:3e:cf:f1:21:75;EE WiFi_Auto 2c:36:f8:0f:2d:76;Virgin Media WiFi 3c:ce:73:f8:40:0c; 5150-5725 64:a0:e7:ff:21:41;1234 64:a0:e7:ff:21:44;Virgin Media WiFi 64:a0:e7:ff:21:43;VodafoneWiFi 64:a0:e7:ff:21:46;1234 2c:3f:38:2b:00:bb;5150-5725 2c:3f:38:2b:00:be;BBConnect 2c:3f:38:2b:00:bd;BBConnect 64:a0:e7:ff:21:42;VodafoneWiFi 2c:3f:38:2b:00:b9;Virgin Media WiFi 2c:3f:38:2b:00:bc;222666328 64:a0:e7:ff:21:4a;2288 2c:3f:38:2b:00:bf;EE WiFi_Auto 2c:3f:38:2b:00:b7;222666328 2c:3f:38:2b:00:ba;222666328 64:a0:e7:fe:b8:05;BBConnect 2c:3f:38:2b:00:b2;1234 64:a0:e7:fe:b8:04;VodafoneWiFi 2c:3f:38:2b:00:b6;EE WiFi_Auto 64:a0:e7:ff:21:47;1234 64:a0:e7:ff:21:4b;BBConnect 64:a0:e7:ff:21:4d;5150-5725 64:a0:e7:ff:21:4e;1234 2c:3f:38:2b:00:b4;VodafoneWiFi 64:a0:e7:ff:21:49;2288 64:a0:e7:fe:b8:00;2288 2c:3f:38:2a:e4:10;2288 2c:3f:38:2b:00:b0;EE WiFi_Auto 2c:3f:38:2a:e4:18;BBConnect c8:f9:f9:72:11:01;1234 2c:3f:38:2a:e4:14;EE WiFi_Auto c8:f9:f9:72:11:06;222666328 64:a0:e7:fe:b8:0a;Virgin Media WiFi 64:a0:e7:fe:b8:03;Virgin Media WiFi 64:a0:e7:ff:21:4c;Virgin Media WiFi 2c:3f:38:2b:00:b3;Virgin Media WiFi c8:f9:f9:72:11:02;";
        mMansionHouse = "1234 c8:f9:f9:5b:7c:94;BBConnect c8:f9:f9:5b:7c:92;5150-5725 c8:f9:f9:5b:7c:91;222666328 c8:f9:f9:5b:7c:95;BBConnect c8:f9:f9:5b:7c:9d;1234 c8:f9:f9:5b:7c:9b;2288 c8:f9:f9:5b:7c:9f;5150-5725 c8:f9:f9:5b:7c:9e;Virgin Media WiFi c8:f9:f9:5b:7c:93;Virgin Media WiFi c8:f9:f9:5b:7c:9c;EE WiFi_Auto c8:f9:f9:5b:7c:98;VodafoneWiFi c8:f9:f9:5b:7c:97;1234 3c:ce:73:70:6c:04;5150-5725 3c:ce:73:70:6c:01;BBConnect 3c:ce:73:70:6c:02;VodafoneWiFi c8:f9:f9:5b:7c:98;2288 c8:f9:f9:5b:7c:90;222666328 c8:f9:f9:5b:7c:9a;EE WiFi_Auto 3c:ce:73:70:6c:07;BBConnect 3c:ce:73:6c:60:12;VodafoneWiFi 3c:ce:73:6c:60:17;2288 3c:ce:73:6c:60:10;EE WiFi_Auto 3c:ce:73:6c:60:18;5150-5725 3c:ce:73:6c:60:11;1234 c8:f9:f9:72:08:e4;1234 3c:ce:73:6c:60:14;Virgin Media WiFi 3c:ce:73:70:6c:03;Virgin Media WiFi 3c:ce:73:6c:60:1c;Virgin Media WiFi 3c:ce:73:6c:60:13;";










    }
}



