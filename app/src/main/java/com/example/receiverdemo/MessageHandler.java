package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageHandler extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.example.receiverdemo.PRIVATE_SIGNAL".equals(intent.getAction())) {
            String content = intent.getStringExtra("payload");
            Toast.makeText(context, "Incoming: " + content, Toast.LENGTH_LONG).show();
        }
    }
}