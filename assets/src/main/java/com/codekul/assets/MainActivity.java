package com.codekul.assets;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager manager = getAssets();
        try {
            InputStream is = manager.open("my.json"); // assets
            int my = R.raw.my; // resources

            String str = new String();

            while(true){
                int ch = is.read();
                if(ch == -1) break;
                else str += (char)ch;
            }
            ((TextView)findViewById(R.id.textInfo)).setText(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
