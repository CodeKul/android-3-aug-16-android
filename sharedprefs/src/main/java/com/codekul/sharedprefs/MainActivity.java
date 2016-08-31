package com.codekul.sharedprefs;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_MY_NAME = "name";
    private static final String KEY_IS_INDIAN = "isIndian";
    public static final String TAG = "@codekul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeData();

        readData();
    }

    private void writeData(){
        //SharedPreferences preferences = getPreferences();
        SharedPreferences preferences
                = getSharedPreferences("my",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_MY_NAME,"codekul");
        editor.putBoolean(KEY_IS_INDIAN,true);
        editor.commit();
    }

    private void readData(){
        SharedPreferences preferences
                = getSharedPreferences("my",MODE_PRIVATE);
        String name = preferences.getString(KEY_MY_NAME,"none");
        Boolean isIndian = preferences.getBoolean(KEY_IS_INDIAN,false);

        Log.i(TAG,"Name - "+name + " Indian "+isIndian);
    }
}
