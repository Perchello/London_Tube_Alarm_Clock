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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                else if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("c8:bc:c8:fd:9d:95")) {
                    mWifiTextView.setText("Rudenko Office");
                    i = mScanResultList.size();
                }
                else if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("c8:f9:f9:2a:84:0d") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("c8:f9:f9:2a:84:02") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("3c:ce:73:f8:88:4d")) {
                    mWifiTextView.setText("Archway");
                    i = mScanResultList.size();
                }
                else if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("a4:56:30:cc:97:fd") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("a4:56:30:cc:97:f2") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("3c:ce:73:f8:90:9d")) {
                    mWifiTextView.setText("Highgate");
                    i = mScanResultList.size();
                }


            }
            mWifiManager.startScan();

        }
    }


}


