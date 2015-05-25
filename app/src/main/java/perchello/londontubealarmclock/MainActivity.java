package perchello.londontubealarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<ScanResult> mScanResultList;
    public TextView mWifiTextView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStationNames();
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


            }
            mWifiManager.startScan();

        }
    }

    private void setStationNames(){
        mAndrewOffice = "c8:bc:c8:fd:9d:95";
        mFincheleyCentral = "";
        mEastFinchley = "";
        mHighgate = "";
        mArchway = "";
        mTufnellPark = "";
        mKentishTown = "";
        mCamdenTown = "";
        mEuston = "";
        mKingsCross = "";
        mAngel = "";
        mOldStreet = "";
        mMoorgate = "";
        mBank = "";
        mLondonBridge = "";
        mBermondsey = "";
        mCanadaWater = "";
        mCanaryWharf = "";
        mNorthGreenwich = "";
        mCanningTown = "";

    }
}



