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
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<ScanResult> mScanResultList;
    public TextView mWifiTextView;
    public WifiManager mWifiManager;
    public WifiScanReceiver mWifiReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiTextView = (TextView) findViewById(R.id.wifiTextView);

        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        mWifiReceiver = new WifiScanReceiver();
        registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mWifiManager.startScan();

    }
    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mScanResultList = mWifiManager.getScanResults();

            for (int i =0; i < mScanResultList.size(); i++) {
                Log.d("NEtwork name is :" + mScanResultList.get (i).SSID.toString().toLowerCase()+" :", mScanResultList.get (i).BSSID.toString().toLowerCase());

                if (mScanResultList.get (i).BSSID.toString().toLowerCase().equals("00:62:2c:72:9c:f4")){
                    mWifiTextView.setVisibility(View.VISIBLE);
                    i = mScanResultList.size();
                }
                if (i==(mScanResultList.size()-1) ) {
                    mWifiTextView.setVisibility(View.INVISIBLE);

                }


            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Log.e (e.toString(), e.getMessage());
            }
            mWifiManager.startScan();

        }
    }


}


