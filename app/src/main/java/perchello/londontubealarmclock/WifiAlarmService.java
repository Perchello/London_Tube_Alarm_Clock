package perchello.londontubealarmclock;

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
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.IBinder;
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
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("WifiAlarm Service :", "OnStart");
        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        mWifiReceiver = new WifiScanReceiver();
        mCurrentStation ="";
        registerReceiver(mWifiReceiver, new IntentFilter(mWifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mWifiManager.startScan();

    }

    class WifiScanReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            mScanResultList = mWifiManager.getScanResults();

            for (int i =0; i < mScanResultList.size(); i++) {
                Log.d("Network name is :" + mScanResultList.get(i).SSID.toString().toLowerCase() + " :", mScanResultList.get(i).BSSID.toString().toLowerCase());

                if (mScanResultList.get (i).BSSID.toString().toLowerCase().contains("00:62:2c:72:9c:f4")){
                    if (!mCurrentStation.equals("George Home")){
                        mCurrentStation="George Home";
                        Toast.makeText(WifiAlarmService.this, mCurrentStation, Toast.LENGTH_LONG).show();
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();

                    }

                    i = mScanResultList.size();
                }
            }

        }
    }

}
