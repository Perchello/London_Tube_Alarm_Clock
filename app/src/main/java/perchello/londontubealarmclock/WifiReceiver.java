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
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String test = extras.getString("1");
        Log.d("WifiReceiver : ", test+"");
        Intent service1 = new Intent(context, WifiAlarmService.class);
        context.startService(service1);
    }
}
