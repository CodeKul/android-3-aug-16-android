package com.codekul.handlingruntimechangesbyown;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            findViewById(R.id.textView)
                    .setBackgroundResource(R.drawable.my);
        else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            findViewById(R.id.textView)
                    .setBackgroundResource(R.drawable.pin);
        else
            findViewById(R.id.textView)
                    .setBackgroundResource(R.drawable.hands);
    }

}
