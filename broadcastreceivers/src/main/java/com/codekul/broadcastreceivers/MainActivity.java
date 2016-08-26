package com.codekul.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver =
            new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
                        ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_battery_charging_full_black_48px);
                    }
                    else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
                        ((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.ic_battery_full_black_48px);
                    }
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop(); // !imp
    }
}
