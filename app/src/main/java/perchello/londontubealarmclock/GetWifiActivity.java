package perchello.londontubealarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class GetWifiActivity extends ActionBarActivity {
    private List<ScanResult> mScanResultList;
    public EditText mStationEditText;
    public WifiManager mWifiManager;
    public WifiScanReceiver mWifiReceiver;
    public Button mGetNewWifiButton;
    private String mStationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_wifi);

        mStationEditText = (EditText) findViewById(R.id.stationEditText);
        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        mWifiReceiver = new WifiScanReceiver();

        mGetNewWifiButton = (Button) findViewById(R.id.saveWifiButton);
        mGetNewWifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStationEditText.getText().length() != 0) {
                    Log.d("Passed click: ", "yes");
                    mGetNewWifiButton.setVisibility(View.INVISIBLE);
                    mStationName = mStationEditText.getText().toString();
                    mWifiManager.startScan();
                    registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
                } else {
                    Toast.makeText(GetWifiActivity.this, "Please enter station name", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mScanResultList = mWifiManager.getScanResults();
            String wifiList ="";
            for (int i =0; i < mScanResultList.size(); i++) {
                wifiList+=mScanResultList.get(i).SSID+ " ";
                wifiList+=mScanResultList.get(i).BSSID+ ";";
            }
            Log.d("Wifilist: ", wifiList);
            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + "/saved_stations");
            myDir.mkdirs();
            String fname = mStationName +".txt";
            File file = new File (myDir, fname);
            try {
            FileWriter writer = new FileWriter(file);
            writer.append(wifiList);
            writer.flush();

                writer.close();
                mGetNewWifiButton.setVisibility(View.VISIBLE);
                Toast.makeText(GetWifiActivity.this, "Saved!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            unregisterReceiver(mWifiReceiver);
        }
    }
}
