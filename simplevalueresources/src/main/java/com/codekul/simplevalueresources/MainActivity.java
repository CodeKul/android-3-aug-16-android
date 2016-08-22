package com.codekul.simplevalueresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String []cities = getResources()
                .getStringArray(R.array.cities);

        int textHeaderColor = getResources().getColor(R.color.textHeaderColor);
        textHeaderColor = ContextCompat.getColor(this, R.color.textHeaderColor);
    }
}
