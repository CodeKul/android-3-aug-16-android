package com.codekul.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver =
            new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    Log.i("@codekul","Our Receiver");
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

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(getResources().getString(R.string.customAction));
                sendBroadcast(intent);
               // sendOrderedBroadcast(intent,null);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerViaCode();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop(); // !imp
    }

    private void registerViaCode(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(getResources().getString(R.string.customAction));
        registerReceiver(receiver,filter);
    }
}
