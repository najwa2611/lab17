package com.example.receiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FlightModeHandler flightHandler;
    private boolean handlerActive = false;
    private Button controlButton;
    private Button customButton;
    private TextView displayLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flightHandler = new FlightModeHandler();
        displayLabel = findViewById(R.id.tvStatus);
        controlButton = findViewById(R.id.btnToggleAirplane);
        customButton = findViewById(R.id.btnSendCustom);

        controlButton.setOnClickListener(v -> toggleFlightMonitor());
        customButton.setOnClickListener(v -> dispatchCustomAlert());
    }

    private void toggleFlightMonitor() {
        if (!handlerActive) {
            IntentListener capture = new IntentListener();
            capture.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            registerReceiver(flightHandler, capture);
            handlerActive = true;
            displayLabel.setText("Flight Monitor: ACTIVE");
            controlButton.setText("Disable Flight Receiver");
            controlButton.setBackgroundColor(0xFF940000);
        } else {
            unregisterReceiver(flightHandler);
            handlerActive = false;
            displayLabel.setText("Flight Monitor: INACTIVE");
            controlButton.setText("Enable Flight Receiver");
            controlButton.setBackgroundColor(0xFFC30101);
        }
    }

    private void dispatchCustomAlert() {
        Intent signal = new Intent("com.example.receiverdemo.PRIVATE_SIGNAL");
        signal.putExtra("payload", "Signal from main controller");
        sendBroadcast(signal);
        displayLabel.setText("Status: Custom signal sent!");
        displayLabel.postDelayed(() -> {
            if (handlerActive) {
                displayLabel.setText("Flight Monitor: ACTIVE");
            } else {
                displayLabel.setText("Flight Monitor: INACTIVE");
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        if (handlerActive) {
            unregisterReceiver(flightHandler);
        }
        super.onDestroy();
    }

    private class IntentListener extends IntentFilter {
        public IntentListener() {
            super();
        }
    }
}