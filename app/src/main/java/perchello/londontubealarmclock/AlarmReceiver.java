package perchello.londontubealarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by g_pirch on 22/05/2015.
 */
public class AlarmReceiver extends BroadcastReceiver{
        WifiScanReceiver mWifiReceiver;
        WifiManager mWifiManager;
        private List<ScanResult> mScanResultList;


    @Override
        public void onReceive(Context context, Intent intent) {

            // For our recurring task, we'll just display a message
            Log.d("Started alarm: ", "yes");
            mWifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            mWifiReceiver = new WifiScanReceiver();
            context.getApplicationContext().registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
            Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
            mWifiManager.startScan();
        }


    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mScanResultList = mWifiManager.getScanResults();

            for (int i =0; i < mScanResultList.size(); i++) {
                Log.d("Network name is :" + mScanResultList.get (i).SSID.toString().toLowerCase()+" :", mScanResultList.get (i).BSSID.toString().toLowerCase());

                if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("00:62:2c:72:9c:f4")){
                    //mWifiTextView.setText("George Home");
                    i = mScanResultList.size();
                }
                else if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("c8:bc:c8:fd:9d:95")) {
                    //mWifiTextView.setText("Rudenko Office");
                    /*Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();*/
                    i = mScanResultList.size();
                }
                else if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("c8:f9:f9:2a:84:0d") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("c8:f9:f9:2a:84:02") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("3c:ce:73:f8:88:4d")) {
                    //mWifiTextView.setText("Archway");
                    i = mScanResultList.size();
                }
                else if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("a4:56:30:cc:97:fd") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("a4:56:30:cc:97:f2") || mScanResultList.get (i).BSSID.toString().toLowerCase().contains("3c:ce:73:f8:90:9d")) {
                    //mWifiTextView.setText("Highgate");
                    i = mScanResultList.size();
                }

            }

        }
    }
}
