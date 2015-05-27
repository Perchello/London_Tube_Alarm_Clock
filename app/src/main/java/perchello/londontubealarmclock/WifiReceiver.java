package perchello.londontubealarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Perchello on 25/05/2015.
 */
public class WifiReceiver extends BroadcastReceiver {
    public static Boolean mRepeatalarm = true;

    @Override
    public void onReceive(Context context, Intent intent) {
                String stationName = intent.getStringExtra("stationName");
        String mac = intent.getStringExtra("mac");
        Log.d("WifiReceiver : ", "Station name is " + stationName + " and mac is " + mac);
        Intent service = new Intent(context, WifiAlarmService.class);
        service.putExtra("stationName", stationName);
        service.putExtra("mac", mac);
        context.startService(service);
    }
}
