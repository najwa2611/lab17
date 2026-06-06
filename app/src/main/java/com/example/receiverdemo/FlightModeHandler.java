package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FlightModeHandler extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean flightActive = intent.getBooleanExtra("state", false);

            String notification = flightActive
                    ? "Flight Mode ENABLED - No connectivity"
                    : "Flight Mode DISABLED - Connection restored";

            Toast.makeText(context, notification, Toast.LENGTH_LONG).show();
        }
    }
}