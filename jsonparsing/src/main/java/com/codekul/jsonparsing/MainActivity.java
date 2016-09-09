package com.codekul.jsonparsing;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("@codekul","Name is - "+getName());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            getPlaces().forEach(s -> {
                Log.i("@codekul","Places - "+s);
            });
        }
    }

    private String getName(){
        String name = "";
        try {
            JSONObject obj = new JSONObject(readJosn());
            name = obj.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return name;
    }

    private ArrayList<String> getPlaces(){

        ArrayList<String> places = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(readJosn());
            JSONArray jsonPlaces = obj.getJSONArray("places");
            for(int i  = 0 ; i < jsonPlaces.length(); i++){
                places.add(jsonPlaces.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  places;
    }

    private String readJosn(){
        StringBuilder builder = new StringBuilder();
        try {
            InputStream is = getAssets().open("my.json");
            while(true){
                int ch = is.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
